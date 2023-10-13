package utils;

public class Validate {

    public static String checkModel(String model) {
        if (model.length() >= 41)
            throw new IllegalArgumentException("The model size is maximum 40 characters");
        if (model.isEmpty()) {
            throw new IllegalArgumentException("The model is null");
        }
        return model;
    }

    public static Double checkRunawaySize(Double runawaySize) {
        if (runawaySize <= 0) throw new IllegalArgumentException("Runaway size cannot be negative or equal to 0");
        return runawaySize;
    }

    public static Double isNegative(Double number) {
        if (number < 0) throw new IllegalArgumentException("This number is negative, please try again");
        return number;
    }

    public static Integer isNegative(Integer number) {
        if (number < 0) throw new IllegalArgumentException("This number is negative, please try again");
        return number;
    }
}
