import entities.Airport;
import services.AircraftService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
            System.out.println(props.get("app.title"));
            System.out.println(props.get("app.menu"));
            System.out.println(props.get("menu.first"));
            System.out.println(props.get("menu.second"));
            System.out.println(props.get("menu.third"));
            System.out.println(props.get("menu.fourth"));
            System.out.println(props.get("menu.exit"));

            System.out.print("> ");
            int idx = Integer.parseInt(input.readLine());
            switch(idx) {
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
                    throw new RuntimeException("Invalid index. Please enter a valid index\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        run();

    }
}
