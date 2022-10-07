package vn.codegym.exam_module4.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.exam_module4.entity.Agreement;
import vn.codegym.exam_module4.repository.IAgreementRepository;
import vn.codegym.exam_module4.service.IAgreementService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AgreementServiceImpl implements IAgreementService {
    @Autowired
    private IAgreementRepository agreementRepository;
    @Override
    public List<Agreement> findAll() {
        return agreementRepository.findAll();
    }

    @Override
    public void save(Agreement agreement) {
        agreementRepository.save(agreement);
    }

    @Override
    public void delete(String id) {
        agreementRepository.deleteAgreementById(id);
    }

    @Override
    public Optional<Agreement> findById(String id) {
        return agreementRepository.findById(id);
    }
}
