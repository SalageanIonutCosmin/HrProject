package com.sda.HRProject.controller;

import com.sda.HRProject.model.Company;
import com.sda.HRProject.service.CompanyService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping(value = "")
    public String findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                          @RequestParam(value = "size", defaultValue = "100") Integer size,
                          ModelMap modelMap) {
        List<Company> companyList = companyService.findAll(page, size);
        modelMap.addAttribute("companyList", companyList);
        return "companyListView";

    }

    @GetMapping(value = "/add")
    public String addNewCompanyView(ModelMap modelMap) {
        modelMap.addAttribute("company", new Company());
        return "companyAddView";
    }

    @GetMapping(value = "/add")
    public String addCompany(@ModelAttribute("company") Company company, ModelMap modelMap) {
        List<Company> companyList = companyService.addCompany(company);
        modelMap.addAttribute("companyList", companyList);
        return "companyListView";
    }
}
