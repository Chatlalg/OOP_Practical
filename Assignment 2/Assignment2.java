import java.util.Scanner;
class Employee {
    Scanner sc=new Scanner(System.in);
    private String empName,addr,email,role;
    private int id;
    private long mobileNo;
    private double basicPay;

    public void setRole(String role) {
        this.role = role;
    }

    public void getInput(){
        System.out.print("Enter name: ");
        this.empName=sc.nextLine();
        System.out.print("Enter id: ");
        this.id=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter email: ");
        this.email=sc.nextLine();
        System.out.print("Enter mobile: ");
        this.mobileNo=sc.nextLong();
        sc.nextLine();
        System.out.print("Enter address: ");
        this.addr=sc.nextLine();
        System.out.print("Enter basic pay: ");
        this.basicPay=sc.nextDouble();
    }

    public String displaySalaryDetails(){
        double hra=this.basicPay*0.10;
        double da=this.basicPay*0.97;
        double sc=this.basicPay*0.01;
        double pf=this.basicPay*0.12;
        double grossSal=basicPay+hra+da+sc+pf;
        double netSal=grossSal-sc-pf;
        return ("------------------Salary Details------------------\nBsic Pay: "+this.basicPay+"\nGross Salary: "+grossSal+"\nNet Salary: "+netSal);
    }

    public void generatePaySlip(){
        System.out.println("--------------------Pay Slip----------------------");
        System.out.println("Name: "+this.empName+"\t\tMobile No: "+this.mobileNo);
        System.out.println("Id: "+this.id+"\t\t\t\t\tAddress: "+this.addr);
        System.out.println("Email: "+this.email+"\trole: "+this.role);
        System.out.println(displaySalaryDetails());
    }
}

class Programmer extends Employee{
    public Programmer(String role){
        super.setRole(role);
    }
}

class TeamLead extends Employee{
    public TeamLead(String role){
        super.setRole(role);
    }
}
class ProjectManager extends Employee{
    public ProjectManager(String role){
        super.setRole(role);
    }
}
class AssistantProjectManager extends Employee{
    public AssistantProjectManager(String role){
        super.setRole(role);
    }
}

public class Assignment2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("1.Programmer \t2.Team lead \t3.Project Manager \t4.Assistant Project Manager");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
                Programmer p=new Programmer("Programmer");
                p.getInput();
                p.generatePaySlip();
                break;
            case 2:
                TeamLead t=new TeamLead("Team Lead");
                t.getInput();
                t.generatePaySlip();
                break;
            case 3:
                ProjectManager pm=new ProjectManager("Project Manager");
                pm.getInput();
                pm.generatePaySlip();
                break;
            case 4:
                AssistantProjectManager apm=new AssistantProjectManager("Assistant Project Manager");
                apm.getInput();
                apm.generatePaySlip();
                break;
            default:
                System.out.println("Invalid choice! Exiting...");
                break;
        }
    }
}