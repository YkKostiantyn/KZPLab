package lab5;

import java.io.*;
import lab4.ExpressionCalculator;

/**
 * The <code>ResultIO</code> class provides methods for saving
 * calculation results in text and binary formats, as well as
 * reading them back. It is used together with {@link ExpressionCalculator}.
 * @author Yaremchuk Kostiantyn
 * @version 1.0
 */
public class ResultIO extends ExpressionCalculator {

    /**
     * Writes the result to a text file.
     * @param fileName the file name
     * @param x input value
     * @param y calculation result
     * @throws IOException if a file I/O error occurs
     */
    public static void writeText(String fileName, double x, double y) throws IOException{
        try(FileWriter writer = new FileWriter(fileName)){
            writer.write("x = " + x + ", y = " + y + "\n");
        }
    }

    /**
     * Reads the result from a text file.
     * @param fileName the file name
     * @return a string with the result
     * @throws IOException if a file I/O error occurs
     */
    public static String readText(String fileName) throws IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.readLine();
        }
    }

    /**
     * Writes the result to a binary file.
     * @param fileName the file name
     * @param x input value
     * @param y calculation result
     * @throws IOException if a file I/O error occurs
     */
    public static void writeBinary(String fileName, double x, double y) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeDouble(x);
            dos.writeDouble(y);
        }
    }

    /**
     * Reads the result from a binary file.
     * @param fileName the file name
     * @return an array where [0] = x, [1] = y
     * @throws IOException if a file I/O error occurs
     */
    public static double[] readBinary(String fileName) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            double x = dis.readDouble();
            double y = dis.readDouble();
            return new double[]{x, y};
        }
    }
}
