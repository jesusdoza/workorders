package org.workorder.workorder;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;


@Entity(name = "workorder")
class Workorder{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
    private String notes;
    private String description;
    private LocalDateTime date_arrived;


    public  Workorder(){

    }


}