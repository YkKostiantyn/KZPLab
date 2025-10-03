package lab5;

import java.io.*;
import java.util.Scanner;

import lab4.ExpressionCalculator;

/**
 * The <code>Main</code> class implements a console application that
 * calculates an expression using {@link ExpressionCalculator} and
 * saves/reads the results in text and binary formats via {@link ResultIO}.
 * @author ...
 * @version 1.0
 */
public class Main {
    /**
     * Entry point of the program.
     * Reads a value <code>x</code> from console, performs calculations,
     * saves the result to files, and reads it back.
     * @param args command line arguments
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.print("Enter x: ");
            double x = scanner.nextDouble();

            // Perform calculation
            double result = ExpressionCalculator.calculate(x);

            // Save and read from text file
            ResultIO.writeText("result.txt", x, result);
            System.out.println("Text file saved: " + ResultIO.readText("result.txt"));

            // Save and read from binary file
            ResultIO.writeBinary("result.bin", x, result);
            double[] values = ResultIO.readBinary("result.bin");
            System.out.println("Binary file saved: x = " + values[0] + ", y = " + values[1]);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
        scanner.close();
    }
}
