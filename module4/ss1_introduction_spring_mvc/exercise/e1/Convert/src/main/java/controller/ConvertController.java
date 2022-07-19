package controller;

import model.Currency;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertController {
    @GetMapping("home")
    public String showFormConvert() {
        return "home";
    }

    @PostMapping("convert")
    public ModelAndView convert(Currency currency) {
        double result = currency.getUsd() * currency.getRate();
        return new ModelAndView("detail", "result", result);
    }
    @GetMapping("convert")
    public ModelAndView convert(@RequestParam(value = "usd") double usd, @RequestParam(value = "rate") double rate) {
        double result = usd * rate;
        return new ModelAndView("detail", "result", result);
    }
}
