package com.sda.HRProject.service;

import com.sda.HRProject.model.Company;
import com.sda.HRProject.repository.CompanyRepository;
import com.sda.HRProject.service.exceptions.CompanyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll(Integer page, Integer size) {
        List<Company> companyList = companyRepository.findAll(PageRequest.of(page, size)).getContent();
        return companyList;
    }

    public Company findById(Integer id) {
        Optional<Company> companyById = companyRepository.findById(id);
        if (companyById.isPresent()) {
            Company company = companyById.get();
            return company;
        } else {
            throw new CompanyNotFoundException(String.format("No company found the id: %s!", id));
        }
    }

    public Company findByName(String name) {
        Company company = companyRepository.findByName(name);
        if (company == null) {
            throw new CompanyNotFoundException(String.format("No company found with name: %s!", name));
        } else {
            return company;
        }
    }

    public List<Company> findByDomain(String domain) {
        List<Company> companyList = companyRepository.findByDomain(domain);
        if (companyList.isEmpty()) {
            throw new CompanyNotFoundException(String.format("No company found with domain: %s!", domain));
        } else {
            return companyList;
        }
    }

    public Company findByFiscalCode(String fiscalCode) {
        Company company = companyRepository.findByFiscalCode(fiscalCode);
        if (company == null) {
            throw new CompanyNotFoundException(String.format("No company found with fiscal code: %s!", fiscalCode));
        } else {
            return company;
        }
    }

    public Company findByRegistrationNumber(String registrationNumber) {
        Company company = companyRepository.findByRegistrationNumber(registrationNumber);
        if (company == null) {
            throw new CompanyNotFoundException(
                    String.format("No company found with registration number: %s!", registrationNumber));
        } else {
            return company;
        }
    }

    public List<Company> findByCAENCode(String CAENCode) {
        List<Company> companyList = companyRepository.findByCAENCode(CAENCode);
        if (companyList.isEmpty()) {
            throw new CompanyNotFoundException(String.format("No company found with CAEN code: %s!", CAENCode));
        } else {
            return companyList;
        }
    }

    public List<Company> findByAdministratorName(String administratorName) {
        List<Company> companyList = companyRepository.findByAdministratorName(administratorName);
        if (companyList.isEmpty()) {
            throw new CompanyNotFoundException(
                    String.format("No company found with administrator name: %s!", administratorName));
        } else {
            return companyList;
        }
    }

    public List<Company> addCompany(Company company) {
        List<Company> companyList = new ArrayList<>();
        companyRepository.save(company);
        companyRepository.findAll().forEach(c -> {
            companyList.add(c);
        });
        return companyList;
    }

    public List<Company> updateCompany(Company company) {
        List<Company> companyList = new ArrayList<>();
        companyRepository.save(company);
        companyRepository.findAll().forEach(c -> {
            companyList.add(c);
        });
        return companyList;
    }

    public List<Company> deleteCompany(Integer id) {
        Optional<Company> companyById = companyRepository.findById(id);
        if (companyById.isPresent()) {
            companyRepository.deleteById(id);
            List<Company> companyList = new ArrayList<>();
            companyRepository.findAll().forEach(c -> {
                companyList.add(c);
            });
            return companyList;
        } else {
            throw new CompanyNotFoundException(String.format("No company found with id: %s!", id));
        }
    }

    public long count() {
        return companyRepository.count();
    }
}