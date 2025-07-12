public // src/test/DividerTest.java

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DividerTest {

    @Test
    void testNormalDivision() {
        Divider divider = new Divider();

        // 正の数の除算
        assertEquals(3.0, divider.divide(6.0, 2.0), 0.0001, "6 ÷ 2 は 3 になるはず");

        // 負の数を含む除算
        assertEquals(-2.0, divider.divide(-4.0, 2.0), 0.0001, "-4 ÷ 2 は -2 になるはず");
        assertEquals(-2.0, divider.divide(4.0, -2.0), 0.0001, "4 ÷ -2 は -2 になるはず");
        assertEquals(2.0, divider.divide(-4.0, -2.0), 0.0001, "-4 ÷ -2 は 2 になるはず");

        // 少数を含む除算
        assertEquals(2.5, divider.divide(5.0, 2.0), 0.0001, "5 ÷ 2 は 2.5 になるはず");
        assertEquals(0.6667, divider.divide(2.0, 3.0), 0.0001, "2 ÷ 3 は 約 0.6667 になるはず");
    }

    @Test
    void testExceptionDivisionUsingTryCatch() {
        Divider divider = new Divider();
        try {
            divider.divide(5.0, 0.0);
            fail("ゼロ除算で例外が発生するはず");
        } catch (IllegalArgumentException e) {
            assertEquals("ゼロで除算はできません", e.getMessage(), "例外メッセージが一致しません");
        }
    }

    @Test
    void testExceptionDivisionUsingAssertThrows() {
        Divider divider = new Divider();

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> divider.divide(10.0, 0.0),
            "ゼロで除算したときにIllegalArgumentExceptionがスローされるべき"
        );

        assertEquals("ゼロで除算はできません", exception.getMessage(), "例外メッセージが一致しません");
    }
}
