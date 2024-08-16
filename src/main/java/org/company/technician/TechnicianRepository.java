package org.company.technician;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serial;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Serial> {
}
