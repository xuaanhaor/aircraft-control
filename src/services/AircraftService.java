package services;

import entities.Airplane;
import utils.Validate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public interface AircraftService {

    Airplane createAirplane() throws IOException;
    void removeAirplane(List<String> list, int index);
}
