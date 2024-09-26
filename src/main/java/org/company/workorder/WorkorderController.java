package org.company.workorder;

import org.hibernate.jdbc.Work;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("test get workorder");
        return workorderRepository.findAll();
    }


    @PostMapping("")
    Workorder createWorkorder() {
        System.out.println("test post workorder");
//        System.out.println(newOrder);
//        return workorderRepository.save();
        return new Workorder();
    }
}
