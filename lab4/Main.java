package lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Application driver for checking the operation of the ExpressionCalculator class.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (FileWriter writer = new FileWriter("result.txt")) {
            System.out.print("Enter x: ");
            double x = scanner.nextDouble();

            double result = ExpressionCalculator.calculate(x);

            System.out.println("Result: " + result);
            writer.write("x = " + x + ", y = " + result + "\n");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Mathematics error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unknown error: " + e.getMessage());
        }
        scanner.close();
    }
}
