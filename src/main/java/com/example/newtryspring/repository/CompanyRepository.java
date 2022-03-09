package com.example.newtryspring.repository;

import com.example.newtryspring.model.Company;
import com.example.newtryspring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {



}
