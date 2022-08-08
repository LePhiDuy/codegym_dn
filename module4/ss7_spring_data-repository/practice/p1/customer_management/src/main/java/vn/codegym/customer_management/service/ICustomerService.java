package vn.codegym.customer_management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.customer_management.model.Customer;
import vn.codegym.customer_management.model.Province;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findCustomersByFirstNameContaining(String name, Pageable pageable);
}
