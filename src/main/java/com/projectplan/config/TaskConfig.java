package com.projectplan.config;

import com.projectplan.entity.ProjectPlan;
import com.projectplan.entity.Task;
import com.projectplan.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

//@Configuration
public class TaskConfig {

//    @Bean
//    CommandLineRunner commandLineRunner (TaskRepository taskRepository) {
//        return args -> {
//
//            Task task = new Task("Task1", LocalDate.of(2022, 3,29), LocalDate.of(2022, 3,31), "Completed", "");
//            Task task1 = new Task("Task2", LocalDate.of(2022, 3, 29), LocalDate.of(2022, 3, 30), "Not Started", "");
//            Task task2 = new Task("Task3", LocalDate.of(2022, 3, 29), LocalDate.of(2022, 3, 30), "Not Started", "1");
//            Task task3 = new Task("Task4", LocalDate.of(2022, 3, 29), LocalDate.of(2022, 3, 30), "Not Started", "1,3,2");
//            Task task4 = new Task("Task5", LocalDate.of(2022, 3, 29), LocalDate.of(2022, 3, 30), "Not Started", "2");
//
//            taskRepository.saveAll(List.of(task, task1, task2, task3, task4));
//        };
//    }

}
