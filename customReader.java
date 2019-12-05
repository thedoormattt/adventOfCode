import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class customReader {
    public static int[] customInputReader(String fileName) {
        final String filePath = "C:\\git\\"+fileName+".txt";
        String content = "";

        try {
            content = new String (Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException err) {
            err.printStackTrace();
        }
        return Arrays.stream(content.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}
