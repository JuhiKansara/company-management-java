package model;

public abstract class Employee {
    private int emp_id;
    private String emp_name;
    private int department_id;
    private Integer performance_rating;

    public Employee(int emp_id, String emp_name, int department_id, Integer performance_rating){
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.department_id = department_id;
        setPerformanceRating(performance_rating);
    }

    public abstract double calculateSalary();

    public int getEmpId(){
        return emp_id;
    }
    public String getEmpName(){
        return emp_name;
    }
    public int getDepartmentId(){
        return department_id;
    }
    public Integer getPerRating(){
        return performance_rating;
    }

    public double calculateAnnualSalary(){
        return calculateSalary()*12;
    }

    public void setPerformanceRating(Integer performance_rating){
        if(performance_rating >= 1 && performance_rating <= 5){
            this.performance_rating = performance_rating;
        } else {
            this.performance_rating = 0;
        }
    }

    public String toString(){
        return "\nID : "+emp_id+
        " | Name : "+emp_name+
        " | Dep-ID : "+department_id+
        " | Performance-Rate : "+(performance_rating == null ? "Not Rated" : performance_rating);
    }
}