package com.example.employee.serviceImpl;

import com.example.employee.entity.Boss;
import com.example.employee.entity.Employee;
import com.example.employee.repository.BossRepository;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BossRepository bossRepository;

    public Employee saveEmployee(Employee employee,Integer bossId){


        Optional<Boss> bossTemp= bossRepository.findById(bossId);

        employee.setBoss(bossTemp.get());

        Employee employeeResult=employeeRepository.save(employee);
        return employeeResult;
    }

    public Employee getEmployeeById(Integer empId){

        Optional<Employee> employeeResult=employeeRepository.findById(empId);

        return employeeResult.get();
    }


    public List<Employee> getEmployeeLessThanAge(Integer age){

        List<Employee> employeeList =employeeRepository.findByEAgeLessThan(age);

        return employeeList;

    }

    public List<Employee> findByEAgeLessThanAndERatingGreaterThan(Integer age,Float eRate){

        List<Employee> employeeList=employeeRepository.findByEAgeLessThanAndERatingGreaterThan(age,eRate);

        return employeeList;
    }
}
