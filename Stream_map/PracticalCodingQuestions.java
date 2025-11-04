import java.util.*;
import java.util.stream.*;

/**
 * ✅ PRACTICAL CODING QUESTIONS - All 6 Problems Solved
 * 
 * Questions:
 * Q1: Convert prices from Rupees to USD (1 USD = 84 Rupees)
 * Q2: Get length of each string
 * Q3: Extract email IDs from User list
 * Q4: Convert List<Employee> → List<EmployeeDTO>
 * Q5: Find uppercase unique departments
 * Q6: Convert comma-separated strings to List<Integer>
 */
public class PracticalCodingQuestions {
    
    public static void main(String[] args) {
        
        System.out.println("╔═══════════════════════════════════════════╗");
        System.out.println("║   PRACTICAL CODING QUESTIONS - SOLUTIONS  ║");
        System.out.println("╚═══════════════════════════════════════════╝\n");
        
        question1();
        question2();
        question3();
        question4();
        question5();
        question6();
    }
    
    // ========================================
    // Q1: Convert Rupees → USD (1 USD = 84)
    // ========================================
    
    static void question1() {
        System.out.println("🔹 Q1: Convert prices from Rupees to USD (1 USD = 84 Rupees)\n");
        
        List<Double> pricesInRupees = Arrays.asList(840.0, 1680.0, 4200.0, 8400.0, 420.0);
        final double USD_RATE = 84.0;
        
        // ❌ TRADITIONAL WAY
        System.out.println("Traditional Approach:");
        List<Double> usdTraditional = new ArrayList<>();
        for (Double rupees : pricesInRupees) {
            usdTraditional.add(rupees / USD_RATE);
        }
        System.out.println("Input (INR): " + pricesInRupees);
        System.out.println("Output (USD): " + usdTraditional);
        
        // ✅ STREAM API WAY
        System.out.println("\nStream API Approach:");
        List<Double> usdStream = pricesInRupees.stream()
                                               .map(rupees -> rupees / USD_RATE)
                                               .collect(Collectors.toList());
        System.out.println("Output (USD): " + usdStream);
        
        // Formatted output
        System.out.println("\nFormatted:");
        pricesInRupees.stream()
                     .map(rupees -> String.format("₹%.2f = $%.2f", rupees, rupees / USD_RATE))
                     .forEach(System.out::println);
        
        System.out.println("\n" + "=".repeat(70) + "\n");
    }
    
    // ========================================
    // Q2: Get length of each string
    // ========================================
    
    static void question2() {
        System.out.println("🔹 Q2: Return length of each string\n");
        
        List<String> words = Arrays.asList("Java", "Stream", "API", "map", "filter", "collect");
        
        // ❌ TRADITIONAL WAY
        System.out.println("Traditional Approach:");
        List<Integer> lengthsTraditional = new ArrayList<>();
        for (String word : words) {
            lengthsTraditional.add(word.length());
        }
        System.out.println("Input:  " + words);
        System.out.println("Output: " + lengthsTraditional);
        
        // ✅ STREAM API WAY
        System.out.println("\nStream API Approach:");
        List<Integer> lengthsStream = words.stream()
                                          .map(String::length)
                                          .collect(Collectors.toList());
        System.out.println("Output: " + lengthsStream);
        
        // With word → length mapping
        System.out.println("\nDetailed:");
        words.stream()
            .map(word -> word + " → " + word.length())
            .forEach(System.out::println);
        
        System.out.println("\n" + "=".repeat(70) + "\n");
    }
    
    // ========================================
    // Q3: Extract email IDs from User list
    // ========================================
    
    static class User {
        private String name;
        private String email;
        
        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
        
        public String getName() { return name; }
        public String getEmail() { return email; }
    }
    
    static void question3() {
        System.out.println("🔹 Q3: Extract email IDs from User list\n");
        
        List<User> users = Arrays.asList(
            new User("Raj Kumar", "raj@gmail.com"),
            new User("Priya Sharma", "priya@yahoo.com"),
            new User("Aman Singh", "aman@outlook.com"),
            new User("Neha Verma", "neha@gmail.com")
        );
        
        // ❌ TRADITIONAL WAY
        System.out.println("Traditional Approach:");
        List<String> emailsTraditional = new ArrayList<>();
        for (User user : users) {
            emailsTraditional.add(user.getEmail());
        }
        System.out.println("Emails: " + emailsTraditional);
        
        // ✅ STREAM API WAY
        System.out.println("\nStream API Approach:");
        List<String> emailsStream = users.stream()
                                        .map(User::getEmail)
                                        .collect(Collectors.toList());
        System.out.println("Emails: " + emailsStream);
        
        // Extract names too
        System.out.println("\nNames:");
        List<String> names = users.stream()
                                 .map(User::getName)
                                 .collect(Collectors.toList());
        System.out.println(names);
        
        System.out.println("\n" + "=".repeat(70) + "\n");
    }
    
    // ========================================
    // Q4: List<Employee> → List<EmployeeDTO>
    // ========================================
    
    static class Employee {
        private int id;
        private String name;
        private String department;
        
        public Employee(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }
        
        public int getId() { return id; }
        public String getName() { return name; }
        public String getDepartment() { return department; }
    }
    
    static class EmployeeDTO {
        private int id;
        private String name;
        
        public EmployeeDTO(int id, String name) {
            this.id = id;
            this.name = name;
        }
        
        @Override
        public String toString() {
            return String.format("EmployeeDTO{id=%d, name='%s'}", id, name);
        }
    }
    
    static void question4() {
        System.out.println("🔹 Q4: Convert List<Employee> → List<EmployeeDTO>\n");
        
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Raj Kumar", "IT"),
            new Employee(2, "Priya Sharma", "HR"),
            new Employee(3, "Aman Singh", "Finance")
        );
        
        // ❌ TRADITIONAL WAY
        System.out.println("Traditional Approach:");
        List<EmployeeDTO> dtosTraditional = new ArrayList<>();
        for (Employee emp : employees) {
            dtosTraditional.add(new EmployeeDTO(emp.getId(), emp.getName()));
        }
        System.out.println("DTOs: " + dtosTraditional);
        
        // ✅ STREAM API WAY
        System.out.println("\nStream API Approach:");
        List<EmployeeDTO> dtosStream = employees.stream()
                                               .map(emp -> new EmployeeDTO(emp.getId(), emp.getName()))
                                               .collect(Collectors.toList());
        System.out.println("DTOs: " + dtosStream);
        
        System.out.println("\n" + "=".repeat(70) + "\n");
    }
    
    // ========================================
    // Q5: Find uppercase unique departments
    // ========================================
    
    static void question5() {
        System.out.println("🔹 Q5: Find uppercase unique departments\n");
        
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Raj", "IT"),
            new Employee(2, "Priya", "HR"),
            new Employee(3, "Aman", "IT"),
            new Employee(4, "Neha", "Finance"),
            new Employee(5, "Arjun", "HR"),
            new Employee(6, "Kavya", "IT")
        );
        
        // ❌ TRADITIONAL WAY
        System.out.println("Traditional Approach:");
        Set<String> deptsTraditional = new HashSet<>();
        for (Employee emp : employees) {
            deptsTraditional.add(emp.getDepartment().toUpperCase());
        }
        List<String> uniqueDepts = new ArrayList<>(deptsTraditional);
        System.out.println("Unique Departments: " + uniqueDepts);
        
        // ✅ STREAM API WAY - Method 1
        System.out.println("\nStream API Approach (Method 1):");
        List<String> deptsStream1 = employees.stream()
                                            .map(Employee::getDepartment)
                                            .map(String::toUpperCase)
                                            .distinct()  // Remove duplicates
                                            .collect(Collectors.toList());
        System.out.println("Unique Departments: " + deptsStream1);
        
        // ✅ STREAM API WAY - Method 2 (Collecting to Set)
        System.out.println("\nStream API Approach (Method 2):");
        Set<String> deptsStream2 = employees.stream()
                                           .map(emp -> emp.getDepartment().toUpperCase())
                                           .collect(Collectors.toSet());
        System.out.println("Unique Departments: " + deptsStream2);
        
        System.out.println("\n" + "=".repeat(70) + "\n");
    }
    
    // ========================================
    // Q6: Convert comma-separated strings to List<Integer>
    // ========================================
    
    static void question6() {
        System.out.println("🔹 Q6: Convert comma-separated strings to List<Integer>\n");
        System.out.println("Input: \"1,2,3\", \"4,5\"");
        System.out.println("Output: [1, 2, 3, 4, 5]\n");
        
        List<String> csvStrings = Arrays.asList("1,2,3", "4,5", "6,7,8,9");
        
        // ❌ TRADITIONAL WAY
        System.out.println("Traditional Approach:");
        List<Integer> numbersTraditional = new ArrayList<>();
        for (String csv : csvStrings) {
            String[] parts = csv.split(",");
            for (String part : parts) {
                numbersTraditional.add(Integer.parseInt(part.trim()));
            }
        }
        System.out.println("Output: " + numbersTraditional);
        
        // ✅ STREAM API WAY
        System.out.println("\nStream API Approach:");
        
        // This requires flatMap (not just map!)
        // Because: One String → Multiple Integers
        List<Integer> numbersStream = csvStrings.stream()
                                               .flatMap(csv -> Arrays.stream(csv.split(",")))  // Flatten
                                               .map(String::trim)
                                               .map(Integer::parseInt)
                                               .collect(Collectors.toList());
        System.out.println("Output: " + numbersStream);
        
        // Compact version
        List<Integer> numbersCompact = csvStrings.stream()
                                                 .flatMap(s -> Arrays.stream(s.split(",")))
                                                 .map(s -> Integer.parseInt(s.trim()))
                                                 .collect(Collectors.toList());
        
        System.out.println("\n⚠️  NOTE: This question uses flatMap() because:");
        System.out.println("   - map() = One → One transformation");
        System.out.println("   - flatMap() = One → Many transformation");
        System.out.println("   - Here: One String → Multiple Integers");
        
        System.out.println("\n" + "=".repeat(70) + "\n");
    }
}
