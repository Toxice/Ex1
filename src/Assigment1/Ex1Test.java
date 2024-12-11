package Assigment1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    @Test
    void int2NumberTest() {
        String[] good = {"4", "12", "15", "10"};
        String[] expected = {"100b2", "1100b2", "1111b2", "1010b2"};
        for (int i = 0; i < good.length; i = i + 1) {
            String actual = Ex1.int2Number(Ex1.valueOf(good[i]), 2);
            assertEquals(expected[i], actual);
        }
        String not_good = "-5";
        String Expected = "";
        assertEquals(Expected, Ex1.int2Number(Ex1.valueOf(not_good), 10));
    }

    @Test
    void maxIndexTest() {
        String good1[] = {"100bA", "10bA", "50bA", "75bA"};
        int expected1 = 0; // index of 75bA

        String good2[] = {"55bA", "85bA", "275bA", "150bA"};
        int expected2 = 3; // index of 275bA

        String not_good1[] = {"10bA", "25bA", "75bA", "200bA"};
        int expected3 = 0;

        assertEquals(expected1, Ex1.maxIndex(good1));
        assertEquals(expected2, Ex1.maxIndex(good2));
        assertNotEquals(expected3, Ex1.maxIndex(not_good1));
    }

    @Test
    void num2DecimalTest() {
        String good[] = {"100b2", "10", "50b6", "AbG", "15bA"};
        String expected[] = {"4", "10", "30", "10", "15"};
        String[] actual = new String[5];
            for (int i = 0; i < good.length; i = i + 1) {
                actual[i] = String.valueOf(Ex1.num2Decimal(good[i]));
                assertEquals(expected[i], actual[i]);
            }
    }

    @Test
    void returningValueForNegativeNumbersTest() {
        String negatives[] = {"-5b8", "-78b9", "-100bA", "-50b6", "-1b3", "-101b2"};
        int expected = -1;
        for (int i = 0; i < negatives.length; i = i + 1) {
            assertEquals(expected, Ex1.number2Int(negatives[i]));
        }


    }
    }
