package org.company.workorder;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity(name = "work_order")
public class Workorder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime dateArrived = LocalDateTime.now();
    private LocalDateTime modifiedAt = LocalDateTime.now();
    private String title = "";
    private String status = "pending";
    private String description = "";
    private String notes = "";
    @Column(name = "technician_id")
    private Long technicianId;
    @Column(name = "customer_id")
    private Long customerId;

    public Workorder() {

    }

    //stored in another table with serviceitem to work order relations
//    @Column(name = "service_item_id")
//    private Long serviceItemId;

    public Workorder(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Workorder{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", dateArrived=" + dateArrived +
                ", modifiedAt=" + modifiedAt +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                ", technicianId=" + technicianId +
                ", customerId=" + customerId +
                '}';
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public LocalDateTime getDateArrived() {
        return dateArrived;
    }

    public void setDateArrived(LocalDateTime dateArrived) {
        this.dateArrived = dateArrived;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public Long getService_item_id() {
//        return serviceItemId;
//    }
//
//    public void setService_item_id(Long service_item_id) {
//        this.serviceItemId = service_item_id;
//    }

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
        return this.dateArrived;
    }

    public void setDate_arrived(LocalDateTime date_arrived) {
        this.dateArrived = date_arrived;
    }

    public LocalDateTime getCreated_at() {
        return this.createdAt;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.createdAt = created_at;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTechnician() {
        return this.technicianId;
    }

    public void setTechnician(Long technician) {
        this.technicianId = technician;
    }


    public Long getCustomer_id() {
        return this.customerId;
    }

    public void setCustomer_id(Long customer_id) {
        this.customerId = customer_id;
    }

    public Long getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Long technicianId) {
        this.technicianId = technicianId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}