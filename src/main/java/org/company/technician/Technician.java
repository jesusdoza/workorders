package org.company.technician;


import jakarta.persistence.*;

@Entity(name = "technician")
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Column(name = "organization_id")
    private Long organizationId;

    public Technician(String name) {
        this.name = name;
    }

    public Technician() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrganization() {
        return organizationId;
    }

    public void setOrganization(Long organization) {
        this.organizationId = organization;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public String toString() {
        return "Technician{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", organizationId=" + organizationId +
                '}';
    }
}
