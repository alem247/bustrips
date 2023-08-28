import entity.Route;
import entity.Stop;
import entity.StopTime;
import entity.Trip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BusTrips {

    public static ArrayList<Route> parseRoutes() {
        ArrayList<Route> routes = new ArrayList<>();

        String path = "gtfs/routes.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 9) {
                    int route_id = Integer.parseInt(fields[0].trim());
                    String route_short_name = fields[2].trim();
                    String route_long_name = fields[3].trim();
                    int route_type = Integer.parseInt(fields[5].trim());

                    Route route = new Route(route_id, route_short_name, route_long_name, route_type);
                    routes.add(route);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return routes;
    }

    public static ArrayList<Stop> parseStops() {
        ArrayList<Stop> stops = new ArrayList<>();

        String path = "gtfs/stops.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            reader.readLine(); // Skip the header line
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 6) {
                    int stop_id = Integer.parseInt(fields[0].trim());
                    String stop_name = fields[2].trim();
                    double stop_lat = Double.parseDouble(fields[4].trim());
                    double stop_lon = Double.parseDouble(fields[5].trim());

                    Stop stop = new Stop(stop_id, stop_name, stop_lat, stop_lon);
                    stops.add(stop);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stops;
    }


    public static ArrayList<StopTime> parseStopTimes() {
        ArrayList<StopTime> stopTimes = new ArrayList<>();

        String path = "gtfs/stop_times.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 5) {
                    String trip_id = fields[0].trim();
                    int stop_sequence = Integer.parseInt(fields[4].trim());
                    int stop_id = Integer.parseInt(fields[3].trim());

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime arrival_time = LocalTime.parse(fields[1].trim(), formatter);
                    LocalTime departure_time = LocalTime.parse(fields[2].trim(), formatter);

                    StopTime stopTime = new StopTime(trip_id, stop_sequence, stop_id, arrival_time, departure_time);
                    stopTimes.add(stopTime);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stopTimes;
    }

    public static ArrayList<Trip> parseTrips() {
        ArrayList<Trip> trips = new ArrayList<>();

        String filePath = "gtfs/trips.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 7) {
                    int route_id = Integer.parseInt(fields[0].trim());
                    int service_id = Integer.parseInt(fields[1].trim());
                    String trip_id = fields[2].trim();
                    String trip_headsign = fields[3].trim();
                    int direction_id = Integer.parseInt(fields[5].trim());

                    Trip trip = new Trip(trip_id, route_id, service_id, direction_id, trip_headsign);
                    trips.add(trip);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return trips;
    }

    public static void removeEmptyLists(Map<String, List<String>> map) {
        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> entry = iterator.next();
            if (entry.getValue().isEmpty()) {
                iterator.remove();
            }
        }
    }

    public static void calculateAndPrintBusTrips(int stop_id, int trip_count, String timeFormat){

        ArrayList<StopTime> stop_times = parseStopTimes();

        LocalTime currentTime = LocalTime.now();

        Map<String, List<String>> busTrips = new HashMap<>();


        for (StopTime stopTime : stop_times){
            String tripId = stopTime.getTripId();
            String departureTime = stopTime.getDepartureTime().toString();
                if (stopTime.getStopId() == stop_id) { // if the stop id is equal
                    if (!busTrips.containsKey(tripId)){ // if the trip isn't already a key
                        busTrips.put(stopTime.getTripId(), new ArrayList<>());
                    }
                    if (stopTime.getDepartureTime().isBefore(currentTime.plusHours(2)) && stopTime.getDepartureTime().isAfter(currentTime)) { // if the departure time is in the next 2 hours
                        if (!busTrips.get(tripId).contains(departureTime) && busTrips.get(tripId).size() < trip_count ) { // if it isn't already in the list and the list is not longer than trip_count
                            if (timeFormat.equals("absolute")) { // time format
                                busTrips.get(tripId).add(departureTime);
                            } else {
                                busTrips.get(tripId).add(Duration.between(currentTime, stopTime.getDepartureTime()).toMinutes() + " minutes");
                            }
                        }
                    }
                }
        }

        removeEmptyLists(busTrips); // usually i would never do it like this but this time i took the easier way

        for (Map.Entry<String, List<String>> entry : busTrips.entrySet()) {
            String trip = entry.getKey();
            List<String> times = entry.getValue();

            System.out.println( trip + " : " + times);
        }


    }


    public static void main(String[] args){

        calculateAndPrintBusTrips(7, 5, "absolute");

    }
}
