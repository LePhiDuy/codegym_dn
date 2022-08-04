package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Blog;
import vn.codegym.service.IBlogService;

@Controller
@RequestMapping({"blog", "home"})
public class BlogController {
    @Autowired
    IBlogService blogService;
    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "list";
    }
    @GetMapping("{id}/edit")
    public ModelAndView edit(@PathVariable Long id) {
        return new ModelAndView("edit", "blog", blogService.findById(id));
    }
    @PostMapping("update")
    public ModelAndView update(@ModelAttribute Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Update blog successfully");
        return modelAndView;
    }
    @GetMapping("create")
    public ModelAndView create() {
        return new ModelAndView("create", "blog", new Blog());
    }
    @PostMapping("save")
    public ModelAndView save(@ModelAttribute Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Add new blog successfully");
        return modelAndView;
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable Long id) {
        blogService.remove(id);
        return "redirect:/blog";
    }
    @GetMapping("{id}/view")
    public ModelAndView view(@PathVariable Long id) {
        return new ModelAndView("view", "blog", blogService.findById(id));
    }
}
