package service;
import model.Employee;

public class BasicSalaryProcessor implements SalaryProcessor{
    public void processSalary(Employee employee){
        double monthlySalary = employee.calculateSalary();
        double annualSalary = employee.calculateAnnualSalary();

        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("Processing Salary for : "+employee.getEmpName());
        System.out.println("Employee Type : "+employee.getClass().getSimpleName());
        System.out.println("Monthly Salary : "+monthlySalary+" per month");
        System.out.println("Annual Salary : "+annualSalary+" per annum");
        System.out.println("------------------------------");
    }
}
