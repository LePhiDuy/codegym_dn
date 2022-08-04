package controller;

import model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {
    private static Setting setting= new Setting();
    @GetMapping("home")
    public String home() {
        return "home";
    }
    @GetMapping("config")
    public ModelAndView config() {
        return new ModelAndView("config", "setting", setting);
    }
    @PostMapping("save")
    public String save(Setting s) {
        setting = s;
        return "home";
    }
}
