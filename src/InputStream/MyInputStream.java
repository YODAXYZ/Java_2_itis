package InputStream;

import java.io.*;

public class MyInputStream  {
    public static void main(String[] args) throws IOException {
//        FileInputStream in = new FileInputStream("/Users/aleksandr/Desktop/Programm/java/lesson_kpfu_2/src/InputStream/txt.txt");
//        int b;
//        while ((b = in.read()) != -1) {
//            System.out.println(b);
//        }
//        in.close();
       try (FileInputStream in = new FileInputStream("/Users/aleksandr/Desktop/Programm/java/lesson_kpfu_2/src/InputStream/txt.txt")) {
           int b;
        while ((b = in.read()) != -1) {
            System.out.println(b);
        }
       }
       catch (IOException e) {
           e.printStackTrace();
       }
    }
}
