package Output_Input_Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        int a = 0;
        int number = 0;
        char ch;
        try (FileInputStream fileInputStream = new FileInputStream("/Users/aleksandr/Desktop/Programm/java/lesson_kpfu_2/src/Output_Input_Stream/test.txt")){
            a = (fileInputStream.read()<<24)|a;
            a = (fileInputStream.read()<<16)|a;
            a = (fileInputStream.read()<<8)|a;
            a = (fileInputStream.read())|a;
            number = a;
            a = 0;
            a = (fileInputStream.read()<<8)|a;
            a = (fileInputStream.read())|a;
            ch = (char)a;
            System.out.println(number);
            System.out.println(ch);
        } catch (IOException e) {
            System.out.println("Error !");
        }
    }
}
