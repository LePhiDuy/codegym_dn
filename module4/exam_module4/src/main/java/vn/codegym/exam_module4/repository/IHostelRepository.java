package vn.codegym.exam_module4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.exam_module4.entity.Hostel;

import java.util.List;

public interface IHostelRepository extends JpaRepository<Hostel, String> {
    List<Hostel> findHostelByStatus(boolean status);
}
