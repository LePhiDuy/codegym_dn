package vn.codegym.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.codegym.student_management.model.Student;

import java.util.List;

public interface IStudentRepository extends PagingAndSortingRepository<Student, Long> {
    @Query(value = "select * from student where name like :name", nativeQuery = true)
    List<Student> searchByName(@Param("name") String name);
    List<Student> findStudentsByNameContaining(String name);
}
