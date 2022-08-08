package vn.codegym.customer_management.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.codegym.customer_management.model.Customer;
import vn.codegym.customer_management.model.Province;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
