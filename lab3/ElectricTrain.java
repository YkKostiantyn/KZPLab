package lab3;

import java.io.IOException;

/**
 * The ElectricTrain class represents the electric train.
 * Are a subclass {@link Locomotive} but implements the interface {@link PassengerTransport}.
 */
public class ElectricTrain extends Locomotive implements PassengerTransport {
    private int maxPassengers;

    /**
     * Electrician designer.
     * @param driverName driver's name
     * @param wagons number of wagons
     * @param maxPassengersnumber of passengers
     */
    public ElectricTrain(String driverName, int wagons, int maxPassengers) throws IOException {
        super("Electric", driverName, wagons);
        this.maxPassengers = maxPassengers;
    }

    @Override
    public void printInfo() {
        System.out.println("Electric train, driver: " + driverName +
                ", wagons: " + wagons +
                ", max.passegers: " + maxPassengers);
    }

    @Override
    public int getMaxPassengers() {
        return maxPassengers;
    }
}
