package com.ptt.mvc.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String customerName;
    @Column
    private String incharge;
    @Column
    private Date start;
    @Column
    private int number;

    @ManyToMany
    private Set<Employee> employees = new HashSet<Employee>();

    @OneToMany
    private Set<Task> listTask = new HashSet<Task>();

    public Project() {
    }

    public Project(Integer id, String name, String customerName, String incharge, Date start, int number, Set<Employee> employees, Set<Task> listTask) {
        this.id = id;
        this.name = name;
        this.customerName = customerName;
        this.incharge = incharge;
        this.start = start;
        this.number = number;
        this.employees = employees;
        this.listTask = listTask;
    }

    public Project(Integer id, String name, String customerName, String incharge, Date start, int number) {
        this.id = id;
        this.name = name;
        this.customerName = customerName;
        this.incharge = incharge;
        this.start = start;
        this.number = number;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIncharge() {
        return incharge;
    }

    public void setIncharge(String incharge) {
        this.incharge = incharge;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Task> getListTask() {
        return listTask;
    }

    public void setListTask(Set<Task> listTask) {
        this.listTask = listTask;
    }
}
