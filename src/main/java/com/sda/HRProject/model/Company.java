package com.sda.HRProject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompany;
    @Column(name = "name")
    private String name;
    @Column(name = "domain")
    private String domain;
    @Column(name = "fiscalCode")
    private String fiscalCode;
    @Column(name = "registrationNumber")
    private String registrationNumber;
    @Column(name = "CAENCode")
    private String CAENCode;
    @Column(name = "address")
    private String address;
    @Column(name = "administratorName")
    private String administratorName;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "emplyee_company",
            joinColumns = {@JoinColumn(name = "idComapny")},
            inverseJoinColumns = {@JoinColumn(name = "idEmployee")})
    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCAENCode() {
        return CAENCode;
    }

    public void setCAENCode(String CAENCode) {
        this.CAENCode = CAENCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }
}
