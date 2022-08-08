package vn.codegym.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.student_management.model.ClassRoom;

public interface IClassRoomRepository extends JpaRepository<ClassRoom, Long> {
}
