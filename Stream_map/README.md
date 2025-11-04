# ✅ Java Stream map() — Complete Guide (Beginner → Advanced)

## 📚 Table of Contents
1. [What is map()?](#what-is-map)
2. [Traditional Java vs Stream API](#traditional-vs-stream)
3. [Simple Examples](#simple-examples)
4. [Why Use map()?](#why-use-map)
5. [Common Use Cases](#use-cases)
6. [Primitive Variants](#primitive-variants)
7. [Practical Questions](#practical-questions)
8. [Interview Q&A](#interview-qa)
9. [Best Practices](#best-practices)

---

## 🎯 What is map()?

**In Simple Words:**
- `map()` is like a **transformer machine**
- You put items in → They get transformed → You get new items out
- **Original items don't change** (immutable)

**Think of it as:**
```
Input → Function → Output

[1, 2, 3] → (multiply by 2) → [2, 4, 6]
["raj", "amit"] → (uppercase) → ["RAJ", "AMIT"]
```

### Method Signature
```java
<R> Stream<R> map(Function<? super T, ? extends R> mapper)
```

**What does this mean?**
- **T** = Input type (what you have)
- **R** = Output type (what you want)
- **Function<T,R>** = The transformation rule

---

## 🔄 Traditional Java vs Stream API

### Example: Square Numbers

#### ❌ **Traditional Way (Before Java 8)**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> squares = new ArrayList<>();

// Manual loop
for (Integer num : numbers) {
    squares.add(num * num);  // Transform and add
}

System.out.println(squares);  // [1, 4, 9, 16, 25]
```

**Problems:**
- More code (boilerplate)
- Need to create new list manually
- Imperative style (tell **HOW** to do it)
- Mutable state (we modify `squares` list)

#### ✅ **Stream API Way (Java 8+)**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

List<Integer> squares = numbers.stream()
                              .map(n -> n * n)
                              .collect(Collectors.toList());

System.out.println(squares);  // [1, 4, 9, 16, 25]
```

**Benefits:**
- Less code
- Declarative (tell **WHAT** to do)
- No mutation (functional programming)
- Chainable operations
- Easier to read

---

## 📖 Simple Examples

### 1. String → Uppercase

#### ❌ Traditional Way
```java
List<String> names = Arrays.asList("raj", "aman", "priya");
List<String> upperNames = new ArrayList<>();

for (String name : names) {
    upperNames.add(name.toUpperCase());
}
```

#### ✅ Stream API Way
```java
List<String> upperNames = names.stream()
                               .map(String::toUpperCase)
                               .collect(Collectors.toList());
```

**Output:** `["RAJ", "AMAN", "PRIYA"]`

---

### 2. Get String Lengths

#### ❌ Traditional Way
```java
List<String> words = Arrays.asList("Java", "Stream", "API");
List<Integer> lengths = new ArrayList<>();

for (String word : words) {
    lengths.add(word.length());  // String → Integer
}
```

#### ✅ Stream API Way
```java
List<Integer> lengths = words.stream()
                            .map(String::length)
                            .collect(Collectors.toList());
```

**Output:** `[4, 6, 3]`

**Note:** Type changed from `String` to `Integer` — map() can do this!

---

### 3. Rupees → USD Conversion

#### ❌ Traditional Way
```java
List<Double> rupees = Arrays.asList(840.0, 1680.0, 4200.0);
List<Double> usd = new ArrayList<>();

final double RATE = 84.0;

for (Double r : rupees) {
    usd.add(r / RATE);
}
```

#### ✅ Stream API Way
```java
final double RATE = 84.0;

List<Double> usd = rupees.stream()
                         .map(r -> r / RATE)
                         .collect(Collectors.toList());
```

**Output:** `[10.0, 20.0, 50.0]`

---

## 🎯 Why Use map()?

| Reason | Explanation |
|--------|-------------|
| **Clean code** | Less boilerplate, more readable |
| **No mutation** | Original data stays unchanged |
| **Composable** | Can chain with other operations |
| **Functional style** | Modern Java programming |
| **Removes loops** | No more manual `for` loops |

---

## 💡 Common Use Cases

### 1️⃣ Extract Object Fields

**Scenario:** Get all employee names from employee list

#### ❌ Traditional
```java
List<Employee> employees = getEmployees();
List<String> names = new ArrayList<>();

for (Employee emp : employees) {
    names.add(emp.getName());
}
```

#### ✅ Stream API
```java
List<String> names = employees.stream()
                             .map(Employee::getName)
                             .collect(Collectors.toList());
```

---

### 2️⃣ Transform Object → Another Object

**Scenario:** Convert `Employee` → `EmployeeDTO`

#### ❌ Traditional
```java
List<EmployeeDTO> dtos = new ArrayList<>();

for (Employee emp : employees) {
    EmployeeDTO dto = new EmployeeDTO(emp.getId(), emp.getName());
    dtos.add(dto);
}
```

#### ✅ Stream API
```java
List<EmployeeDTO> dtos = employees.stream()
                                 .map(emp -> new EmployeeDTO(emp.getId(), emp.getName()))
                                 .collect(Collectors.toList());
```

---

### 3️⃣ Combine map() with filter()

**Scenario:** Get names of employees with salary > 50000

#### ❌ Traditional
```java
List<String> highEarners = new ArrayList<>();

for (Employee emp : employees) {
    if (emp.getSalary() > 50000) {
        highEarners.add(emp.getName());
    }
}
```

#### ✅ Stream API
```java
List<String> highEarners = employees.stream()
                                   .filter(e -> e.getSalary() > 50000)
                                   .map(Employee::getName)
                                   .collect(Collectors.toList());
```

**Pipeline:** `filter()` (select) → `map()` (transform)

---

## ⚡ Primitive Variants (Performance Boost)

### Why Primitive Variants?

**Problem with regular map():**
```java
numbers.stream()
       .map(n -> n * 2)  // Creates Integer objects (boxing)
       .reduce(0, Integer::sum);
```

**Boxing/Unboxing overhead:**
- `int` → `Integer` (boxing)
- `Integer` → `int` (unboxing)
- **Slower** due to object creation

### Solutions: mapToInt(), mapToDouble(), mapToLong()

#### 1️⃣ mapToInt()

```java
// ❌ Regular map - Stream<Integer>
int sum = numbers.stream()
                .map(n -> n * 2)
                .reduce(0, Integer::sum);

// ✅ mapToInt - IntStream (no boxing!)
int sum = numbers.stream()
                .mapToInt(n -> n * 2)
                .sum();
```

**Special methods in IntStream:**
- `sum()`
- `average()`
- `max()`
- `min()`
- `summaryStatistics()`

---

#### 2️⃣ mapToDouble()

```java
List<Product> products = getProducts();

// Total price
double total = products.stream()
                      .mapToDouble(Product::getPrice)
                      .sum();

// Average price
double avg = products.stream()
                    .mapToDouble(Product::getPrice)
                    .average()
                    .orElse(0.0);
```

---

#### 3️⃣ mapToLong()

```java
List<City> cities = getCities();

long totalPopulation = cities.stream()
                            .mapToLong(City::getPopulation)
                            .sum();
```

### Performance Comparison

**Regular map():**
```
1,000,000 numbers → ~45ms
```

**mapToInt():**
```
1,000,000 numbers → ~30ms
```

**⚡ Result:** mapToInt() is **~33% faster!**

---

## 🧩 Practical Questions

### Q1: Convert Rupees to USD
```java
List<Double> rupees = Arrays.asList(840.0, 1680.0, 4200.0);

List<Double> usd = rupees.stream()
                         .map(r -> r / 84.0)
                         .collect(Collectors.toList());
```

---

### Q2: Get String Lengths
```java
List<String> words = Arrays.asList("Java", "Stream", "API");

List<Integer> lengths = words.stream()
                            .map(String::length)
                            .collect(Collectors.toList());
```

---

### Q3: Extract Emails from Users
```java
List<User> users = getUsers();

List<String> emails = users.stream()
                          .map(User::getEmail)
                          .collect(Collectors.toList());
```

---

### Q4: Employee → EmployeeDTO
```java
List<EmployeeDTO> dtos = employees.stream()
                                 .map(e -> new EmployeeDTO(e.getId(), e.getName()))
                                 .collect(Collectors.toList());
```

---

### Q5: Unique Uppercase Departments
```java
Set<String> departments = employees.stream()
                                  .map(Employee::getDepartment)
                                  .map(String::toUpperCase)
                                  .collect(Collectors.toSet());
```

---

### Q6: CSV String → List of Integers
**Input:** `["1,2,3", "4,5"]`  
**Output:** `[1, 2, 3, 4, 5]`

```java
List<Integer> numbers = csvList.stream()
                              .flatMap(csv -> Arrays.stream(csv.split(",")))
                              .map(s -> Integer.parseInt(s.trim()))
                              .collect(Collectors.toList());
```

**⚠️ Note:** Uses `flatMap()` (not just `map()`) because one string becomes multiple integers.

---

## 🎤 Interview Q&A

### Q1: Does map() change the original collection?
**Answer:** ❌ No. Streams are **immutable**. Original data stays unchanged.

---

### Q2: Is map() eager or lazy?
**Answer:** 🦥 **Lazy**. It doesn't execute until a terminal operation is called.

```java
stream.map(...)      // Not executed yet
      .map(...)      // Not executed yet
      .filter(...)   // Not executed yet
      .collect(...); // NOW everything executes!
```

---

### Q3: Difference between map() and flatMap()?

| Feature | map() | flatMap() |
|---------|-------|-----------|
| Transformation | One → One | One → Many |
| Returns | `Stream<R>` | `Stream<R>` (flattened) |
| Use case | Simple transform | Nested collections |

**Example:**
```java
// map()
[1, 2, 3] → map(n -> n * 2) → [2, 4, 6]

// flatMap()
[["a", "b"], ["c"]] → flatMap(list → stream) → ["a", "b", "c"]
```

---

### Q4: Can map() return null?
**Answer:** ✅ Yes, but **not recommended**.

```java
// ❌ Bad
.map(emp -> emp.getName())  // Could be null

// ✅ Better
.map(emp -> Optional.ofNullable(emp.getName()))
```

---

### Q5: When to use primitive map variants?
**Answer:** When working with **numeric data** to avoid boxing/unboxing overhead.

Use:
- `mapToInt()` for `int`
- `mapToDouble()` for `double`
- `mapToLong()` for `long`

---

## ✅ Best Practices

### 1️⃣ Keep Functions Pure
```java
// ❌ Bad - Side effect
.map(emp -> {
    count++;  // Modifying external state!
    return emp.getName();
})

// ✅ Good - Pure function
.map(Employee::getName)
```

---

### 2️⃣ Use Method References
```java
// ❌ OK but verbose
.map(s -> s.toUpperCase())

// ✅ Better - Method reference
.map(String::toUpperCase)
```

---

### 3️⃣ Avoid Heavy Computation
```java
// ❌ Bad - Slow operation in map
.map(data -> callSlowAPI(data))  // Don't do this!

// ✅ Better - Use parallel stream if needed
.parallelStream()
.map(data -> callSlowAPI(data))
```

---

### 4️⃣ Use Primitive Variants for Numbers
```java
// ❌ Slower
.map(n -> n * 2)
.reduce(0, Integer::sum)

// ✅ Faster
.mapToInt(n -> n * 2)
.sum()
```

---

## 📊 Summary Table

| Property | map() |
|----------|-------|
| **Type** | Intermediate operation |
| **Input** | `Stream<T>` |
| **Output** | `Stream<R>` |
| **Purpose** | Transform elements |
| **Lazy?** | ✅ Yes |
| **Mutates data?** | ❌ No |
| **Pure function?** | ✅ Recommended |

---

## 🚀 Next Steps

Now that you know `map()`, learn:
1. **flatMap()** — Flatten nested structures
2. **filter()** — Select elements
3. **collect()** — Terminal operations
4. **Parallel Streams** — Performance boost

---

## 📂 Files in This Module

```
Stream_map/
├── README.md                          ← You are here
├── BasicTransformations.java          ← Squaring, uppercase, length
├── TypeConversionExample.java         ← String ↔ Integer, Rupees → USD
├── ObjectTransformationExample.java   ← Employee fields, DTO conversion
├── MapWithFilterExample.java          ← Combining map() + filter()
├── PrimitiveMapExample.java           ← mapToInt/Double/Long
└── PracticalCodingQuestions.java      ← All 6 practice problems
```

---

## 🎯 Key Takeaways

✅ **map()** transforms elements  
✅ Use **pure functions** (no side effects)  
✅ **Lazy evaluation** — executes only on terminal operation  
✅ **Immutable** — original data unchanged  
✅ Use **primitive variants** for performance  
✅ **Chainable** with other stream operations  

---

## 🏃 How to Run

```bash
# Compile all files
javac *.java

# Run individual examples
java BasicTransformations
java TypeConversionExample
java ObjectTransformationExample
java MapWithFilterExample
java PrimitiveMapExample
java PracticalCodingQuestions
```

---

**Happy Coding! 🚀**
