package org.workorder.workorder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;


@Entity(name = "workorder")
class Workorder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String notes;
    private String description;
    private LocalDateTime date_arrived;
    private LocalDateTime created_at;
    private String status;
    private Long technician;
    private Long item_id;
    private Long customer_id;


    public Workorder() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate_arrived() {
        return date_arrived;
    }

    public void setDate_arrived(LocalDateTime date_arrived) {
        this.date_arrived = date_arrived;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTechnician() {
        return technician;
    }

    public void setTechnician(Long technician) {
        this.technician = technician;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
}