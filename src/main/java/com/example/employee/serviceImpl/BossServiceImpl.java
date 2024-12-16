package com.example.employee.serviceImpl;

import com.example.employee.entity.Boss;
import com.example.employee.entity.Employee;
import com.example.employee.repository.BossRepository;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BossServiceImpl {

    @Autowired
    private BossRepository bossRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    public Boss saveBoss(Boss boss){

        System.out.println("Inside saveBoss() method");

        //temp Boss object
        Boss bossTemp=new Boss();
        bossTemp.setbName(boss.getbName());
        bossTemp.setbRating(boss.getbRating());

        List<Employee> employeeList=new ArrayList<>();


        if(boss.getEmployeeList() !=null){
            for(Employee employee:boss.getEmployeeList()){

                Employee empObj=new Employee(employee.geteId(),employee.geteName(),employee.geteAge(),employee.geteRating(),employee.geteSalary());

                empObj.setBoss(bossTemp);

                employeeList.add(empObj);

            }
        }

        bossTemp.setEmployeeList(employeeList);

        //final Boss Save
        Boss bossResult=bossRepository.save(bossTemp);

        return bossResult;

    }

    public Boss getBossById(Integer bossId){
        Optional<Boss> bossResult = bossRepository.findById(bossId);

        return bossResult.get();
    }


    public int updateBSalaryByBRating(Float bRate){
        int result=bossRepository.updateBSalaryByBRating(bRate);
        return result;
    }


}

