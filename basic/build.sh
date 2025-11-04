#!/bin/bash

# Java 8 Functional Interfaces Tutorial - Build Script
# This script compiles and runs all the demo modules in the workspace

set -e  # Exit on any error

echo "=========================================="
echo "Java 8 Functional Interfaces - Build Script"
echo "=========================================="

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Function to print colored output
print_status() {
    echo -e "${BLUE}[INFO]${NC} $1"
}

print_success() {
    echo -e "${GREEN}[SUCCESS]${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

print_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

# Function to compile and run a module
build_module() {
    local module_name=$1
    local module_path=$2
    local main_class=$3
    local src_dir=${4:-""}
    
    print_status "Building module: $module_name"
    
    if [ ! -d "$module_path" ]; then
        print_warning "Module directory $module_path not found, skipping..."
        return
    fi
    
    cd "$module_path"
    
    # Determine source directory
    if [ -n "$src_dir" ] && [ -d "$src_dir" ]; then
        cd "$src_dir"
    fi
    
    # Check if Java files exist
    if ! ls *.java 1> /dev/null 2>&1; then
        print_warning "No Java files found in $(pwd), skipping..."
        cd - > /dev/null
        return
    fi
    
    # Compile Java files
    print_status "Compiling Java files in $(pwd)..."
    if javac *.java; then
        print_success "Compilation successful for $module_name"
        
        # Run the main class if specified
        if [ -n "$main_class" ]; then
            print_status "Running $main_class..."
            echo "----------------------------------------"
            if java "$main_class"; then
                print_success "$module_name executed successfully"
            else
                print_error "Execution failed for $module_name"
            fi
            echo "----------------------------------------"
        fi
    else
        print_error "Compilation failed for $module_name"
    fi
    
    cd - > /dev/null
    echo
}

# Function to clean compiled files
clean_build() {
    print_status "Cleaning compiled files..."
    find . -name "*.class" -type f -delete
    print_success "Clean completed"
    echo
}

# Function to show help
show_help() {
    echo "Usage: $0 [OPTION]"
    echo "Build and run Java 8 Functional Interfaces tutorial modules"
    echo
    echo "Options:"
    echo "  build          Build and run all modules (default)"
    echo "  clean          Remove all compiled .class files"
    echo "  lambda         Build and run Lambda and Anonymous demo"
    echo "  predicate      Build and run Predicate demo"
    echo "  function       Build and run Function demo"
    echo "  supplier       Build and run Supplier demo"
    echo "  consumer       Build and run Consumer demo"
    echo "  exercises      Build and run Functional Interfaces exercises"
    echo "  help           Show this help message"
    echo
}

# Main script logic
case "${1:-build}" in
    "clean")
        clean_build
        ;;
    "lambda")
        build_module "Lambda and Anonymous Classes" "lembdaAndAnonymous" "Main" "src"
        ;;
    "predicate")
        build_module "Predicate Demo" "PredicatesDemo" "Main"
        ;;
    "function")
        build_module "Function Demo" "FunctionDemo" "Main"
        ;;
    "supplier")
        build_module "Supplier Demo" "SupplierDemo" "Main"
        ;;
    "consumer")
        build_module "Consumer Demo" "ConsumerDemo" "Main"
        ;;
    "exercises")
        build_module "Functional Interfaces Exercises" "FunctionalInterfacesExercises" "Exercises"
        ;;
    "help")
        show_help
        ;;
    "build")
        print_status "Building all modules..."
        echo
        
        # Build each module in order
        build_module "Lambda and Anonymous Classes" "lembdaAndAnonymous" "Main" "src"
        build_module "Predicate Demo" "PredicatesDemo" "Main"
        build_module "Function Demo" "FunctionDemo" "Main"
        build_module "Supplier Demo" "SupplierDemo" "Main"
        build_module "Consumer Demo" "ConsumerDemo" "Main"
        build_module "Functional Interfaces Exercises" "FunctionalInterfacesExercises" "Exercises"
        
        print_success "All modules built successfully!"
        ;;
    *)
        print_error "Unknown option: $1"
        show_help
        exit 1
        ;;
esac