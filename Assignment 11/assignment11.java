import java.util.*;

interface PaymentStrategy{
    public void payment(Order o);
}

class Order{
    private String itemName;
    private int quantity;
    private double price;

    Order(String itemName,int quantity,double price){
        this.itemName=itemName;
        this.quantity=quantity;
        this.price=price;
    }

    
    public String display(){
        return "\nOrder Details: Item Name: "+this.itemName+" \nQuantity: "+this.quantity+"\nPrice: "+this.price+"\nTotal Price: "+(this.price*this.quantity);
    }
}

class CreditCardStrategy implements PaymentStrategy{
    Scanner sc=new Scanner(System.in);
    private int ccNo;
    private String ccName;

    public void payment(Order o){
        System.out.print("Enter credit card number: ");
        this.ccNo=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        this.ccName=sc.nextLine();
        System.out.println(o.display());
    }
}

class PayPalStrategy implements PaymentStrategy{
    Scanner sc=new Scanner(System.in);
    private int acNo;
    private String acName;

    public void payment(Order o){
        System.out.print("Enter account number: ");
        this.acNo=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter account name: ");
        this.acName=sc.nextLine();
        System.out.println(o.display());
    }
}

class BitCoinStrategy implements PaymentStrategy{
    Scanner sc=new Scanner(System.in);
    private String bcAdd;
    private String transAdd;

    public void payment(Order o){
        System.out.print("Enter BitCoin Address: ");
        this.bcAdd=sc.nextLine();
        System.out.print("Enter Transaction Address: ");
        this.transAdd=sc.nextLine();
        System.out.println(o.display());
    }
}

class ShoppingCart{
    private PaymentStrategy ps;
    
    public void setPaymentStrategy(PaymentStrategy ps){
        this.ps=ps;
    }
    
    public void checkout(Order o){
        ps.payment(o);
    }

}

public class assignment11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("-----Items-----");
        System.out.println("1.TV\n2.AC\n3.Washing Machine\n4.Laptop\n5.Oven");
        System.out.print("Enter choice: ");
        int choice=sc.nextInt();
        System.out.print("Enter quantity: ");
        int quan=sc.nextInt();

        Order selectedOrder = null;
        switch(choice){
            case 1:selectedOrder=new Order("TV",quan,50000);break;
            case 2:selectedOrder=new Order("AC",quan,10000);break;
            case 3:selectedOrder=new Order("Washing Machine",quan,20000);break;
            case 4:selectedOrder=new Order("Laptop",quan,80000);break;
            case 5:selectedOrder=new Order("Oven",quan,40000);break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        
        ShoppingCart cart=new ShoppingCart();
        System.out.println("Enter method of payment:\n1.Credit Card\n2.PayPal\n3.BitCoin");
        int pay=sc.nextInt();
        switch(pay){
            case 1:cart.setPaymentStrategy(new CreditCardStrategy());break;
            case 2:cart.setPaymentStrategy(new PayPalStrategy());break;
            case 3:cart.setPaymentStrategy(new BitCoinStrategy());break;
            default:
                System.out.println("Invalid Payment method");
                break;
        }
        cart.checkout(selectedOrder);
        sc.close();
    }
}
