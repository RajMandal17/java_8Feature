# Makefile for Java 8 Functional Interfaces Tutorial
# Usage: make [target]

# Default target
.DEFAULT_GOAL := all

# Variables
JAVA_FILES = $(shell find . -name "*.java")
CLASS_FILES = $(shell find . -name "*.class")

# Colors for output
BLUE = \033[0;34m
GREEN = \033[0;32m
YELLOW = \033[1;33m
NC = \033[0m # No Color

# Targets
.PHONY: all clean lambda predicate function supplier consumer exercises help

all: ## Build and run all modules
	@echo -e "$(BLUE)[INFO]$(NC) Building all Java 8 Functional Interfaces modules..."
	@./build.sh build

clean: ## Remove all compiled .class files
	@echo -e "$(BLUE)[INFO]$(NC) Cleaning compiled files..."
	@find . -name "*.class" -type f -delete
	@echo -e "$(GREEN)[SUCCESS]$(NC) Clean completed"

lambda: ## Build and run Lambda and Anonymous demo
	@echo -e "$(BLUE)[INFO]$(NC) Building Lambda and Anonymous Classes demo..."
	@./build.sh lambda

predicate: ## Build and run Predicate demo
	@echo -e "$(BLUE)[INFO]$(NC) Building Predicate demo..."
	@./build.sh predicate

function: ## Build and run Function demo
	@echo -e "$(BLUE)[INFO]$(NC) Building Function demo..."
	@./build.sh function

supplier: ## Build and run Supplier demo
	@echo -e "$(BLUE)[INFO]$(NC) Building Supplier demo..."
	@./build.sh supplier

consumer: ## Build and run Consumer demo
	@echo -e "$(BLUE)[INFO]$(NC) Building Consumer demo..."
	@./build.sh consumer

exercises: ## Build and run Functional Interfaces exercises
	@echo -e "$(BLUE)[INFO]$(NC) Building Functional Interfaces exercises..."
	@./build.sh exercises

# Individual module compilation targets
compile-lambda: ## Compile only Lambda and Anonymous demo
	@cd lembdaAndAnonymous/src && javac *.java

compile-predicate: ## Compile only Predicate demo
	@cd PredicatesDemo && javac *.java

compile-function: ## Compile only Function demo
	@cd FunctionDemo && javac *.java

compile-supplier: ## Compile only Supplier demo  
	@cd SupplierDemo && javac *.java

compile-consumer: ## Compile only Consumer demo
	@cd ConsumerDemo && javac *.java

compile-exercises: ## Compile only Functional Interfaces exercises
	@cd FunctionalInterfacesExercises && javac *.java

# Run individual modules (assumes they're already compiled)
run-lambda: ## Run Lambda and Anonymous demo
	@cd lembdaAndAnonymous/src && java Main

run-predicate: ## Run Predicate demo
	@cd PredicatesDemo && java Main

run-function: ## Run Function demo
	@cd FunctionDemo && java Main

run-supplier: ## Run Supplier demo
	@cd SupplierDemo && java Main

run-consumer: ## Run Consumer demo
	@cd ConsumerDemo && java Main

run-exercises: ## Run Functional Interfaces exercises
	@cd FunctionalInterfacesExercises && java Exercises

# Development helpers
check-java: ## Check Java version
	@echo -e "$(BLUE)[INFO]$(NC) Checking Java version..."
	@java -version
	@javac -version

list-files: ## List all Java files in the workspace
	@echo -e "$(BLUE)[INFO]$(NC) Java files in workspace:"
	@find . -name "*.java" -type f

list-classes: ## List all compiled class files
	@echo -e "$(BLUE)[INFO]$(NC) Compiled class files:"
	@find . -name "*.class" -type f || echo "No compiled files found"

help: ## Show this help message
	@echo "Java 8 Functional Interfaces Tutorial - Makefile"
	@echo "================================================="
	@echo "Available targets:"
	@echo
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "  $(YELLOW)%-20s$(NC) %s\n", $$1, $$2}'
	@echo
	@echo "Examples:"
	@echo "  make              # Build and run all modules"
	@echo "  make clean        # Clean compiled files"
	@echo "  make lambda       # Build and run lambda demo"
	@echo "  make help         # Show this help"