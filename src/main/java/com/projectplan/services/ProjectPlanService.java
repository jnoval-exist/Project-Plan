package com.projectplan.services;

import com.projectplan.dto.ProjectPlanScheduleDto;
import com.projectplan.entity.ProjectPlan;
import com.projectplan.entity.Task;
import com.projectplan.entity.enumeration.TaskStatus;
import com.projectplan.repository.ProjectPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


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

    public ProjectPlan getSchedule(int id) {
        return projectPlanRepository.findById(id).orElseThrow(() -> new IllegalStateException("Project Plan does not exist"));
    }

    public ProjectPlan addProjectPlan(ProjectPlan projectPlan) {
        return projectPlanRepository.save(projectPlan);
    }

    public ProjectPlanScheduleDto calculateSchedule (int id) {
        ProjectPlan projectPlan = projectPlanRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Project Plan does not exist"));

        List<Task> excludeCompletedTasks = projectPlan.getTaskList().stream()
                .filter( task ->
                        !task.getStatus().equals(TaskStatus.COMPLETED))
                .collect(Collectors.toList());

        List<LocalDate> startDateList = excludeCompletedTasks.stream().map(Task::getStartDate).collect(Collectors.toList());
        List<LocalDate> endDateList = excludeCompletedTasks.stream().map(Task::getEndDate).collect(Collectors.toList());

        LocalDate startDateMin = Collections.min(startDateList);
        LocalDate endDateMax = Collections.max(endDateList);

        long daysBetween = ChronoUnit.DAYS.between(startDateMin, endDateMax);

        System.out.println("START DATE MIN: " + startDateMin);
        System.out.println("END DATE MAX: " + endDateMax);

        ProjectPlanScheduleDto projectPlanScheduleDto = new ProjectPlanScheduleDto(
                projectPlan.getName(),
                daysBetween
        );

        return projectPlanScheduleDto;
    }

    public List<ProjectPlanScheduleDto> calculateSchedules () {
        List<ProjectPlanScheduleDto> projectPlanScheduleDtos = new ArrayList<>();
        List<ProjectPlan> projectPlanList = projectPlanRepository.findAll();

        if (CollectionUtils.isEmpty(projectPlanList)) {
            return projectPlanScheduleDtos;
        }

        for (ProjectPlan projectPlan : projectPlanList) {
            List<Task> excludeCompletedTasks = projectPlan.getTaskList().stream()
                    .filter( task ->
                            !task.getStatus().equals(TaskStatus.COMPLETED))
                    .collect(Collectors.toList());

            List<LocalDate> startDateList = excludeCompletedTasks.stream().map(Task::getStartDate).collect(Collectors.toList());
            List<LocalDate> endDateList = excludeCompletedTasks.stream().map(Task::getEndDate).collect(Collectors.toList());

            LocalDate startDateMin = Collections.min(startDateList);
            LocalDate endDateMax = Collections.max(endDateList);

            long daysBetween = ChronoUnit.DAYS.between(startDateMin, endDateMax);

            System.out.println("START DATE MIN: " + startDateMin);
            System.out.println("END DATE MAX: " + endDateMax);

            ProjectPlanScheduleDto projectPlanScheduleDto = new ProjectPlanScheduleDto(
                    projectPlan.getName(),
                    daysBetween
            );

            projectPlanScheduleDtos.add(projectPlanScheduleDto);
        }

        return projectPlanScheduleDtos;
    }
}
