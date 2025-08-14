import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main4 {
    public static void main(String[] args) {
        // コピー元ファイル
        Path sourceFile = Path.of("source.txt");
        // バックアップ先フォルダ
        File backupFolder = new File("backup");
        // アーカイブ先フォルダ
        File archiveFolder = new File("archive");

        try {
            // backupフォルダ作成（存在しなければ）
            if (!backupFolder.exists()) {
                backupFolder.mkdir();
            }

            // source.txt を backup/ にコピー
            Path backupFile = backupFolder.toPath().resolve("source.txt");
            Files.copy(sourceFile, backupFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("ファイルが'backup/'にコピーされました。");

            // コピーの確認
            if (Files.exists(backupFile)) {
                System.out.println("コピーの確認:成功");
            } else {
                System.out.println("コピーの確認:失敗");
            }

            // archiveフォルダ作成（存在しなければ）
            if (!archiveFolder.exists()) {
                archiveFolder.mkdir();
            }

            // backup/source.txt を archive/ に移動
            Path archiveFile = archiveFolder.toPath().resolve("source.txt");
            Files.move(backupFile, archiveFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("ファイルが'archive/'に移動されました。");

            // 移動の確認
            if (Files.exists(archiveFile) && !Files.exists(backupFile)) {
                System.out.println("移動の確認:成功");
            } else {
                System.out.println("移動の確認:失敗");
            }

        } catch (IOException e) {
            System.out.println("ファイル操作中にエラーが発生しました。");
            e.printStackTrace();
        }
    }
}
