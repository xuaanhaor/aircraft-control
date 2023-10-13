package services;

import entities.Airport;
import entities.FixedWing;

import java.io.IOException;

public interface FixedWingService {
    void deleteFixedWing(Airport airport) throws IOException;
    FixedWing createFixedWing(String model, Double cruiseSpeed, Double emptyWeight, Double maxTakeoffWeight) throws IOException;
}
