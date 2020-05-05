package Music;

import java.util.Scanner;

public class Sound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        System.out.println("Piano (Фортепиано)\n" +
                "1\n" +
                "Acoustic piano\n" +
                "Акустический рояль\n" +
                " \n" +
                "2\n" +
                "Bright piano\n" +
                "Яркий рояль\n" +
                " \n" +
                "3\n" +
                "Grand piano\n" +
                "Большой рояль\n" +
                " \n" +
                "4\n" +
                "Honky-tonk piano\n" +
                "\"Разбитной\" рояль\n" +
                " \n" +
                "5\n" +
                "Rhodes piano1\n" +
                "Электропианино 1 (Родес)\n" +
                " \n" +
                "6\n" +
                "Chorused piano2\n" +
                "Электропианино 2 (с эффектом хорус)\n" +
                " \n" +
                "7\n" +
                "Harpsichord\n" +
                "Клавесин\n" +
                " \n" +
                "8\n" +
                "Clavinet\n" +
                "Клавинет\n" +
                "Chromatik Percussion (Хроматические ударные)\n" +
                "9\n" +
                "Celesta\n" +
                "Челеста\n" +
                " \n" +
                "10\n" +
                "Glockenspiel\n" +
                "Колокольчики\n" +
                " \n" +
                "11\n" +
                "Music Box\n" +
                "Музыкальная шкатулка\n" +
                " \n" +
                "12\n" +
                "Vibraphone\n" +
                "Вибрафон\n" +
                " \n" +
                "13\n" +
                "Marimba\n" +
                "Маримба\n" +
                " \n" +
                "14\n" +
                "Xylophone\n" +
                "Ксилофон\n" +
                " \n" +
                "15\n" +
                "Tubular Bells\n" +
                "Колокола\n" +
                " \n" +
                "16\n" +
                "Dulcimer\n" +
                "Цимбалы");
        System.out.println("Выбирайте инструмент: ");
        int inst = scanner.nextInt();
        while (true) {
            String c = scanner.next();
            if (c.equals("a")) {
                player.playSound(inst, 1000, 80, 69, 72, 76);
            }
            if (c.equals("s")) {
                player.playSound(inst, 1000, 80, 67, 71, 74);
            }
            if (c.equals("d")) {
                player.playSound(inst, 1000, 80, 100, 120, 77);
            }

            if (c.equals("q")) {
                break;
            }
        }
        player.close();

    }
}
