package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IProductService;
import service.ProductServiceImpl;

@Controller
@RequestMapping("product")
public class ProductController {
    IProductService productService = new ProductServiceImpl();
    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }
    @GetMapping("search")
    public String search(@RequestParam String q, Model model) {
        model.addAttribute("products", productService.findByName(q));
        return "redirect:/product";
    }
    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int)(Math.random() * 100));
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Add new product successfully");
        return "redirect:/product";
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }
    @PostMapping("update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/product";
    }
    @GetMapping("{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}
