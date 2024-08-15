package org.company.part;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/part")
public class PartController {
    private PartRepository repository;

    public PartController(PartRepository repository) {
    }

    @RequestMapping("")
    List<Part> getAll() {
        return this.repository.findAll();
    }
}
