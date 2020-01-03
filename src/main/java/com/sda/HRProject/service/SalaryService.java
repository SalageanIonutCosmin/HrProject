package com.sda.HRProject.service;

import com.sda.HRProject.model.Salary;
import com.sda.HRProject.repository.SalaryRepository;
import com.sda.HRProject.service.exceptions.SalaryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;

    public List<Salary> findAll(Integer page, Integer size) {
        List<Salary> salaryList = salaryRepository.findAll(PageRequest.of(page, size)).getContent();
        return salaryList;
    }

    public Salary findById(Integer id) {
        Optional<Salary> salaryById = salaryRepository.findById(id);
        if (salaryById.isPresent()) {
            Salary salary = salaryById.get();
            return salary;
        } else {
            throw new SalaryNotFoundException(String.format("No salary found with id: %s!", id));
        }
    }

    public List<Salary> findBySalary(Integer salary) {
        List<Salary> salaryList = salaryRepository.findBySalary(salary);
        if (salaryList.isEmpty()) {
            throw new SalaryNotFoundException(String.format("No salary found with salary: %s!", salary));
        } else {
            return salaryList;
        }
    }

    public List<Salary> findByStartDate(String startDate) {
        List<Salary> salaryList = salaryRepository.findByStartDate(startDate);
        if (salaryList.isEmpty()) {
            throw new SalaryNotFoundException(String.format("No salary found with start date: %s!", startDate));
        } else {
            return salaryList;
        }
    }

    public List<Salary> findByEndDate(String endDate) {
        List<Salary> salaryList = salaryRepository.findByEndDate(endDate);
        if (salaryList.isEmpty()) {
            throw new SalaryNotFoundException(String.format("No salary found with end date: %s!", endDate));
        } else {
            return salaryList;
        }
    }

    public List<Salary> findByTaxes(Integer taxes) {
        List<Salary> salaryList = salaryRepository.findByTaxes(taxes);
        if (salaryList.isEmpty()) {
            throw new SalaryNotFoundException(String.format("No salary found with taxes: %s!", taxes));
        } else {
            return salaryList;
        }
    }

    public List<Salary> addSalary(Salary salary) {
        salaryRepository.save(salary);
        List<Salary> salaryList = new ArrayList<>();
        salaryRepository.findAll().forEach(c -> {
            salaryList.add(c);
        });
        return salaryList;
    }

    public List<Salary> updateSalary(Salary salary) {
        List<Salary> salaryList = new ArrayList<>();
        salaryRepository.save(salary);
        salaryRepository.findAll().forEach(c -> {
            salaryList.add(c);
        });
        return salaryList;
    }

    public List<Salary> deleteSalary(Integer id) {
        Optional<Salary> salaryById = salaryRepository.findById(id);
        if (salaryById.isPresent()) {
            salaryRepository.deleteById(id);
            List<Salary> salaryList = new ArrayList<>();
            salaryRepository.findAll().forEach(c -> {
                salaryList.add(c);
            });
            return salaryList;
        } else {
            throw new SalaryNotFoundException(String.format("No salary found with id: %s!", id));
        }
    }

    public long count() {
        return salaryRepository.count();
    }
}
