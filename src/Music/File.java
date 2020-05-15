package Music;

import java.io.*;
import java.util.Scanner;

public class File {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("song.txt"));
//        for (int i = 0; i < n; i++) {
//            int node = scanner.nextInt();
//            int node2 = scanner.nextInt();
//            bufferedWriter.write(node + " " + node2 + "\n");
//        }
//        bufferedWriter.close();

                    String line = null;
                    Player player = new Player();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("song.txt")));
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] notes = line.split(" ");
                        if (Integer.parseInt(notes[1]) != -1) {
                            player.playSound(0, Integer.parseInt(notes[0]), 80, Integer.parseInt(notes[1]));
                        } else {
                            try {
                                Thread.sleep(Integer.parseInt(notes[0]));
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        }
        bufferedReader.close();
        player.close();
    }
}
