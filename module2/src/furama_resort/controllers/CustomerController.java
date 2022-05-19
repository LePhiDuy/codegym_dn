package furama_resort.controllers;

import furama_resort.models.Customer;
import furama_resort.services.Impl.CustomerServiceImpl;

import java.util.List;

public class CustomerController {
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    public void save(Customer customer) {
        customerServiceImpl.save(customer);
    }
    public List<Customer> getAll() {
        return customerServiceImpl.getAll();
    }
}
