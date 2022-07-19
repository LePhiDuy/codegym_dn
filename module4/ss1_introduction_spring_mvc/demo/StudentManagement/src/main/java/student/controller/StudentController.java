package student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import student.service.IStudentService;
import student.service.StudentServiceImpl;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService studentService;
    @GetMapping
    public String showList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "list";
    }
}
