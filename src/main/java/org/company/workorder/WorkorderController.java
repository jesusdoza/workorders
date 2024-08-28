package org.company.workorder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/workorder")
public class WorkorderController {

    WorkorderRepository workorderRepository;

    public WorkorderController(WorkorderRepository workorderRepository) {
        this.workorderRepository = workorderRepository;
    }


    @GetMapping("")
    List<Workorder> getAll() {
        return workorderRepository.findAll();
    }
}
