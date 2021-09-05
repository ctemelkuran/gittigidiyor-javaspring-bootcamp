package dev.patika.patika0401.controller;

import dev.patika.patika0401.dto.CustomerDTO;
import dev.patika.patika0401.model.Customer;
import dev.patika.patika0401.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.crypto.spec.OAEPParameterSpec;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    CustomerService mockCustomerService;

    @InjectMocks
    CustomerController customerController;

    @Test
    void saveCustomer() {

        // gerçekten servise gitmek istemiyoruz o yüzden mock a ihtiyaç duyuyoruz.
        //given
        Customer customer = new Customer();
        Optional<Customer> expected = Optional.of(customer);
        Mockito.when(mockCustomerService.saveCustomer(Mockito.any())).thenReturn(expected);

        //when
        CustomerDTO dto = new CustomerDTO();
        Customer actual = this.customerController.saveCustomer(dto).getBody();

        // then
        assertAll(
                ()->assertNotNull(actual),
                ()->assertEquals(expected.get(), actual)
        );



    }
}