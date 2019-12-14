package com.sda.HRProject.repository;

import com.sda.HRProject.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findByName(String name);

    List<Company> findByDomain(String domain);

    Company findByFiscalCode(String fiscalCode);

    Company findByRegistrationNumber(String registrationNumber);

    List<Company> findByCAENCode(String CAENCode);

    List<Company> findByAdministratorName(String administratorName);
}
