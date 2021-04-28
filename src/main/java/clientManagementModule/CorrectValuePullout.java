package clientManagementModule;

/**
 * Class for pulling the correct values from the input device
 */

public class CorrectValuePullout {
    /**
     * Method for get Long value.
     *
     * @param s . It param will convert to Long value.
     * @return Long value.
     * @throws IncorrectValueException if param is not Long.
     */
    public long getLongValue(String s) throws IncorrectValueException {
        long value;
        try {
            value = Long.parseLong(s);
        } catch (NumberFormatException e) {
            throw new IncorrectValueException("Incorrect Long Value, please input correct number ");
        }
        return value;
    }

    /**
     * Method for get Double value.
     *
     * @param s . It param will convert to Double value.
     * @return Double value.
     * @throws IncorrectValueException if param is not Double.
     */
    public double getDoubleValue(String s) throws IncorrectValueException {
        double value;
        try {
            value = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new IncorrectValueException("Incorrect Double Value, please input correct number");
        }
        return value;
    }

    /**
     * Method for get Float value.
     *
     * @param s . It param will convert to Float value.
     * @return Float value.
     * @throws IncorrectValueException if param is not Float.
     */
    public float getFloatValue(String s) throws IncorrectValueException {
        float value;
        try {
            value = Float.parseFloat(s);
        } catch (NumberFormatException e) {
            throw new IncorrectValueException("Incorrect Float Value, please input correct number");
        }
        return value;
    }

    /**
     * Method for get Integer value.
     *
     * @param s . It param will convert to Integer value.
     * @return Double value.
     * @throws IncorrectValueException if param is not Integer.
     */
    public int getIntegerValue(String s) throws IncorrectValueException {
        int value;
        try {
            value = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IncorrectValueException("Incorrect Integer Value, please input correct number");
        }
        return value;
    }

}
