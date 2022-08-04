package student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import student.model.Student;
import student.service.IStudentService;
import student.service.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"student",""})
public class StudentController {
    @Qualifier("studentServiceImpl")
    @Autowired
    IStudentService studentService;
    @RequestMapping(method = RequestMethod.GET)
    public String showList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "list";
    }
    @GetMapping("/list")
    public String showList1(@RequestParam(required = false, defaultValue = "No Name") String name, int age, Model model) {
        model.addAttribute("studentName", name);
        model.addAttribute("studentAge", age);
        return "detail";
        //return new ModelAndView("list", "students", studentService.findAll());
    }
    @GetMapping("/edit/{name}/{studentAge:^[2-9][0-9]?$|^18$|^19$|^100$}")
    public String edit(@PathVariable String name, @PathVariable(value = "studentAge", required = false) Integer studentAge, Model model) {
        model.addAttribute("studentName", name);
        model.addAttribute("studentAge", studentAge);
        return "detail";
    }
    @GetMapping("/create")
    public String showCreatePage(Model model) {
        Student student = new Student();
        List<String> languageList = new ArrayList<>();
        languageList.add("C#");
        languageList.add("Java");
        languageList.add("PHP");
        model.addAttribute("languageList", languageList);
        model.addAttribute("student", student);
        return "create";
    }
    @PostMapping("create")
    public String create(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Create successfully");
        studentService.save(student);
        return "redirect:/student";
    }
}
