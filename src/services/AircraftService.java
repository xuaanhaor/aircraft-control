package services;

import entities.Airplane;
import entities.Airport;
import entities.FixedWing;
import entities.Helicopter;
import utils.Validate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AircraftService {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


    public void createAirport() throws IOException {

        System.out.println("- Input new airport name: ");
        String name = input.readLine();
        System.out.println("- Input runaway size: ");
        Double runawaySize = Validate.checkRunawaySize(Double.parseDouble(input.readLine()));
        System.out.println("- Input max fixed-wing parking place: ");
        Double maxFixedwingParkingPlace = Validate.isNegative(Double.parseDouble(input.readLine()));
        List<String> fixedWingId = new ArrayList<>();
        System.out.println("- Input max rotated wing parking place: ");
        Double maxRotatedWingId = Validate.isNegative(Double.parseDouble(input.readLine()));
        List<String> helicopterId = new ArrayList<>();

        Airport airport = new Airport(
                name,
                runawaySize,
                maxFixedwingParkingPlace,
                fixedWingId,
                maxFixedwingParkingPlace,
                helicopterId
        );
    }

    public Airplane createAirplane() throws IOException {
        System.out.println("What airplane do you want to add (create) ?\n");
        System.out.println("1. Fixed-wing\n2. Helicopter\n:: ");
        int type = Validate.isNegative(Integer.parseInt(input.readLine()));
        if (type == 1) return createFixedWing(getModel(), getCruiseSpeed(), getEmptyWeight(), getMaxTakeoffWeight());
        if (type == 2) return createHelicopter(getModel(), getCruiseSpeed(), getEmptyWeight(), getMaxTakeoffWeight());
        else throw new IllegalArgumentException("Invalid plane type");
    }

    private String getModel() throws IOException {
        System.out.println("- Input airplane model:: ");
        return Validate.checkModel(input.readLine());
    }

    private Double getCruiseSpeed() throws IOException {
        System.out.println("- Input cruise speed:: ");
        return Validate.isNegative(Double.parseDouble(input.readLine()));
    }

    private Double getEmptyWeight() throws IOException {
        System.out.println("- Input empty weight:: ");
        return Validate.isNegative(Double.parseDouble(input.readLine()));
    }

    private Double getMaxTakeoffWeight() throws IOException {
        System.out.println("- Input max takeoff weight:: ");
        return Validate.isNegative(Double.parseDouble(input.readLine()));
    }

    private FixedWing createFixedWing(String model, Double cruiseSpeed, Double emptyWeight, Double maxTakeoffWeight) throws IOException {
        System.out.println("- Input plane type::\n");
        System.out.println("1. Cargo\n2. Long range\n3. Private\n::");
        Integer planeType = Validate.isNegative(Integer.parseInt(input.readLine()));
        System.out.println("- Input min needed runaway size:: ");
        Double minNeededRunawaySize = Validate.isNegative(Double.parseDouble(input.readLine()));
        return new FixedWing(model, cruiseSpeed, emptyWeight, maxTakeoffWeight, planeType, minNeededRunawaySize);
    }

    private Helicopter createHelicopter(String model, Double cruiseSpeed, Double emptyWeight, Double maxTakeoffWeight) throws IOException {
        System.out.println(" - Input range for helicopter:: ");
        Double range = Validate.isNegative(Double.parseDouble(input.readLine()));
        return new Helicopter(model, cruiseSpeed, emptyWeight, maxTakeoffWeight, range);
    }

    public void deleteFixedwing(Airport airport) throws IOException {
        System.out.println("- The index of the plane you want to remove::");
        int index = Validate.isNegative(Integer.parseInt(input.readLine()));
        removeAirplane(airport.getFixedWingId(), index);
    }

    // delete helicopter from airport
    public void deleteHelicopter(Airport airport) throws IOException {
        System.out.println("- The index of the helicopter you want to remove:: ");
        int index = Validate.isNegative(Integer.parseInt(input.readLine()));
        removeAirplane(airport.getHelicopterId(), index);
    }

    private void removeAirplane(List<String> list, int index) {
        if (index >= 1 && index < list.size()) {
            list.remove(index - 1);
        } else {
            System.out.println("Invalid index. Please try again");
        }
    }
    // method update fixed-wing



}
