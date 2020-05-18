package Thread;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DownloadThread thread = new DownloadThread("https://teams.microsoft.com/_#/school/conversations/General?threadId=19:b1696a746e99436eb5df3ecb18859948@thread.tacv2&ctx=channel");

        while (true) {
            String command = sc.nextLine();
            if (command.equals("start")) {
                thread.run();
            }
            if (command.equals("status")) {
                thread.percentOfDownloading();
            }
            if (command.equals("stop")) {
                thread.interrupt();
                if (thread.getState().equals(Thread.State.NEW)) {
                    System.out.println("Поток не запущен");
                }

            }
            if (command.equals("quit") || command.equals("q")) {
                break;
            }
        }
    }
}







