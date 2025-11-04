import java.util.*;
import java.util.stream.*;

/**
 * Employee class representing company employee
 */
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private String email;
    
    public Employee(int id, String name, String department, double salary, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }
    
    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public String getEmail() { return email; }
    
    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', dept='%s', salary=%.2f}", 
                           id, name, department, salary);
    }
}

/**
 * EmployeeDTO (Data Transfer Object) - Simplified version
 */
class EmployeeDTO {
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

/**
 * ✅ OBJECT TRANSFORMATIONS - Traditional vs Stream API
 * 
 * Demonstrates:
 * 1. Extract single field from objects
 * 2. Extract multiple fields
 * 3. Transform Object → Another Object
 */
public class ObjectTransformationExample {
    
    public static void main(String[] args) {
        
        // Sample data
        List<Employee> employees = getEmployees();
        
        System.out.println("=== Original Employee List ===");
        employees.forEach(System.out::println);
        
        System.out.println("\n=== Example 1: Extract Names Only ===\n");
        extractNamesTraditional(employees);
        extractNamesWithStream(employees);
        
        System.out.println("\n=== Example 2: Extract Emails Only ===\n");
        extractEmailsTraditional(employees);
        extractEmailsWithStream(employees);
        
        System.out.println("\n=== Example 3: Employee → EmployeeDTO ===\n");
        transformToDTOTraditional(employees);
        transformToDTOWithStream(employees);
        
        System.out.println("\n=== Example 4: Salary Calculation ===\n");
        calculateBonusTraditional(employees);
        calculateBonusWithStream(employees);
    }
    
    // ========================================
    // Example 1: Extract Names
    // ========================================
    
    /**
     * ❌ TRADITIONAL WAY - Extract field from object
     */
    static void extractNamesTraditional(List<Employee> employees) {
        System.out.println("Traditional Approach:");
        
        List<String> names = new ArrayList<>();
        
        for (Employee emp : employees) {
            names.add(emp.getName());  // Extract name field
        }
        
        System.out.println("Names: " + names);
    }
    
    /**
     * ✅ STREAM API WAY
     * map() extracts field from each object
     * Employee::getName is method reference
     */
    static void extractNamesWithStream(List<Employee> employees) {
        System.out.println("\nStream API Approach:");
        
        List<String> names = employees.stream()
                                     .map(Employee::getName)  // Extract name
                                     .collect(Collectors.toList());
        
        System.out.println("Names: " + names);
    }
    
    // ========================================
    // Example 2: Extract Emails
    // ========================================
    
    /**
     * ❌ TRADITIONAL WAY
     */
    static void extractEmailsTraditional(List<Employee> employees) {
        System.out.println("Traditional Approach:");
        
        List<String> emails = new ArrayList<>();
        
        for (Employee emp : employees) {
            emails.add(emp.getEmail());
        }
        
        System.out.println("Emails: " + emails);
    }
    
    /**
     * ✅ STREAM API WAY
     */
    static void extractEmailsWithStream(List<Employee> employees) {
        System.out.println("\nStream API Approach:");
        
        List<String> emails = employees.stream()
                                      .map(Employee::getEmail)
                                      .collect(Collectors.toList());
        
        System.out.println("Emails: " + emails);
    }
    
    // ========================================
    // Example 3: Transform Employee → EmployeeDTO
    // ========================================
    
    /**
     * ❌ TRADITIONAL WAY
     * Converting one object type to another
     */
    static void transformToDTOTraditional(List<Employee> employees) {
        System.out.println("Traditional Approach:");
        
        List<EmployeeDTO> dtos = new ArrayList<>();
        
        for (Employee emp : employees) {
            EmployeeDTO dto = new EmployeeDTO(emp.getId(), emp.getName());
            dtos.add(dto);
        }
        
        System.out.println("DTOs: " + dtos);
    }
    
    /**
     * ✅ STREAM API WAY
     * Clean transformation from one type to another
     */
    static void transformToDTOWithStream(List<Employee> employees) {
        System.out.println("\nStream API Approach:");
        
        List<EmployeeDTO> dtos = employees.stream()
                                         .map(emp -> new EmployeeDTO(emp.getId(), emp.getName()))
                                         .collect(Collectors.toList());
        
        System.out.println("DTOs: " + dtos);
    }
    
    // ========================================
    // Example 4: Business Logic - Calculate Bonus
    // ========================================
    
    /**
     * ❌ TRADITIONAL WAY
     * Apply business logic: 10% bonus on salary
     */
    static void calculateBonusTraditional(List<Employee> employees) {
        System.out.println("Traditional Approach:");
        
        List<Double> bonuses = new ArrayList<>();
        
        for (Employee emp : employees) {
            double bonus = emp.getSalary() * 0.10;  // 10% bonus
            bonuses.add(bonus);
        }
        
        System.out.println("Bonuses (10%): " + bonuses);
    }
    
    /**
     * ✅ STREAM API WAY
     */
    static void calculateBonusWithStream(List<Employee> employees) {
        System.out.println("\nStream API Approach:");
        
        List<Double> bonuses = employees.stream()
                                       .map(emp -> emp.getSalary() * 0.10)
                                       .collect(Collectors.toList());
        
        System.out.println("Bonuses (10%): " + bonuses);
        
        // Formatted output
        System.out.println("\nFormatted:");
        employees.stream()
                .map(emp -> String.format("%s: ₹%.2f", 
                                         emp.getName(), 
                                         emp.getSalary() * 0.10))
                .forEach(System.out::println);
    }
    
    // ========================================
    // Sample Data
    // ========================================
    
    static List<Employee> getEmployees() {
        return Arrays.asList(
            new Employee(1, "Raj Kumar", "IT", 75000, "raj@company.com"),
            new Employee(2, "Priya Sharma", "HR", 60000, "priya@company.com"),
            new Employee(3, "Aman Singh", "IT", 80000, "aman@company.com"),
            new Employee(4, "Neha Verma", "Finance", 70000, "neha@company.com"),
            new Employee(5, "Arjun Patel", "IT", 90000, "arjun@company.com")
        );
    }
}
