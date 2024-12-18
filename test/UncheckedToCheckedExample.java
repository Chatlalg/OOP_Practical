// class CustomCheckedException extends Exception {
//     public CustomCheckedException(String message) {
//         super(message);
//     }
// }

// public class UncheckedToCheckedExample {
//     public static void main(String[] args) {
//         try {
//             processData(null);  // Will throw NullPointerException
//         } catch (CustomCheckedException e) {
//             System.out.println("Caught exception: " + e.getMessage());
//         }
//     }

//     public static void processData(String data) throws CustomCheckedException {
//         try {
//             // This is an unchecked exception
//             if (data == null) {
//                 throw new NullPointerException("Data cannot be null");
//             }
//             System.out.println(data.length());
//         } catch (NullPointerException e) {
//             // Wrapping the unchecked exception in a checked exception
//             throw new CustomCheckedException("Wrapped NullPointerException: " + e.getMessage());
//         }
//     }
// }
