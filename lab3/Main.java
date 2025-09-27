package lab3;

/**
 * Демонстрація роботи електрички.
 */
public class Main {
    public static void main(String[] args) {
        try {
            ElectricTrain train = new ElectricTrain("John Snow", 8, 1200);
            train.start();
            train.printInfo();
            train.addWagon();
            train.horn();
            train.stop();
            train.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
