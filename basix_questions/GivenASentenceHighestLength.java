
import java.util.Arrays;
    
public class GivenASentenceHighestLength {

    public static void main(String[] args) {
        
        String str = "Java is a programming language"; 

        // Find the longest word
        String longest = Arrays.stream(str.split(" "))
                          .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                          .orElse("");

        System.out.println("Longest word: " + longest);
        System.out.println("Length: " + longest.length());
             }
  

}