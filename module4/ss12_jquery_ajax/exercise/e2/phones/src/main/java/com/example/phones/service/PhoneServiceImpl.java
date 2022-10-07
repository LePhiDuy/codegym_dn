package com.example.phones.service;

import com.example.phones.model.Phone;
import com.example.phones.repository.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PhoneServiceImpl implements IPhoneService{
    @Autowired
    private IPhoneRepository phoneRepository;
    @Override
    public Iterable<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Optional<Phone> findById(Long id) {
        return phoneRepository.findById(id);
    }

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public void delete(Long id) {
        phoneRepository.deleteById(id);
    }
}
