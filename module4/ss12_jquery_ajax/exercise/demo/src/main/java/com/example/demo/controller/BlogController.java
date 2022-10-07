package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"blog", "home"})
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String home(@RequestParam("q") Optional<String> q,
                       @PageableDefault(value = 3, sort = "name", direction = Sort.Direction.ASC)
                               Pageable pageable, Model model) {
        if (!q.isPresent()) {
            model.addAttribute("blogs", blogService.findAll(pageable));
        } else {
            model.addAttribute("blogs", blogService.searchByName(q.get(), pageable));
            model.addAttribute("q", q.get());
        }
        return "blogs/list";
    }

//    @GetMapping("")
//    public String home(@RequestParam("q") Optional<String> q, Model model) {
////        List<Blog> blogList = blogService.findAllByNameContaining(q.get());
////        System.out.println(blogList.size());
//        if (!q.isPresent()) {
//            model.addAttribute("blogs", blogService.findAll());
//        } else {
//            model.addAttribute("blogs", blogService.findAllByNameContaining(q.get()));
//        }
//        return "blogs/list";
//    }

    @ModelAttribute(name = "categorys")
    public List<Category> categorys(Model model) {
        return categoryService.findAll();
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        // model.addAttribute("categorys", categoryService.findAll());
        return "blogs/create";
    }

    @PostMapping("save")
    public String save(Blog blog, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", bindingResult.getAllErrors());
            return "blogs/create";
        }
        blogService.save(blog);
        model.addAttribute("message", "New Blog create successfully");
        return "blogs/create";
    }

    @GetMapping("{id}/edit")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("blogs/edit");
        modelAndView.addObject("blog", blogService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("update")
    public ModelAndView update(@ModelAttribute Blog blog, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("blogs/edit");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("errorMessage", bindingResult.getAllErrors());
        } else {
            blogService.save(blog);
            modelAndView.addObject("message", "Update blog successfully");
        }
        return modelAndView;
    }
}
