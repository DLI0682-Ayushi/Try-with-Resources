import java.awt.*;
import java.util.Scanner;

public class RethrowingException {

    public static double performDivision(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double) numerator / denominator;
    }
    public static double calculate(int numerator, int denominator) {
        try {
            return performDivision(numerator, denominator);
        } catch (ArithmeticException e) {

            throw new ArithmeticException("Error calculating division: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numerator: ");
        int numerator = sc.nextInt();
        System.out.println("Enter denominator: ");
        int denominator = sc.nextInt();

        try {
            if(numerator!=0) {
                double result = RethrowingException.calculate(numerator, denominator);
                System.out.println("Result: " + result);
            }
            else{
                throw new ArithmeticException("division with zero not allowed");
            }
        } catch (ArithmeticException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}