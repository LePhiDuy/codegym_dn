package vn.codegym.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.student_management.entity.ClassStudent;

public interface IClassRepository extends JpaRepository<ClassStudent, Long> {
}
