package com.projectplan.repository;

import com.projectplan.entity.ProjectPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectPlanRepository extends JpaRepository<ProjectPlan, Integer> {
}
