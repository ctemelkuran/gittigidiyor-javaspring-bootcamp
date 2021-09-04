package dev.patika.patika0401.service;

import dev.patika.patika0401.dto.CustomerDTO;
import dev.patika.patika0401.exceptions.BadRequestException;
import dev.patika.patika0401.mappers.CustomerMapper;
import dev.patika.patika0401.model.Customer;
import dev.patika.patika0401.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public Optional<Customer> saveCustomer(CustomerDTO customerDTO){

        boolean isExists = customerRepository.selectExistsSsid(customerDTO.getSsid());

        if(isExists){
            throw new BadRequestException("Customer with SSID : " + customerDTO.getSsid() + " is already exists!");
        }

        /*
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setSsid(customerDTO.getSsid());
        customer.setEmail(customerDTO.getEmail());
         */

        Customer customer = customerMapper.mapFromCustomerDTOtoCustomer(customerDTO);

        return Optional.of(customerRepository.save(customer));
    }

}
