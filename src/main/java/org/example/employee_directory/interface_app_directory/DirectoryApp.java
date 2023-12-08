package org.example.employee_directory.interface_app_directory;

import java.util.ArrayList;
import java.util.List;

public class DirectoryApp {

    private List<Employee> employees;

    public DirectoryApp() {
        employees = new ArrayList<>();
    }

    public List<Employee> searchByExperience(int experience) {
        List<Employee> result = new ArrayList<>();
        for ( Employee employee : employees ) {
            if (employee.getExperience() >= experience) {
                result.add( employee );
            }
        }
        return result;
    }

    public List<String> searchPhoneNumberByName(String name) {
        List<String> result = new ArrayList<>();
        for ( Employee employee : employees ) {
            if (employee.getName().equalsIgnoreCase( name )) {
                result.add( employee.getPhoneNumber() );
            }
        }
        return result;
    }

    public Employee searchByEmployeeId(int employeeId) {
        for ( Employee employee : employees ) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    public void addEmployee(Employee employee) {
        employees.add( employee );
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
