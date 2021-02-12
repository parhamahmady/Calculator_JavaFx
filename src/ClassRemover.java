import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * ClassRemover
 */
public class ClassRemover {
    private static String address;

    public static void main(String[] args) {
        // Scanner fScanner = new Scanner(System.in);
        // System.out.println("Tell Me The Folder Address (Must have / add the end)");
        // address = fScanner.next();
        // fScanner.close();
        address = "./";
        try {
            fileFinder(address);
            System.out.println("Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void fileFinder(String folder) throws IOException {
        Path path = Paths.get(folder);
        DirectoryStream<Path> stream = Files.newDirectoryStream(path);

        for (Path path2 : stream) {
            File temp = path2.toFile();
            if (temp.isDirectory()) {
                fileFinder(temp.getPath());
            } else {
                if (temp.getName().contains(".class")) {
                    temp.delete();
                } else
                    continue;
            }
        }
    }
}