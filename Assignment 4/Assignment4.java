import java.util.Scanner;

abstract class Shape{
    private double a;
    private double b;
    private double area;
    public void setArea(double area) {
        this.area = area;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    abstract void compute_area();

    abstract void input_data();

    void display_area(){
        System.out.println("Area: "+this.area);
    }
}

class Triangle extends Shape{
    Scanner sc=new Scanner(System.in);
    @Override
    void input_data() {
        double base,height;
        System.out.print("Enter Base: ");
        base= sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Height: ");
        height=sc.nextDouble();
        sc.nextLine();
        super.setA(base);
        super.setB(height);
    }

    @Override
    void compute_area() {
        double base=super.getA();
        double height=super.getB();
        double area= 0.5*base*height;
        super.setArea(area);
    }
}

class Rectangle extends Shape{
    Scanner sc=new Scanner(System.in);
    @Override
    void input_data() {
        double length,breadth;
        System.out.print("Enter Base: ");
        length= sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Height: ");
        breadth=sc.nextDouble();
        sc.nextLine();
        super.setA(length);
        super.setB(breadth);
    }

    @Override
    void compute_area() {
        double length=super.getA();
        double breadth=super.getB();
        double rect_area= 0.5*length*breadth;
        super.setArea(rect_area);
    }
}

public class Assignment4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Calculate Area:\n1.Triangle\n2.Rectangle");
        int choice=sc.nextInt();
        sc.nextLine();
        Shape s;
        switch(choice){
            case 1:
                s=new Triangle();
                s.input_data();
                s.compute_area();
                s.display_area();
                break;
            case 2:
                s=new Rectangle();
                s.input_data();
                s.compute_area();
                s.display_area();
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }
}

