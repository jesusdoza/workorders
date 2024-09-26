package org.company.workorder;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public record WorkOrderPostRequest(
        String title,
        String notes,
        String description,
        LocalDateTime dateArrived,
        Long serviceItemId,
        Long technicianId,
        Long customerId
) {
}
