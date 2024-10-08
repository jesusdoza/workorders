package org.company.service_item;

import jakarta.persistence.*;

@Entity(name = "service_item")
public class ServiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private String name;

    private String image;

    @Column(name = "part_number")
    private String partNumber;

    private String manufacturer;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "organization_id")
    private Long organizationId;

    public ServiceItem(String name, String serial) {
        this.name = name;
        this.serialNumber = serial;
    }

    public ServiceItem() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPart_number() {
        return partNumber;
    }

    public void setPart_number(String part_number) {
        this.partNumber = part_number;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSerial_number() {
        return serialNumber;
    }

    public void setSerial_number(String serial_number) {
        this.serialNumber = serial_number;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public String toString() {
        return "ServiceItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", partNumber='" + partNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", organizationId=" + organizationId +
                '}';
    }
}
