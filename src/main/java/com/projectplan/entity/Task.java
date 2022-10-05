package com.projectplan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


import java.time.LocalDate;

@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_plan_id_seq")
    @SequenceGenerator(name = "project_plan_id_seq", allocationSize = 1)
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="projectPlan_id", referencedColumnName="id")
    private ProjectPlan projectPlan;
    private String taskName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private String dependency;

    public Task() {
    }

    public Task(String taskName, ProjectPlan projectPlan, LocalDate startDate, LocalDate endDate, String status, String dependency) {
        this.taskName = taskName;
        this.projectPlan = projectPlan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.dependency = dependency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProjectPlan getProjectPlan() {
        return projectPlan;
    }

    public void setProjectPlan(ProjectPlan projectPlan) {
        this.projectPlan = projectPlan;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDependency() {
        return dependency;
    }

    public void setDependency(String dependency) {
        this.dependency = dependency;
    }
}
