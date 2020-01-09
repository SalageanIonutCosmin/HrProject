package com.sda.HRProject.controller;

import com.sda.HRProject.model.Employee;
import com.sda.HRProject.service.EmployeeService;
import com.sda.HRProject.util.GenerateEmployeePDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "")
    public String findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                          @RequestParam(value = "size", defaultValue = "100") Integer size,
                          ModelMap modelMap) {
        List<Employee> employeeList = employeeService.findAll(page, size);
        modelMap.addAttribute("employeeList", employeeList);
        return "employeeListView";
    }

    @GetMapping(value = "/add")
    public String addEmployeeView(ModelMap modelMap) {
        modelMap.addAttribute("employee", new Employee());
        return "employeeAddView";
    }

    @PostMapping(value = "/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee, ModelMap modelMap) {
        List<Employee> employeeList = employeeService.addEmployee(employee);
        modelMap.addAttribute("employeeList", employeeList);
        return "employeeListView";
    }

    @GetMapping(value = "/update/{id}")
    public String updateEmployeeView(@PathVariable(name = "id") Integer id, ModelMap modelMap) {
        Employee employee = employeeService.findById(id);
        modelMap.addAttribute("employee", employee);
        return "employeeUpdateView";
    }

    @PostMapping(value = "/update")
    public String updateEmployeeSave(@ModelAttribute("employee") Employee employee, ModelMap modelMap) {
        List<Employee> employeeList = employeeService.updateEmployee(employee);
        modelMap.addAttribute("employeeList", employeeList);
        return "redirect:/employees/";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") Integer id, ModelMap modelMap) {
        List<Employee> employeeList = employeeService.deleteEmployee(id);
        modelMap.addAttribute("employeeList", employeeList);
        return "redirect:/employees/";
    }

    @GetMapping(value = "id")
    public String findById(@PathVariable(name = "id") Integer id, ModelMap modelMap) {
        Employee byId = employeeService.findById(id);
        modelMap.addAttribute("employee", byId);
        return "employeeListView";
    }

    @GetMapping(value = "firstName")
    public String findByFirstName(@PathVariable(name = "firstName") String firstName, ModelMap modelMap) {
        List<Employee> byFirstName = employeeService.findByFirstName(firstName);
        modelMap.addAttribute("employeeList", byFirstName);
        return "employeeListView";
    }

    @GetMapping(value = "lastName")
    public String findByLastName(@PathVariable(name = "lastName") String lastName, ModelMap modelMap) {
        List<Employee> byLastName = employeeService.findByLastName(lastName);
        modelMap.addAttribute("employeeList", byLastName);
        return "employeeListView";
    }

    @GetMapping(value = "CNP")
    public String findByCNP(@PathVariable(name = "CNP") String CNP, ModelMap modelMap) {
        Employee byCNP = employeeService.findByCNP(CNP);
        modelMap.addAttribute("employeeList", byCNP);
        return "employeeListView";
    }

    @GetMapping(value = "position")
    public String findByPosition(@PathVariable(name = "position") String position, ModelMap modelMap) {
        List<Employee> byPosition = employeeService.findByPosition(position);
        modelMap.addAttribute("employeeList", byPosition);
        return "employeeListView";
    }

    @GetMapping(value = "daysOff")
    public String findByDaysOff(@PathVariable(name = "daysOff") Integer daysOff, ModelMap modelMap) {
        List<Employee> byDaysOff = employeeService.findByDaysOff(daysOff);
        modelMap.addAttribute("employeeList", byDaysOff);
        return "employeeListView";
    }

    @GetMapping(value = "norm")
    public String findByNorm(@PathVariable(name = "norm") String norm, ModelMap modelMap) {
        List<Employee> byNorm = employeeService.findByNorm(norm);
        modelMap.addAttribute("employeeList", byNorm);
        return "employeeListView";
    }

    @GetMapping(value = "hireDate")
    public String findByHireDate(@PathVariable(name = "hireDate") String hireDate, ModelMap modelMap) {
        List<Employee> byHireDate = employeeService.findByHireDate(hireDate);
        modelMap.addAttribute("employeeList", byHireDate);
        return "employeeListView";
    }

    @GetMapping(value = "endDate")
    public String findByEndDate(@PathVariable(name = "endDate") String endDate, ModelMap modelMap) {
        List<Employee> byEndDate = employeeService.findByEndDate(endDate);
        modelMap.addAttribute("employeeList", byEndDate);
        return "employeeListView";
    }

    @GetMapping(value = "/count")
    public String count(ModelMap modelMap) {
        long count = employeeService.count();
        modelMap.addAttribute("employeeList", count);
        return "employeeListView";
    }

    @GetMapping(value = "/pdfreport/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> employeeReport(@PathVariable(value = "id") Integer id) {
        Employee employee = employeeService.findById(id);

        ByteArrayInputStream bis = GenerateEmployeePDF.employeesReport(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename:employeeReport.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
