package com.nueladeyemi.syllogi.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanyRoute() {
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyByIdRoute(@PathVariable Long id) {
        return new ResponseEntity<>(companyService.getCompanyById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompanyRoute (@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>("Company created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyRoute(@RequestBody Company company, @PathVariable Long id) {
      Boolean isUpdated =  companyService.updateCompany(company, id);

      if (isUpdated) {
        return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
      }

      return new ResponseEntity<>("Error updating company", HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyRoute(@PathVariable Long id) {
        Boolean isDeleted =  companyService.deleteCompany(id);

        if (isDeleted) {
            return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("Error delete company", HttpStatus.NOT_FOUND);
    }
}
