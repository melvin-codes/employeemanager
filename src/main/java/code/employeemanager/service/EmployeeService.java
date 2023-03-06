package code.employeemanager.service;

import code.employeemanager.exception.UserNotFoundException;
import code.employeemanager.model.Employee;
import code.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<Employee> findEmployeeById(Long id) {
        try {
            return employeeRepo.findEmployeeById(id);
        } catch(Exception e) {
            throw new UserNotFoundException("User by ID " + id + " was not found");
        }
//        return employeeRepo.findEmployeeById(id)
//                .orElseThrow(() -> new UserNotFoundException("User by ID " + id + " was not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
