package controller;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @RequestMapping(value = "showform", method = RequestMethod.GET)
    public String showFormCreate(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create";
    }
    @RequestMapping(value = "addEmployee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute Employee employee, Model model) {
        model.addAttribute("employee", employee);
        return "info";
    }
}
