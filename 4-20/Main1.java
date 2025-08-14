import java.io.FileWriter;
import java.io.IOException;

public class Main1 {
    public static void main(String[] args) {
        try {
            // "exercise.txt"という名前のファイルを新規作成し、書き込み用に開く
            FileWriter writer = new FileWriter("exercise.txt");

            // ファイルに"Hello,World!"を書き込み
            writer.write("Hello,World!");

            // ファイルを閉じる
            writer.close();

            // 書き込み完了メッセージ
            System.out.println("ファイルに書き込みが完了しました。");

        } catch (IOException e) {
            // エラー時メッセージ
            System.out.println("ファイルの書き込み中にエラーが発生しました。");
            e.printStackTrace(); // どんなエラーか詳細表示
        }
    }
}
