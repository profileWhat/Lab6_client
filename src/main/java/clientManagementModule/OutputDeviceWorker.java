package clientManagementModule;

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

}
