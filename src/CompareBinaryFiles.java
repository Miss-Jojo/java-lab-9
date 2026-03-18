import java.io.FileInputStream;
import java.io.IOException;

public class CompareBinaryFiles {

    public static void main(String[] args) {

        
        String file1 = "fileA.bin";
        String file2 = "fileB.bin";

        try (FileInputStream f1 = new FileInputStream(file1);
             FileInputStream f2 = new FileInputStream(file2)) {

            int byte1, byte2;
            int position = 0;
            boolean equal = true;

            while (true) {
                byte1 = f1.read();
                byte2 = f2.read();

               
                if (byte1 == -1 && byte2 == -1) {
                    break;
                }

                
                if (byte1 != byte2) {
                    equal = false;
                    System.out.println(
                            "Two files are not equal: byte position at which two files differ is "
                                    + position
                    );
                    break;
                }

                position++;
            }

            if (equal) {
                System.out.println("Two files are equal");
            }

        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }
    }
}
