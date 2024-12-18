import java.util.Scanner;

//account : abstract class
//current account : no daily withdrawal limit, minimium balance required
//savings account : daily withdrawal limit, zero balance account

class Bank{
    private final int id;
    Bank(int id){
        this.id=id;
    }
    public void displayInfo(){
        System.out.println("Account Created!\nAccount ID: "+this.id);
    }
    public int getId() {
        return id;
    }
}

abstract class Account extends Bank{
    private double currentBalance;
    private final String name;
    private final int age;
    private final long contact;
    private final String email;
    private double minBalance;
    private double maxWithdrawLimit;
    Account(String name,int age, long contact, String email,int id,double currentBalance){
        super(id);
        super.displayInfo();
        this.name=name;
        this.age=age;
        this.contact=contact;
        this.email=email;
        this.currentBalance=currentBalance;
    }

    @Override
    public abstract void displayInfo();
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void setMinBalance();
    public abstract void setMaxWithdrawLimit();
    public double getMinBalance() {
        return minBalance;
    }
    public double getMaxWithdrawLimit() {
        return maxWithdrawLimit;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public int getAge() {
        return age;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public long getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }
}

class SavingsAccount extends Account{
    SavingsAccount(String name,int age, long contact, String email,int id,double currentBalance){
        super(name,age,contact,email,id,currentBalance);
    }
    @Override
    public void displayInfo() {
        System.out.println("Account details");
        System.out.println("Account ID: "+super.getId());
        System.out.println("Holder Name: "+super.getName());
        System.out.println("Holder Age: "+super.getAge());
        System.out.println("Holder Contact: "+super.getContact());
        System.out.println("Holder Email: "+super.getEmail());
        System.out.println("Current Account Balance: "+super.getCurrentBalance());
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void withdraw(double amount) {

    }

    @Override
    public void setMaxWithdrawLimit() {

    }

    @Override
    public void setMinBalance() {

    }
}

public class Assignment9 {
    Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {

    }
}
