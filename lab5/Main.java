package lab5;

import java.io.*;
import java.util.Scanner;

import lab4.ExpressionCalculator;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.print("Enter x: ");
            double x = scanner.nextDouble();

            double result = ExpressionCalculator.calculate(x);

            ResultIO.writeText("result.txt", x, result);
            System.out.println("Text file saved: " + ResultIO.readText("result.txt"));

            ResultIO.writeBinary("result.bin", x, result);
            double[] values = ResultIO.readBinary("result.bin");
            System.out.println("Binary file saved: x = " + values[0] + ", y = " + values[1]);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
        scanner.close();
    }
}
