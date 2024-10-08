package org.company.technician;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tech")
public class TechnicianController {


    private TechnicianRepository repository;


    public TechnicianController(TechnicianRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Technician> getAllTechs() {
        return repository.findAll();
    }
}
