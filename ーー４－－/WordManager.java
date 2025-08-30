import java.util.ArrayList;
import java.util.List;

/**
 * 単語コレクションを管理するクラス
 */
public class WordManager {
    private List<Word> words;

    /**
     * コンストラクタ
     */
    public WordManager() {
        words = new ArrayList<>();
    }

    /**
     * 単語を追加
     * @param word 追加する単語
     */
    public void addWord(Word word) {
        words.add(word);
    }

    /**
     * 登録された単語を取得
     * @return 単語リスト
     */
    public List<Word> getWords() {
        return words;
    }

    /**
     * 登録された単語の数を取得
     * @return 単語の数
     */
    public int getWordCount() {
        return words.size();
    }
}
