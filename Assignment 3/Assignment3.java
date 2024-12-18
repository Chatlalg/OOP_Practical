import java.util.*;
class Publication{
    private String title;
    private int price;
    private int copies;
    static int totalSale=0;
    Publication(String title, int price, int copies){
        this.title=title;
        this.price=price;
        this.copies=copies;
    }
    public String getTitle() {
        return title;
    }
    public int getPrice() {
        return price;
    }

    public int getCopies() {
        return copies;
    }

    public boolean sellCopies(int order) {
        if(order<=this.copies) {
            this.copies = this.copies - order;
            return true;
        }
        else {
            System.out.println("Copies insufficient!");
            return false;
        }
    }
    public String calculateSale(int bookSale,int magSale){
        totalSale=bookSale+magSale;
        return ("\nTotal Sale: "+totalSale);
    }
}
class Book extends Publication{
    private String author;
    private String supplier="Default";
    static int bookSale=0;
    Book(String title, String author, int price, int copies){
        super(title,price,copies);
        this.author=author;
    }
    public void orderCopies(int order){
        if(super.sellCopies(order)) bookSale+=this.getPrice()*order;
    }

    public void orderCopies(int order, String supplier){
        super.sellCopies(order);
        this.supplier=supplier;
        bookSale+=this.getPrice()*order;
    }
    public String calculateSale(){
        return "Book Sale: "+bookSale;
    }
    @Override
    public String toString() {
        return ("Title:"+this.getTitle()+" || Author: "+this.author+" || Price: "+this.getPrice()+" || Available Copies: "+this.getCopies()+" || Supplier: "+this.supplier);
    }
}

class Magazine extends Publication{
    static int magSale=0;
    private int issue;
    Magazine(String title, int price, int copies, int issue){
        super(title,price,copies);
        this.issue=issue;
    }
    public void orderQty(int order){
        if(super.sellCopies(order)) magSale+=this.getPrice()*order;
    }
    public String calculateSale() {
        return "Magazine Sale: "+magSale;
    }
    public void receiveIssue(int newIssue){
        if(newIssue<=this.issue) System.out.println("\nCan't revert to older issue:");
        else this.issue=newIssue;
    }

    @Override
    public String toString() {
        return ("Title:"+this.getTitle()+" || Available Copies: "+this.getCopies()+" || Price:"+this.getPrice()+" || Issue:"+this.issue);
    }
}


public class Assignment3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List <Publication> list=new ArrayList<>();
        while(true){
            System.out.print("\n------------------------------\n\t\t  Enter Choice\n------------------------------\n\t\t\t1.Book\n\t\t  2.Magazine\n\t3.Calculate Total Sale\n\t\t\t4.Exit\n------------------------------\nYour Choice:");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==4) break;
            switch (choice){
                case 1://book
                    System.out.print("\n------------------------------\n\t\t\tBOOK\n------------------------------\n1.Add Book\n2.Display Book\n3.Order Book\n4.Calculate Book Sale\n------------------------------\nYour Choice:");
                    int opChoice1=sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    switch (opChoice1){
                        case 1://add book
                            System.out.print("Enter Title: ");
                            String title1=sc.nextLine();
                            System.out.print("Enter Price: ");
                            int price=sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Copies: ");
                            int copies=sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Author: ");
                            String author=sc.nextLine();
                            list.add(new Book(title1,author,price,copies));
                            break;
                        case 2://display books
                            System.out.println("AVAILABLE BOOKS\n------------------------------");
                            for(Publication p:list){
                                if(p instanceof Book) System.out.println(p);
                            }
                            break;
                        case 3://order book
                            System.out.print("Enter Book Title:");
                            String booktitle=sc.nextLine();
                            System.out.print("Enter 1 to change supplier / 0 to continue: ");
                            int wantSupplier=sc.nextInt();
                            sc.nextLine();
                            boolean flag=false;
                            for(Publication p:list){
                                if(p instanceof Book){
                                    Book b=(Book)p;
                                    if(b.getTitle().equals(booktitle)){
                                        System.out.print("Enter number of copies:");
                                        int order =sc.nextInt();
                                        sc.nextLine();
                                        if(wantSupplier==1){
                                            System.out.print("Enter Supplier name: ");
                                            String supplier=sc.nextLine();
                                            b.orderCopies(order,supplier);
                                        }
                                        else{
                                            b.orderCopies(order);
                                        }
                                        flag=true;
                                        break;
                                    }
                                }
                            }
                            if(!flag) System.out.println("Book not available!");
                            break;
                        case 4:// calculate sale
                            Book b=new Book(" "," ",0,0);
                            System.out.println(b.calculateSale());
                            break;
                        default:
                            System.out.println("Invalid choice!!!");
                            break;
                    }
                    break;
                case 2://magazine
                    System.out.print("\n------------------------------\n\t\tMAGAZINE\n------------------------------\n1.Add Magazine\n2.Update Issue\n3.Display Magazine\n4.Order Magazine\n5.Calculate Book Sale\n------------------------------\nYour Choice:");
                    int opChoice2=sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    switch (opChoice2){
                        case 1://add magazine
                            System.out.print("Enter Title: ");
                            String title1=sc.nextLine();
                            System.out.print("Enter Price: ");
                            int price=sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Copies: ");
                            int copies=sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Issue: ");
                            int issue=sc.nextInt();
                            sc.nextLine();
                            list.add(new Magazine(title1,price,copies,issue));
                            break;
                        case 2://receive issue
                            System.out.print("Enter name of magazine to update: ");
                            String mag=sc.nextLine();
                            boolean check=false;
                            for(Publication p:list){
                                if(p instanceof Magazine){
                                    Magazine m=(Magazine)p;
                                    if(m.getTitle().equals(mag)) {
                                        System.out.print("Enter updated issue: ");
                                        int newIssue = sc.nextInt();
                                        sc.nextLine();
                                        m.receiveIssue(newIssue);
                                        System.out.println("Issue updated");
                                        check=true;
                                        break;
                                    }
                                }
                            }
                            if(!check) System.out.println("Magazine not found!!");
                            break;
                        case 3://display magazines
                            System.out.println("\nAVAILABLE MAGAZINES\n------------------------------");
                            for(Publication p:list){
                                if(p instanceof Magazine) System.out.println(p);
                            }
                            break;
                        case 4://order magazines
                            System.out.print("Enter Magazine Title: ");
                            String title2=sc.nextLine();
                            boolean flag=false;
                            for(Publication p:list){
                                if(p instanceof Magazine){
                                    Magazine m=(Magazine)p;
                                    if(m.getTitle().equals(title2)){
                                        System.out.print("Enter number of copies:");
                                        int order =sc.nextInt();
                                        m.orderQty(order);
                                        flag=true;
                                        break;
                                    }
                                }
                            }
                            if(!flag) System.out.println("Magazine not available!");
                            break;
                        case 5:// calculate sale
                            Magazine m=new Magazine("",0,0,0);
                            System.out.println(m.calculateSale());
                            break;
                        default:
                            System.out.println("Invalid choice!!!");
                            break;
                    }
                    break;
                case 3:
                    Publication p=new Publication("",0,0);
                    System.out.println(p.calculateSale(Book.bookSale,Magazine.magSale));
                    break;
                default:
                    System.out.println("Exiting program");
                    break;
            }
        }
    }
}

