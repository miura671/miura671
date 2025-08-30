import java.io.*;
import java.util.List;

/**
 * CSVファイルの読み書きを管理するクラス
 */
public class FileHandler {
    
    /**
     * CSVファイルに単語をエクスポート
     * @param words 単語リスト
     * @param filename ファイル名
     * @return 成功したかどうか
     */
    public boolean exportToCSV(List<Word> words, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Word word : words) {
                writer.println(word.getEnglish() + "," + word.getJapanese());
            }
            System.out.println(words.size() + "個の単語を保存しました。");
            return true;
        } catch (IOException e) {
            System.out.println("ファイルの保存中にエラーが発生しました: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * CSVファイルから単語をインポート
     * @param filename ファイル名
     * @param wordManager 単語マネージャー
     * @return 読み込んだ単語の数
     */
    public int importFromCSV(String filename, WordManager wordManager) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String english = parts[0].trim();
                    String japanese = parts[1].trim();
                    
                    if (!english.isEmpty() && !japanese.isEmpty()) {
                        wordManager.addWord(new Word(english, japanese));
                        count++;
                    }
                }
            }
            System.out.println(count + "個の単語を読み込みました。");
        } catch (FileNotFoundException e) {
            System.out.println("ファイルが見つかりません: " + filename);
        } catch (IOException e) {
            System.out.println("ファイルの読み込み中にエラーが発生しました: " + e.getMessage());
        }
        return count;
    }
}
