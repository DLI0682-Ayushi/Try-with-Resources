import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TryWithResource {
    public void processFiles(List<String> filePaths) {
        for (String filePath : filePaths) {
            try {
                processSingleFile(filePath);
            } catch (IOException e) {
                System.err.println("Error reading file: " + filePath);
                e.printStackTrace();
            }
        }
    }

    private void processSingleFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read from file " + filePath + ": " + line);
            }
        }
    }

    public static void main(String[] args) {
        List<String> filePaths = List.of("file1.txt", "file2.txt", "file3.txt");
        TryWithResource fileProcessor = new TryWithResource();
        fileProcessor.processFiles(filePaths);
    }
}

