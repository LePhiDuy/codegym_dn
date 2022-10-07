package vn.codegym.exam_module4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.exam_module4.entity.Agreement;

public interface IAgreementRepository extends JpaRepository<Agreement, String> {
    void deleteAgreementById(String id);
}
