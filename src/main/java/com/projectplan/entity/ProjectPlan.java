package com.projectplan.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ProjectPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_seq")
    @SequenceGenerator(name = "task_id_seq", allocationSize = 1)
    private int id;
    private String name;
    @OneToMany(mappedBy = "projectPlan", cascade = CascadeType.ALL)
    private List<Task> taskList;

    public ProjectPlan() {
    }

    public ProjectPlan(String name, List<Task> taskList) {
        this.name = name;
        this.taskList = taskList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
