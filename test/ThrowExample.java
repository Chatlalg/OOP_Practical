import java.util.*;

public class ThrowExample {
    public static void main(String[] args) {
        try{
            // throwExcpetion(17);
            // something happened
            throw new NumberFormatException();
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    static void throwExcpetion(int age) throws IllegalArgumentException{
        // Check eligibility to vote
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above to vote.");
        }
        System.out.println("You are eligible to vote!");
    }
}
