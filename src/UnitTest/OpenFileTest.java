package UnitTest;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.*;

class OpenFileTest {
    String pathFile;

    @org.junit.jupiter.api.Test
    String soutPath() {
        if (pathFile != null) {
            String result = new OpenFile("some_file").soutPath();
            String result2 = new OpenFile("some_file").soutPath();
            assertEquals(result, "some_file");
            assertEquals(result, result2);
            assertNotSame(result, "");
        }
        return null;
    }

    @org.junit.jupiter.api.Test
    void exist() {
        boolean result = new OpenFile("er_file").exist();
        assertFalse(result);
    }

}