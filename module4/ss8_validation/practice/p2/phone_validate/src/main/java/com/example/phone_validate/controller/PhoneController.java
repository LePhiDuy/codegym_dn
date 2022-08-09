package com.example.phone_validate.controller;

import com.example.phone_validate.model.Phone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PhoneController {
    @GetMapping("phone")
    public String home(Model model) {
        model.addAttribute("phone", new Phone());
        return "home";
    }
    @PostMapping("validate")
    public String validate(@Validated Phone phone, BindingResult bindingResult) {
        new Phone().validate(phone, bindingResult);
        if (bindingResult.hasErrors()) {
            return "home";
        }
        return "success";
    }
}
