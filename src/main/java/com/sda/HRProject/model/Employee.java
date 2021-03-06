package com.sda.HRProject.model;

import com.sda.HRProject.service.exceptions.CompanyNotFoundException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmployee;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "CNP")
    private String CNP;
    @Column(name = "studies")
    private boolean studies;
    @Column(name = "position")
    private String position;
    @Column(name = "daysOff")
    private Integer daysOff;
    @Column(name = "norm")
    private String norm;
    @Column(name = "hireDate")
    private String hireDate;
    @Column(name = "endDate")
    private String endDate;
    @Column(name = "contractNumber")
    private Integer contractNumber;
    @Column(name = "additionalActNumber")
    private Integer additionalActNumber;

    @ManyToMany(mappedBy = "employeeList")
    private List<Company> companyList = new ArrayList<>();
    @OneToMany(mappedBy = "employee")
    private List<Salary> salaryList = new ArrayList<>();

    public boolean isStudies() {
        return studies;
    }

    public List<Salary> getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(List<Salary> salaryList) {
        this.salaryList = salaryList;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public boolean getStudies() {
        return studies;
    }

    public void setStudies(boolean studies) {
        this.studies = studies;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(Integer daysOff) {
        this.daysOff = daysOff;
    }

    public String getNorm() {
        return norm;
    }

    public void setNorm(String norm) {
        this.norm = norm;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Company getCurrentCompany() {
        if (companyList.size() > 0) {
            return companyList.get(companyList.size() - 1);
        } else {
            throw new CompanyNotFoundException("No company was found!");
        }
    }

    public String getCurrentSalary() {
        if (salaryList.size() > 0) {
            return String.valueOf(salaryList.get(salaryList.size() - 1).getNetSalary());
        } else {
            return "";
        }
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Integer getAdditionalActNumber() {
        return additionalActNumber;
    }

    public void setAdditionalActNumber(Integer additionalActNumber) {
        this.additionalActNumber = additionalActNumber;
    }

    public Integer defaultAdditionalActNumber() {
        additionalActNumber = 0;
        return additionalActNumber;
    }
}
