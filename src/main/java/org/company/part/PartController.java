package org.company.part;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/part")
public class PartController {
    private PartRepository repository;

    public PartController(PartRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Part> getAll() {
        return repository.findAll();
    }
}
