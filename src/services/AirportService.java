package services;

import entities.Airport;

import java.io.IOException;
import java.util.List;

public interface AirportService {
    Airport createAirport() throws IOException;
    void deleteAirport() throws IOException;
}
