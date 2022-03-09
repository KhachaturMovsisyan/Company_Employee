package com.example.newtryspring.repository;

import com.example.newtryspring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Transactional
    void deleteEmployeeByCompanyId(int id);

}
