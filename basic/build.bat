@echo off
REM Java 8 Functional Interfaces Tutorial - Windows Build Script
REM Usage: build.bat [option]

echo ==========================================
echo Java 8 Functional Interfaces - Build Script
echo ==========================================

if "%1"=="" goto build_all
if "%1"=="build" goto build_all
if "%1"=="clean" goto clean
if "%1"=="lambda" goto lambda
if "%1"=="predicate" goto predicate
if "%1"=="function" goto function
if "%1"=="supplier" goto supplier
if "%1"=="consumer" goto consumer
if "%1"=="exercises" goto exercises
if "%1"=="help" goto help
goto unknown

:build_all
echo [INFO] Building all modules...
echo.
call :build_module "Lambda and Anonymous Classes" "lembdaAndAnonymous\src" "Main"
call :build_module "Predicate Demo" "PredicatesDemo" "Main"
call :build_module "Function Demo" "FunctionDemo" "Main"
call :build_module "Supplier Demo" "SupplierDemo" "Main"
call :build_module "Consumer Demo" "ConsumerDemo" "Main"
call :build_module "Functional Interfaces Exercises" "FunctionalInterfacesExercises" "Exercises"
echo [SUCCESS] All modules built successfully!
goto end

:clean
echo [INFO] Cleaning compiled files...
for /r %%i in (*.class) do del "%%i"
echo [SUCCESS] Clean completed
goto end

:lambda
call :build_module "Lambda and Anonymous Classes" "lembdaAndAnonymous\src" "Main"
goto end

:predicate
call :build_module "Predicate Demo" "PredicatesDemo" "Main"
goto end

:function
call :build_module "Function Demo" "FunctionDemo" "Main"
goto end

:supplier
call :build_module "Supplier Demo" "SupplierDemo" "Main"
goto end

:consumer
call :build_module "Consumer Demo" "ConsumerDemo" "Main"
goto end

:exercises
call :build_module "Functional Interfaces Exercises" "FunctionalInterfacesExercises" "Exercises"
goto end

:help
echo Usage: %0 [OPTION]
echo Build and run Java 8 Functional Interfaces tutorial modules
echo.
echo Options:
echo   build          Build and run all modules (default)
echo   clean          Remove all compiled .class files
echo   lambda         Build and run Lambda and Anonymous demo
echo   predicate      Build and run Predicate demo
echo   function       Build and run Function demo
echo   supplier       Build and run Supplier demo
echo   consumer       Build and run Consumer demo
echo   exercises      Build and run Functional Interfaces exercises
echo   help           Show this help message
goto end

:unknown
echo [ERROR] Unknown option: %1
call :help
goto end

:build_module
set module_name=%~1
set module_path=%~2
set main_class=%~3

echo [INFO] Building module: %module_name%

if not exist "%module_path%" (
    echo [WARNING] Module directory %module_path% not found, skipping...
    goto :eof
)

cd "%module_path%"

if not exist "*.java" (
    echo [WARNING] No Java files found in %cd%, skipping...
    cd ..
    goto :eof
)

echo [INFO] Compiling Java files in %cd%...
javac *.java
if %errorlevel% neq 0 (
    echo [ERROR] Compilation failed for %module_name%
    cd ..
    goto :eof
)

echo [SUCCESS] Compilation successful for %module_name%

if "%main_class%" neq "" (
    echo [INFO] Running %main_class%...
    echo ----------------------------------------
    java %main_class%
    if %errorlevel% neq 0 (
        echo [ERROR] Execution failed for %module_name%
    ) else (
        echo [SUCCESS] %module_name% executed successfully
    )
    echo ----------------------------------------
)

cd ..
echo.
goto :eof

:end