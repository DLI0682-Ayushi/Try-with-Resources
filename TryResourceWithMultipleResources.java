import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class TryResourceWithMultipleResources {
    public static void main(String[] args) {
        String inputFile1 = "file1.txt";
        String inputFile2 = "file2.txt";
        String outputFile = "combined.txt";
        try (
                BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
                BufferedReader reader2 = new BufferedReader(new FileReader(inputFile2));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data from " + inputFile1 + " and " + inputFile2 + " combined successfully.");
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }
}
