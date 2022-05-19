package _8_clean_code.demoMVC.service.impl;

import _8_clean_code.demoMVC.model.Student;
import _8_clean_code.demoMVC.repository.IStudentRepository;
import _8_clean_code.demoMVC.repository.impl.StudentRepository;
import _8_clean_code.demoMVC.service.IStudentService;

public class StudentService implements IStudentService {
    private static IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public void addStudent(Student student) {
        if(student.getPoint()<0) {

        } else {
            iStudentRepository.saveStudent(student);
        }
    }
}
