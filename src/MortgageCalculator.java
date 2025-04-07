import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class MortgageCalculator {
    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte PERCENT = 100;
    private static final int MIN_PRINCIPAL = 1_000;
    private static final int MAX_PRINCIPAL = 1_000_000;
    private static final byte MIN_YEARS = 1;
    private static final byte MAX_YEARS = 30;
    private static final float MIN_RATE = 1;
    private static final float MAX_RATE = 30;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Mortgage Calculator!");
        int principal = getPrincipal(scanner);
        float monthlyInterest = getMonthlyInterestRate(scanner);
        int numPayments = getLoanTerm(scanner);

        BigDecimal monthlyPayment = calculateMortgage(principal, monthlyInterest, numPayments);

        System.out.println("Your monthly mortgage payment is: " + formatCurrency(monthlyPayment));
    }

    private static int getPrincipal(Scanner scanner) {
        while (true) {
            System.out.print("Please enter the principal (numbers only): ");
            int principal = scanner.nextInt();
            if (principal >= MIN_PRINCIPAL && principal <= MAX_PRINCIPAL)
                return principal;
            System.out.println("Please enter a value between 1,000 and 1,000,000.");
        }
    }

    private static float getMonthlyInterestRate(Scanner scanner) {
        while (true) {
            System.out.print("Annual Interest Rate (no percent symbol): ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= MIN_RATE && annualInterest <= MAX_RATE)
                return (annualInterest / PERCENT) / MONTHS_IN_YEAR;
            System.out.println("Please enter a value between 1 and 30.");
        }
    }

    private static int getLoanTerm(Scanner scanner) {
        while (true) {
            System.out.print("Length of mortgage in years: ");
            byte mortgageLength = scanner.nextByte();
            if (mortgageLength >= MIN_YEARS && mortgageLength <= MAX_YEARS)
                return mortgageLength * MONTHS_IN_YEAR;
            System.out.println("Please enter a number between 1 and 30.");
        }
    }

    private static BigDecimal calculateMortgage(int principal, float monthlyInterest, int numPayments) {
        if (monthlyInterest == 0) // Edge case: zero interest rate
            return BigDecimal.valueOf(principal).divide(BigDecimal.valueOf(numPayments), 2, RoundingMode.HALF_UP);

        double factor = Math.pow(1 + monthlyInterest, numPayments);
        double result = (principal * monthlyInterest * factor) / (factor - 1);
        return BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP);
    }

    private static String formatCurrency(BigDecimal value) {
        return "$" + value;
    }
}
