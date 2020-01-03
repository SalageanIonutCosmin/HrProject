package com.sda.HRProject.controller;

import com.sda.HRProject.model.Company;
import com.sda.HRProject.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    public String addCompanyView(ModelMap modelMap) {
        modelMap.addAttribute("company", new Company());
        return "companyAddView";
    }

    @PostMapping(value = "/add")
    public String addCompany(@ModelAttribute("company") Company company, ModelMap modelMap) {
        List<Company> companyList = companyService.addCompany(company);
        modelMap.addAttribute("companyList", companyList);
        return "companyListView";
    }

    @GetMapping(value = "/update/{id}")
    public String updateCompanyView(@PathVariable(name = "id") Integer id, ModelMap modelMap) {
        Company company = companyService.findById(id);
        modelMap.addAttribute("company", company);
        return "companyUpdateView";
    }

    @PostMapping(value = "/update")
    public String updateCompanySave(@ModelAttribute("company") Company company, ModelMap modelMap) {
        List<Company> companyList = companyService.updateCompany(company);
        modelMap.addAttribute("companyList", companyList);
        return "redirect:/companies/";
    }

    @GetMapping(value = "delete/{id}")
    public String deleteCompany(@PathVariable(name = "id") Integer id, ModelMap modelMap) {
        List<Company> companyList = companyService.deleteCompany(id);
        modelMap.addAttribute("companyList", companyList);
        return "redirect:/companies/";
    }

    @GetMapping(value = "id")
    public String findById(@PathVariable(name = "id") Integer id, ModelMap modelMap) {
        Company byId = companyService.findById(id);
        modelMap.addAttribute("companyList", byId);
        return "companyListView";
    }

    @GetMapping(value = "name")
    public String findByName(@PathVariable(name = "name") String name, ModelMap modelMap) {
        Company byName = companyService.findByName(name);
        modelMap.addAttribute("companyList", byName);
        return "companyListView";
    }

    @GetMapping(value = "domain")
    public String findByDomain(@PathVariable(name = "domain") String domain, ModelMap modelMap) {
        List<Company> byDomain = companyService.findByDomain(domain);
        modelMap.addAttribute("companyList", byDomain);
        return "companyListView";
    }

    @GetMapping(value = "fiscalCode")
    public String findByFiscalCode(@PathVariable(name = "fiscalCode") String fiscalCode, ModelMap modelMap) {
        Company byFiscalCode = companyService.findByFiscalCode(fiscalCode);
        modelMap.addAttribute("companyList", byFiscalCode);
        return "companyListView";
    }

    @GetMapping(value = "registrationNumber")
    public String findByRegistrationNumber(@PathVariable(name = "registrationNumber") String registrationNumber,
                                           ModelMap modelMap) {
        Company byRegistrationNumber = companyService.findByRegistrationNumber(registrationNumber);
        modelMap.addAttribute("companyList", byRegistrationNumber);
        return "companyListView";
    }

    @GetMapping(value = "CAENCode")
    public String findByCAENCode(@PathVariable(name = "CAENCode") String CAENCode, ModelMap modelMap) {
        List<Company> byCAENCode = companyService.findByCAENCode(CAENCode);
        modelMap.addAttribute("companyList", byCAENCode);
        return "companyListView";
    }

    @GetMapping(value = "administratorName")
    public String findByAdministratorName(@PathVariable(name = "administratorName") String administratorName,
                                          ModelMap modelMap) {
        List<Company> byAdministratorName = companyService.findByAdministratorName(administratorName);
        modelMap.addAttribute("companyList", byAdministratorName);
        return "companyListView";
    }

    @GetMapping(value = "/count")
    public String count(ModelMap modelMap) {
        long count = companyService.count();
        modelMap.addAttribute("companyList", count);
        return "companyListView";
    }
}
