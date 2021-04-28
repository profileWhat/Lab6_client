package clientManagementModule;

import collectionManagementModule.Route;

/**
 * Class for working with the input device
 */
public class OutputDeviceWorker {
    private static OutputDeviceWorker describer;

    private OutputDeviceWorker() {
    }

    /**
     * Static Method to init Output Device for the first time and then get this Output Device.
     *
     * @return Output Device
     */
    public static OutputDeviceWorker getDescriber() {
        if (OutputDeviceWorker.describer == null) OutputDeviceWorker.describer = new OutputDeviceWorker();
        return OutputDeviceWorker.describer;
    }

    /**
     * Method for describe file which not specified
     */
    public void describeFileNotSpecified() {
        System.out.println("the environment variable is not set, the collection will not be loaded and will not be saved");
    }

    /**
     * Method for describe String
     *
     * @param s to describe string
     */
    public void describeString(String s) {
        System.out.println(s);
    }

    /**
     * Method for describe Exception
     *
     * @param e to describe exception
     */
    public void describeException(Exception e) {
        System.out.println(e.getMessage());
    }

    /**
     * Method to describe Collection Info
     *
     * @param collectionClassName to describe collection class name
     * @param creationDate        to describe collection date creation
     * @param collectionSize      to describe collection size
     */
    public void describeCMInfo(String collectionClassName, java.util.Date creationDate, int collectionSize) {
        System.out.println(
                "Type of collection: " + collectionClassName + '\n' +
                        "Date of creation: " + creationDate + '\n' +
                        "Size of collection: " + collectionSize);
    }

    /**
     * Method for describe Distance
     *
     * @param distance to describe Distance
     */
    public void describeDistance(Double distance) {
        System.out.println(distance);
    }

    /**
     * Method for show Route
     *
     * @param route to show it
     */
    public void showRoute(Route route) {
        System.out.println(
                "Route Name: " + route.getName() + '\n' +
                        "Id: " + route.getId() + '\n' +
                        "Coordinates: " + '\n' +
                        "\t x: " + route.getCoordinates().getX() + '\n' +
                        "\t y: " + route.getCoordinates().getY() + '\n' +
                        "CreationDate: " + route.getCreationDate() + '\n' +
                        "LocationFrom: " + '\n' +
                        "\t x: " + route.getFrom().getX() + '\n' +
                        "\t y: " + route.getFrom().getY() + '\n' +
                        "\t z: " + route.getFrom().getZ() + '\n' +
                        "LocationTo: " + '\n' +
                        "\t x: " + route.getTo().getX() + '\n' +
                        "\t y: " + route.getTo().getY() + '\n' +
                        "\t z: " + route.getTo().getZ() + '\n' +
                        "\t name: " + route.getTo().getName() + '\n' +
                        "Distance: " + route.getDistance() + '\n');
    }
}
