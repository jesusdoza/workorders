package org.company.workorder;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/workorder")
public class WorkorderController {

    WorkorderRepository workorderRepository;

    List<Workorder> getAll() {
        return workorderRepository.findAll();
    }
}
