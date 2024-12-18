import java.util.Scanner;

public class DivisionCalculator {

    static int divide(int n1,int n2) throws ArithmeticException{
        if(n2==0) throw new ArithmeticException();
        return n1/n2;
    }
    
          

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter the first number: ");
            String num1Str = scanner.nextLine();
            System.out.print("Enter the second number: ");
            String num2Str = scanner.nextLine();
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);
            int result = divide(num1,num2);
            System.out.println("The result of " + num1 + " divided by " + num2 + " is " + result);
            System.out.println("enter the number for ");
            // int num3=scanner.nextInt();
            System.out.println("enter the no");
            String yash=args[4]; 
            Integer.parseInt(yash);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integers.");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
	
// /*
//  write a program to add two consecutive numbers of an array by catching an exception of
// array bound.
//  Accept two numbers from the user calculate division of num1 divide by num2 by handling
// mathematical
//  exception like divide by 0 and number format expression
// */

// import java.util.Scanner;
// public class Assignment61 {
//     static void exceptionOfArrayBound(String args[]) {
//         System.out.println("\n----------------------------------------------");
//         if (args.length == 0) {
//             System.out.println("No array elements provided.");
//             return;
//         }
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the number of elements of array to be added : ");
//         int n = sc.nextInt();
//         int sum = 0;
//         for (int i = 0; i < n; i++) {
//             try {
//                 sum += Integer.parseInt(args[i]);
//             }
//             catch(NumberFormatException e ){
//                 System.out.println("Invalid input : " + args[i]);
//             }
//             catch (ArrayIndexOutOfBoundsException e) {
//                 System.out.println("You are trying to access an element not present in the array!");
//                 break;
//             }
//         }
//         System.out.println("The sum of the consecutive array elements is: " + sum);
//     }

//     static void mathematicalException() {
//         System.out.println("\n----------------------------------------------");
//         int num1, num2;
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter dividend and divisor: ");
//         try {
//             num1 = sc.nextInt();
//             num2 = sc.nextInt();
//             float r = num1 / num2;
//             System.out.println("Result of the division is: " + r);
//         }
//         catch (ArithmeticException e) {
//             System.out.println("Error: Division by zero is not allowed.");
//         }
//         catch (Exception e) {
//             System.out.println("Error: Invalid input.");
//         }
//     }
    
//     static void numberFormatException(String args[]) {
//         System.out.println("\n----------------------------------------------");
//         int num2 = 0;
//         if (args.length == 0) {
//             System.out.println("No array elements provided.");
//             return;
//         }
//         System.out.println("Array elements:");
//         for (String arg : args) {
//             try {
//                 int num1 = Integer.parseInt(arg);
//                 System.out.print(num1 + " ");
//             }
//             catch (NumberFormatException e) {
//                 System.out.print("\nInvalid input: " + arg);
//                 num2++;
//             }
//         }
//         System.out.println("\nTotal invalid inputs: " + num2);
//     }

//     public static void main(String[] args) {
//         numberFormatException(args);
//         exceptionOfArrayBound(args);
//         mathematicalException();
//     }

// }