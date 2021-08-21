package dev.patika.service;

import dev.patika.models.Customer;
import dev.patika.repository.CrudRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;

public class CustomerService implements CrudRepository<Customer>, CrudRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
    @Override
    public List<T> findAll() {
        return em.createQuery("select c from Customer c", Customer.class).getResultList(); //JPA'in özelliklerinden

    }

    @Override
    public Customer findById(int id) {
        Customer c = em.find(Customer.class, id);
        return c;
    }

    @Override
    public void saveToDatabase(Customer object) {

    }

    @Override
    public void deleteFromDatabase(Customer object) {

    }

    @Override
    public void deleteFromDatabase(int id) {

    }
    @Override
    public void deleteCustomerFromDatabase(long ssid) {

    }

    @Override
    public void updateOnDatabase(Customer object) {

    }
}
