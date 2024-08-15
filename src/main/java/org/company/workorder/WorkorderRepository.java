package org.company.workorder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serial;

public interface WorkorderRepository extends JpaRepository<Workorder, Serial> {
}
