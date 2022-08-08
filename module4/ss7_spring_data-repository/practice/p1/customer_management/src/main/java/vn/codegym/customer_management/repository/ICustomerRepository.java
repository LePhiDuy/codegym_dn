package vn.codegym.customer_management.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.codegym.customer_management.model.Customer;
import vn.codegym.customer_management.model.Province;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findCustomersByFirstNameContaining(String name, Pageable pageable);
}
