package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.DictionaryService;

@Controller
public class DictionaryController {
    DictionaryService dictionaryService = new DictionaryService();
    @GetMapping("home")
    public String home() {
        return "home";
    }
    @GetMapping("search")
    public ModelAndView search(@RequestParam String english_word) {
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("result", dictionaryService.search(english_word));
        return modelAndView;
    }
}
