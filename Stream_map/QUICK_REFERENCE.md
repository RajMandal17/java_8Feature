# 🚀 Stream map() — Quick Reference Cheat Sheet

## 📋 Basic Syntax

```java
// General form
stream.map(element -> transformation)
      .collect(Collectors.toList());

// Method reference form
stream.map(ClassName::methodName)
      .collect(Collectors.toList());
```

---

## 🎯 Common Patterns

### 1. Transform Numbers
```java
// Square numbers
numbers.stream().map(n -> n * n).collect(Collectors.toList());

// Double numbers
numbers.stream().map(n -> n * 2).collect(Collectors.toList());

// Convert to string
numbers.stream().map(String::valueOf).collect(Collectors.toList());
```

### 2. String Operations
```java
// Uppercase
strings.stream().map(String::toUpperCase).collect(Collectors.toList());

// Lowercase
strings.stream().map(String::toLowerCase).collect(Collectors.toList());

// Get length
strings.stream().map(String::length).collect(Collectors.toList());

// Trim
strings.stream().map(String::trim).collect(Collectors.toList());
```

### 3. Type Conversion
```java
// String → Integer
strings.stream().map(Integer::parseInt).collect(Collectors.toList());

// Integer → String
numbers.stream().map(String::valueOf).collect(Collectors.toList());

// Double → Integer
doubles.stream().map(Double::intValue).collect(Collectors.toList());
```

### 4. Extract Object Fields
```java
// Get names
employees.stream().map(Employee::getName).collect(Collectors.toList());

// Get emails
users.stream().map(User::getEmail).collect(Collectors.toList());

// Get prices
products.stream().map(Product::getPrice).collect(Collectors.toList());
```

### 5. Object Transformation
```java
// Employee → EmployeeDTO
employees.stream()
         .map(e -> new EmployeeDTO(e.getId(), e.getName()))
         .collect(Collectors.toList());

// Apply business logic
prices.stream()
      .map(p -> p * 1.18)  // Add 18% tax
      .collect(Collectors.toList());
```

---

## 🔗 Combining Operations

### map() + filter()
```java
// Filter then transform
employees.stream()
         .filter(e -> e.getSalary() > 50000)
         .map(Employee::getName)
         .collect(Collectors.toList());
```

### Multiple map() operations
```java
// Chain transformations
words.stream()
     .map(String::trim)
     .map(String::toUpperCase)
     .map(s -> s + "!")
     .collect(Collectors.toList());
```

### map() + distinct()
```java
// Transform and get unique values
employees.stream()
         .map(Employee::getDepartment)
         .distinct()
         .collect(Collectors.toList());
```

### map() + sorted()
```java
// Transform and sort
strings.stream()
       .map(String::length)
       .sorted()
       .collect(Collectors.toList());
```

---

## ⚡ Primitive Variants

### mapToInt()
```java
// Sum
int sum = numbers.stream().mapToInt(n -> n).sum();

// Average
double avg = numbers.stream().mapToInt(n -> n).average().orElse(0.0);

// Max/Min
int max = numbers.stream().mapToInt(n -> n).max().orElse(0);
```

### mapToDouble()
```java
// Total price
double total = products.stream().mapToDouble(Product::getPrice).sum();

// Average price
double avg = products.stream().mapToDouble(Product::getPrice).average().orElse(0.0);
```

### mapToLong()
```java
// Total population
long total = cities.stream().mapToLong(City::getPopulation).sum();
```

---

## 🎨 Lambda vs Method Reference

```java
// Lambda expression
.map(s -> s.toUpperCase())
.map(n -> n * 2)
.map(e -> e.getName())

// Method reference (cleaner!)
.map(String::toUpperCase)
.map(n -> n * 2)              // No method reference for this
.map(Employee::getName)
```

---

## ⚠️ Common Mistakes

### ❌ Don't Modify External State
```java
int count = 0;
list.stream()
    .map(x -> {
        count++;  // BAD! Side effect
        return x * 2;
    });
```

### ❌ Don't Use map() for Side Effects
```java
// BAD - Use forEach instead
list.stream()
    .map(x -> {
        System.out.println(x);  // Don't do this
        return x;
    });

// GOOD
list.stream().forEach(System.out::println);
```

### ❌ Don't Use map() When You Need flatMap()
```java
// BAD - Returns List<String[]>
list.stream()
    .map(s -> s.split(" "))
    .collect(Collectors.toList());

// GOOD - Returns List<String>
list.stream()
    .flatMap(s -> Arrays.stream(s.split(" ")))
    .collect(Collectors.toList());
```

---

## 📊 Performance Tips

### ✅ Use Primitive Streams for Numbers
```java
// Slower (boxing overhead)
numbers.stream().map(n -> n * 2).reduce(0, Integer::sum);

// Faster (no boxing)
numbers.stream().mapToInt(n -> n * 2).sum();
```

### ✅ Use Parallel Streams for Large Data
```java
// Sequential
largeList.stream().map(heavy::computation);

// Parallel (for CPU-intensive tasks)
largeList.parallelStream().map(heavy::computation);
```

---

## 🎯 Quick Decision Guide

**When to use map():**
- ✅ Transform each element
- ✅ One-to-one mapping
- ✅ Extract fields from objects
- ✅ Type conversion

**When NOT to use map():**
- ❌ Filtering (use `filter()`)
- ❌ One-to-many transformation (use `flatMap()`)
- ❌ Side effects (use `forEach()`)
- ❌ Combining elements (use `reduce()`)

---

## 🔍 Real-World Examples

```java
// 1. Currency conversion
rupees.stream().map(r -> r / 84.0).collect(Collectors.toList());

// 2. Format dates
dates.stream().map(d -> formatter.format(d)).collect(Collectors.toList());

// 3. Calculate discounts
prices.stream().map(p -> p * 0.9).collect(Collectors.toList());

// 4. Extract JSON fields
jsonList.stream().map(json -> json.get("name")).collect(Collectors.toList());

// 5. Build URLs
ids.stream().map(id -> "https://api.com/" + id).collect(Collectors.toList());
```

---

## 📚 Terminal Operations (to collect results)

```java
.collect(Collectors.toList())       // List
.collect(Collectors.toSet())        // Set (unique)
.collect(Collectors.joining(", "))  // String (for String streams)
.forEach(System.out::println)       // Print each
.toArray()                          // Array
.count()                            // Count elements
.findFirst()                        // First element (Optional)
```

---

## 🎓 Interview Quick Answers

**Q: Is map() lazy or eager?**  
A: Lazy — executes only when terminal operation is called

**Q: Does map() modify original data?**  
A: No — streams are immutable

**Q: map() vs flatMap()?**  
A: map() = 1→1, flatMap() = 1→many

**Q: When to use mapToInt()?**  
A: When working with numeric data to avoid boxing

---

**💡 Pro Tip:** Always prefer method references over lambdas when possible for cleaner code!

```java
// Good
.map(String::toUpperCase)

// OK, but verbose
.map(s -> s.toUpperCase())
```
