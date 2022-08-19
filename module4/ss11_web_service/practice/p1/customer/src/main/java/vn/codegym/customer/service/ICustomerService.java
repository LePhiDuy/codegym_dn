package vn.codegym.customer.service;

import vn.codegym.customer.entity.Customer;

import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();
    Optional<Customer> findById(Long id);
    void save(Customer customer);
    void delete(Long id);
}
