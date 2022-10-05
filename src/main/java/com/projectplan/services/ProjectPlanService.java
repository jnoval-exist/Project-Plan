package com.projectplan.services;

import com.projectplan.entity.ProjectPlan;
import com.projectplan.repository.ProjectPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectPlanService {

    private ProjectPlanRepository projectPlanRepository;

    @Autowired
    public ProjectPlanService (ProjectPlanRepository projectPlanRepository) {
        this.projectPlanRepository = projectPlanRepository;
    }

    public List<ProjectPlan> getProjectPlans() {
        return projectPlanRepository.findAll();
    }

    public ProjectPlan addProjectPlan(ProjectPlan projectPlan) {
        return projectPlanRepository.save(projectPlan);
    }

}
