import java.io.*;
import java.util.Scanner;

class StudentFileProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Roll No: ");
            int rollNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Subject: ");
            String subject = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            // ❌ ONLY ERROR: file does not exist
            String fileName = "abc.txt";

            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Roll No: " + rollNo);
            bw.newLine();
            bw.write("Name: " + name);
            bw.newLine();
            bw.write("Subject: " + subject);
            bw.newLine();
            bw.write("Marks: " + marks);
            bw.newLine();
            bw.close();

            // ❌ Error occurs here if file is missing
            FileReader fr = new FileReader("nonexistingfile.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("File handling error occurred: " + e);
        }

        sc.close();
    }
}
