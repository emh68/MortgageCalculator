# Mortgage Calculator

A simple command-line Java program that calculates monthly mortgage payments based on user input.

---

## Features

- Takes user input for:
  - Loan principal amount
  - Annual interest rate (percentage)
  - Loan term in years
- Validates inputs within sensible ranges
- Calculates monthly mortgage payments using the standard amortization formula
- Handles zero interest rate as a special case
- Displays monthly payment formatted as currency

---

## Requirements

- Java Development Kit (JDK) 11 or higher
- Command line terminal or IDE supporting Java

---

## How to run

1. Clone or download this repository.

2. Open a terminal and navigate to the project folder.

3. Compile the Java source code:

   ```java
   javac src/MortgageCalculator.java -d bin
   ```

4. Run the program:
    ```java
    java -cp bin MortgageCalculator
    ```

5. Follow the on-screen prompts to input:
    - Principal  amount (between $1,000 and $1,000,000)
    - Annual interest rate (1% to 30%)
    - Loan term in years (1 to 30)

### Example Usage
```
Welcome to the Mortgage Calculator!
Please enter the principal (numbers only): 250000
Annual Interest Rate (no percent symbol): 3.5
Length of mortgage in years: 30
Your monthly mortgage payment is: $1122.61
```