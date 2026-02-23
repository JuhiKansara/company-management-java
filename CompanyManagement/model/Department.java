package model;

public class Department {
    private int department_id;
    private String dep_name;

    public Department(int department_id, String dep_name){
        this.department_id = department_id;
        this.dep_name = dep_name;
    }

    public int getDepartmentId(){
        return department_id;
    }
    public String getDepartmentName(){
        return dep_name;
    }

    public String toString(){
        return "ID : "+department_id+
        " | Name : "+dep_name;
    }
}