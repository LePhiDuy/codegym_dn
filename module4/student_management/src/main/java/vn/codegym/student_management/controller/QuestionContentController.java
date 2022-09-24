package vn.codegym.student_management.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.student_management.dto.StudentDto;
import vn.codegym.student_management.entity.Student;
import vn.codegym.student_management.service.IClassService;
import vn.codegym.student_management.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassService classService;
    @GetMapping("")
    public String view(@PageableDefault(value = 3) Pageable pageable, Model model) {
        model.addAttribute("students", studentService.findAll(pageable));
        model.addAttribute("studentDto", new StudentDto());
        model.addAttribute("classStudents", classService.findAll());
        return "student/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        studentService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully");
        return "redirect:/student";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("studentDto", new StudentDto());
        model.addAttribute("classStudents", classService.findAll());
        model.addAttribute("tittle", "Add new student");
        return "/student/create";
    }
    @PostMapping("/save")
    public String save(StudentDto studentDto, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/student/create";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        return "redirect:/student";
    }
}
