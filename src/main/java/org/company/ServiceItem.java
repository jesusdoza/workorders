package org.company;

import jakarta.persistence.*;
import org.company.part.Part;
import org.hibernate.annotations.ManyToAny;

import java.util.Set;

//@Entity(name = "service_items")
public class ServiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;


    private String description;
    private String name;
    private String image;
    private String part_number;
    private String manufacturer;

    @ManyToAny
    @Column(name = "parts_available")
    private Set<Part> partsAvailable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

