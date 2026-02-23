package model;

public class Contract extends Employee{
    private double contractAmount;
    private static final double BONUS_PER_RATING = 500;

    public Contract(int emp_id,String emp_name, int department_id, int performance_rating, double contractAmount){
        super(emp_id, emp_name, department_id, performance_rating);
        setContractAmount(contractAmount);
    }

    public void setContractAmount(double contractAmount){
        if(contractAmount > 0){
            this.contractAmount = contractAmount;
        } else {
            throw new IllegalArgumentException("Contract Amount should be positive.");
        }
    }

    public double getContractAmount(){
        return contractAmount;
    }

    public double calculateSalary(){
        double bonus = 0;
        if(getPerRating() != null){
            bonus = getPerRating() * BONUS_PER_RATING;
        }

        return contractAmount + bonus;
    }

    public String toString(){
        return "\nContractEmployee->"+super.toString()+
        " | Contract Amount : "+contractAmount;
    }
}
