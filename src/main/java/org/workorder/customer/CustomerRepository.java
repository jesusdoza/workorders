package org.workorder.customer;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serial;
import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Serial> {

     List<Customer> findAll();
}
