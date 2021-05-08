package com.org.employeemanager.service;

import com.org.employeemanager.Repo.EmployeeRepository;
import com.org.employeemanager.exception.UsernotFoundException;
import com.org.employeemanager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long employeeId) throws UsernotFoundException {
        return employeeRepository.findEmployeeById(employeeId).
                orElseThrow(()->new UsernotFoundException("User by id "+employeeId+" was not find"));
    }

    public Long deleteEmployee(Long employeeID){
        return employeeRepository.deleteEmployeeById(employeeID);
    }

}
