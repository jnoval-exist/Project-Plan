package com.projectplan.controller;

import com.projectplan.entity.Task;
import com.projectplan.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController (TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
       return taskService.getTasks();
    }

    @PostMapping
    public Task addTask (Task task) {
        return taskService.addTask(task);
    }

    @PatchMapping("/{id}")
    public Task updateStatus(@PathVariable int id, @RequestParam String status) {
        return taskService.updateTask(id, status);
    }
}
