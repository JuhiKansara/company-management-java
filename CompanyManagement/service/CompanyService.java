package service;

import model.*;

import java.util.*;

public class CompanyService {
    private Map<Integer, Employee> employees = new HashMap<>();
    private Map<Integer, Department> departments = new HashMap<>();
    private Set<String> departmentNames = new HashSet<>();

    private SalaryProcessor salaryProcessor;
    private int departmentCounter = 101;
    private int employeeCounter = 26001;

    public CompanyService(SalaryProcessor salaryProcessor) {
        this.salaryProcessor = salaryProcessor;
    }

    // Department Methods
    public void addDepartment(String name) {
        name = name.toUpperCase();
        if(name == null || name.trim().isEmpty()){
            System.out.println("Department Name cannot be Empty.");
            return;
        }
        String normalizeName = name.trim().toUpperCase();
        if(departmentNames.contains(normalizeName)){
            System.out.println("Department already exists!");
            return;
        }

        Department department = new Department(departmentCounter, name.trim());
        departments.put(departmentCounter, department);
        departmentNames.add(normalizeName);
        System.out.println("Department created with ID : " + departmentCounter);

        departmentCounter++;
    }

    public void viewDepartments() {
        if (departments.isEmpty()) {
            System.out.println("No Department Exists!!!");
        } else {
            for (Department d : departments.values()) {
                System.out.println(d);
            }
        }
    }

    public void viewDepartmentSummary() {
        if (departments.isEmpty()) {
            System.out.println("No Department Exists!!!");
        } else {
            for (Department d : departments.values()) {
                System.out.println("ID : " + d.getDepartmentId() + "| Name : " + d.getDepartmentName());
            }
        }
    }

    // Employee Methods
    public void addEmployee(String emp_name, int department_id, int performance_rating, int type, double value1,
            double value2) {
        if (!departments.containsKey(department_id)) {
            System.out.println("Department does not exist!");
            return;
        }

        Employee employee = null;
        if (type == 1) {
            employee = new FullTimeEmployee(employeeCounter, emp_name, department_id, performance_rating, value1);
        } else if (type == 2) {
            employee = new PartTimeEmployee(employeeCounter, emp_name, department_id, performance_rating, value1,
                    (int) value2);
        } else if (type == 3) {
            employee = new Contract(employeeCounter, emp_name, department_id, performance_rating, value1);
        }

        if (employee != null) {
            System.out.println("Employee created with ID : " + employeeCounter);
            employees.put(employeeCounter, employee);
            employeeCounter++;
        }
    }

    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No Employee Exists!!!");
        } else {
            for (Employee e : employees.values()) {
                System.out.println(e);
            }
        }
    }

    public void processSalary(int employeeId) {
        Employee employee = employees.get(employeeId);
        if (employee == null) {
            System.out.println("Employee not found!");
            return;
        } else {
            salaryProcessor.processSalary(employee);
        }
    }

    public boolean hasDepartment() {
        return !departments.isEmpty();
    }
}
