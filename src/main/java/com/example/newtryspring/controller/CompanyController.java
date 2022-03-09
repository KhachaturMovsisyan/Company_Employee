package com.example.newtryspring.controller;

import com.example.newtryspring.model.Company;
import com.example.newtryspring.model.Employee;
import com.example.newtryspring.repository.CompanyRepository;
import com.example.newtryspring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/company")
    public String company(ModelMap map) {
        map.addAttribute("companies", companyRepository.findAll());


        return "company";
    }

    @GetMapping("/addCompany")
    public String addCompany() {
        return "addCompany";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute Company company) {
        companyRepository.save(company);

        return "redirect:/company";
    }

    @GetMapping("/deleteCompany/{id}")
    @Transactional
    public String deleteCompany(@PathVariable("id") int id) {
        employeeRepository.deleteEmployeeByCompanyId(id);
        companyRepository.deleteById(id);

        return "redirect:/";


    }

}
