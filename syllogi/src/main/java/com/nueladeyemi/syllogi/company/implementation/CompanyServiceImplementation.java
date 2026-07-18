package com.nueladeyemi.syllogi.company.implementation;

import com.nueladeyemi.syllogi.company.Company;
import com.nueladeyemi.syllogi.company.CompanyRepository;
import com.nueladeyemi.syllogi.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplementation implements CompanyService {
    CompanyRepository companyRepository;

    public CompanyServiceImplementation(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Boolean updateCompany(Company companyPayload, Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            Company actualCompany = company.get();
            actualCompany.setName(companyPayload.getName());
            actualCompany.setAddress(companyPayload.getAddress());
    //      actualCompany.setId(actualCompany.getId());
            actualCompany.setJobs(actualCompany.getJobs());

            companyRepository.save(actualCompany);
            return  true;
        }

        return false;
    }

    @Override
    public Boolean deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(Long id) {
        if (id != null) {
           return companyRepository.findById(id).orElse(null);
        }
        return null;
    }


}
