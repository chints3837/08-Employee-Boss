package com.example.employee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer eId;

    public String eName;

    public Integer eAge;

    public Float eRating;

    public Double eSalary;

    @ManyToOne
    @JoinColumn(name = "b_id",nullable = false)
    @JsonIgnore
    public Boss boss;

    public Employee(){

    }
    public Employee(Integer id,String name,Integer age,Float eRating,Double eSalary){
        this.eId=id;
        this.eName=name;
        this.eAge=age;
        this.eRating=eRating;
        this.eSalary=eSalary;

    }



    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Integer geteAge() {
        return eAge;
    }

    public void seteAge(Integer eAge) {
        this.eAge = eAge;
    }

    public Float geteRating() {
        return eRating;
    }

    public void seteRating(Float eRating) {
        this.eRating = eRating;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public Double geteSalary() {
        return eSalary;
    }

    public void seteSalary(Double eSalary) {
        this.eSalary = eSalary;
    }
}
