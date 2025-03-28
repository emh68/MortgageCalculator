import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the mortgage calculator!");

        // Get loan amount
        System.out.print("Please enter the principal (numbers only): ");
        int principal = scanner.nextInt();

        // Convert Annual Interest Rate to Monthly Interest Rate
        System.out.print("Annual Interest Rate (no percent symbol): ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = (annualInterest / MONTHS_IN_YEAR) / PERCENT;

        // Convert loan length from years to months
        System.out.print("Length of mortgage in years: ");
        byte mortgageLength = scanner.nextByte();
        int numPayments = mortgageLength * MONTHS_IN_YEAR;

        // Calculate monthly mortgage payment
        float result = (float) ((monthlyInterest * Math.pow(1 + monthlyInterest, numPayments)) / (Math.pow(1 + monthlyInterest, numPayments) - 1) * principal);
        String monthlyPayment =  String.format("$%.2f", result);
        System.out.println("Your monthly mortgage payment is: " + monthlyPayment);
    }
}