package vn.codegym.customer_management.service;

import vn.codegym.customer_management.model.Customer;
import vn.codegym.customer_management.model.Province;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
