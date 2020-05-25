package UnitTest;

import java.io.File;
import java.io.IOException;

public class OpenFile {
    private String filePath;

    public OpenFile(String filePath) {
        this.filePath = filePath;
    }

    public String soutPath () {
        return filePath;
    }

    public boolean exist() {
//        File file = new File(filePath);
//        return file.exists();
        return filePath.length() > 0; // Спецальная ошибка
    }

    public void runFile() {
        if (filePath != null) {
            String[] cmd = {"/usr/bin/open", filePath};
            try {
                Runtime.getRuntime().exec(cmd);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
