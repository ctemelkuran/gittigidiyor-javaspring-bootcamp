package dev.patika.patika0401.mappers;

import dev.patika.patika0401.dto.CustomerDTO;
import dev.patika.patika0401.model.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer mapFromCustomerDTOtoCustomer(CustomerDTO dto);
    CustomerDTO mapFromCustomertoCustomerDTO(Customer customer);

}
