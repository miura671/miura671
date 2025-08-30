import java.util.Scanner;

/**
 * 英単語学習アプリのメインクラス
 */
public class VocabularyApp {
    private WordManager wordManager;
    private Quiz quiz;
    private FileHandler fileHandler;
    private Scanner scanner;
    
    /**
     * コンストラクタ
     */
    public VocabularyApp() {
        wordManager = new WordManager();
        quiz = new Quiz(wordManager);
        fileHandler = new FileHandler();
        scanner = new Scanner(System.in);
    }
    
    /**
     * アプリケーションを開始
     */
    public void start() {
        System.out.println("=== 英単語暗記アプリ ===");
        
        while (true) {
            showMenu();
            int choice = getMenuChoice();
            
            switch (choice) {
                case 1:
                    registerWord();
                    break;
                case 2:
                    startQuiz();
                    break;
                case 3:
                    importWords();
                    break;
                case 4:
                    exportWords();
                    break;
                case 5:
                    System.out.println("アプリケーションを終了します。");
                    return;
                default:
                    System.out.println("1〜5の数字を入力してください。");
            }
        }
    }
    
    /**
     * メニューを表示
     */
    private void showMenu() {
        System.out.println("\n1: 単語を登録する");
        System.out.println("2: クイズを受ける");
        System.out.println("3: CSVファイルから単語をインポート");
        System.out.println("4: CSVファイルに単語をエクスポート");
        System.out.println("5: 終了する");
        System.out.print("選択してください: ");
    }
    
    /**
     * メニュー選択を取得
     * @return 選択されたメニュー番号
     */
    private int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    /**
     * 単語を登録
     */
    private void registerWord() {
        System.out.println("\n【単語登録】");
        System.out.print("英単語を入力してください: ");
        String english = scanner.nextLine().trim();
        
        if (english.isEmpty()) {
            System.out.println("英単語を入力してください。");
            return;
        }
        
        System.out.print("日本語訳を入力してください: ");
        String japanese = scanner.nextLine().trim();
        
        if (japanese.isEmpty()) {
            System.out.println("日本語訳を入力してください。");
            return;
        }
        
        wordManager.addWord(new Word(english, japanese));
        System.out.println("単語を登録しました。");
    }
    
    /**
     * クイズを開始
     */
    private void startQuiz() {
        quiz.startQuiz();
    }
    
    /**
     * CSVファイルから単語をインポート
     */
    private void importWords() {
        System.out.println("\n【CSVファイルからインポート】");
        System.out.print("CSVファイル名を入力してください: ");
        String filename = scanner.nextLine().trim();
        
        if (filename.isEmpty()) {
            System.out.println("ファイル名を入力してください。");
            return;
        }
        
        fileHandler.importFromCSV(filename, wordManager);
    }
    
    /**
     * CSVファイルに単語をエクスポート
     */
    private void exportWords() {
        System.out.println("\n【CSVファイルへエクスポート】");
        System.out.print("CSVファイル名を入力してください: ");
        String filename = scanner.nextLine().trim();
        
        if (filename.isEmpty()) {
            System.out.println("ファイル名を入力してください。");
            return;
        }
        
        if (wordManager.getWordCount() == 0) {
            System.out.println("登録された単語がありません。");
            return;
        }
        
        fileHandler.exportToCSV(wordManager.getWords(), filename);
    }
    
    /**
     * メインメソッド
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        VocabularyApp app = new VocabularyApp();
        app.start();
    }
}
