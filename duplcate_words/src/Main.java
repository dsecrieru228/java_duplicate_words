import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       Scanner scr = new Scanner(System.in);
       String text = scr.nextLine();

        try {
            findDuplicates(text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void findDuplicates(String text) throws Exception {
        String[] sentences = text.split("\\.");
        if (sentences.length <= 1) {
            throw new Exception("No repeated words");
        }

        String[] words = sentences[1].trim().split("\\s+");
        boolean foundRepeatedWord = false;

        for (int i = 0; i < words.length; i++) {
            words[i] = removeSpecialChars(words[i]);
        }

        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) continue;
            int count = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equalsIgnoreCase(words[j])) {
                    count++;
                    words[j] = "";
                }
            }
            if (count > 1) {
                System.out.println(words[i] + ": " + count);
                foundRepeatedWord = true;
            }
        }

        if (!foundRepeatedWord) {
            throw new Exception("No repeated words");
        }
    }

    private static String removeSpecialChars(String word) {
        return word.replaceAll("[^a-zA-Z0-9]", "");
    }
}