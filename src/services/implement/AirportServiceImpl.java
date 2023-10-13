package services.implement;

import entities.Airport;
import services.AirportService;
import utils.Validate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AirportServiceImpl implements AirportService {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public Airport createAirport() throws IOException {

        System.out.println("- Input new airport name: ");
        String name = input.readLine();
        System.out.println("- Input runaway size: ");
        Double runawaySize = Validate.checkRunawaySize(Double.parseDouble(input.readLine()));
        System.out.println("- Input max fixed-wing parking place: ");
        Double maxFixedWingParkingPlace = Validate.isNegative(Double.parseDouble(input.readLine()));
        List<String> fixedWingId = new ArrayList<>();
        System.out.println("- Input max rotated wing parking place: ");
        Double maxRotatedWingParkingPlace = Validate.isNegative(Double.parseDouble(input.readLine()));
        List<String> helicopterId = new ArrayList<>();

        return new Airport(
                name,
                runawaySize,
                maxFixedWingParkingPlace,
                fixedWingId,
                maxRotatedWingParkingPlace,
                helicopterId
        );
    }

    @Override
    public void deleteAirport() throws IOException {
    }

}
