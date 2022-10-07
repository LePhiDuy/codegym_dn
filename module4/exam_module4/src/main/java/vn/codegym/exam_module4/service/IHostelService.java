package vn.codegym.exam_module4.service;

import org.springframework.stereotype.Service;
import vn.codegym.exam_module4.entity.Hostel;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface IHostelService {
    List<Hostel> findAll();
    List<Hostel> findHostelFree();
}
