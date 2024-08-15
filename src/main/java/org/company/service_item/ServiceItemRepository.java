package org.company.service_item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serial;

@Repository
public interface ServiceItemRepository extends JpaRepository<ServiceItem, Serial> {


}
