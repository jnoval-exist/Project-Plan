package com.projectplan.services;

import com.projectplan.entity.Task;
import com.projectplan.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Transactional
    public Task addTask(Task task) {
        if (task.getDependency() != null) {
            String[] dependencies = task.getDependency().split(",");
            for (String dependency:  dependencies) {
               taskRepository.findById(Integer.parseInt(dependency))
                        .orElseThrow(() -> new IllegalStateException("Dependent TaskID provided does not exist"));
            }
        }
        return taskRepository.save(task);
    }

    public Task updateTask(int id, String status) {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (!taskOptional.isPresent()) {
            throw new IllegalStateException("Id does not exist");
        }

        Task task = taskOptional.get();
        // Dependency check
        checkDependency(task);
        task.setStatus(status);

        taskRepository.save(task);

        return task;
    }

    private void checkDependency(Task task) {
        if (task.getDependency() != null) {
            String[] dependencies = task.getDependency().split(",");
            for (String dependency:  dependencies) {
                Optional<Task> taskOptional = taskRepository.findById(Integer.parseInt(dependency));

                if (taskOptional.isPresent()) {
                    Task dbTask = taskOptional.get();
                    if (!dbTask.getStatus().equals("Completed")) {
                        throw new IllegalStateException("Please finish task: " + dbTask.getTaskName());
                    }
                }
            }
        }
    }
}
