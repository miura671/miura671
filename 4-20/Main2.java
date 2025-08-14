import java.io.FileReader;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) {
        try {
            // "exercise.txt" を開く
            FileReader reader = new FileReader("exercise.txt");

            int data;
            // 1文字ずつ読み込む (-1 はEOF: end of file)
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }

            // ファイルを閉じる
            reader.close();

        } catch (IOException e) {
            System.out.println("ファイルの読み込み中にエラーが発生しました。");
            e.printStackTrace();
        }
    }
}
