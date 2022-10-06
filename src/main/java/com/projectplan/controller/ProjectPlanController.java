package com.projectplan.controller;

import com.projectplan.dto.ProjectPlanScheduleDto;
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

    @GetMapping("/{id}")
    public ProjectPlan getSchedule(@PathVariable int id) {
        return projectPlanService.getSchedule(id);
    }

    @PostMapping
    public ProjectPlan addProjectPlan(ProjectPlan projectPlan) {
        return projectPlanService.addProjectPlan(projectPlan);
    }

    @GetMapping("calculate-schedules/{id}")
    public ProjectPlanScheduleDto calculateSchedule (@PathVariable int id) {
        return projectPlanService.calculateSchedule(id);
    }

    @GetMapping("calculate-schedules")
    public List<ProjectPlanScheduleDto> calculateSchedules () {
        return projectPlanService.calculateSchedules();
    }
}
