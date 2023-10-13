package services.implement;

import entities.Airport;
import entities.Helicopter;
import services.AircraftService;
import services.HelicopterService;
import utils.Validate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelicopterServiceImpl implements HelicopterService {

    AircraftService service;

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public Helicopter createHelicopter(String model, Double cruiseSpeed, Double emptyWeight, Double maxTakeoffWeight) throws IOException {
        System.out.println(" - Input range for helicopter:: ");
        Double range = Validate.isNegative(Double.parseDouble(input.readLine()));
        return new Helicopter(model, cruiseSpeed, emptyWeight, maxTakeoffWeight, range);
    }

    @Override
    public void deleteHelicopter(Airport airport) throws IOException {
        System.out.println("- The index of the helicopter you want to remove:: ");
        int index = Validate.isNegative(Integer.parseInt(input.readLine()));
        service.removeAirplane(airport.getHelicopterId(), index);
    }
}
