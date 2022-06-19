package service;

import model.Customer;
import repository.CustomerRepositoryImpl;
import repository.ICustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService{
    private ICustomerRepository customers = new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAll() {
        return customers.findAll();
    }

    @Override
    public void save(Customer customer) {
        customers.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.update(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
