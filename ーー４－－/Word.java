
/**
 * 単語データを管理するクラス
 */
public class Word {

    private String english;
    private String japanese;

    /**
     * コンストラクタ
     *
     * @param english 英単語
     * @param japanese 日本語訳
     */
    public Word(String english, String japanese) {
        this.english = english;
        this.japanese = japanese;
    }

    /**
     * 英単語を取得
     *
     * @return 英単語
     */
    public String getEnglish() {
        return english;
    }

    /**
     * 日本語訳を取得
     *
     * @return 日本語訳
     */
    public String getJapanese() {
        return japanese;
    }

    /**
     * 英単語を設定
     *
     * @param english 英単語
     */
    public void setEnglish(String english) {
        this.english = english;
    }

    /**
     * 日本語訳を設定
     *
     * @param japanese 日本語訳
     */
    public void setJapanese(String japanese) {
        this.japanese = japanese;
    }

    /**
     * 文字列表現
     *
     * @return 英単語と日本語訳の文字列
     */
    @Override
    public String toString() {
        return english + " - " + japanese;
    }
}
