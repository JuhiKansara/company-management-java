import service.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SalaryProcessor salaryProcessor = new BasicSalaryProcessor();
        CompanyService companyService = new CompanyService(salaryProcessor);

        int choice;

        do {
            System.out.println("\n------- COMPANY MANAGEMENT SYSTEM -------");
            System.out.println("1. Add Department");
            System.out.println("2. View Departments");
            System.out.println("3. Add Employee");
            System.out.println("4. View Employees");
            System.out.println("5. Process Salary");
            System.out.println("6. Exit");
            System.out.println("------- COMPANY MANAGEMENT SYSTEM -------");
            System.out.println((""));
            System.out.print("Enter Choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Department Name : ");
                    String depname = sc.nextLine();

                    companyService.addDepartment(depname);
                    waitForUser(sc);
                    clearConsole();
                    break;

                case 2:
                    companyService.viewDepartments();
                    
                    waitForUser(sc);
                    clearConsole();
                    break;

                case 3:
                    if (!companyService.hasDepartment()) {
                        System.out.println("No Department exist!!!");
                        System.out.println("Please add a department first.\n");

                        System.out.print("Enter Department Name : ");
                        String dep_name = sc.nextLine();

                        companyService.addDepartment(dep_name);
                    }

                    System.out.print("Enter Employee Name : ");
                    String empname = sc.nextLine();

                    System.out.println("Available Departments : ");
                    companyService.viewDepartmentSummary();
                    System.out.print("Enter Department ID : ");
                    int department_id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Performance Rating(1-5) or 0 to skip: ");
                    String rating = sc.nextLine();
                    Integer inputRating = null;
                    if(!rating.isEmpty()){
                        inputRating = Integer.parseInt(rating);
                    }

                    System.out.println("Select Employee Type : ");
                    System.out.println("1. Full-Time");
                    System.out.println("2. Part-Time");
                    System.out.println("3. Contract");
                    int type = sc.nextInt();

                    double value1 = 0;
                    double value2 = 0;
                    if (type == 1) {
                        System.out.print("Enter Monthly Salary : \n");
                        value1 = sc.nextDouble();
                    } else if (type == 2) {
                        System.out.print("Enter Hourly Rate : \n");
                        value1 = sc.nextDouble();
                        System.out.print("Enter Hours Worked : \n");
                        value2 = sc.nextInt();
                    } else if (type == 3) {
                        System.out.print("Enter Contract Amount : \n");
                        value1 = sc.nextDouble();
                    }

                    companyService.addEmployee(empname,department_id,inputRating,type,value1,value2);
                    
                    waitForUser(sc);
                    sc.nextLine();
                    clearConsole();
                    break;

                case 4:
                    companyService.viewEmployees();
                    
                    waitForUser(sc);
                    clearConsole();
                    break;

                case 5:
                    System.out.println("Available Employees : ");
                    companyService.viewEmployees();
                    System.out.println("\nEnter Employee ID to process salary : ");
                    int id = sc.nextInt();
                    companyService.processSalary(id);
                    waitForUser(sc);
                    sc.nextLine();
                    clearConsole();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice < 6 && choice != 0);

        sc.close();
    }

    public static void clearConsole(){
        try{
            String os = System.getProperty("os.name");

            if(os.contains("Windows")){
                new ProcessBuilder("cmd","/c","cls")
                    .inheritIO()
                    .start()
                    .waitFor();
            } else {
                new ProcessBuilder("cler")
                    .inheritIO()
                    .start()
                    .waitFor();
            }
        } catch(Exception e) {
            System.out.println("Error clearing console.");
        }
    }

    public static void waitForUser(Scanner sc){
        System.out.println("\nPress Enter to continue...");
        sc.nextLine();
    }
}