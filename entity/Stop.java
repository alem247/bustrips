package entity;

public class Stop {

    private int stop_id;
    private String stop_name;
    private double stop_lat;
    private double stop_lon;

    public Stop(int stop_id, String stop_name, double stop_lat, double stop_lon) {
        this.stop_id = stop_id;
        this.stop_name = stop_name;
        this.stop_lat = stop_lat;
        this.stop_lon = stop_lon;
    }

    public int getStopId() {
        return stop_id;
    }

    public void setStopId(int stop_id) {
        this.stop_id = stop_id;
    }

    public String getStopName() {
        return stop_name;
    }

    public void setStopName(String stop_name) {
        this.stop_name = stop_name;
    }

    public double getStopLat() {
        return stop_lat;
    }

    public void setStopLat(double stop_lat) {
        this.stop_lat = stop_lat;
    }

    public double getStopLon() {
        return stop_lon;
    }

    public void setStopLon(double stop_lon) {
        this.stop_lon = stop_lon;
    }

    /** AL Masjid Al-nabawi (Clock Roundabout)
     Uhud battlefield
     Al Quiblatain Mosque
     The Trench Battlefield
     AL Masjid Al-nabawi (AL Baqe) */

}
