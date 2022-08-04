package vn.codegym.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import vn.codegym.model.Customer;
import vn.codegym.repository.ICustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("select c from Customer as c", Customer.class).getResultList();
    }

    @Override
    public Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() != null) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }
}
