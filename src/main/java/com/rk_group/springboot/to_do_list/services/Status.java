package com.rk_group.springboot.to_do_list.services;

public enum Status {
    NOT_YET_STARTED("Not Yet Started"),
    STARTED("Started"),
    IN_PROGRESS("In Progress"),
    DELAYED("Delayed"),
    COMPLETED("Completed");

    private final String message;

    Status(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
