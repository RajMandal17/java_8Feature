import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestWordExamples {

    public static void main(String[] args) {
        String sentence = "Java is a programming language";

        System.out.println("=== TRADITIONAL JAVA (Pre-Java 8) ===");
        traditionalApproach(sentence);

        System.out.println("\n=== STREAM API SOLUTIONS ===");
        streamReduceApproach(sentence);
        streamMaxApproach(sentence);
        streamSortedApproach(sentence);
        streamCollectApproach(sentence);
    }

    // 1. TRADITIONAL JAVA APPROACH (No Streams)
    public static void traditionalApproach(String sentence) {
        String[] words = sentence.split(" ");
        String longestWord = "";

        // Loop through each word
        for (String word : words) {
            // If current word is longer than longestWord, update it
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        System.out.println("Longest word: " + longestWord);
        System.out.println("Length: " + longestWord.length());
    }

    // 2. STREAM API - reduce() approach (Your current code)
    public static void streamReduceApproach(String sentence) {
        String longest = Arrays.stream(sentence.split(" "))
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .orElse("");

        System.out.println("Reduce approach - Longest: " + longest + " (length: " + longest.length() + ")");
    }

    // 3. STREAM API - max() with Comparator
    public static void streamMaxApproach(String sentence) {
       String longest = Arrays.stream(sentence.split(" "))
                 .max(Comparator.comparingInt(String::length))
                 .orElse("");

        System.out.println("Max approach - Longest: " + longest + " (length: " + longest.length() + ")");
    }

    // 4. STREAM API - sorted() then findFirst()
    public static void streamSortedApproach(String sentence) {
        String longest = Arrays.stream(sentence.split(" "))
                .sorted((w1, w2) -> Integer.compare(w2.length(), w1.length())) // Sort descending by length
                .findFirst()  // Get first (longest)
                .orElse("");

        System.out.println("Sorted approach - Longest: " + longest + " (length: " + longest.length() + ")");
    }

    // 5. STREAM API - collect() with custom logic
    public static void streamCollectApproach(String sentence) {
        List<String> words = Arrays.asList(sentence.split(" "));

        String longest = words.stream()
                .collect(() -> new String[]{""},  // Supplier: create array to hold result
                        (result, word) -> {       // Accumulator: compare and update
                            if (word.length() > result[0].length()) {
                                result[0] = word;
                            }
                        },
                        (result1, result2) -> {   // Combiner: for parallel streams
                            if (result2[0].length() > result1[0].length()) {
                                result1[0] = result2[0];
                            }
                        })[0];  // Get the result from array

        System.out.println("Collect approach - Longest: " + longest + " (length: " + longest.length() + ")");
    }


}