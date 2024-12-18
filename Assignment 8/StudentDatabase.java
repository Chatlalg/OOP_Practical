import java.io.*;
import java.util.Scanner;

class datab {
    int id;
    String name;
    String address;
    datab() throws IOException {
        File f1 = new File("hi.txt");
        if (f1.createNewFile()) {
            FileWriter fw = new FileWriter("hi.txt");
            fw.write("ID\t\tName\t\tAddress\n");
            fw.close();
        }
    }

    void inputdata() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = new FileWriter("hi.txt",true);
        System.out.println("Enter id: ");
        id = Integer.parseInt(br.readLine());
        System.out.println("Enter Name: ");
        name = br.readLine();
        System.out.println("Enter Address: ");
        address = br.readLine();
        fw.write("\n"+id + "\t\t" + name + "\t\t" + address + "\n");
        fw.close();
        System.out.println("Record added succesfully!!!!!");
        System.out.println();
    }

    void display() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hi.txt"));
        System.out.println("Database content are: ");
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    void clear() throws IOException {
        FileWriter fw = new FileWriter("hi.txt");
        fw.write("ID\t\tName\t\tAddress");
        fw.close();
        System.out.println("Database cleared.");
    }

    void search(int sid) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hi.txt"));
        String line;
        boolean found = false;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split("\t\t");
            if (arr.length > 0 && arr[0].equals(String.valueOf(sid))) {
                System.out.println("record found: " + line);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("not found.");
        }
        br.close();
    }


    void delete(int sid) throws IOException {
        File f1 = new File("hi.txt");
        File f2 = new File("temp.txt");

        if (!f1.exists()) {
            System.out.println("File not found.");
            return;
        }

        try (
                BufferedReader br = new BufferedReader(new FileReader(f1));
                BufferedWriter bw = new BufferedWriter(new FileWriter(f2))
        ) {
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] lo = line.split("\t\t");

                if (lo.length > 0 && lo[0].equals(String.valueOf(sid))) {
                    found = true;
                    System.out.println("Record with ID " + sid + " has been deleted.");
                } else {
                    bw.write(line);
                    bw.newLine();  // Ensure correct line break format
                }
            }

            if (!found) {
                System.out.println("Record not found.");
            }
        }

        // Replace old file with the updated one
        if (f1.delete() && f2.renameTo(f1)) {
            System.out.println("File updated successfully.");
        } else {
            System.out.println("Error updating file.");
        }
    }



//    void delete(int sid) throws IOException {
//        File f1 = new File("hi.txt");
//        File f2 = new File("temp.txt");
//        BufferedReader br = new BufferedReader(new FileReader(f1));
//        BufferedWriter bw = new BufferedWriter(new FileWriter(f2));
//        String line;
//        boolean found = false;
//        while ((line = br.readLine()) != null) {
//            String[] lo = line.split("\t\t");
//            if (lo.length > 0 && lo[0].equals(String.valueOf(sid))) {
//                found = true;  // Skip this line (the record to delete)
//                System.out.println("Record with ID " + sid + " has been deleted.");
//            } else {
//                bw.write(line + "\n");
//            }
//        }
//        br.close();
//        bw.close();
//        if (found) {
//            f1.delete();
//            f2.renameTo(f1);
//        } else {
//            System.out.println("Record not found.");
//        }
//    }


    void modify(int sid) throws IOException {
        File f1 = new File("hi.txt");
        File f2 = new File("temp.txt");

        BufferedReader br = new BufferedReader(new FileReader(f1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(f2));

        String line;
        boolean found = false;

        while ((line = br.readLine()) != null) {
            String[] lo = line.split("\t\t");

            if (lo.length > 0 && lo[0].equals(String.valueOf(sid))) {
                found = true;
                System.out.println("Enter new details for student with ID " + sid + ":");
                BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter new ID: ");
                int newId = Integer.parseInt(brInput.readLine());
                System.out.println("Enter new Name: ");
                String newName = brInput.readLine();
                System.out.println("Enter new Address: ");
                String newAddress = brInput.readLine();

                bw.write(newId + "\t\t" + newName + "\t\t" + newAddress + "\n");
            } else {
                bw.write(line + "\n");
            }
        }
        br.close();
        bw.close();
        f1.delete();
        f2.renameTo(f1);
        if (!found) {
            System.out.println("Record not found.");
        } else {
            System.out.println("Record modified.");
        }
    }
}

public class StudentDatabase{
    public static void main(String[] args)throws IOException {
        Scanner sc=new Scanner(System.in);
        datab db=new datab();
        while(true){
            System.out.println("Enter 1.Insert 2.Display 3.Clear 4.Search 5.Modify 6.Delete 7.Exit: ");
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                    db.inputdata();
                    break;
                case 2:
                    db.display();
                    break;
                case 3:
                    db.clear();
                    break;
                case 4:
                    System.out.println("Enter ID to search: ");
                    int sid=sc.nextInt();
                    db.search(sid);
                    break;
                case 5:
                    System.out.println("Enter id to which to modified: ");
                    int mid=sc.nextInt();
                    db.modify(mid);
                    break;
                case 6:
                    System.out.println("Enter id to delete: ");
                    int bid=sc.nextInt();
                    db.delete(bid);
                    break;
                case 7:
                    return;
            }
        }
    }
}