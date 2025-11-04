import java.util.*;
import java.util.stream.*;

/**
 * Product class for demonstration
 */
class Product {
    private String name;
    private double price;
    private String category;
    
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    
    @Override
    public String toString() {
        return String.format("Product{name='%s', price=%.2f, category='%s'}", 
                           name, price, category);
    }
}

/**
 * ✅ COMBINING map() with filter() - Traditional vs Stream API
 * 
 * Demonstrates:
 * 1. Filter then transform
 * 2. Transform then filter
 * 3. Multiple conditions
 * 4. Real-world scenarios
 */
public class MapWithFilterExample {
    
    public static void main(String[] args) {
        
        List<Product> products = getProducts();
        
        System.out.println("=== Original Products ===");
        products.forEach(System.out::println);
        
        System.out.println("\n=== Example 1: Get names of expensive products (>500) ===\n");
        expensiveProductNamesTraditional(products);
        expensiveProductNamesWithStream(products);
        
        System.out.println("\n=== Example 2: Get uppercase categories of Electronics ===\n");
        electronicsUppercaseTraditional(products);
        electronicsUppercaseWithStream(products);
        
        System.out.println("\n=== Example 3: Apply discount to expensive items ===\n");
        discountOnExpensiveTraditional(products);
        discountOnExpensiveWithStream(products);
    }
    
    // ========================================
    // Example 1: Expensive Product Names
    // ========================================
    
    /**
     * ❌ TRADITIONAL WAY
     * Filter (price > 500) + Transform (get name)
     */
    static void expensiveProductNamesTraditional(List<Product> products) {
        System.out.println("Traditional Approach:");
        
        List<String> expensiveNames = new ArrayList<>();
        
        for (Product product : products) {
            if (product.getPrice() > 500) {          // Filter
                expensiveNames.add(product.getName());  // Transform
            }
        }
        
        System.out.println("Expensive product names: " + expensiveNames);
    }
    
    /**
     * ✅ STREAM API WAY
     * Clean pipeline: filter → map
     */
    static void expensiveProductNamesWithStream(List<Product> products) {
        System.out.println("\nStream API Approach:");
        
        List<String> expensiveNames = products.stream()
                                             .filter(p -> p.getPrice() > 500)  // Filter first
                                             .map(Product::getName)             // Then transform
                                             .collect(Collectors.toList());
        
        System.out.println("Expensive product names: " + expensiveNames);
    }
    
    // ========================================
    // Example 2: Electronics - Uppercase Category
    // ========================================
    
    /**
     * ❌ TRADITIONAL WAY
     */
    static void electronicsUppercaseTraditional(List<Product> products) {
        System.out.println("Traditional Approach:");
        
        List<String> categories = new ArrayList<>();
        
        for (Product product : products) {
            if (product.getCategory().equals("Electronics")) {
                categories.add(product.getCategory().toUpperCase());
            }
        }
        
        System.out.println("Electronics categories: " + categories);
    }
    
    /**
     * ✅ STREAM API WAY
     */
    static void electronicsUppercaseWithStream(List<Product> products) {
        System.out.println("\nStream API Approach:");
        
        List<String> categories = products.stream()
                                         .filter(p -> p.getCategory().equals("Electronics"))
                                         .map(p -> p.getCategory().toUpperCase())
                                         .collect(Collectors.toList());
        
        System.out.println("Electronics categories: " + categories);
    }
    
    // ========================================
    // Example 3: Apply 20% Discount on Expensive Items
    // ========================================
    
    /**
     * ❌ TRADITIONAL WAY
     * Complex business logic with filter + transform
     */
    static void discountOnExpensiveTraditional(List<Product> products) {
        System.out.println("Traditional Approach:");
        
        List<Double> discountedPrices = new ArrayList<>();
        
        for (Product product : products) {
            if (product.getPrice() > 500) {
                double discountedPrice = product.getPrice() * 0.80;  // 20% off
                discountedPrices.add(discountedPrice);
            }
        }
        
        System.out.println("Discounted prices: " + discountedPrices);
    }
    
    /**
     * ✅ STREAM API WAY
     * Very clean and readable
     */
    static void discountOnExpensiveWithStream(List<Product> products) {
        System.out.println("\nStream API Approach:");
        
        List<Double> discountedPrices = products.stream()
                                                .filter(p -> p.getPrice() > 500)
                                                .map(p -> p.getPrice() * 0.80)
                                                .collect(Collectors.toList());
        
        System.out.println("Discounted prices: " + discountedPrices);
        
        // More detailed output
        System.out.println("\nDetailed:");
        products.stream()
               .filter(p -> p.getPrice() > 500)
               .map(p -> String.format("%s: ₹%.2f → ₹%.2f (20%% off)", 
                                      p.getName(), 
                                      p.getPrice(), 
                                      p.getPrice() * 0.80))
               .forEach(System.out::println);
    }
    
    // ========================================
    // Sample Data
    // ========================================
    
    static List<Product> getProducts() {
        return Arrays.asList(
            new Product("Laptop", 1200.00, "Electronics"),
            new Product("Mouse", 250.00, "Electronics"),
            new Product("Keyboard", 450.00, "Electronics"),
            new Product("Monitor", 800.00, "Electronics"),
            new Product("Desk", 600.00, "Furniture"),
            new Product("Chair", 350.00, "Furniture"),
            new Product("Phone", 700.00, "Electronics")
        );
    }
}
