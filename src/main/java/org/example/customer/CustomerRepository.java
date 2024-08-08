package org.example.customer;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serial;
import java.util.List;
import java.util.Objects;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Serial> {

     List<Customer> findAll();
}
