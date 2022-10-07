package vn.codegym.exam_module4.service;

import org.springframework.stereotype.Service;
import vn.codegym.exam_module4.entity.Agreement;
import vn.codegym.exam_module4.entity.Hostel;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface IAgreementService {
   List<Agreement> findAll();
   void save(Agreement agreement);
   void delete(String id);
   Optional<Agreement> findById(String id);
}
