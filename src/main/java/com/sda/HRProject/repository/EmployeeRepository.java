package com.sda.HRProject.repository;

import com.sda.HRProject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    Employee findByCNP(String CNP);

    List<Employee> findByPosition(String position);

    List<Employee> findByDaysOff(Integer daysOff);

    List<Employee> findByNorm(String norm);

    List<Employee> findByHireDate(String hireDate);

    List<Employee> findByEndDate(String endDate);

}
