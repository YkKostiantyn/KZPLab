package lab5;

import java.io.*;
import lab4.ExpressionCalculator;

public class ResultIO extends ExpressionCalculator{
    public static void writeText(String fileName, double x, double y) throws IOException{
        try(FileWriter writer = new FileWriter(fileName)){
            writer.write("x = " + x + ", y = " + y + "\n");
        }
    }

    public static String readText(String fileName) throws IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.readLine();
        }
    }

    public static void writeBinary(String fileName, double x, double y) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeDouble(x);
            dos.writeDouble(y);
        }
    }

    public static double[] readBinary(String fileName) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            double x = dis.readDouble();
            double y = dis.readDouble();
            return new double[]{x, y};
        }
    }
}
