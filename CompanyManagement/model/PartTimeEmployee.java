package model;

public class PartTimeEmployee extends Employee{
    private double hourly_rate;
    private int hours_worked;
    private static final double BONUS_PER_RATING = 200;
    
    public PartTimeEmployee(int emp_id,String emp_name, int department_id, int performance_rating, double hourly_rate,int hours_worked){
        super(emp_id, emp_name, department_id, performance_rating);
        setHourlyRate(hourly_rate);
        setHoursWorked(hours_worked);
    }

    public void setHourlyRate(double hourly_rate){
        if(hourly_rate > 0){
            this.hourly_rate = hourly_rate;
        } else{
            throw new IllegalArgumentException("Hourly Rate should be positive.");
        }
    }

    public void setHoursWorked(int hours_worked){
        if(hours_worked >= 0){
            this.hours_worked = hours_worked;
        } else{
            this.hours_worked = 0;
        }
    }

    public double getHourlyRate(){
        return hourly_rate;
    }

    public int getHoursWorked(){
        return hours_worked;
    }

    public double calculateSalary(){
        double bonus = 0;
        if(getPerRating() != null){
            bonus = getPerRating() * BONUS_PER_RATING;
        }
        double baseSalary = hourly_rate * hours_worked;

        return baseSalary + bonus;
    }

    public String toString(){
        return "\nPartTimeEmployee->"+super.toString()+
        " | Hourly Rate : "+hourly_rate+
        " | Hours Worked : "+hours_worked;
    }
}
