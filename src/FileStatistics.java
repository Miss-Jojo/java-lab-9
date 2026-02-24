import java.io.*;
import java.util.Scanner;

class FileStatistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter file name: ");
            String fileName = sc.nextLine();

            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            int characters = 0;
            int lines = 0;
            int words = 0;

            String line;

            while ((line = br.readLine()) != null) {
                lines++;                         // correct line count
                characters += line.length();

                String w[] = line.trim().split("\\s+");
                if (!line.trim().isEmpty())
                    words += w.length;
            }

            br.close();

            System.out.println("No. of characters: " + characters);
            System.out.println("No. of lines: " + lines);
            System.out.println("No. of words: " + words);

        } catch (IOException e) {
            System.out.println("File handling error: " + e.getMessage());
        }

        sc.close();
    }
}