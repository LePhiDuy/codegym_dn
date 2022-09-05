package com.example.phones.repository;

import com.example.phones.model.Phone;
import org.springframework.data.repository.CrudRepository;

public interface IPhoneRepository extends CrudRepository<Phone, Long> {
}
