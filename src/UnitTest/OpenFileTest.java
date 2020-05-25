package UnitTest;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

class OpenFileTest {
    String pathFile;

    @org.junit.jupiter.api.Test
    String soutPath() {
        if (pathFile != null) {
            System.out.print("Path to file: ");
            String result = new OpenFile("some_file").soutPath();
            assertEquals("some_file", result);
        }
        return null;
    }

    @org.junit.jupiter.api.Test
    void exist() {
        boolean result = new OpenFile("er_file").exist();
        assertFalse(result);
    }

}