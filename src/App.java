import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Airport;
import services.AircraftService;
import utils.Validate;

import java.io.*;
import java.util.*;

public class App {
    AircraftService service;

    public static void run() throws IOException {
        Properties props = new Properties();
        InputStream in = App.class.getClassLoader().getResourceAsStream("conf/config.properties");

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        List<Airport> list = new ArrayList<>();

        props.load(in);

        while (true) {
            int idx = 0;
            try {
                System.out.println(props.get("app.title"));
                System.out.println(props.get("app.menu"));
                System.out.println(props.get("menu.first"));
                System.out.println(props.get("menu.second"));
                System.out.println(props.get("menu.third"));
                System.out.println(props.get("menu.fourth"));
                System.out.println(props.get("menu.exit"));

                System.out.print("> ");
                idx = Integer.parseInt(input.readLine());
                switch (idx) {
                    case 1:
                        System.out.println(props.get("menu.first"));
                        break;
                    case 2:
                        System.out.println("Hello world 2");
                        break;
                    case 3:
                        System.out.println("3");
                        break;
                    case 4:
                        System.out.println("4");
                        break;
                    case 5:
                        System.out.println(props.get("goodbye"));
                        System.exit(0);
                    default:
                        System.out.println("Invalid index. Please enter 1-5\n");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number\n ");
            }

        }
    }

    public static void main(String[] args) throws IOException {
//        run();
        add();
    }

    public static void add() {
        ObjectMapper mapper = new ObjectMapper();
        List<Airport> list;
        try {
            list = Arrays.asList(mapper.readValue(new File("src/data/sample.json"), Airport[].class));
            for (Airport airport : list) {
                System.out.println("Name: " + airport.getName());
                System.out.println("Runway Size: " + airport.getRunawaySize());
                System.out.println("Max Fixed Wing Parking Place: " + airport.getMaxFixedwingParkingPlace());
                System.out.println("Max Rotated Wing Parking Place: " + airport.getMaxRotatedWingParkingPlace());
                System.out.println("---------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
