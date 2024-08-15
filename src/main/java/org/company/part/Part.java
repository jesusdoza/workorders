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
    private String application;

    public Part() {
    }

    public Part(Long id, String name, String part_number, String description, String application) {
        this.id = id;
        this.name = name;
        this.part_number = part_number;
        this.description = description;
        this.application = application;
    }

}
