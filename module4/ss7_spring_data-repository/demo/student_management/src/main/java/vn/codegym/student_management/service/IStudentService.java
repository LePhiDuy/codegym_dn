package vn.codegym.student_management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.student_management.model.Student;

import java.util.List;

public interface IStudentService extends IGeneralService<Student> {
    List<Student> searchByName(String name);
    Page<Student> findAll(Pageable pageable);
}
