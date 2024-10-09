package org.company.customer;


import jakarta.persistence.*;

@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String company;
    @Column(name = "contact_info")
    private String contactInfo;
    @Column(name = "organization_id")
    private Long organizationId;


    public Customer(Long id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public Customer(String name, String company, String contactInfo) {

        this.name = name;
        this.company = company;
        this.contactInfo = contactInfo;
    }

    public Customer() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContact_info() {
        return contactInfo;
    }

    public void setContact_info(String contact_info) {
        this.contactInfo = contact_info;
    }

    public Long getOrganization_id() {
        return organizationId;
    }

    public void setOrganization_id(Long organization_id) {
        this.organizationId = organization_id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", contact_info='" + contactInfo + '\'' +
                ", organizationId=" + organizationId +
                '}';
    }
}
