import java.util.Scanner;
interface Vehicles{
    public void accelerate(int increment);
    public void decelerate(int decrement);
    public void changeGears(int gear);  
    public void vehicleStatus();
}

class Car implements Vehicles{
    public int speed;
    public int gear;
    Car(){
        this.speed=0;
        this.gear=0;
    }
    @Override 
    public void accelerate(int increment){
        if(this.speed+increment>=300){
            System.out.println("Max Speed reached : 300 kph");
            this.speed=300;
        }
        else this.speed+=increment;
        System.out.println("Speed: "+this.speed);
    }
    
    @Override
    public void decelerate(int decrement){
        if(this.speed-decrement<=0){
            System.out.println("Car stopped");
            this.speed=0;
        }
        else this.speed-=decrement;
        System.out.println("Speed: "+this.speed);
    }
    
    @Override
    public void changeGears(int gear){
        if(gear>7){
            System.out.println("Max Gear : 7");
        }
        else if(gear<1){
            System.out.println("Minimum Gear : 1");
        }
        else this.gear=gear;
        System.out.println("Gear: "+this.gear);
    }
    
    @Override
    public void vehicleStatus(){
        System.out.println("Speed: "+this.speed+" Gear: "+this.gear);
    }
}

class Bicycle implements Vehicles{
    public int speed;
    public int gear;
    Bicycle(){
        this.speed=0;
        this.gear=0;
    }
    @Override 
    public void accelerate(int increment){
        if(this.speed+increment>=300){
            System.out.println("Max Speed reached : 80 kph");
            this.speed=80;
        }
        else this.speed+=increment;
        System.out.println("Speed: "+this.speed);
    }
    
    @Override
    public void decelerate(int decrement){
        if(this.speed-decrement<=0){
            System.out.println("Bicycle stopped");
            this.speed=0;
        }
        else this.speed-=decrement;
        System.out.println("Speed: "+this.speed);
    }
    
    @Override
    public void changeGears(int gear){
        if(gear>21){
            System.out.println("Max Gear : 21");
        }
        else if(gear<1){
            System.out.println("Minimum Gear : 1");
        }
        else this.gear=gear;
        System.out.println("Gear: "+this.gear);
    }
    @Override
    public void vehicleStatus(){
        System.out.println("Speed: "+this.speed+" Gear: "+this.gear);
    }
}

class Bike implements Vehicles{
    public int speed;
    public int gear;
    Bike(){
        this.speed=0;
        this.gear=0;
    }
    @Override 
    public void accelerate(int increment){
        if(this.speed+increment>=300){
            System.out.println("Max Speed reached : 200 kph");
            this.speed=200;
        }
        else this.speed+=increment;
        System.out.println("Speed: "+this.speed);
    }
    
    @Override
    public void decelerate(int decrement){
        if(this.speed-decrement<=0){
            System.out.println("Bike stopped");
            this.speed=0;
        }
        else this.speed-=decrement;
        System.out.println("Speed: "+this.speed);
    }
    
    @Override
    public void changeGears(int gear){
        if(gear>4){
            System.out.println("Max Gear : 4");
        }
        else if(gear<1){
            System.out.println("Minimum Gear : 1");
        }
        else this.gear=gear;
        System.out.println("Gear: "+this.gear);
    }
    @Override
    public void vehicleStatus(){
        System.out.println("Speed: "+this.speed+" Gear: "+this.gear);
    }
}

public class Assignment5{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Choice : 1. Car\t\t2. Bike\t\t3. Bicycle");
        int choice=sc.nextInt();
        Vehicles vehicle=null;
        switch(choice){
            case 1:vehicle=new Car();
                break;
            case 2:vehicle=new Bike();
                break;
            case 3:vehicle=new Bicycle();
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
        while(true){
            System.out.println("Enter choice: 1. Accelerate\t\t 2. Decelerate\t\t 3. Change Gears\t\t 4. Vehicle Status\t\t 5. Exit");
            int opchoice=sc.nextInt();
            if(opchoice==5) break;
            switch(opchoice){
                case 1:
                    System.out.print("Enter speed increment: ");
                    int inc=sc.nextInt();
                    vehicle.accelerate(inc);
                    break;
                case 2:
                    System.out.print("Enter speed decrement: ");
                    int dec=sc.nextInt();
                    vehicle.decelerate(dec);
                    break;
                case 3:
                    System.out.print("Enter gear change: ");
                    int g=sc.nextInt();
                    vehicle.changeGears(g);
                    break;
                case 4:
                    vehicle.vehicleStatus();
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}