package Output_Input_Stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int integer = scanner.nextInt();
        char ch = scanner.next().charAt(0);

        try (FileOutputStream toFile = new FileOutputStream("/Users/aleksandr/Desktop/Programm/java/lesson_kpfu_2/src/Output_Input_Stream/test.txt")) {
            toFile.write(integer>>24);
            toFile.write(integer>>16);
            toFile.write(integer>>8);
            toFile.write(integer);
            toFile.flush();
            toFile.write(((int) ch)>>8);
            toFile.write(((int) ch));
            toFile.flush();
        } catch (IOException e) {
            System.out.println("Error !");;
        }
    }
}
