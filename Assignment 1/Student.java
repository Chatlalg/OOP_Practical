    import java.util.*;
    public class Student {
        private int rno;
        private String name;

        public int getRno() {
            return rno;
        }

        public String getName() {
            return name;
        }
        public  Student(int rno,String name){
            this.rno=rno;
            this.name=name;
        }

        @Override
        public String toString() {
            return("Roll no: " + this.rno + " Name: " + this.name);
        }
    }

    class studentList {
        static Scanner sc=new Scanner(System.in);
        static List<Student> list=new ArrayList<Student>();
        public void getInput(){
            while(true){
                System.out.println("Enter choice of operation:");
                System.out.println("1. Add element to the list");
                System.out.println("2. Remove element from the list");
                System.out.println("3. Check element from the list");
                System.out.println("4. Display for element in the list");
                System.out.println("5. Sort the elements");
                int choice=sc.nextInt();
                sc.nextLine();
                switch(choice){
                    case 1:
                        studentList.add();
                        break;
                    case 2:
                        studentList.remove();
                        break;
                    case 3:
                        studentList.check();
                        break;
                    case 4:
                        studentList.display();
                        break;
                    case 5:
                        studentList.sort();
                        studentList.display();
                        break;
                    default:
                        System.out.print("Wrong input! Exiting program...");
                }
                System.out.print("Enter 1 to continue / 0 to exit : ");
                choice= sc.nextInt();
                sc.nextLine();
                if(choice==0){
                    break;
                }
            }
        }

        public static void add(){
            System.out.print("Enter name:");
            String name=sc.nextLine();
            System.out.print("Enter roll number:");
            int rno=sc.nextInt();
            sc.nextLine();
            Student s=new Student(rno,name);
            list.add(s);
        }
        public static void remove(){
            System.out.print("Enter the roll number to be removed:");
            int rno=sc.nextInt();
            sc.nextLine();
            for(Student s:list){
                if(s.getRno()==rno){
                    list.remove(s);
                    break;
                }
            }
        }
        public static void display(){
            for(Student s:list){
                System.out.println(s);
            }
        }
        public static void check(){
            System.out.print("Enter roll number to check:");
            int rno=sc.nextInt();
            sc.nextLine();
            if(list.contains(rno)){
                System.out.println("Given element is present in the list");
            }
            else{
                System.out.println("Element not found");
            }
        }
        public static void sort(){
            Comparator<Student> sortRno = Comparator.comparing(Student::getRno);
            Collections.sort(list,sortRno);
        }
        public static void main(String[] args){
            studentList sl=new studentList();
            sl.getInput();
        }
    }

