package com.rk_group.springboot.to_do_list.models;

import com.rk_group.springboot.to_do_list.services.Status;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

public class Todo {
    private long id;
    private String userName;
    private String taskName;
    private LocalDate createdDate;
    private LocalDate startDate;
    private LocalDate finishDate;
    private Status status;

    private static final AtomicLong counter = new AtomicLong();

    public Todo(String userName, String taskName, LocalDate startDate, LocalDate finishDate, Status status){
        this.id = counter.incrementAndGet();
        this.userName =userName;
        this.taskName =taskName;
        this.createdDate = LocalDate.now();
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.status=status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
