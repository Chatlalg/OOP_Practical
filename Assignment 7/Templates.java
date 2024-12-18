/*
Implement a generic program using any collection class to count the number of elements in a 
collection that have a specific property such as even numbers, odd number, prime number and 
palindromes.  
 */

import java.util.ArrayList;

public class Templates<T extends Number> {
    private ArrayList<T> arr;

    public Templates() {
        arr = new ArrayList<T>();
    }

    public void addElement(T element) {
        arr.add(element);
    }

    public int countEven() {
        int even = 0;
        for (T data : arr) {
            if (data.intValue() % 2 == 0) { // Using intValue() for type conversion
                even++;
            }
        }
        return even;
    }

    public int countOdd() {
        int odd = 0;
        for (T data : arr) {
            if (data.intValue() % 2 != 0) {
                odd++;
            }
        }
        return odd;
    }
    
    public int countPrimes() {
        int primeCount = 0;
        for (T data : arr) {
            if (isPrime(data.intValue())) {
                primeCount++;
            }
        }
        return primeCount;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public int countPalindromes() {
        int palindromeCount = 0;
        for (T data : arr) {
            if (isPalindrome(data.intValue())) {
                palindromeCount++;
            }
        }
        return palindromeCount;
    }

    private boolean isPalindrome(int num) {
        int original = num, reverse = 0;
        while (num != 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        return original == reverse;
    }

    public static void main(String[] args) {
        Templates<Integer> template = new Templates<>();
        
        // Adding elements to the collection
        template.addElement(2);
        template.addElement(3);
        template.addElement(121);
        template.addElement(11);
        template.addElement(22);

        // Counting elements based on specific properties
        System.out.println("Even Count: " + template.countEven());
        System.out.println("Odd Count: " + template.countOdd());
        System.out.println("Prime Count: " + template.countPrimes());
        System.out.println("Palindrome Count: " + template.countPalindromes());
    }
}



























// import java.util.*;

// public class Sample {
//     Scanner sc=new Scanner(System.in);
//     public List<Integer> ll= new LinkedList<>();
//     List<Integer> evenLL= new LinkedList<>();
//     List<Integer> oddLL= new LinkedList<>();
//     List<Integer> palindromeLL= new LinkedList<>();
//     List<Integer> primeLL= new LinkedList<>();
//     public void getInput(){
//         System.out.print("Enter number of integers to enter: ");
//         int n=sc.nextInt();
//         System.out.println("Enter numbers : ");
//         for(int i=0;i<n;i++){
//             int num=sc.nextInt();
//             ll.add(num);
//         }
//     }
//     public void getEvenOdd(){
//         for(int num:ll){
//             if(num%2==0) evenLL.add(num);
//             else oddLL.add(num);
//         }
//         Collections.sort(evenLL);
//         Collections.sort(oddLL);
//     }
//     public boolean isPrime(int num){
//         int count=0;
//         for(int i=1;i<=num;i++){
//             if(num%i==0) count++;
//             if(count>2) return false;
//         }
//         return true;
//     }
//     public boolean isPalindrome(int num){
//         int revNum=0;
//         int origNum=num;
//         while(num>0){
//             int digit=num%10;
//             revNum=revNum*10+digit;
//             num=num/10;
//         }
//         return revNum == origNum;
//     }
//     public void getPrimes(){
//         for(int num:ll){
//             if(isPrime(num)){
//                 primeLL.add(num);
//             }
//         }
//         Collections.sort(primeLL);
//     }
//     public void getPalindrome(){
//         for(int num:ll){
//             if(isPalindrome(num)){
//                 palindromeLL.add(num);
//             }
//         }
//         Collections.sort(palindromeLL);
//     }

//     public static void main(String[] args) {
//         Sample ob=new Sample();
//         ob.getInput();
//         ob.getEvenOdd();
//         ob.getPalindrome();
//         ob.getPrimes();
//         System.out.println("Even numbers: "+ob.evenLL);
//         System.out.println("Odd numbers: "+ob.oddLL);
//         System.out.println("Palindrome numbers: "+ob.palindromeLL);
//         System.out.println("Prime numbers: "+ob.primeLL);
//     }
// }
