package lab2;
/**
 * Locomotive test class driver.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Locomotive loco = new Locomotive("electric", "John Snow", 2);

            loco.start();
            loco.horn();
            loco.addWagon();
            loco.removeWagon();

            System.out.println("Driver: " + loco.getDriverName());
            System.out.println("number of wagons: " + loco.getWagons());

            loco.changeDriver("Patrick Udes");
            loco.checkEngineStatus();
            loco.refuel(500);
            loco.stop();

            loco.close();   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
