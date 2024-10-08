package org.company.customer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serial;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Serial> {


}
