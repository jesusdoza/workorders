package org.company.part;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serial;

@Repository
public interface PartRepository extends JpaRepository<Part, Serial> {
}
