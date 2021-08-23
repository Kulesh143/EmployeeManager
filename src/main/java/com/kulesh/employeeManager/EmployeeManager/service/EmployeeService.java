package com.kulesh.employeeManager.EmployeeManager.service;

import com.kulesh.employeeManager.EmployeeManager.exception.UserNotFoundException;
import com.kulesh.employeeManager.EmployeeManager.model.Employee;
import com.kulesh.employeeManager.EmployeeManager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
   @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
employee.setEmployeeCode(UUID.randomUUID().toString());
return  employeeRepo.save(employee);
    }
    public List<Employee>findAllEmployees(){
    return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
    return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id){
    return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User by Id "+id+" was not found!"));
    }
    public void deleteEmployee(Long id){
    employeeRepo.deleteEmployeeById(id);
    }
}
