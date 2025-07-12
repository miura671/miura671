// src/test/RPGCharacterTest.java

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RPGCharacterTest {

    @Test
    void testInitialStatus() {
        RPGCharacter character = new RPGCharacter();

        assertEquals(1, character.getLevel(), "初期レベルは1であるべき");
        assertEquals(100, character.getHP(), "初期HPは100であるべき");
        assertEquals(50, character.getMP(), "初期MPは50であるべき");
    }

    @Test
    void testNormalLevelUp() {
        RPGCharacter character = new RPGCharacter();

        character.levelUp();

        assertEquals(2, character.getLevel(), "レベルアップ後、レベルは2になるべき");
        assertEquals(110, character.getHP(), "レベルアップ後、HPは110になるべき");
        assertEquals(55, character.getMP(), "レベルアップ後、MPは55になるべき");
    }

    @Test
    void testMaxLevel() {
        RPGCharacter character = new RPGCharacter();

        // レベルを98まで上げる
        for (int i = 1; i < 98; i++) {
            character.levelUp();
        }
        assertEquals(98, character.getLevel(), "98回レベルアップした後、レベルは98であるべき");

        // 98→99はOK
        character.levelUp();
        assertEquals(99, character.getLevel(), "98からのレベルアップ後、レベルは99であるべき");

        // 99→100 は例外が出る
        IllegalStateException exception = assertThrows(
            IllegalStateException.class,
            character::levelUp,
            "レベル99でのレベルアップは例外を投げるべき"
        );
        assertEquals("最大レベルに達しています", exception.getMessage(), "例外メッセージが一致しません");
    }
}

    
}