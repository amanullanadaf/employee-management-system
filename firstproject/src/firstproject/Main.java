package firstproject;
import java.util.LinkedList;
import java.util.Scanner;

abstract class  Employee {
    private String name;
    private int id;


    public  Employee(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    public String getName()
    {
        return name;
    }
    public int getid()
    {
        return id;
    }
    public void setid()
    {
        this.id=id;

    }
    public abstract double calculateSalary();

    @Override
    public String toString()
    {
        return "Employee [name= "+name+",id= "+id+", salary= "+calculateSalary()+"]";
    }
}
class FullTimeEmployee extends Employee
{
    private double monthlySalary;

    public FullTimeEmployee(String name,int id,double monthlySalary)
    {
        super(name,id);
        this.monthlySalary=monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}
class PartTimeEmployee extends Employee
{
    int count=0;
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee( String name, int id,int hoursWorked,double hourlyRate){
        super(name, id);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked*hourlyRate;
    }
}

class payrollSystem{
    Scanner sc = new Scanner(System.in);
    private LinkedList<Employee> employeelist;
    String name;
    int id;
    double salary;

    public payrollSystem()
    {
        employeelist= new LinkedList<>();

    }
    public void addEmployee(){
        int choice,n,hoursWorked,hourlyRate,count=0;
        System.out.println("Which Employee to be added");
        System.out.println("1.Full time employee");
        System.out.println("2.Part time employee");
        choice=sc.nextInt();
        switch (choice)
        {
            case 1:

                System.out.println("Enter number of Employees to be added");
                n= sc.nextInt();
                FullTimeEmployee emp;
                for(int i=1;i<=n;i++)
                {
                    System.out.println("Enter name of employee");
                    name=sc.next();
                    System.out.println("Enter employee ID");
                    id=sc.nextInt();
                    System.out.println("Enter employee salary");
                    salary=sc.nextDouble();
                    emp = new FullTimeEmployee(name,id,salary);
                    employeelist.add(emp);
                    count++;
                }
                break;


            case 2:

                System.out.println("Enter number of Employees to be added");
                n= sc.nextInt();
                PartTimeEmployee emp1;
                for(int i=1;i<=n;i++)
                {
                    System.out.println("Enter name of employee "+i);
                    name=sc.next();
                    System.out.println("Enter employee ID");
                    id=sc.nextInt();
                    System.out.println("Enter hours worked");
                    hoursWorked=sc.nextInt();
                    System.out.println("Enter hourly rate");
                    hourlyRate=sc.nextInt();

                    emp1 = new PartTimeEmployee(name,id,hoursWorked,hourlyRate);
                    employeelist.add(emp1);
                    count++;
                }
                break;
        }
    }

    public void removeEmployee()
    {
        int id,count;
        Employee employeeToRemove=null;
        if(employeelist.isEmpty())
        {
            System.out.println("No employee records to delete");
        }
        else {
            System.out.println("Enter ID of the employee to be removed");
            id= sc.nextInt();
            for (Employee employee : employeelist) {
                if (employee.getid() == id) {
                    employeeToRemove = employee;
                    employeelist.remove(employeeToRemove);
                    System.out.println("Employee removed");
                    break;
                }
            }
        }
    }

    public void displayEmployee(){
        if(employeelist.isEmpty())
        {
            System.out.println("No employees to display");
        }
        else {
            for (Employee employee : employeelist) {
                System.out.println(employee);
            }
            System.out.println("Total Number of Employees: "+employeelist.size());
        }
    }
    public void searchEmployee() {
        int id;
        if(employeelist.isEmpty())
        {
            System.out.println(" No Employee records to search ");

        }
        else {
            System.out.println("Enter ID of the employee to be searched");
            id = sc.nextInt();
            Employee targetEmployee;
            for (Employee employee : employeelist) {
                if (employee.getid() == id) {
                    targetEmployee = employee;
                    System.out.println("Employee found : " + targetEmployee);
                    break;
                }
                else
                {
                    System.out.println("Employee Not found");
                }
            }
        }


    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean keepRunning=true;
        payrollSystem p1 = new payrollSystem();
        while(keepRunning) {
            System.out.println("Choose valid option");
            System.out.println("1.Add New Employee");
            System.out.println("2.Display All Employees");
            System.out.println("3.Remove Employee");
            System.out.println("4.Search Employee");
            System.out.println("5.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    p1.addEmployee();
                    break;
                case 2:
                    p1.displayEmployee();
                    break;
                case 3:
                    p1.removeEmployee();
                    break;
                case 4:
                    p1.searchEmployee();
                    break;
                case 5:
                    System.out.println("Exiting the system");
                    keepRunning=false;
                    break;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        }
    }

}