package furama_resort.controllers;

import furama_resort.models.Employee;
import furama_resort.services.Impl.EmployeeServiceImpl;

import java.util.List;

public class EmployeeController {
    EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

    public List<Employee> getAll() {
        return employeeServiceImpl.getAll();
    }

    public void save(Employee employee) {
        employeeServiceImpl.save(employee);
    }
}
