package vn.codegym.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.student_management.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Long> {
}
