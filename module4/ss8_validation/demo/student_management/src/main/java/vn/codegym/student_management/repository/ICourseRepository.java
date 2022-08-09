package vn.codegym.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.student_management.model.Course;

public interface ICourseRepository extends JpaRepository<Course, Long> {
}
