package com.sda.HRProject.repository;

import com.sda.HRProject.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {
    List<Salary> findByGrossSalary(Float grossSalary);

    List<Salary> findByStartDate(String startDate);

    List<Salary> findByEndDate(String endDate);

    List<Salary> findByTaxes(Float taxes);
}
