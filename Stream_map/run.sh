#!/bin/bash

# Stream map() Examples - Build and Run Script

echo "╔══════════════════════════════════════════════════════╗"
echo "║      Java Stream map() - Build & Run Examples       ║"
echo "╚══════════════════════════════════════════════════════╝"
echo ""

# Colors for output
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Navigate to Stream_map directory
cd /workspaces/java_8Feature/Stream_map

# Function to compile and run
run_example() {
    local file=$1
    local name=$2
    
    echo -e "${BLUE}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
    echo -e "${YELLOW}Running: $name${NC}"
    echo -e "${BLUE}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
    echo ""
    
    # Compile
    if javac "$file.java" 2>/dev/null; then
        echo -e "${GREEN}✓ Compiled successfully${NC}"
        echo ""
        
        # Run
        java "$file"
        echo ""
    else
        echo -e "\033[0;31m✗ Compilation failed${NC}"
        echo ""
    fi
}

# Show menu
show_menu() {
    echo "Select an example to run:"
    echo ""
    echo "  1) Basic Transformations (squares, uppercase, lengths)"
    echo "  2) Type Conversion (String↔Integer, Rupees→USD)"
    echo "  3) Object Transformation (Employee, DTO)"
    echo "  4) map() with filter()"
    echo "  5) Primitive Variants (mapToInt, mapToDouble, mapToLong)"
    echo "  6) Practical Coding Questions (All 6 problems)"
    echo "  7) Complete Workflow Demonstration"
    echo "  8) Run ALL Examples"
    echo "  9) Clean (remove .class files)"
    echo "  0) Exit"
    echo ""
}

# Main script
if [ $# -eq 0 ]; then
    while true; do
        show_menu
        read -p "Enter your choice: " choice
        echo ""
        
        case $choice in
            1)
                run_example "BasicTransformations" "Basic Transformations"
                ;;
            2)
                run_example "TypeConversionExample" "Type Conversion"
                ;;
            3)
                run_example "ObjectTransformationExample" "Object Transformation"
                ;;
            4)
                run_example "MapWithFilterExample" "map() with filter()"
                ;;
            5)
                run_example "PrimitiveMapExample" "Primitive Map Variants"
                ;;
            6)
                run_example "PracticalCodingQuestions" "Practical Coding Questions"
                ;;
            7)
                run_example "CompleteMapWorkflow" "Complete Workflow"
                ;;
            8)
                echo -e "${GREEN}Running ALL Examples...${NC}"
                echo ""
                run_example "BasicTransformations" "Basic Transformations"
                run_example "TypeConversionExample" "Type Conversion"
                run_example "ObjectTransformationExample" "Object Transformation"
                run_example "MapWithFilterExample" "map() with filter()"
                run_example "PrimitiveMapExample" "Primitive Map Variants"
                run_example "PracticalCodingQuestions" "Practical Coding Questions"
                run_example "CompleteMapWorkflow" "Complete Workflow"
                echo -e "${GREEN}✓ All examples completed!${NC}"
                echo ""
                ;;
            9)
                echo "Cleaning .class files..."
                rm -f *.class
                echo -e "${GREEN}✓ Cleaned successfully${NC}"
                echo ""
                ;;
            0)
                echo "Goodbye!"
                exit 0
                ;;
            *)
                echo -e "\033[0;31m✗ Invalid choice. Please try again.${NC}"
                echo ""
                ;;
        esac
        
        read -p "Press Enter to continue..."
        clear
    done
else
    # Handle command line arguments
    case $1 in
        all)
            echo -e "${GREEN}Compiling and running ALL examples...${NC}"
            echo ""
            run_example "BasicTransformations" "Basic Transformations"
            run_example "TypeConversionExample" "Type Conversion"
            run_example "ObjectTransformationExample" "Object Transformation"
            run_example "MapWithFilterExample" "map() with filter()"
            run_example "PrimitiveMapExample" "Primitive Map Variants"
            run_example "PracticalCodingQuestions" "Practical Coding Questions"
            run_example "CompleteMapWorkflow" "Complete Workflow"
            ;;
        clean)
            echo "Cleaning .class files..."
            rm -f *.class
            echo -e "${GREEN}✓ Cleaned successfully${NC}"
            ;;
        basic)
            run_example "BasicTransformations" "Basic Transformations"
            ;;
        type)
            run_example "TypeConversionExample" "Type Conversion"
            ;;
        object)
            run_example "ObjectTransformationExample" "Object Transformation"
            ;;
        filter)
            run_example "MapWithFilterExample" "map() with filter()"
            ;;
        primitive)
            run_example "PrimitiveMapExample" "Primitive Map Variants"
            ;;
        questions)
            run_example "PracticalCodingQuestions" "Practical Coding Questions"
            ;;
        workflow)
            run_example "CompleteMapWorkflow" "Complete Workflow"
            ;;
        *)
            echo "Usage: ./run.sh [option]"
            echo ""
            echo "Options:"
            echo "  all        - Run all examples"
            echo "  basic      - Basic transformations"
            echo "  type       - Type conversion"
            echo "  object     - Object transformation"
            echo "  filter     - map() with filter()"
            echo "  primitive  - Primitive variants"
            echo "  questions  - Practical questions"
            echo "  workflow   - Complete workflow"
            echo "  clean      - Remove .class files"
            echo ""
            echo "Or run without arguments for interactive menu"
            ;;
    esac
fi
