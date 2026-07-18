package com.nueladeyemi.syllogi.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();

    void createCompany(Company company);

    Boolean updateCompany(Company companyPayload, Long id);

    Boolean deleteCompany(Long id);

    Company getCompanyById(Long id);
}
