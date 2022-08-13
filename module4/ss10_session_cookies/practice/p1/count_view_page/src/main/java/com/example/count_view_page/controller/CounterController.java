package com.example.count_view_page.controller;

import com.example.count_view_page.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("counter")
public class CounterController {

    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }

    @GetMapping("")
    public String get(@SessionAttribute("counter") Counter counter) {
        counter.increment();
        return "view";
    }
}