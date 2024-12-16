package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


    List<Employee> findByEAgeLessThan(Integer age);



    List<Employee> findByEAgeLessThanAndERatingGreaterThan(Integer age,Float erate);


}
