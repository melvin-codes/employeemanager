package code.employeemanager.repo;

import code.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    List<Employee> findEmployeeById(Long id);
}
