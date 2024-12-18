// import java.util.*;
// interface Car{
//     void manufacture();
//     void install();
//     void assemble();
//     void paint();
//     void finalTouch();
// }

// class Sedan implements Car{
//     @Override
//     public void manufacture(){
//         System.out.println("Sedan manufacturing!");
//     }
//     @Override
//     public void install(){
//         System.out.println("Installing sedan parts!");
//     }
//     @Override
//     public void assemble(){
//         System.out.println("Sedan Assembled!");
//     }
//     @Override
//     public void paint(){
//         System.out.println("Sedan Painted!");
//     }
//     @Override
//     public void finalTouch(){
//         System.out.println("Sedan manufacturing completed!");
//     }
// }

// class Hatchback implements Car{
//     @Override
//     public void manufacture(){
//         System.out.println("Hatchback manufacturing!");
//     }
//     @Override
//     public void install(){
//         System.out.println("Installing Hatchback parts!");
//     }
//     @Override
//     public void assemble(){
//         System.out.println("Hatchback Assembled!");
//     }
//     @Override
//     public void paint(){
//         System.out.println("Hatchback Painted!");
//     }
//     @Override
//     public void finalTouch(){
//         System.out.println("Hatchback manufacturing completed!");
//     }
// }

// class SUV implements Car{
//     @Override
//     public void manufacture(){
//         System.out.println("SUV manufacturing!");
//     }
//     @Override
//     public void install(){
//         System.out.println("Installing SUV parts!");
//     }
//     @Override
//     public void assemble(){
//         System.out.println("SUV Assembled!");
//     }
//     @Override
//     public void paint(){
//         System.out.println("SUV Painted!");
//     }
//     @Override
//     public void finalTouch(){
//         System.out.println("SUV manufacturing completed!");
//     }
// }

// class CarFactory{
//     public Car buildCar(String s){
//         if(s.equalsIgnoreCase("sedan")){
//             return new Sedan();
//         }
//         else if(s.equalsIgnoreCase("hatchback")){
//             return new Hatchback();
//         }
//         else if(s.equalsIgnoreCase("suv")){
//             return new SUV();
//         }
//         else{
//             throw new IllegalArgumentException("Invalid car type");
//         }
//     }
// }

// public class assignment10 {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);

//         CarFactory cf=new CarFactory();
//         System.out.println("Enter choice of car: 1.Sedan 2.Hatchback 3.SUV");
//         String choice=sc.nextLine();

//         Car newCar=cf.buildCar(choice);
        
//         newCar.manufacture();
//         newCar.install();
//         newCar.assemble();
//         newCar.paint();
//         newCar.finalTouch();
//         sc.close();
//     }
// }


import java.util.Scanner;
interface Car {
    void build_body();
    void engine_install();
    void assemble();
    void paint();
    void ready_to_go();
}
class Car_build {
    Car Carbuild(String type) {
        if (type.equalsIgnoreCase("sedan")) {
            return new Sedan();
        } else if (type.equalsIgnoreCase("hatchback")) {
            return new Hatchback();
        } else if (type.equalsIgnoreCase("SUV")) {
            return new SUV();
        }
        throw new IllegalArgumentException("Invalid car type entered!");
    }
}
class Hatchback implements Car {
    @Override
    public void build_body() {
        System.out.println("Hatchback body is ready");
    }
    @Override
    public void engine_install() {
        System.out.println("Engine is installed in Hatchback car");
    }
    @Override
    public void assemble() {
        System.out.println("Hatchback is assembled");
    }
    @Override
    public void paint() {
        System.out.println("Hatchback car is painted");
    }
    @Override
    public void ready_to_go() {
        System.out.println("Hatchback is ready to go");
    }
}
class Sedan implements Car {
    @Override
    public void build_body() {
        System.out.println("Sedan body is ready");
    }
    @Override
    public void engine_install() {
        System.out.println("Engine is installed in Sedan car");
    }
    @Override
    public void assemble() {
        System.out.println("Sedan is assembled");
    }
    @Override
    public void paint() {
        System.out.println("Sedan car is painted");
    }
    @Override
    public void ready_to_go() {
        System.out.println("Sedan is ready to go");
    }
}
class SUV implements Car {
    @Override
    public void build_body() {
        System.out.println("SUV body is ready");
    }
    @Override
    public void engine_install() {
        System.out.println("Engine is installed in SUV car");
    }
    @Override
    public void assemble() {
        System.out.println("SUV is assembled");
    }
    @Override
    public void paint() {
        System.out.println("SUV car is painted");
    }
    @Override
    public void ready_to_go() {
        System.out.println("SUV is ready to go");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car_build cb = new Car_build();
        Car c =null;
        System.out.println("Enter car type:  Sedan , Hatchback , SUV");
        String type = sc.nextLine();
        try {
            c = cb.Carbuild(type);
            c.build_body();
            c.engine_install();
            c.assemble();
            c.paint();  // Missing earlier
            c.ready_to_go();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}