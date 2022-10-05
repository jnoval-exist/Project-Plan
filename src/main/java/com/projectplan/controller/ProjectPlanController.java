package com.projectplan.controller;

import com.projectplan.entity.ProjectPlan;
import com.projectplan.services.ProjectPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/project-plan")
public class ProjectPlanController {

    private final ProjectPlanService projectPlanService;

    @Autowired
    public ProjectPlanController (ProjectPlanService projectPlanService) {
        this.projectPlanService = projectPlanService;
    }

    @GetMapping
    public List<ProjectPlan> getProjectPlans() {
        return projectPlanService.getProjectPlans();
    }

    @PostMapping
    public ProjectPlan addProjectPlan(ProjectPlan projectPlan) {
        return projectPlanService.addProjectPlan(projectPlan);
    }

}
