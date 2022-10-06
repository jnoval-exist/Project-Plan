package com.projectplan.entity.enumeration;

public enum TaskStatus {

    START("START"),
    NOT_STARTED("NOT_STARTED"),
    COMPLETED("COMPLETED");

    private String friendlyName;

    TaskStatus (String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getFriendlyName() {
        return this.friendlyName;
    }
}
