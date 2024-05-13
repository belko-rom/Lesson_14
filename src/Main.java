
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int i;
        StringBuilder romeoAndJuliet = new StringBuilder();
        String[] arrWords;
        try (FileReader reader = new FileReader("src/romeo-and-juliet.txt")) {
            while ((i = reader.read()) != -1) {
                romeoAndJuliet.append((char) i);
            }
        } catch (IOException exception) {
            System.out.println(exception);
        }
        arrWords = romeoAndJuliet.toString().split("\\W+");
        String longestWord = arrWords[0];
        for (String word : arrWords) {
            if (longestWord.length() < word.length()) {
                longestWord = word;
            }
        }
        try (FileWriter writer = new FileWriter("src/the-longest-word.txt", true)) {
            writer.write(longestWord + "\n");
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }
}