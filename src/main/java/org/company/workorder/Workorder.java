package org.company.workorder;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity(name = "work_order")
public class Workorder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title = "";
    private String notes = "";
    private String description = "";
    private LocalDateTime date_arrived = LocalDateTime.now();
    private LocalDateTime created_at = LocalDateTime.now();
    private String status = "pending";

    @Column(name = "technician_id")
    private Long technician;
    private Long customer_id;


    public Workorder() {

    }

    public Workorder(String title) {
        this.title = title;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate_arrived() {
        return this.date_arrived;
    }

    public void setDate_arrived(LocalDateTime date_arrived) {
        this.date_arrived = date_arrived;
    }

    public LocalDateTime getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTechnician() {
        return this.technician;
    }

    public void setTechnician(Long technician) {
        this.technician = technician;
    }


    public Long getCustomer_id() {
        return this.customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
}