package vn.codegym.student_management.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.student_management.dto.StudentDto;
import vn.codegym.student_management.model.Student;
import vn.codegym.student_management.service.IClassRoomService;
import vn.codegym.student_management.service.ICourseService;
import vn.codegym.student_management.service.IStudentService;


import java.util.Date;

@Controller
@RequestMapping({"student", "home"})
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IClassRoomService classRoomService;
    @GetMapping("")
    public String list(@PageableDefault(value = 2, sort = "id", direction = Sort.Direction.DESC)
                                   Pageable pageable, Model model) {
        model.addAttribute("students", studentService.findAll(pageable));
        return "list";
    }
    @GetMapping("create")
    public String showCreatePage(Model model){
        model.addAttribute("studentDto", new StudentDto());
        model.addAttribute("classRooms", classRoomService.findAll());
        model.addAttribute("courses", courseService.findAll());
        return "create";
    }
    @PostMapping("create")
    public String createStudent(@Validated @ModelAttribute StudentDto studentDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model){
        new StudentDto().validate(studentDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("classRooms", classRoomService.findAll());
            model.addAttribute("courses", courseService.findAll());
            return "create";
        } else {
            Student student = new Student();
            BeanUtils.copyProperties(studentDto, student);
            student.getAccount().setDateCreate(new Date(System.currentTimeMillis()));
            studentService.save(student);
            redirectAttributes.addFlashAttribute("message",
                    "Create student: " + student.getName() + " OK!");
            return "redirect:/student";
        }
    }
    @GetMapping("search")
    public ModelAndView search(@RequestParam("kq") String keyword){
        //return new ModelAndView("list", "students", studentService.searchByName("%" + keyword +"%"));
        return new ModelAndView("list", "students", studentService.searchByName(keyword));
    }
}
