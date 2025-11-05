import java.util.*;
import java.util.stream.*;

/**
 * 🎯 MAP() PRACTICE EXERCISES - BEGINNER TO ADVANCED
 * 
 * Instructions:
 * 1. Read each question carefully
 * 2. Complete the TODO sections
 * 3. Run and verify your output matches expected output
 * 4. Difficulty increases from Level 1 to Level 5
 * 
 * Scoring:
 * - Level 1: Beginner (Basic transformations)
 * - Level 2: Intermediate (Type conversions, method references)
 * - Level 3: Advanced (Chaining, complex objects)
 * - Level 4: Expert (Nested streams, custom logic)
 * - Level 5: Master (Real-world scenarios)
 */
public class MapPracticeExercises {
    
    public static void main(String[] args) {
        System.out.println("=== 🎯 MAP() PRACTICE EXERCISES ===\n");
        
        // Uncomment each level as you complete it
     //   runLevel1();
       //  runLevel2();
        // runLevel3();
       //  runLevel4();
         runLevel5();
    }
    
    // ========================================
    // LEVEL 1: BEGINNER 🟢
    // Basic transformations
    // ========================================
    
    static void runLevel1() {
        System.out.println("=== LEVEL 1: BEGINNER 🟢 ===\n");
        exercise1_1();
        exercise1_2();
        exercise1_3();
        System.out.println("\n✅ Level 1 Complete!\n");
    }
    
    /**
     * Exercise 1.1: Double the numbers
     * Expected Output: [2, 4, 6, 8, 10]
     */
    static void exercise1_1() {
        System.out.println("Exercise 1.1: Double each number");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // TODO: Use map() to double each number
        List<Integer> doubled = numbers.stream().map(num -> num*2).collect(Collectors.toList());
        
        System.out.println("Input:    " + numbers);
        System.out.println("Output:   " + doubled);
        System.out.println("Expected: [2, 4, 6, 8, 10]\n");
    }
    
    /**
     * Exercise 1.2: Add "Hello, " prefix to names
     * Expected Output: [Hello, Raj, Hello, Aman, Hello, Priya]
     */
    static void exercise1_2() {
        System.out.println("Exercise 1.2: Add 'Hello, ' prefix");
        List<String> names = Arrays.asList("Raj", "Aman", "Priya");
        
        // TODO: Use map() to add "Hello, " prefix
        List<String> greetings = names.stream().map(a -> "Hello, ".concat(a) ).collect(Collectors.toList());
        
        System.out.println("Input:    " + names);
        System.out.println("Output:   " + greetings);
        System.out.println("Expected: [Hello, Raj, Hello, Aman, Hello, Priya]\n");
    }
    
    /**
     * Exercise 1.3: Calculate absolute values
     * Expected Output: [5, 10, 3, 8, 15]
     */
    static void exercise1_3() {
        System.out.println("Exercise 1.3: Get absolute values");
        List<Integer> numbers = Arrays.asList(-5, 10, -3, 8, -15);
        
        // TODO: Use map() to get absolute values (Math.abs())
        List<Integer> absolute = numbers.stream().map(a -> Math.abs(a)).collect(Collectors.toList());
        
        System.out.println("Input:    " + numbers);
        System.out.println("Output:   " + absolute);
        System.out.println("Expected: [5, 10, 3, 8, 15]\n");
    }
    
    // ========================================
    // LEVEL 2: INTERMEDIATE 🟡
    // Type conversions and method references
    // ========================================
    
    static void runLevel2() {
        System.out.println("=== LEVEL 2: INTERMEDIATE 🟡 ===\n");
        exercise2_1();
        exercise2_2();
        exercise2_3();
        System.out.println("\n✅ Level 2 Complete!\n");
    }
    
    /**
     * Exercise 2.1: Convert integers to strings
     * Expected Output: [1, 2, 3, 4, 5]
     * Hint: Use String.valueOf() or method reference
     */
    static void exercise2_1() {
        System.out.println("Exercise 2.1: Convert Integer to String");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // TODO: Use map() to convert Integer → String
        List<String> strings = numbers.stream().map(a -> String.valueOf(a)).collect(Collectors.toList());
        
        System.out.println("Input:    " + numbers);
        System.out.println("Output:   " + strings);
        System.out.println("Expected: [1, 2, 3, 4, 5] (as Strings)\n");
    }
    
    /**
     * Exercise 2.2: Extract first character from each word
     * Expected Output: [J, P, S]
     * Hint: Use charAt(0) or substring(0, 1)
     */
    static void exercise2_2() {
        System.out.println("Exercise 2.2: Get first character");
        List<String> words = Arrays.asList("Java", "Python", "Scala");
        
        // TODO: Use map() to get first character of each word
        List<Character> firstChars = words.stream().map(a -> a.charAt(0)).collect(Collectors.toList());
        
        System.out.println("Input:    " + words);
        System.out.println("Output:   " + firstChars);
        System.out.println("Expected: [J, P, S]\n");
    }
    
    /**
     * Exercise 2.3: Calculate age from birth year
     * Current year: 2025
     * Expected Output: [25, 30, 22, 28]
     */
    static void exercise2_3() {
        System.out.println("Exercise 2.3: Calculate age from birth year");
        List<Integer> birthYears = Arrays.asList(2000, 1995, 2003, 1997);
        int currentYear = 2025;
        
        // TODO: Use map() to calculate age (currentYear - birthYear)
        List<Integer> ages = birthYears.stream().map(a -> currentYear-a).collect(Collectors.toList());
        
        System.out.println("Birth Years: " + birthYears);
        System.out.println("Ages:        " + ages);
        System.out.println("Expected:    [25, 30, 22, 28]\n");
    }
    
    // ========================================
    // LEVEL 3: ADVANCED 🟠
    // Working with objects and chaining
    // ========================================
    
    static void runLevel3() {
        System.out.println("=== LEVEL 3: ADVANCED 🟠 ===\n");
        exercise3_1();
        exercise3_2();
        exercise3_3();
        System.out.println("\n✅ Level 3 Complete!\n");
    }
    
    /**
     * Exercise 3.1: Extract product names
     * Expected Output: [Laptop, Mouse, Keyboard]
     */
    static void exercise3_1() {
        System.out.println("Exercise 3.1: Extract product names");
        
        List<Product> products = Arrays.asList(
            new Product("Laptop", 50000),
            new Product("Mouse", 500),
            new Product("Keyboard", 1500)
        );
        
        // TODO: Use map() to extract product names
        List<String> names = products.stream().map(a -> a.name).collect(Collectors.toList());

         
        
        System.out.println("Products: " + products);
        System.out.println("Names:    " + names);
        System.out.println("Expected: [Laptop, Mouse, Keyboard]\n");
    }
    
    /**
     * Exercise 3.2: Apply 10% discount to prices
     * Expected Output: [45000.0, 450.0, 1350.0]
     */
    static void exercise3_2() {
        System.out.println("Exercise 3.2: Apply 10% discount");
        
        List<Product> products = Arrays.asList(
            new Product("Laptop", 50000),
            new Product("Mouse", 500),
            new Product("Keyboard", 1500)
        );
        
        // TODO: Use map() to apply 10% discount (price * 0.9)
        List<Double> discountedPrices = products.stream().map(pdt -> pdt.price - pdt.price*10/100).collect(Collectors.toList());
        
        System.out.println("Original Prices: " + products.stream().map(p -> p.price).collect(Collectors.toList()));
        System.out.println("After Discount:  " + discountedPrices);
        System.out.println("Expected:        [45000.0, 450.0, 1350.0]\n");
    }
    
    /**
     * Exercise 3.3: Chain map() and filter()
     * Get uppercase names longer than 3 characters
     * Expected Output: [ALICE, KUMAR]
     */
    static void exercise3_3() {
        System.out.println("Exercise 3.3: Chain map() with filter()");
        List<String> names = Arrays.asList("raj", "alice", "bob", "kumar");
        
        // TODO: 
        // 1. Filter names longer than 3 characters
        // 2. Convert to uppercase using map()
        List<String> result = names.stream()
                            .filter(str -> str.length()>3)
                            .map(str -> str.toUpperCase()).collect(Collectors.toList());
        
        System.out.println("Input:    " + names);
        System.out.println("Output:   " + result);
        System.out.println("Expected: [ALICE, KUMAR]\n");
    }
    
    // ========================================
    // LEVEL 4: EXPERT 🔴
    // Complex transformations and nested operations
    // ========================================
    
    static void runLevel4() {
        System.out.println("=== LEVEL 4: EXPERT 🔴 ===\n");
        exercise4_1();
        exercise4_2();
        exercise4_3();
        System.out.println("\n✅ Level 4 Complete!\n");
    }
    
    /**
     * Exercise 4.1: Transform Employee to EmployeeSummary
     * Expected Output: [Raj (30), Aman (25), Priya (28)]
     */
    static void exercise4_1() {
        System.out.println("Exercise 4.1: Object transformation");
        
        List<Employee> employees = Arrays.asList(
            new Employee("Raj", 30, 50000),
            new Employee("Aman", 25, 40000),
            new Employee("Priya", 28, 45000)
        );
        
        // TODO: Use map() to create "Name (Age)" format
        List<String> summaries = employees.stream().map(emp -> emp.name + " (" + emp.age + ")"  ).collect(Collectors.toList());
        
        System.out.println("Employees: " + employees);
        System.out.println("Summaries: " + summaries);
        System.out.println("Expected:  [Raj (30), Aman (25), Priya (28)]\n");
    }
    
    /**
     * Exercise 4.2: Calculate salary after tax
     * Tax: 20% for salary > 45000, else 10%
     * Expected Output: [40000.0, 36000.0, 36000.0]
     */
    static void exercise4_2() {
        System.out.println("Exercise 4.2: Conditional transformation");
        
        List<Employee> employees = Arrays.asList(
            new Employee("Raj", 30, 50000),
            new Employee("Aman", 25, 40000),
            new Employee("Priya", 28, 45000)
        );
        
        // TODO: Use map() with conditional logic
        // If salary > 45000: salary * 0.8
        // Else: salary * 0.9
        List<Double> afterTax = employees.stream().map(emp -> emp.salary >= 45000? emp.salary * 0.8 : emp.salary* 0.9 ).collect(Collectors.toList());
        
        System.out.println("Original: " + employees.stream().map(e -> e.salary).collect(Collectors.toList()));
        System.out.println("After Tax: " + afterTax);
        System.out.println("Expected:  [40000.0, 36000.0, 36000.0]\n");
    }
    
    /**
     * Exercise 4.3: Split and flatten words
     * Split sentences into words and convert to uppercase
     * Expected Output: [JAVA, IS, AWESOME, STREAMS, ARE, POWERFUL]
     */
    static void exercise4_3() {
        System.out.println("Exercise 4.3: flatMap() challenge");
        List<String> sentences = Arrays.asList("Java is awesome", "Streams are powerful");
        
        // TODO: Use flatMap() to split into words, then map() to uppercase
        // Hint: sentence.split(" ") returns String[]
        // Hint: Arrays.stream() converts array to stream
        List<String> words = sentences.stream()
                             .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                             .map(String :: toUpperCase)
                             .collect(Collectors.toList());
        
        System.out.println("Input:    " + sentences);
        System.out.println("Output:   " + words);
        System.out.println("Expected: [JAVA, IS, AWESOME, STREAMS, ARE, POWERFUL]\n");
    }
    
    // ========================================
    // LEVEL 5: MASTER 🏆
    // Real-world scenarios
    // ========================================
    
    static void runLevel5() {
        System.out.println("=== LEVEL 5: MASTER 🏆 ===\n");
        exercise5_1();
        exercise5_2();
        exercise5_3();
        System.out.println("\n✅ Level 5 Complete! You're a Stream Master! 🏆\n");
    }
    
    /**
     * Exercise 5.1: Create a complete transformation pipeline
     * 
     * Transform Employee list to meet these requirements:
     * 1. Filter employees with salary > 40000
     * 2. Give them 15% bonus
     * 3. Create formatted string: "NAME: Rs. SALARY"
     * 4. Sort by salary (highest first)
     * 
     * Expected Output: [RAJ: Rs. 57500.0, PRIYA: Rs. 51750.0]
     */
    static void exercise5_1() {
        System.out.println("Exercise 5.1: Complete transformation pipeline");
        
        List<Employee> employees = Arrays.asList(
            new Employee("Raj", 30, 50000),
            new Employee("Aman", 25, 40000),
            new Employee("Priya", 28, 45000),
            new Employee("Kumar", 22, 35000)
        );
        
        // TODO: Build complete pipeline
        List<String> result = employees.stream()
                              .filter(emp -> emp.salary > 40000)
                              .map(emp -> {

                                double increaseSal = emp.salary + (emp.salary*15/100) ;

                                return new Employee(emp.name, emp.age, increaseSal);
                            })
                              .sorted(Comparator.comparing((Employee emp) -> emp.salary  ).reversed())
                              .map(e -> e.name.toUpperCase()+ ": Rs. " + e.salary).collect(Collectors.toList());
                              
                            
        
        System.out.println("Employees: " + employees);
        System.out.println("Result:    " + result);
        System.out.println("Expected:  [RAJ: Rs. 57500.0, PRIYA: Rs. 51750.0]\n");
    }
    
    /**
     * Exercise 5.2: Group and transform
     * 
     * Create a Map<String, List<Integer>> where:
     * - Key: Department
     * - Value: List of salaries in that department
     * 
     * Expected Output: {IT=[50000, 45000], HR=[40000], Sales=[35000]}
     */
    static void exercise5_2() {
        System.out.println("Exercise 5.2: Grouping with transformation");
        
        List<EmployeeWithDept> employees = Arrays.asList(
            new EmployeeWithDept("Raj", "IT", 50000),
            new EmployeeWithDept("Aman", "HR", 40000),
            new EmployeeWithDept("Priya", "IT", 45000),
            new EmployeeWithDept("Kumar", "Sales", 35000)
        );
        
        // TODO: Use Collectors.groupingBy() and mapping()
        Map<String, List<Integer>> deptSalaries = null;
        
        System.out.println("Employees: " + employees);
        System.out.println("Result:    " + deptSalaries);
        System.out.println("Expected:  {IT=[50000, 45000], HR=[40000], Sales=[35000]}\n");
    }
    
    /**
     * Exercise 5.3: Custom mapper method
     * 
     * Create your own generic mapper method that:
     * 1. Takes a List<T> and a transformation function
     * 2. Returns List<R> after applying transformation
     * 3. Use it to solve: Square numbers and filter > 10
     * 
     * Expected Output: [16, 25, 36]
     */
    static void exercise5_3() {
        System.out.println("Exercise 5.3: Create custom mapper");
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6);
        
        // TODO: Implement customMap() method below
        List<Integer> result = customMap(
            numbers,
            n -> n * n,
            n -> n > 10
        );
        
        System.out.println("Input:    " + numbers);
        System.out.println("Output:   " + result);
        System.out.println("Expected: [16, 25, 36]\n");
    }
    
    /**
     * TODO: Implement this generic mapper method
     * 
     * @param list - Input list
     * @param mapper - Transformation function
     * @param filter - Filter condition
     * @return Transformed and filtered list
     */
    static <T, R> List<R> customMap(List<T> list, 
                                     java.util.function.Function<T, R> mapper,
                                     java.util.function.Predicate<R> filter) {
        // TODO: Implement using streams
        return null;
    }
    
    // ========================================
    // HELPER CLASSES
    // ========================================
    
    static class Product {
        String name;
        double price;
        
        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
        
        @Override
        public String toString() {
            return name + "(" + price + ")";
        }
    }
    
    static class Employee {
        String name;
        int age;
        double salary;
        
        Employee(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }
        
        @Override
        public String toString() {
            return name + "(" + age + ", Rs." + salary + ")";
        }
    }
    
    static class EmployeeWithDept {
        String name;
        String department;
        double salary;
        
        EmployeeWithDept(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
        
        @Override
        public String toString() {
            return name + "(" + department + ", Rs." + salary + ")";
        }
    }
}

// ========================================
// 📝 SOLUTIONS (Don't peek until you try!)
// ========================================
/*

LEVEL 1 SOLUTIONS:
==================

Exercise 1.1:
List<Integer> doubled = numbers.stream()
    .map(n -> n * 2)
    .collect(Collectors.toList());

Exercise 1.2:
List<String> greetings = names.stream()
    .map(name -> "Hello, " + name)
    .collect(Collectors.toList());

Exercise 1.3:
List<Integer> absolute = numbers.stream()
    .map(Math::abs)
    .collect(Collectors.toList());


LEVEL 2 SOLUTIONS:
==================

Exercise 2.1:
List<String> strings = numbers.stream()
    .map(String::valueOf)
    .collect(Collectors.toList());

Exercise 2.2:
List<Character> firstChars = words.stream()
    .map(word -> word.charAt(0))
    .collect(Collectors.toList());

Exercise 2.3:
List<Integer> ages = birthYears.stream()
    .map(year -> currentYear - year)
    .collect(Collectors.toList());


LEVEL 3 SOLUTIONS:
==================

Exercise 3.1:
List<String> names = products.stream()
    .map(p -> p.name)
    .collect(Collectors.toList());

Exercise 3.2:
List<Double> discountedPrices = products.stream()
    .map(p -> p.price * 0.9)
    .collect(Collectors.toList());

Exercise 3.3:
List<String> result = names.stream()
    .filter(name -> name.length() > 3)
    .map(String::toUpperCase)
    .collect(Collectors.toList());


LEVEL 4 SOLUTIONS:
==================

Exercise 4.1:
List<String> summaries = employees.stream()
    .map(e -> e.name + " (" + e.age + ")")
    .collect(Collectors.toList());

Exercise 4.2:
List<Double> afterTax = employees.stream()
    .map(e -> e.salary > 45000 ? e.salary * 0.8 : e.salary * 0.9)
    .collect(Collectors.toList());

Exercise 4.3:
List<String> words = sentences.stream()
    .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
    .map(String::toUpperCase)
    .collect(Collectors.toList());


LEVEL 5 SOLUTIONS:
==================

Exercise 5.1:
List<String> result = employees.stream()
    .filter(e -> e.salary > 40000)
    .map(e -> new Employee(e.name, e.age, e.salary * 1.15))
    .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
    .map(e -> e.name.toUpperCase() + ": Rs. " + e.salary)
    .collect(Collectors.toList());

Exercise 5.2:
Map<String, List<Integer>> deptSalaries = employees.stream()
    .collect(Collectors.groupingBy(
        e -> e.department,
        Collectors.mapping(e -> (int)e.salary, Collectors.toList())
    ));

Exercise 5.3:
static <T, R> List<R> customMap(List<T> list, 
                                 Function<T, R> mapper,
                                 Predicate<R> filter) {
    return list.stream()
        .map(mapper)
        .filter(filter)
        .collect(Collectors.toList());
}

*/
