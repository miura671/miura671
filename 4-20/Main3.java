import java.io.File;
import java.io.IOException;

public class Main3 {
    public static void main(String[] args) {
        // フォルダ名とファイル名
        String folderName = "exercise_folder";
        String fileName = "exercise_file.txt";

        // フォルダオブジェクト作成
        File folder = new File(folderName);

        // フォルダの存在確認と作成
        if (folder.exists()) {
            System.out.println("フォルダは既に存在します。");
        } else {
            if (folder.mkdir()) {
                System.out.println("フォルダを作成しました。");
            } else {
                System.out.println("フォルダの作成に失敗しました。");
                return; // フォルダ作成できない場合は終了
            }
        }

        // ファイルオブジェクト作成（フォルダの中）
        File file = new File(folder, fileName);

        try {
            if (file.exists()) {
                System.out.println("ファイルは既に存在します。");
            } else {
                if (file.createNewFile()) {
                    System.out.println("ファイルを作成しました。");
                } else {
                    System.out.println("ファイルの作成に失敗しました。");
                }
            }
        } catch (IOException e) {
            System.out.println("ファイルの作成中にエラーが発生しました。");
            e.printStackTrace();
        }
    }
}
