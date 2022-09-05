package com.example.phones.service;

import com.example.phones.model.Phone;

import java.util.Optional;

public interface IPhoneService {
    Iterable<Phone> findAll();
    Optional<Phone> findById(Long id);
    Phone save(Phone phone);
    void delete(Long id);
}
