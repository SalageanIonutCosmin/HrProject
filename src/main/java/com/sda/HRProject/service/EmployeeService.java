package com.sda.HRProject.service;

import com.sda.HRProject.model.Employee;
import com.sda.HRProject.repository.EmployeeRepository;
import com.sda.HRProject.service.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(Integer page, Integer size) {
        List<Employee> employeeList = employeeRepository.findAll(PageRequest.of(page, size)).getContent();
        return employeeList;
    }

    public Employee findById(Integer id) {
        Optional<Employee> employeeById = employeeRepository.findById(id);
        if (employeeById.isPresent()) {
            Employee employee = employeeById.get();
            return employee;
        } else {
            throw new EmployeeNotFoundException(String.format("No employee found the id: %s!, id"));
        }
    }

    public List<Employee> findByFirstName(String firstName) {
        List<Employee> employeeList = employeeRepository.findByFirstName(firstName);
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException(String.format("No employee found with first name: %s!", firstName));
        } else {
            return employeeList;
        }
    }

    public List<Employee> findByLastName(String lastName) {
        List<Employee> employeeList = employeeRepository.findByLastName(lastName);
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException(String.format("No employee found with last name: %s!", lastName));
        } else {
            return employeeList;
        }
    }

    public Employee findByCNP(String CNP) {
        Employee employee = employeeRepository.findByCNP(CNP);
        if (employee == null) {
            throw new EmployeeNotFoundException(String.format("No employee found with CNP: %s!", CNP));
        } else {
            return employee;
        }
    }

    public List<Employee> findByPosition(String position) {
        List<Employee> employeeList = employeeRepository.findByPosition(position);
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException(String.format("No employee found with position: %s!", position));
        } else {
            return employeeList;
        }
    }

    public List<Employee> findByDaysOff(Integer daysOff) {
        List<Employee> employeeList = employeeRepository.findByDaysOff(daysOff);
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException(String.format("No employee found with days off: %s!", daysOff));
        } else {
            return employeeList;
        }
    }

    public List<Employee> findByNorm(String norm) {
        List<Employee> employeeList = employeeRepository.findByNorm(norm);
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException(String.format("No employee found with norm: %s!", norm));
        } else {
            return employeeList;
        }
    }

    public List<Employee> findByHireDate(String hireDate) {
        List<Employee> employeeList = employeeRepository.findByHireDate(hireDate);
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException(String.format("No employee found with hire date: %s!", hireDate));
        } else {
            return employeeList;
        }
    }

    public List<Employee> findByEndDate(String endDate) {
        List<Employee> employeeList = employeeRepository.findByEndDate(endDate);
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException(String.format("No employee found with end date: %s!", endDate));
        } else {
            return employeeList;
        }
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> deleteEmployee(Integer id) {
        Optional<Employee> employeeById = employeeRepository.findById(id);
        if (employeeById.isPresent()) {
            employeeRepository.deleteById(id);
            List<Employee> employeeList = new ArrayList<>();
            employeeRepository.findAll().forEach(c -> {
                employeeList.add(c);
            });
            return employeeList;
        } else {
            throw new EmployeeNotFoundException(String.format("No employee found with id: %s!", id));
        }
    }

    public long count() {
        return employeeRepository.count();
    }
}

