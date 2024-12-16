package com.example.employee.controller;

import com.example.employee.entity.Boss;
import com.example.employee.serviceImpl.BossServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BossController {

    @Autowired
    private BossServiceImpl bossService;

    @PostMapping("/addBoss")
    public Boss saveBoss(@RequestBody Boss boss){

        Boss bossResult=bossService.saveBoss((boss));
        return bossResult;
    }

    @GetMapping("/getBossById/{bossId}")
    public Boss getBossById(@PathVariable Integer bossId){
        Boss bossResult=bossService.getBossById(bossId);

        return bossResult;
    }

    @GetMapping("/update/{bRate}")
    public int updateBSalaryByBRating(@PathVariable Float bRate){
        int result=bossService.updateBSalaryByBRating(bRate);

        return result;
    }
}
