package com.example.employee.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Boss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer bId;

    public String bName;

    public Float bRating;

    public Double bSalary;

    @OneToMany(mappedBy = "boss", cascade = CascadeType.ALL, orphanRemoval = false)
    public List<Employee> employeeList;

    public Boss(){
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public Float getbRating() {
        return bRating;
    }

    public void setbRating(Float bRating) {
        this.bRating = bRating;
    }

    public Double getbSalary() {
        return bSalary;
    }

    public void setbSalary(Double bSalary) {
        this.bSalary = bSalary;
    }


    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
