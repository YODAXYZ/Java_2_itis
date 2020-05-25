package UnitTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddEvenTest {

    @Test
    void evenNum() {
        OddEven oddEven = new OddEven();
        assertTrue(oddEven.evenNum(6));
        assertFalse(oddEven.evenNum(5));
    }
}