package lab2;

import java.io.*;
import java.time.LocalDateTime;

/**
 * The Locomotive class describes the locomotive and its operation.
 * It has an engine, a driver and a number of cars.
 * Logs actions to the app.log file.
 */
public class Locomotive {
    private String engineType;
    private String driverName;
    private int wagons;
    private FileWriter logger;

    /**
     * Designer with all parameters.
     */
    public Locomotive(String engineType, String driverName, int wagons) throws IOException {
        this.engineType = engineType;
        this.driverName = driverName;
        this.wagons = wagons;
        this.logger = new FileWriter("app.log", true);
        log("A locomotive was created: " + engineType + ", driver " + driverName);
    }

    /**
     * Default builder.
     */
    public Locomotive() throws IOException {
        this("Diesel", "John Snow", 0);
    }

    public void start() throws IOException {
        log("The locomotive has been launched (" + engineType + ")");
    }

    public void stop() throws IOException {
        log("The locomotive is stopped");
    }

    public void addWagon() throws IOException {
        wagons++;
        log("Added wagon. Total number: " + wagons);
    }

    public void removeWagon() throws IOException {
        if (wagons > 0) {
            wagons--;
            log("The wagon was unhooked. Remaining: " + wagons);
        } else {
            log("No uncoupling wagons");
        }
    }

    public void horn() throws IOException {
        log("The locomotive sounded the horn");
    }

    public void changeDriver(String newDriver) throws IOException {
        this.driverName = newDriver;
        log("Changed driver to: " + newDriver);
    }

    public void checkEngineStatus() throws IOException {
        log("Engine check: type " + engineType);
    }

    public void refuel(int liters) throws IOException {
        log("Powered " + liters + " ");
    }

    public int getWagons() {
        return wagons;
    }

    public String getDriverName() {
        return driverName;
    }

    public void close() throws IOException {
        log("The locomotive's work is complete\n");
        if (logger != null) {
            logger.close();
        }
    }

    private void log(String message) throws IOException {
        logger.write(LocalDateTime.now() + " - " + message + "\n");
        logger.flush();
    }
}