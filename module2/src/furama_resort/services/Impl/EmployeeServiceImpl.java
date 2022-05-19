package furama_resort.services.Impl;

import furama_resort.models.Employee;
import furama_resort.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employees = new ArrayList<>();

    @Override
    public void save(Employee employee) {
        if (employee.getID() > 0) {
            int index = employees.indexOf(employee);
            employees.set(index, employee);
        } else {
            employee.setID(employees.size() + 1);
            employees.add(employee);
        }
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }
}
