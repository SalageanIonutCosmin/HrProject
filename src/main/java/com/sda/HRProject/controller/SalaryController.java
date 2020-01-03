package com.sda.HRProject.controller;

import com.sda.HRProject.model.Salary;
import com.sda.HRProject.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/salaries")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @GetMapping(value = "")
    public String findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                          @RequestParam(value = "size", defaultValue = "100") Integer size,
                          ModelMap modelMap) {
        List<Salary> salaryList = salaryService.findAll(page, size);
        modelMap.addAttribute("salaryList", salaryList);
        return "salaryListView";
    }

    @GetMapping(value = "/add")
    public String addNewSalaryView(ModelMap modelMap) {
        modelMap.addAttribute("salary", new Salary());
        return "salaryAddView";
    }

    @PostMapping(value = "/add")
    public String addSalary(@ModelAttribute("salary") Salary salary, ModelMap modelMap) {
        List<Salary> salaryList = salaryService.addSalary(salary);
        modelMap.addAttribute("salaryList", salaryList);
        return "salaryListView";
    }

    @GetMapping(value = "/update/{id}")
    public String updateSalaryView(@PathVariable(name = "id") Integer id, ModelMap modelMap) {
        Salary salary = salaryService.findById(id);
        modelMap.addAttribute("salary", salary);
        return "salaryUpdateView";
    }

    @PostMapping(value = "/update")
    public String updateSalarySave(@ModelAttribute("salary") Salary salary, ModelMap modelMap) {
        List<Salary> salaryList = salaryService.updateSalary(salary);
        modelMap.addAttribute("salaryList", salaryList);
        return "redirect:/salaries/";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteSalary(@PathVariable(name = "id") Integer id, ModelMap modelMap) {
        List<Salary> salaryList = salaryService.deleteSalary(id);
        modelMap.addAttribute("salaryList", salaryList);
        return "redirect:/salaries/";
    }

    @GetMapping(value = "salary")
    public String findBySalary(@PathVariable(name = "salary") Integer salary, ModelMap modelMap) {
        List<Salary> bySalary = salaryService.findBySalary(salary);
        modelMap.addAttribute("salaryList", bySalary);
        return "salaryListView";
    }

    @GetMapping(value = "startDate")
    public String findByStartDate(@PathVariable(name = "startDate") String startDate, ModelMap modelMap) {
        List<Salary> byStartDate = salaryService.findByStartDate(startDate);
        modelMap.addAttribute("salaryList", byStartDate);
        return "salaryListView";
    }

    @GetMapping(value = "endDate")
    public String findByEndDate(@PathVariable(name = "endDate") String endDate, ModelMap modelMap) {
        List<Salary> byEndDate = salaryService.findByEndDate(endDate);
        modelMap.addAttribute("salaryList", byEndDate);
        return "salaryListView";
    }

    @GetMapping(value = "taxes")
    public String findByTaxes(@PathVariable(name = "taxes") Integer taxes, ModelMap modelMap) {
        List<Salary> byTaxes = salaryService.findByTaxes(taxes);
        modelMap.addAttribute("salaryList", byTaxes);
        return "salaryListView";
    }

    @GetMapping(value = "/count")
    public String count(ModelMap modelMap) {
        long count = salaryService.count();
        modelMap.addAttribute("salaryList", count);
        return "salaryListView";
    }
}
