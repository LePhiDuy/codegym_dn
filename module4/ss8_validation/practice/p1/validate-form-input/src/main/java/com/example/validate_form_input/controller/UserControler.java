package com.example.validate_form_input.controller;

import com.example.validate_form_input.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserControler {
    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }
    @PostMapping("save")
    public String save(@Validated User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "create";
        } else {
            return "success";
        }
    }
}
