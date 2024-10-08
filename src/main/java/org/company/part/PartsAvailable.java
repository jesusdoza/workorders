package org.company.part;

import jakarta.persistence.*;
import org.company.service_item.ServiceItem;

@Entity(name = "part_available")
public class PartsAvailable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "service_item_id", referencedColumnName = "id")
    private ServiceItem serviceItem;

    @ManyToOne
    @JoinColumn(name = "part_id", referencedColumnName = "id")
    private Part part;

    // Getters and Setters
}
