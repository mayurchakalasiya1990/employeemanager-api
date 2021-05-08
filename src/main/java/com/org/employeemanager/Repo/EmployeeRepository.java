package com.org.employeemanager.Repo;

import com.org.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Long deleteEmployeeById(Long employeeID);
    Optional<Employee> findEmployeeById(Long employeeId);
}
