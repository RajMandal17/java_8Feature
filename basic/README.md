# Java 8 Functional Interfaces Tutorial

A comprehensive tutorial series covering Java 8 functional interfaces, from beginner to advanced level. This workspace includes anonymous classes, lambda expressions, and all major functional interfaces with hands-on exercises.

## 📁 Workspace Structure

```
java_8Feature/
├── lembdaAndAnonymous/      # Anonymous classes and lambdas
│   └── src/
│       ├── Emp.java
│       └── Main.java
├── PredicatesDemo/          # Predicate interface demos
│   ├── Main.java
│   ├── Person.java
│   └── README.md
├── FunctionDemo/            # Function interface demos
│   └── Main.java
├── SupplierDemo/            # Supplier interface demos
│   └── Main.java
├── ConsumerDemo/            # Consumer interface demos
│   └── Main.java
├── FunctionalInterfacesExercises/  # Practice exercises
│   └── Exercises.java
├── build.sh                 # Main build script
├── Makefile                 # Alternative build system
└── README.md               # This file
```

## 🚀 How to Build and Run

### Prerequisites
- Java 8 or higher (Java 21 recommended)
- Unix-like environment (Linux, macOS, WSL)

### Build Methods

#### Method 1: Using the Build Script (Recommended)
```bash
# Make the script executable (first time only)
chmod +x build.sh

# Build and run all modules
./build.sh

# Build specific modules
./build.sh lambda      # Lambda and Anonymous Classes
./build.sh predicate   # Predicate Interface
./build.sh function    # Function Interface
./build.sh supplier    # Supplier Interface
./build.sh consumer    # Consumer Interface
./build.sh exercises   # Practice Exercises

# Clean compiled files
./build.sh clean

# Show help
./build.sh help
```

#### Method 2: Using Make
```bash
# Build and run all modules
make

# Build specific modules
make lambda
make predicate
make function
make supplier
make consumer
make exercises

# Clean compiled files
make clean

# Show help
make help
```

#### Method 3: Using VS Code Tasks
1. Open the workspace in VS Code
2. Press `Ctrl+Shift+P` (or `Cmd+Shift+P` on macOS)
3. Type "Tasks: Run Task"
4. Select "Build All Modules" or any specific module

#### Method 4: Manual Compilation
```bash
# Navigate to any module directory and compile
cd PredicatesDemo
javac *.java
java Main

# For the lambda module (has src subdirectory)
cd lembdaAndAnonymous/src
javac *.java
java Main
```

## 📚 Learning Path

### 1. **Lambda and Anonymous Classes** (`lembdaAndAnonymous/`)
- Start here to understand the fundamentals
- Learn the difference between anonymous classes and lambda expressions
- Understand variable scope and capture

### 2. **Predicate Interface** (`PredicatesDemo/`)
- Learn about boolean-valued functions
- Practice combining predicates with AND, OR, negate
- Apply predicates to filter data

### 3. **Function Interface** (`FunctionDemo/`)
- Understand transformation functions
- Learn method chaining with `andThen` and `compose`
- Practice with `apply` and `identity`

### 4. **Supplier Interface** (`SupplierDemo/`)
- Learn about lazy evaluation and supplier patterns
- Practice generating values on demand
- Understand factory patterns with suppliers

### 5. **Consumer Interface** (`ConsumerDemo/`)
- Learn about void operations with side effects
- Practice chaining consumers with `andThen`
- Understand logging and printing patterns

### 6. **Practice Exercises** (`FunctionalInterfacesExercises/`)
- Apply all concepts in progressive exercises
- Work through beginner to advanced problems
- Implement real-world scenarios

## 🛠️ Build Script Features

The `build.sh` script provides:
- **Automatic compilation** of all Java files
- **Colored output** for better readability
- **Error handling** with detailed messages
- **Modular building** - build individual modules
- **Clean builds** - remove all `.class` files
- **Cross-platform compatibility**

## 🔧 Troubleshooting

### Common Issues

**Permission Denied on build.sh:**
```bash
chmod +x build.sh
```

**Java Not Found:**
```bash
# Check if Java is installed
java -version
javac -version

# Install Java if needed (Ubuntu/Debian)
sudo apt update
sudo apt install openjdk-21-jdk
```

**Compilation Errors:**
- Ensure you're in the correct directory
- Check for typos in Java code
- Verify Java version compatibility

### Clean Build
If you encounter any issues, try a clean build:
```bash
./build.sh clean
./build.sh
```

## 📖 Additional Resources

- Each module contains detailed comments explaining the concepts
- `README.md` files in individual modules provide specific guidance
- Check the Java 8 documentation for detailed API reference

## 🎯 Quick Start

1. Clone or download this workspace
2. Run `./build.sh` to build everything
3. Start with the `lembdaAndAnonymous` module
4. Progress through each module in order
5. Complete the exercises to test your understanding

Happy learning! 🚀