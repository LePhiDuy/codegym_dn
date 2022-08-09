package com.example.register_form_validate.controller;

import com.example.register_form_validate.dto.UserDto;
import com.example.register_form_validate.model.User;
import com.example.register_form_validate.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }
    @PostMapping("save")
    public String save(@Validated UserDto userDto, BindingResult bindingResult) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "register";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        return "success";
    }
}
