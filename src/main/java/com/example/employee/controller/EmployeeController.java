package com.example.employee.controller;

import com.example.employee.entity.Employee;
import com.example.employee.serviceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;


    @PostMapping("/addEmployee/{bossId}")
    public Employee addEmployee(@RequestBody Employee employee, @PathVariable Integer bossId){

        Employee employeeResult=employeeService.saveEmployee(employee,bossId);
        return employeeResult;

    }

    @GetMapping("/getEmployeeById/{empId}")
    public Employee getEmployeeById(@PathVariable Integer empId){

        Employee employeeResult = employeeService.getEmployeeById(empId);
        return employeeResult;
    }

    @GetMapping("/getEmployeeByAge/{age}")
    public List<Employee> getEmployeeLessThanAge(@PathVariable Integer age){

        List<Employee> employeeList=employeeService.getEmployeeLessThanAge(age);

        return employeeList;
    }

    @GetMapping("/getEMployeeByAgeAndRating/{age}/{rate}")
    public List<Employee> getEmployeeUnderAgeAndRatingGreater(@PathVariable Integer age,@PathVariable Float rate){
        List<Employee>  employeeList= employeeService.findByEAgeLessThanAndERatingGreaterThan(age,rate);

        return employeeList;
    }


}
