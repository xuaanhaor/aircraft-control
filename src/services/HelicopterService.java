package services;

import entities.Airport;
import entities.Helicopter;
import utils.Validate;

import java.io.IOException;

public interface HelicopterService {
    Helicopter createHelicopter(String model, Double cruiseSpeed, Double emptyWeight, Double maxTakeoffWeight) throws IOException;
    void deleteHelicopter(Airport airport) throws IOException;
}
