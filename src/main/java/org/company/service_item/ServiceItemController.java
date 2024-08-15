package org.company.service_item;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service_item")
public class ServiceItemController {

    private ServiceItemRepository repository;

    public ServiceItemController(ServiceItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<ServiceItem> getAllServiceItems() {

        return this.repository.findAll();
    }
}
