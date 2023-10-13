package utils;


import java.util.concurrent.atomic.AtomicInteger;

public class UniqueId {
    private static final AtomicInteger counter = new AtomicInteger(0);
    public static String generateId(String aircraft) {
        if (!aircraft.isEmpty()) {
            return aircraft + String.format("%05d", counter.getAndIncrement() % 10000);
        } else {
            throw new IllegalArgumentException("Invalid aircraft/airport id");
        }
    }
}
