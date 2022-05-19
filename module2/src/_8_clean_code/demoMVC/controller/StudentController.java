package _8_clean_code.demoMVC.controller;

import _8_clean_code.demoMVC.model.Student;
import _8_clean_code.demoMVC.service.IStudentService;
import _8_clean_code.demoMVC.service.impl.StudentService;

public class StudentController {
    private static IStudentService iStudentService = new StudentService();
    public void addStudent(Student student) {
        iStudentService.addStudent(student);
    }
}
