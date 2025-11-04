# Java 8 Functional Interfaces Tutorial - PowerShell Build Script
# Usage: .\build.ps1 [option]

param(
    [string]$Action = "build"
)

# Colors for output
$InfoColor = "Cyan"
$SuccessColor = "Green"
$WarningColor = "Yellow"
$ErrorColor = "Red"

function Write-Info {
    param([string]$Message)
    Write-Host "[INFO] $Message" -ForegroundColor $InfoColor
}

function Write-Success {
    param([string]$Message)
    Write-Host "[SUCCESS] $Message" -ForegroundColor $SuccessColor
}

function Write-Warning {
    param([string]$Message)
    Write-Host "[WARNING] $Message" -ForegroundColor $WarningColor
}

function Write-Error {
    param([string]$Message)
    Write-Host "[ERROR] $Message" -ForegroundColor $ErrorColor
}

function Build-Module {
    param(
        [string]$ModuleName,
        [string]$ModulePath,
        [string]$MainClass = ""
    )
    
    Write-Info "Building module: $ModuleName"
    
    if (-not (Test-Path $ModulePath)) {
        Write-Warning "Module directory $ModulePath not found, skipping..."
        return
    }
    
    Push-Location $ModulePath
    
    $javaFiles = Get-ChildItem -Filter "*.java"
    if ($javaFiles.Count -eq 0) {
        Write-Warning "No Java files found in $(Get-Location), skipping..."
        Pop-Location
        return
    }
    
    Write-Info "Compiling Java files in $(Get-Location)..."
    $compileResult = javac *.java
    
    if ($LASTEXITCODE -eq 0) {
        Write-Success "Compilation successful for $ModuleName"
        
        if ($MainClass -ne "") {
            Write-Info "Running $MainClass..."
            Write-Host "----------------------------------------"
            java $MainClass
            if ($LASTEXITCODE -eq 0) {
                Write-Success "$ModuleName executed successfully"
            } else {
                Write-Error "Execution failed for $ModuleName"
            }
            Write-Host "----------------------------------------"
        }
    } else {
        Write-Error "Compilation failed for $ModuleName"
    }
    
    Pop-Location
    Write-Host ""
}

function Clean-Build {
    Write-Info "Cleaning compiled files..."
    Get-ChildItem -Recurse -Filter "*.class" | Remove-Item -Force
    Write-Success "Clean completed"
    Write-Host ""
}

function Show-Help {
    Write-Host "Usage: .\build.ps1 [OPTION]"
    Write-Host "Build and run Java 8 Functional Interfaces tutorial modules"
    Write-Host ""
    Write-Host "Options:"
    Write-Host "  build          Build and run all modules (default)"
    Write-Host "  clean          Remove all compiled .class files"
    Write-Host "  lambda         Build and run Lambda and Anonymous demo"
    Write-Host "  predicate      Build and run Predicate demo"
    Write-Host "  function       Build and run Function demo"
    Write-Host "  supplier       Build and run Supplier demo"
    Write-Host "  consumer       Build and run Consumer demo"
    Write-Host "  exercises      Build and run Functional Interfaces exercises"
    Write-Host "  help           Show this help message"
    Write-Host ""
}

Write-Host "=========================================="
Write-Host "Java 8 Functional Interfaces - Build Script"
Write-Host "=========================================="

switch ($Action.ToLower()) {
    "clean" {
        Clean-Build
    }
    "lambda" {
        Build-Module "Lambda and Anonymous Classes" "lembdaAndAnonymous\src" "Main"
    }
    "predicate" {
        Build-Module "Predicate Demo" "PredicatesDemo" "Main"
    }
    "function" {
        Build-Module "Function Demo" "FunctionDemo" "Main"
    }
    "supplier" {
        Build-Module "Supplier Demo" "SupplierDemo" "Main"
    }
    "consumer" {
        Build-Module "Consumer Demo" "ConsumerDemo" "Main"
    }
    "exercises" {
        Build-Module "Functional Interfaces Exercises" "FunctionalInterfacesExercises" "Exercises"
    }
    "help" {
        Show-Help
    }
    "build" {
        Write-Info "Building all modules..."
        Write-Host ""
        
        Build-Module "Lambda and Anonymous Classes" "lembdaAndAnonymous\src" "Main"
        Build-Module "Predicate Demo" "PredicatesDemo" "Main"
        Build-Module "Function Demo" "FunctionDemo" "Main"
        Build-Module "Supplier Demo" "SupplierDemo" "Main"
        Build-Module "Consumer Demo" "ConsumerDemo" "Main"
        Build-Module "Functional Interfaces Exercises" "FunctionalInterfacesExercises" "Exercises"
        
        Write-Success "All modules built successfully!"
    }
    default {
        Write-Error "Unknown option: $Action"
        Show-Help
        exit 1
    }
}