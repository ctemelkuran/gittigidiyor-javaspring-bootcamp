package dev.patika.patika0401.repository;

import dev.patika.patika0401.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {


    @Query("SELECT " +
            "CASE WHEN COUNT(c)>0 " +
            "THEN TRUE ELSE FALSE END" +
            " FROM Customer c where c.ssid = :ssid")
    boolean selectExistsSsid(long ssid);


}
