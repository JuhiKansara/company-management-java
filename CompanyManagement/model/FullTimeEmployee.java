package model;

public class FullTimeEmployee extends Employee{
    private double monthlySalary;
    private static final double TAX_RATE = 0.10;
    private static final double BONUS_PER_RATING = 1000;

    public FullTimeEmployee(int emp_id,String emp_name, int department_id, int performance_rating, double monthlySalary){
        super(emp_id,emp_name,department_id,performance_rating);
        setBaseSalary(monthlySalary);
    }

    public void setBaseSalary(double monthlySalary){
        if(monthlySalary > 0){
            this.monthlySalary = monthlySalary;
        } else {
            throw new IllegalArgumentException("Salary must be positive.");
        }
    }

    public double getBaseSalary(){
        return monthlySalary;
    }

    public double calculateSalary(){
        double bonus = 0;
        if(getPerRating() != null){
            bonus = getPerRating() * BONUS_PER_RATING;
        }
        double grossSalary = monthlySalary + bonus;
        double tax = grossSalary * TAX_RATE;

        return grossSalary - tax;
    }

    public String toString(){
        return "FullTimeEmployee->"+super.toString()+
        //here why monthlysalary how the calculated salary is stored in the monthly salary : toString prints stored obj data
        " | Base Salary : "+monthlySalary;
    }
}
