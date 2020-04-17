package Path;

import java.io.IOException;

public class Open {

    public static void main(String[] args) throws IOException {
        String[] cmd = {"/usr/bin/open", "/Users/aleksandr/Desktop/Programm/java/lesson_kpfu_2/src/Path/Open.java"};
        String[] cmd2 = {"/usr/bin/open", "/Users/aleksandr/Desktop/test.png"};
        String[] cmd3 = {"/usr/bin/open", "/Users/aleksandr/Desktop/eng.txt"};
        Runtime.getRuntime().exec(cmd);
        Runtime.getRuntime().exec(cmd2);
        Runtime.getRuntime().exec(cmd3);
    }

}
