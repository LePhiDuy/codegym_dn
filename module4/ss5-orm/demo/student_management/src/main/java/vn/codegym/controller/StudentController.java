package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.service.IStudentService;

import java.util.List;

@Controller
@RequestMapping({"student", ""})
public class StudentController {
    @Autowired
    @Qualifier("studentServiceImpl")
    private IStudentService studentService;
    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "list";
    }
}
