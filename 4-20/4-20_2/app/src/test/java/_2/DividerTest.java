package _2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class DividerTest {

    @Test
    void testNormalDivision() {
        Divider divider = new Divider();

        // 正の数同士
        assertEquals(3.0, divider.divide(6, 2), 0.0001, "6 ÷ 2 は 3 になるはずです");

        // 負の数を含む
        assertEquals(-4.0, divider.divide(-8, 2), 0.0001, "-8 ÷ 2 は -4 になるはずです");

        // 小数を含む
        assertEquals(2.5, divider.divide(5.0, 2.0), 0.0001, "5.0 ÷ 2.0 は 2.5 になるはずです");
    }

    @Test
    void testExceptionDivision() {
        Divider divider = new Divider();

        // ゼロ除算の例外テスト
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> divider.divide(5, 0),
            "ゼロで除算した場合は IllegalArgumentException が投げられるはずです"
        );

        assertEquals("ゼロで除算はできません", exception.getMessage(),
            "例外メッセージが期待と一致しません");
    }
}
