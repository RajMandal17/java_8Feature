import java.util.*;
import java.util.stream.*;

/**
 * ✅ BASIC TRANSFORMATIONS - Traditional vs Stream API
 * 
 * This demonstrates:
 * 1. Squaring numbers
 * 2. Converting strings to uppercase
 * 3. String length calculation
 */
public class BasicTransformations {
    
    public static void main(String[] args) {
        
        System.out.println("=== Example 1: Square Numbers ===\n");
        squareNumbersTraditional();
        squareNumbersWithStream();
        
        System.out.println("\n=== Example 2: Convert to Uppercase ===\n");
        uppercaseTraditional();
        uppercaseWithStream();
        
        System.out.println("\n=== Example 3: Get String Lengths ===\n");
        stringLengthTraditional();
        stringLengthWithStream();
    }
    
    // ========================================
    // Example 1: Square Numbers
    // ========================================
    
    /**
     * ❌ TRADITIONAL WAY - Using for loop
     * Problems:
     * - More code
     * - Manual list creation
     * - Imperative (HOW to do it)
     * - Mutable state (we modify 'squares' list)
     */
    static void squareNumbersTraditional() {
        System.out.println("Traditional Approach:");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = new ArrayList<>();
        
        // Manual iteration
        for (Integer num : numbers) {
            squares.add(num * num);  // Transform and add
        }
        
        System.out.println("Input:  " + numbers);
        System.out.println("Output: " + squares);
    }
    
    /**
     * ✅ STREAM API WAY - Using map()
     * Benefits:
     * - Less code
     * - Declarative (WHAT to do)
     * - No mutation
     * - Functional style
     * - Chainable operations
     */
    static void squareNumbersWithStream() {
        System.out.println("\nStream API Approach:");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
       String squares = numbers.stream().map(n -> n*n ).toString();
        System.out.println("Input:  " + numbers);
        System.out.println("Output: " + squares);
        
        // Even cleaner in Java 16+
        List<Integer> squaresModern = numbers.stream()
                                            .map(n -> n * n)
                                            .toList();
    }
    
    // ========================================
    // Example 2: Convert to Uppercase
    // ========================================
    
    /**
     * ❌ TRADITIONAL WAY
     */
    static void uppercaseTraditional() {
        System.out.println("Traditional Approach:");
        
        List<String> names = Arrays.asList("raj", "aman", "priya", "kumar");
        List<String> upperNames = new ArrayList<>();
        
        for (String name : names) {
            upperNames.add(name.toUpperCase());
        }
        
        System.out.println("Input:  " + names);
        System.out.println("Output: " + upperNames);
    }
    
    /**
     * ✅ STREAM API WAY
     * Note: String::toUpperCase is a METHOD REFERENCE
     * It's shorthand for: name -> name.toUpperCase()
     */
    static void uppercaseWithStream() {
        System.out.println("\nStream API Approach:");
        
        List<String> names = Arrays.asList("raj", "aman", "priya", "kumar");
        
        // Using lambda
        List<String> upperNames1 = names.stream()
                                       .map(name -> name.toUpperCase())
                                       .collect(Collectors.toList());
        
        // Using method reference (cleaner!)
        List<String> upperNames2 = names.stream()
                                       .map(String::toUpperCase)
                                       .collect(Collectors.toList());
        
        System.out.println("Input:  " + names);
        System.out.println("Output: " + upperNames2);
    }
    
    // ========================================
    // Example 3: Get String Lengths
    // ========================================
    
    /**
     * ❌ TRADITIONAL WAY
     * Note: Converting String → Integer (type change)
     */
    static void stringLengthTraditional() {
        System.out.println("Traditional Approach:");
        
        List<String> words = Arrays.asList("Java", "Stream", "API", "is", "powerful");
        List<Integer> lengths = new ArrayList<>();
        
        for (String word : words) {
            lengths.add(word.length());
        }
        
        System.out.println("Input:  " + words);
        System.out.println("Output: " + lengths);
    }
    
    /**
     * ✅ STREAM API WAY
     * map() can change type: Stream<String> → Stream<Integer>
     */
    static void stringLengthWithStream() {
        System.out.println("\nStream API Approach:");
        
        List<String> words = Arrays.asList("Java", "Stream", "API", "is", "powerful");
        
        List<Integer> lengths = words.stream()
                                    .map(String::length)  // String → Integer
                                    .collect(Collectors.toList());
        
        System.out.println("Input:  " + words);
        System.out.println("Output: " + lengths);
    }
}
