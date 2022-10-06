package com.projectplan.dto;

public class ProjectPlanScheduleDto {
    private String name;
    private long durationInDays;

    public ProjectPlanScheduleDto() {
    }

    public ProjectPlanScheduleDto(String name, long durationInDays) {
        this.name = name;
        this.durationInDays = durationInDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(long durationInDays) {
        this.durationInDays = durationInDays;
    }
}
