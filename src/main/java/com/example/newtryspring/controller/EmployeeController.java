package com.example.newtryspring.controller;

import com.example.newtryspring.model.Employee;
import com.example.newtryspring.repository.CompanyRepository;
import com.example.newtryspring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/employee")
    public String company(ModelMap map) {

        map.addAttribute("employees", employeeRepository.findAll());

        return "employee";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(ModelMap map) {
        map.addAttribute("companies", companyRepository.findAll());
        return "saveEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveCompany(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employee";
    }


    @GetMapping("/deleteEmployee/{id}")
    public String deleteCompany(@PathVariable("id") int id) {
        employeeRepository.deleteById(id);

        return "redirect:/employee";


    }

    @GetMapping("/editeEmployee/{id}")
    public String editeEmployee(ModelMap map, @PathVariable("id") int id) {
        Optional<Employee> employeeById = employeeRepository.findById(id);
        if (employeeById.isPresent()) {
            map.addAttribute("employee", employeeById.get());
            map.addAttribute("companies", companyRepository.findAll());
            return "saveEmployee";
        } else {
            return "redirect:/";
        }


    }

}