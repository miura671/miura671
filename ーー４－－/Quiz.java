import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * クイズ機能を提供するクラス
 */
public class Quiz {
    private WordManager wordManager;
    private int score;
    private int totalQuestions;
    private Scanner scanner;
    
    /**
     * コンストラクタ
     * @param wordManager 単語マネージャー
     */
    public Quiz(WordManager wordManager) {
        this.wordManager = wordManager;
        this.score = 0;
        this.totalQuestions = 0;
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * クイズを開始
     */
    public void startQuiz() {
        List<Word> words = wordManager.getWords();
        
        if (words.isEmpty()) {
            System.out.println("登録された単語がありません。先に単語を登録してください。");
            return;
        }
        
        System.out.println("=== クイズを開始します ===");
        score = 0;
        totalQuestions = words.size();
        
        // すべての単語をランダムな順序で出題
        Random random = new Random();
        for (int i = 0; i < totalQuestions; i++) {
            int randomIndex = random.nextInt(words.size());
            Word word = words.get(randomIndex);
            
            System.out.println((i + 1) + "問目: " + word.getEnglish() + "の意味は？");
            System.out.print("解答: ");
            String answer = scanner.nextLine().trim();
            
            if (checkAnswer(word, answer)) {
                System.out.println("正解です！");
                score++;
            } else {
                System.out.println("不正解です。正解は「" + word.getJapanese() + "」でした。");
            }
            System.out.println();
        }
        
        showResult();
    }
    
    /**
     * 解答をチェック
     * @param word 問題の単語
     * @param answer ユーザーの解答
     * @return 正解かどうか
     */
    public boolean checkAnswer(Word word, String answer) {
        return word.getJapanese().equalsIgnoreCase(answer);
    }
    
    /**
     * ランダムな単語を取得
     * @return ランダムな単語
     */
    public Word getRandomWord() {
        List<Word> words = wordManager.getWords();
        if (words.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
    
    /**
     * 結果を表示
     */
    public void showResult() {
        System.out.println("クイズ終了！");
        System.out.println(totalQuestions + "問中" + score + "問正解でした！");
    }
    
    /**
     * スコアを取得
     * @return スコア
     */
    public int getScore() {
        return score;
    }
    
    /**
     * 総問題数を取得
     * @return 総問題数
     */
    public int getTotalQuestions() {
        return totalQuestions;
    }
}
