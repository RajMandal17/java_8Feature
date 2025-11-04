import java.util.*;
import java.util.stream.*;

/**
 * ✅ TYPE CONVERSION - Traditional vs Stream API
 * 
 * Demonstrates:
 * 1. String → Integer conversion
 * 2. Integer → String conversion
 * 3. Rupees → Dollars conversion (business logic)
 */
public class TypeConversionExample {
    
    public static void main(String[] args) {
        
        System.out.println("=== Example 1: String → Integer ===\n");
        stringToIntTraditional();
        stringToIntWithStream();
        
        System.out.println("\n=== Example 2: Integer → String ===\n");
        intToStringTraditional();
        intToStringWithStream();
        
        System.out.println("\n=== Example 3: Rupees → USD (Business Logic) ===\n");
        rupeesToUsdTraditional();
        rupeesToUsdWithStream();
    }
    
    // ========================================
    // Example 1: String → Integer
    // ========================================
    
    /**
     * ❌ TRADITIONAL WAY
     */
    static void stringToIntTraditional() {
        System.out.println("Traditional Approach:");
        
        List<String> stringNumbers = Arrays.asList("10", "20", "30", "40", "50");
        List<Integer> integers = new ArrayList<>();
        
        for (String str : stringNumbers) {
            integers.add(Integer.parseInt(str));  // Convert String → Integer
        }
        
        System.out.println("Input:  " + stringNumbers);
        System.out.println("Output: " + integers);
    }
    
    /**
     * ✅ STREAM API WAY
     * Type transformation: Stream<String> → Stream<Integer>
     */
    static void stringToIntWithStream() {
        System.out.println("\nStream API Approach:");
        
        List<String> stringNumbers = Arrays.asList("10", "20", "30", "40", "50");
        
        List<Integer> integers = stringNumbers.stream()
                                             .map(Integer::parseInt)  // String → Integer
                                             .collect(Collectors.toList());
        
        System.out.println("Input:  " + stringNumbers);
        System.out.println("Output: " + integers);
    }
    
    // ========================================
    // Example 2: Integer → String
    // ========================================
    
    /**
     * ❌ TRADITIONAL WAY
     */
    static void intToStringTraditional() {
        System.out.println("Traditional Approach:");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> strings = new ArrayList<>();
        
        for (Integer num : numbers) {
            strings.add("Number: " + num);  // Integer → String with formatting
        }
        
        System.out.println("Input:  " + numbers);
        System.out.println("Output: " + strings);
    }
    
    /**
     * ✅ STREAM API WAY
     */
    static void intToStringWithStream() {
        System.out.println("\nStream API Approach:");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        List<String> strings = numbers.stream()
                                     .map(num -> "Number: " + num)
                                     .collect(Collectors.toList());
        
        System.out.println("Input:  " + numbers);
        System.out.println("Output: " + strings);
    }
    
    // ========================================
    // Example 3: Rupees → USD Conversion
    // ========================================
    
    /**
     * ❌ TRADITIONAL WAY
     * Business logic: 1 USD = 84 Rupees
     */
    static void rupeesToUsdTraditional() {
        System.out.println("Traditional Approach:");
        
        List<Double> pricesInRupees = Arrays.asList(840.0, 1680.0, 4200.0, 8400.0);
        List<Double> pricesInUsd = new ArrayList<>();
        
        final double CONVERSION_RATE = 84.0;
        
        for (Double rupees : pricesInRupees) {
            double usd = rupees / CONVERSION_RATE;
            pricesInUsd.add(usd);
        }
        
        System.out.println("Prices in Rupees: " + pricesInRupees);
        System.out.println("Prices in USD:    " + pricesInUsd);
    }
    
    /**
     * ✅ STREAM API WAY
     * Clean, functional, declarative
     */
    static void rupeesToUsdWithStream() {
        System.out.println("\nStream API Approach:");
        
        List<Double> pricesInRupees = Arrays.asList(840.0, 1680.0, 4200.0, 8400.0);
        final double CONVERSION_RATE = 84.0;
        
        List<Double> pricesInUsd = pricesInRupees.stream()
                                                 .map(rupees -> rupees / CONVERSION_RATE)
                                                 .collect(Collectors.toList());
        
        System.out.println("Prices in Rupees: " + pricesInRupees);
        System.out.println("Prices in USD:    " + pricesInUsd);
        
        // With formatting
        System.out.println("\nFormatted Output:");
        pricesInRupees.stream()
                     .map(rupees -> String.format("₹%.2f = $%.2f", 
                                                   rupees, 
                                                   rupees / CONVERSION_RATE))
                     .forEach(System.out::println);
    }
}
