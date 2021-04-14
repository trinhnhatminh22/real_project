package com.ptt.mvc.model;

import javax.persistence.*;

@Entity

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nameTask;
    @Column
    private int status;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Project project;

    public Task() {
    }

    public Task(Integer id, int projectId, int employeeId, String nameTask, int status) {
        this.id = id;
        this.nameTask = nameTask;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
