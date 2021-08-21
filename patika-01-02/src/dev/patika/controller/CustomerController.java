package dev.patika.controller;

import dev.patika.models.Customer;
import dev.patika.models.Vehicle;
import dev.patika.service.CustomerService;

import java.util.List;

public class CustomerController {

    private CustomerService customerService = new CustomerService();
    public Customer findCustomer(int custId){
        return customerService.findById(custId);
    }

    public List<Customer> findAllCustomers(){
        return null;
    }

    public void saveCustomer(Customer customer){

    }
    public void deleteCustomer(int ssid){
        customerService.deleteFromDatabase(ssid);
    }
    public List<Vehicle> findVehiclesOfCustomer(long ssid){
        return null;
    }
}
