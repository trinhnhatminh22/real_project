package com.ptt.mvc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String address;
    @Column
    private String department;

    @JsonIgnore
    @ManyToMany
    private List<Project> project;

    @JsonIgnore
    @OneToMany
    private List<Task> listTask;

    public Employee() {
    }

    public Employee(Integer id, String name, int age, String address, String department, List<Project> project, List<Task> listTask) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.department = department;
        this.project = project;
        this.listTask = listTask;
    }

    public Employee(Integer id, String name, int age, String address, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }

    public List<Task> getListTask() {
        return listTask;
    }

    public void setListTask(List<Task> listTask) {
        this.listTask = listTask;
    }
}
