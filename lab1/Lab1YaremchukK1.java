import java.io.*;
import java.util.Scanner;

/**
 * Lab1YaremchukK1
 * 
 * The Lab1YaremchukK1 class implements a program that creates a
 * symmetrical "diamond-shaped" character matrix and outputs it to the console
 * and a file. The program asks the user for the matrix size and the filler character.
 * 
 * @author Yaremchuk Kostiantyn
 * @version 1.0
 */
public class Lab1YaremchukK1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = readMatrixSize(sc);
        char filler = readFillerChar(sc);

        char[][] jaggedArray = generateJaggedArray(n, filler);

        printArray(jaggedArray);
        writeArrayToFile(jaggedArray, "output.txt");

        sc.close();
    }

    /**
     * Reads the size of the square matrix.
     * 
     * @param sc Scanner
     * @return size of matrix n
     */
    public static int readMatrixSize(Scanner sc) {
        System.out.print("Введіть розмір квадратної матриці: ");
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }

    /**
     * Reads the placeholder character. 
     * If the string is empty or contains several characters - completes the program.
     * 
     * @param sc Scanner
     * @return symbol that fills
     */
    public static char readFillerChar(Scanner sc) {
        System.out.print("Введіть один символ-заповнювач: ");
        String input = sc.nextLine();

        if (input.length() != 1) {
            System.out.println("Помилка: потрібно ввести лише один символ!");
            System.exit(1);
        }

        return input.charAt(0);
    }

    /**
     * Generates a toothed array for the shaded upper-right part of the matrix.
     * 
     * @param n size of matrix
     * @param filler symbol that fills
     * @return toothed array
     */
    public static char[][] generateJaggedArray(int n, char filler) {
        char[][] arr = new char[n][];

        for (int i = 0; i < n; i++) {
            arr[i] = new char[n + i];
            for (int j = 0; j < n; j++) {
                if(j >=n - 1 - i){
                    arr[i][j] = filler;
                }
                else {
                    arr[i][j] = ' ';
                }
            }
        }

        return arr;
    }

    /**
     * Enter array on screen
     * 
     * @param arr 
     */
    public static void printArray(char[][] arr) {
        System.out.println("Зубчастий масив:");
        for (char[] row : arr) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    /**
     * Writes the array to a file.
     * 
     * @param arr 
     * @param filename 
     */
    public static void writeArrayToFile(char[][] arr, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (char[] row : arr) {
                for (char c : row) {
                    writer.write(c + " ");
                }
                writer.write("\n");
            }
            System.out.println("Масив записано у файл " + filename);
        } catch (IOException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
        }
    }
}
