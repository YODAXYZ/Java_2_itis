package Path;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
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
                    }
                    else {
                        folder = new File(String.valueOf(Paths.get(now_place).relativize(Paths.get(commands[1]))));
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
                    if (now_place.length() != 1)
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
            String to_place = now_place;
            if (commands[0].equals("mv")) {
                if (commands[1].charAt(0) == '/') {
                    now_place = commands[1];
                }
                else {
                    now_place += commands[1];
                }
                if (commands[2].charAt(0) == '/') {
                    to_place = commands[2];
                }
                else {
                    to_place += commands[2];
                }
                File from = new File(now_place);
                File to = new File(to_place);

                boolean status = copyFileUsingStream(from, to);
                if (status) {
                    System.out.println("File copy successfully");
                }
                else {
                    System.out.println("Failed to copy the file");
                }
            }
            if (commands[0].equals("rm")) {
                if (commands[1].charAt(0) == '/') {
                    now_place = commands[1];
                } else {
                    now_place += commands[1];
                }

                File file = new File(now_place);

                if(file.delete())
                {
                    System.out.println("File deleted successfully");
                }
                else
                {
                    System.out.println("Failed to delete the file");
                }

            }
            if (commands[0].equals("cat")) {
                if (commands[1].charAt(0) == '/') {
                    now_place = commands[1];
                } else {
                    now_place += commands[1];
                }
                soutFile(now_place, commands[2]);
            }

            if (command.equals("exit")) break;

            if (commands[0].equals("test")) {
                System.out.println("Test");
            }
        }
    }
    private static boolean copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
        return true;
    }

    private static void soutFile(String path, String encode) {
        try {
            File fileDir = new File(path);

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), encode));

            String str;

            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }

            in.close();
        }
        catch (UnsupportedEncodingException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
