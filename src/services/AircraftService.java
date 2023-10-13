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

    HelicopterService helicopterService;
    FixedWingService fixedWingService;
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public Airplane createAirplane() throws IOException {
        System.out.println("What airplane do you want to add (create) ?\n");
        System.out.println("1. Fixed-wing\n2. Helicopter\n:: ");
        int type = Validate.isNegative(Integer.parseInt(input.readLine()));
        if (type == 1)
            return fixedWingService.createFixedWing(getModel(), getCruiseSpeed(), getEmptyWeight(), getMaxTakeoffWeight());
        if (type == 2)
            return helicopterService.createHelicopter(getModel(), getCruiseSpeed(), getEmptyWeight(), getMaxTakeoffWeight());
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

    public void removeAirplane(List<String> list, int index) {
        if (index >= 1 && index < list.size()) {
            list.remove(index - 1);
        } else {
            System.out.println("Invalid index. Please try again");
        }
    }
}
