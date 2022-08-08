package vn.codegym.customer_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.customer_management.model.Province;
import vn.codegym.customer_management.repository.IProvinceRepository;
import vn.codegym.customer_management.service.IProvinceService;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class ProvinceServiceImpl implements IProvinceService {
    @Autowired
    IProvinceRepository provinceRepository;
    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
