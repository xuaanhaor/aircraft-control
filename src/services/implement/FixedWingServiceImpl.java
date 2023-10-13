package services.implement;

import entities.Airport;
import entities.FixedWing;
import services.AircraftService;
import services.FixedWingService;
import utils.Validate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FixedWingServiceImpl implements FixedWingService {

    private final AircraftService service;
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public FixedWingServiceImpl(AircraftService service) {
        this.service = service;
    }

    public void deleteFixedWing(Airport airport) throws IOException {
        System.out.println("- The index of the plane you want to remove::");
        int index = Validate.isNegative(Integer.parseInt(input.readLine()));
        service.removeAirplane(airport.getFixedWingId(), index);
    }

    @Override
    public FixedWing createFixedWing(String model, Double cruiseSpeed, Double emptyWeight, Double maxTakeoffWeight) throws IOException {
        System.out.println("- Input plane type::\n");
        System.out.println("1. Cargo\n2. Long range\n3. Private\n::");
        Integer planeType = Validate.isNegative(Integer.parseInt(input.readLine()));
        System.out.println("- Input min needed runaway size:: ");
        Double minNeededRunawaySize = Validate.isNegative(Double.parseDouble(input.readLine()));
        return new FixedWing(model, cruiseSpeed, emptyWeight, maxTakeoffWeight, planeType, minNeededRunawaySize);
    }
}
