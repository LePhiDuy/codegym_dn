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
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("register")
    public String register(Model model, @CookieValue(value = "counter", defaultValue = "0") Long counter, HttpServletResponse httpServletResponse) {
        counter++;
        Cookie cookie = new Cookie("counter", counter.toString());
        cookie.setMaxAge(30);
        httpServletResponse.addCookie(cookie);
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("cookie", cookie);
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
