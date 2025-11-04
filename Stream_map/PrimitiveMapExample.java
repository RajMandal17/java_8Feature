import java.util.*;
import java.util.stream.*;

/**
 * ✅ PRIMITIVE MAP VARIANTS - Performance Optimization
 * 
 * Demonstrates:
 * 1. mapToInt() - for int values
 * 2. mapToDouble() - for double values
 * 3. mapToLong() - for long values
 * 
 * WHY USE THEM?
 * - Avoids boxing/unboxing (Integer ↔ int)
 * - Better performance
 * - Specialized operations (sum, average, max, min)
 */
public class PrimitiveMapExample {
    
    public static void main(String[] args) {
        
        System.out.println("=== Example 1: mapToInt() - Calculate Total Length ===\n");
        mapToIntExample();
        
        System.out.println("\n=== Example 2: mapToDouble() - Calculate Total Price ===\n");
        mapToDoubleExample();
        
        System.out.println("\n=== Example 3: mapToLong() - Population Statistics ===\n");
        mapToLongExample();
        
        System.out.println("\n=== Example 4: Performance Comparison ===\n");
        performanceComparison();
    }
    
    // ========================================
    // Example 1: mapToInt()
    // ========================================
    
    /**
     * ✅ mapToInt() Example
     * Use Case: Calculate sum of string lengths
     */
    static void mapToIntExample() {
        List<String> words = Arrays.asList("Java", "Stream", "API", "is", "powerful");
        
        System.out.println("Words: " + words);
        
        // ❌ Using map() - Returns Stream<Integer> (boxed)
        int totalLengthBoxed = words.stream()
                                   .map(String::length)           // Stream<Integer>
                                   .reduce(0, Integer::sum);       // Boxing overhead
        
        System.out.println("Total length (map): " + totalLengthBoxed);
        
        // ✅ Using mapToInt() - Returns IntStream (primitive)
        int totalLength = words.stream()
                              .mapToInt(String::length)    // IntStream (no boxing!)
                              .sum();                       // Built-in sum()
        
        System.out.println("Total length (mapToInt): " + totalLength);
        
        // ✅ IntStream provides special methods
        IntSummaryStatistics stats = words.stream()
                                         .mapToInt(String::length)
                                         .summaryStatistics();
        
        System.out.println("\nStatistics:");
        System.out.println("  Count:   " + stats.getCount());
        System.out.println("  Sum:     " + stats.getSum());
        System.out.println("  Min:     " + stats.getMin());
        System.out.println("  Max:     " + stats.getMax());
        System.out.println("  Average: " + stats.getAverage());
    }
    
    // ========================================
    // Example 2: mapToDouble()
    // ========================================
    
    static class Product {
        String name;
        double price;
        
        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
        
        double getPrice() { return price; }
    }
    
    /**
     * ✅ mapToDouble() Example
     * Use Case: Calculate total price, average, etc.
     */
    static void mapToDoubleExample() {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 1200.50),
            new Product("Mouse", 250.00),
            new Product("Keyboard", 450.75),
            new Product("Monitor", 800.25)
        );
        
        System.out.println("Products: " + products.size() + " items");
        
        // ❌ Using map() - Stream<Double> (boxed)
        double totalBoxed = products.stream()
                                   .map(Product::getPrice)
                                   .reduce(0.0, Double::sum);
        
        System.out.println("Total (map): ₹" + totalBoxed);
        
        // ✅ Using mapToDouble() - DoubleStream (primitive)
        double total = products.stream()
                              .mapToDouble(Product::getPrice)  // DoubleStream
                              .sum();
        
        System.out.println("Total (mapToDouble): ₹" + total);
        
        // ✅ DoubleStream special methods
        double average = products.stream()
                                .mapToDouble(Product::getPrice)
                                .average()
                                .orElse(0.0);
        
        double max = products.stream()
                            .mapToDouble(Product::getPrice)
                            .max()
                            .orElse(0.0);
        
        double min = products.stream()
                            .mapToDouble(Product::getPrice)
                            .min()
                            .orElse(0.0);
        
        System.out.println("\nPrice Statistics:");
        System.out.println("  Average: ₹" + String.format("%.2f", average));
        System.out.println("  Max:     ₹" + String.format("%.2f", max));
        System.out.println("  Min:     ₹" + String.format("%.2f", min));
    }
    
    // ========================================
    // Example 3: mapToLong()
    // ========================================
    
    static class City {
        String name;
        long population;
        
        City(String name, long population) {
            this.name = name;
            this.population = population;
        }
        
        long getPopulation() { return population; }
    }
    
    /**
     * ✅ mapToLong() Example
     * Use Case: Large numbers (population, file sizes, etc.)
     */
    static void mapToLongExample() {
        List<City> cities = Arrays.asList(
            new City("Mumbai", 20_000_000L),
            new City("Delhi", 19_000_000L),
            new City("Bangalore", 12_000_000L),
            new City("Hyderabad", 10_000_000L)
        );
        
        System.out.println("Cities: " + cities.size());
        
        // ✅ Using mapToLong() - LongStream
        long totalPopulation = cities.stream()
                                    .mapToLong(City::getPopulation)
                                    .sum();
        
        System.out.println("Total population: " + totalPopulation);
        
        double avgPopulation = cities.stream()
                                    .mapToLong(City::getPopulation)
                                    .average()
                                    .orElse(0.0);
        
        System.out.println("Average population: " + String.format("%.0f", avgPopulation));
        
        long maxPopulation = cities.stream()
                                  .mapToLong(City::getPopulation)
                                  .max()
                                  .orElse(0L);
        
        System.out.println("Largest city: " + maxPopulation);
    }
    
    // ========================================
    // Example 4: Performance Comparison
    // ========================================
    
    /**
     * Demonstrates performance difference between map() and mapToInt()
     */
    static void performanceComparison() {
        // Create large list
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 1_000_000; i++) {
            numbers.add(i);
        }
        
        System.out.println("Processing " + numbers.size() + " numbers...\n");
        
        // ❌ Using map() - With boxing
        long start1 = System.nanoTime();
        long sum1 = numbers.stream()
                          .map(n -> n * 2)              // Stream<Integer> (boxing!)
                          .reduce(0, Integer::sum);
        long end1 = System.nanoTime();
        
        System.out.println("map() result: " + sum1);
        System.out.println("Time: " + (end1 - start1) / 1_000_000 + " ms");
        
        // ✅ Using mapToInt() - No boxing
        long start2 = System.nanoTime();
        long sum2 = numbers.stream()
                          .mapToInt(n -> n * 2)         // IntStream (no boxing!)
                          .sum();
        long end2 = System.nanoTime();
        
        System.out.println("\nmapToInt() result: " + sum2);
        System.out.println("Time: " + (end2 - start2) / 1_000_000 + " ms");
        
        long diff = (end1 - start1) - (end2 - start2);
        System.out.println("\n⚡ Performance gain: " + diff / 1_000_000 + " ms faster!");
        System.out.println("✅ mapToInt() is more efficient due to no boxing/unboxing");
    }
}
