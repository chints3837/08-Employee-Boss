package com.example.employee.repository;

import com.example.employee.entity.Boss;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BossRepository extends JpaRepository<Boss,Integer> {


    @Modifying
    @Transactional
    @Query(value = "Update Boss set b_Salary =b_Salary + 500 where b_Rating >:b_Rating",nativeQuery = true)
    int updateBSalaryByBRating(@Param("b_Rating") Float b_Rating);
}
