#!/bin/bash

# Java 8 Functional Interfaces - Workspace Verification Script
# This script checks if the workspace is properly set up

echo "=========================================="
echo "Java 8 Functional Interfaces - Workspace Verification"
echo "=========================================="

# Colors for output
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m'

print_check() {
    if [ $1 -eq 0 ]; then
        echo -e "${GREEN}✓${NC} $2"
    else
        echo -e "${RED}✗${NC} $2"
    fi
}

print_info() {
    echo -e "${BLUE}[INFO]${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}[WARN]${NC} $1"
}

# Check Java installation
print_info "Checking Java installation..."
if command -v java &> /dev/null && command -v javac &> /dev/null; then
    JAVA_VERSION=$(java -version 2>&1 | head -n 1)
    JAVAC_VERSION=$(javac -version 2>&1)
    print_check 0 "Java found: $JAVA_VERSION"
    print_check 0 "Java compiler found: $JAVAC_VERSION"
else
    print_check 1 "Java not found - please install Java 8 or higher"
fi

echo ""

# Check workspace structure
print_info "Checking workspace structure..."

declare -a required_dirs=(
    "lembdaAndAnonymous/src"
    "PredicatesDemo"
    "FunctionDemo"
    "SupplierDemo"
    "ConsumerDemo"
    "FunctionalInterfacesExercises"
)

for dir in "${required_dirs[@]}"; do
    if [ -d "$dir" ]; then
        print_check 0 "Directory exists: $dir"
    else
        print_check 1 "Directory missing: $dir"
    fi
done

echo ""

# Check build scripts
print_info "Checking build scripts..."

if [ -f "build.sh" ]; then
    if [ -x "build.sh" ]; then
        print_check 0 "build.sh exists and is executable"
    else
        print_check 1 "build.sh exists but is not executable (run: chmod +x build.sh)"
    fi
else
    print_check 1 "build.sh missing"
fi

if [ -f "Makefile" ]; then
    print_check 0 "Makefile exists"
else
    print_check 1 "Makefile missing"
fi

if [ -f "build.bat" ]; then
    print_check 0 "build.bat exists (Windows support)"
else
    print_check 1 "build.bat missing"
fi

if [ -f "build.ps1" ]; then
    print_check 0 "build.ps1 exists (PowerShell support)"
else
    print_check 1 "build.ps1 missing"
fi

echo ""

# Check VS Code configuration
print_info "Checking VS Code configuration..."

if [ -d ".vscode" ]; then
    print_check 0 ".vscode directory exists"
    
    if [ -f ".vscode/tasks.json" ]; then
        print_check 0 "VS Code tasks.json exists"
    else
        print_check 1 "VS Code tasks.json missing"
    fi
else
    print_check 1 ".vscode directory missing"
fi

echo ""

# Check Java files
print_info "Checking Java files..."

total_java_files=$(find . -name "*.java" | wc -l)
echo -e "${BLUE}[INFO]${NC} Total Java files found: $total_java_files"

if [ $total_java_files -eq 0 ]; then
    print_warning "No Java files found in workspace"
else
    echo -e "${BLUE}[INFO]${NC} Java files by module:"
    for dir in "${required_dirs[@]}"; do
        if [ -d "$dir" ]; then
            count=$(find "$dir" -name "*.java" 2>/dev/null | wc -l)
            if [ $count -gt 0 ]; then
                echo -e "  ${GREEN}✓${NC} $dir: $count files"
            else
                echo -e "  ${YELLOW}!${NC} $dir: $count files (module may be empty)"
            fi
        fi
    done
fi

echo ""

# Check for common issues
print_info "Checking for common issues..."

# Check if any .class files exist
class_files=$(find . -name "*.class" | wc -l)
if [ $class_files -gt 0 ]; then
    print_warning "Found $class_files compiled .class files - consider running 'make clean' or './build.sh clean'"
else
    print_check 0 "No old compiled files found"
fi

# Check permissions on current directory
if [ -w . ]; then
    print_check 0 "Current directory is writable"
else
    print_check 1 "Current directory is not writable"
fi

echo ""

# Summary and recommendations
print_info "Summary and Recommendations:"

if command -v java &> /dev/null && [ -f "build.sh" ] && [ -x "build.sh" ]; then
    echo -e "${GREEN}✓${NC} Workspace appears to be properly set up!"
    echo -e "${BLUE}[INFO]${NC} You can start building with:"
    echo "  ./build.sh        # Build all modules"
    echo "  make              # Alternative build method"
    echo "  ./build.sh help   # Show all options"
else
    echo -e "${RED}✗${NC} Workspace setup incomplete. Please address the issues above."
fi

echo ""
echo "For detailed build instructions, see README.md"