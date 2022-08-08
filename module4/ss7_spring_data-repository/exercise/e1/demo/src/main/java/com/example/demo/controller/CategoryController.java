package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IBlogService blogService;
    @GetMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("categorys/list");
        modelAndView.addObject("categorys", categoryService.findAll());
        return modelAndView;
    }
    @GetMapping("{id}/view")
    public ModelAndView view(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (!category.isPresent()) {
            return new ModelAndView("error");
        }
        ModelAndView modelAndView = new ModelAndView("categorys/view");
        modelAndView.addObject("blogs", blogService.findAllByCategory(category.get()));
        modelAndView.addObject("category", category.get());
        return modelAndView;
    }
}
