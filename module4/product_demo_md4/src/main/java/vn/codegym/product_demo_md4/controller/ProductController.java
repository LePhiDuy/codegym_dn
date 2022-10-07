package vn.codegym.product_demo_md4.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.product_demo_md4.dto.ProductDto;
import vn.codegym.product_demo_md4.entity.Category;
import vn.codegym.product_demo_md4.entity.Product;
import vn.codegym.product_demo_md4.service.ICategoryService;
import vn.codegym.product_demo_md4.service.IProductService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String find(@PageableDefault(value = 3) Pageable pageable, Model model, ProductDto productDto,
                       BindingResult bindingResult, @RequestParam(defaultValue = "") String searchBy, @RequestParam(defaultValue = "") String q) {
        model.addAttribute("products", productService.find(searchBy, q, pageable));
        model.addAttribute("searchBy", searchBy);
        model.addAttribute("q", q);
        model.addAttribute("sort", pageable.getSort());
        model.addAttribute("size", pageable.getPageSize());
        System.out.println(pageable.getPageSize());
        model.addAttribute("productDto", productDto);
        model.addAttribute("isError", bindingResult.hasErrors());
        return "product/list";
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return (List<Category>) categoryService.findAll();
    }

    @PostMapping(" ")
    public String create(@Validated ProductDto productDto, BindingResult bindingResult, @PageableDefault(value = 3) Pageable pageable, Model model) {
        if (bindingResult.hasErrors()) {
            return find(pageable, model, productDto, bindingResult, "", "");
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/product/delete")
    public ResponseEntity<Page<Product>> delete(@RequestParam Long id, @PageableDefault(value = 3) Pageable pageable) {
        productService.delete(id);
        Page<Product> products = productService.findAll(pageable);
        for (Product product : products
        ) {
            System.out.println(product.getName());
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


//    @GetMapping("/product/delete")
//    public String delete(@RequestParam Long id) {
//        productService.delete(id);
//        return "redirect:/";
//    }
}
