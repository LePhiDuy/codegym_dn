package vn.codegym.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.customer.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
