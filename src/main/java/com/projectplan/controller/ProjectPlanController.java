package com.projectplan.controller;

import com.projectplan.dto.ProjectPlanScheduleDto;
import com.projectplan.entity.ProjectPlan;
import com.projectplan.services.ProjectPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ProjectPlan>> getProjectPlans() {
        return ResponseEntity.ok(projectPlanService.getProjectPlans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectPlan> getSchedule(@PathVariable int id) {
        return ResponseEntity.ok(projectPlanService.getSchedule(id));
    }

    @PostMapping
    public ResponseEntity<ProjectPlan> addProjectPlan(ProjectPlan projectPlan) {
        return ResponseEntity.ok(projectPlanService.addProjectPlan(projectPlan));
    }

    @GetMapping("calculate-schedules/{id}")
    public ResponseEntity<ProjectPlanScheduleDto> calculateSchedule (@PathVariable int id) {
        return ResponseEntity.ok(projectPlanService.calculateSchedule(id));
    }

    @GetMapping("calculate-schedules")
    public ResponseEntity<List<ProjectPlanScheduleDto>> calculateSchedules () {
        return ResponseEntity.ok(projectPlanService.calculateSchedules());
    }
}
