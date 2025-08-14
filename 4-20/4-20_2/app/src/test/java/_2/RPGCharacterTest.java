package _2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class RPGCharacterTest {
    @Test
    void testInitialStatus() {
        RPGCharacter character = new RPGCharacter();

        assertAll("初期状態の確認",
            () -> assertEquals(1, character.getLevel(), "初期レベルは1であるべき"),
            () -> assertEquals(100, character.getHP(), "初期HPは100であるべき"),
            () -> assertEquals(50, character.getMP(), "初期MPは50であるべき")
        );
    }

    @Test
    void testNormalLevelUp() {
        RPGCharacter character = new RPGCharacter();

        int beforeLevel = character.getLevel();
        int beforeHP = character.getHP();
        int beforeMP = character.getMP();

        character.levelUp();

        assertAll("レベルアップ後の状態確認",
            () -> assertEquals(beforeLevel + 1, character.getLevel(), "レベルは1上昇しているはず"),
            () -> assertEquals(beforeHP + 10, character.getHP(), "HPは10増えているはず"),
            () -> assertEquals(beforeMP + 5, character.getMP(), "MPは5増えているはず")
        );
    }

    @Test
    void testMaxLevel() {
        RPGCharacter character = new RPGCharacter();

        // レベル98まで上げる
        for (int i = 1; i < 98; i++) {
            character.levelUp();
        }
        assertEquals(98, character.getLevel(), "レベル98になっているはず");

        // レベル99へ正常アップ
        character.levelUp();
        assertEquals(99, character.getLevel(), "レベル99に到達しているはず");

        // レベル99でのレベルアップ試行は例外になる
        IllegalStateException exception = assertThrows(
            IllegalStateException.class,
            character::levelUp,
            "レベル99でのレベルアップは例外になるはず"
        );

        assertEquals("最大レベルに達しています", exception.getMessage(),
            "例外メッセージが一致しない");
    }
}
