package Path;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class CdLs {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String now_place = "/";
        while (true) {
            System.out.print("(base) MacBook-Pro-Aleksandr-2:" + now_place + " aleksandr$ ");
            String command = scanner.nextLine();
            String[] commands = command.split("\\s");
            if (commands[0].equals("ls")) {
                File folder = new File(now_place);
                if (commands.length > 1) {
                    if (commands[1].length() == 1 && commands[1].charAt(0) == '.') {
                        folder = new File(now_place);
                    }
                    if (commands[1].charAt(0) == '/') {
                        folder = new File(commands[1]);
                    } else {
                        folder = new File(now_place + commands[1]);
                    }
                }
                File[] listOfFiles = folder.listFiles();

                System.out.println("________________________________________________________________________________");
                int stolb = 0;
                for (File file : listOfFiles) {
                    if (stolb % 3 == 0) {
                        System.out.println();
                    }
                    if (file.isFile()) {
                        System.out.printf("%-30s", file.getName() + " " + file.length() + " size");
                    }
                    else {
                        System.out.printf("%-30s", file.getName() + "  ");
                    }
                    stolb++;
                }
                System.out.println();
                System.out.println("________________________________________________________________________________");
            }

            if (commands[0].equals("cd")) {
                String last_pos =  now_place;
                if (commands[1].charAt(0) == '/') {
                    now_place = commands[1];
                }
                else {
                    if (now_place.length()!= 1)
                        now_place += "/" + commands[1];
                    else
                        now_place += commands[1];
                }
                File file = new File(now_place);
                if (!file.exists()) {
                    now_place = last_pos;
                    System.out.println("-bash: cd: No such file or directory");
                }
            }
            // Да я знаю, что не проделал логику для ../ -,
            // если надо то сделаю, и да я решил использовать файл вместо работы через path и getResources,
            // просто я сразу достаю файлы и работаю с ними а пути от рабочего директории и от
            // и я знаю, что для чего используется, но сейчас 2 часа ночи(надеюсь на понимание)
            // главное, что работает))))
            if (command.equals("exit")) break;
        }
    }
}
