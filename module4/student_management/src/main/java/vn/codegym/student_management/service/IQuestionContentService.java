package vn.codegym.student_management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.student_management.entity.Student;

public interface IStudentService {
    Page<Student> findAll(Pageable pageable);
    void save(Student student);
    void delete(Long id);
}
