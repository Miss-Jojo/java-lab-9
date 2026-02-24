import java.io.*;
import java.util.Scanner;

class FileCopyProgram_Fixed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter source file name: ");
            String source = sc.nextLine();

            System.out.print("Enter destination file name: ");
            String dest = sc.nextLine();

            File srcFile = new File(source);

            // ✅ Fix: check file validity
            if (!srcFile.exists() || !srcFile.isFile()) {
                System.out.println("Source file is invalid.");
                return;
            }

            // -------- Character Stream --------
            FileReader fr = new FileReader(srcFile);
            FileWriter fw = new FileWriter(dest);

            int ch;
            while ((ch = fr.read()) != -1) {
                fw.write(ch);
            }

            fr.close();
            fw.close();

            // -------- Byte Stream --------
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(dest, true);

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            fis.close();
            fos.close();

            System.out.println("File Copied");

        } catch (IOException e) {
            System.out.println("File handling error: " + e.getMessage());
        }

        sc.close();
    }
}