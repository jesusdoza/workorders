package org.company.part;

import jakarta.persistence.*;


@Entity(name = "part")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String part_number;
    private String description;
    private Long quantity;
    

    public Part() {
    }


}
