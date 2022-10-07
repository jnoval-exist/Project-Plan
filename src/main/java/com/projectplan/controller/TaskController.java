package com.projectplan.controller;

import com.projectplan.entity.Task;
import com.projectplan.entity.enumeration.TaskStatus;
import com.projectplan.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Task>> getTasks() {
       return ResponseEntity.ok(taskService.getTasks());
    }

    @PostMapping
    public ResponseEntity<Task> addTask (Task task) {
        return ResponseEntity.ok(taskService.addTask(task));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> updateStatus(@PathVariable int id, @RequestParam TaskStatus status) {
        return ResponseEntity.ok(taskService.updateTask(id, status));
    }
}
