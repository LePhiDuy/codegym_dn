package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ProductService;
import service.ProductServiceImpl;

@Controller
public class ProductController {
    ProductService productService = new ProductServiceImpl();
    @GetMapping("home")
    public String index(Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("products", productService.findAll());
        redirectAttributes.addFlashAttribute("success", "");
        return "index";
    }

}
