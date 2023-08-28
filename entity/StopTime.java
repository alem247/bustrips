package entity;

import java.time.LocalTime;

public class StopTime {

    public String trip_id;
    public int stop_sequence;
    public int stop_id;
    public LocalTime arrival_time;
    public LocalTime departure_time;

    public StopTime(String trip_id, int stop_sequence, int stop_id, LocalTime arrival_time, LocalTime departure_time) {
        this.trip_id = trip_id;
        this.stop_sequence = stop_sequence;
        this.stop_id = stop_id;
        this.arrival_time = arrival_time;
        this.departure_time = departure_time;
    }

    public String getTripId() {
        return trip_id;
    }

    public void setTripId(String trip_id) {
        this.trip_id = trip_id;
    }

    public int getStopSequence() {
        return stop_sequence;
    }

    public void setStopSequence(int stop_sequence) {
        this.stop_sequence = stop_sequence;
    }

    public int getStopId() {
        return stop_id;
    }

    public void setStopId(int stop_id) {
        this.stop_id = stop_id;
    }

    public LocalTime getArrivalTime() {
        return arrival_time;
    }

    public void setArrivalTime(LocalTime arrival_time) {
        this.arrival_time = arrival_time;
    }

    public LocalTime getDepartureTime() {
        return departure_time;
    }

    public void setDepartureTime(LocalTime departure_time) {
        this.departure_time = departure_time;
    }

}
