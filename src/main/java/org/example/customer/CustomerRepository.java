package org.example.customer;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class CustomerRepository {


    private ArrayList<Customer> customerList = new ArrayList<>(Arrays.asList( new Customer("1","bob","company1")));


    public CustomerRepository() {

    }


    public List<Customer> getAll(){
        return customerList;
    }
}
