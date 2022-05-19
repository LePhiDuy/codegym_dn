package furama_resort.services.Impl;

import furama_resort.models.Customer;
import furama_resort.services.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customers = new ArrayList<>();
    @Override
    public void save(Customer customer) {
        if (customer.getID() > 0) {
            int index = customers.indexOf(customer);
            customers.set(index, customer);
        } else {
            customer.setID(customers.size() + 1);
            customers.add(customer);
        }
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }
}
