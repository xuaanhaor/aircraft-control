package services;

import entities.Airport;

import java.io.IOException;

public interface AirportService {
    Airport createAirport() throws IOException;
    void deleteAirport() throws IOException;
}
