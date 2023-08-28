package entity;

public class Trip {

    private String trip_id;
    private int route_id;
    private int service_id;
    private int direction_id;
    private String trip_headsign;

    public Trip(String trip_id, int route_id, int service_id, int direction_id, String trip_headsign) {
        this.trip_id = trip_id;
        this.route_id = route_id;
        this.service_id = service_id;
        this.direction_id = direction_id;
        this.trip_headsign = trip_headsign;
    }

    public String getTripId() {
        return trip_id;
    }

    public void setTripId(String trip_id) {
        this.trip_id = trip_id;
    }

    public int getRouteId() {
        return route_id;
    }

    public void setRouteId(int route_id) {
        this.route_id = route_id;
    }

    public int getServiceId() {
        return service_id;
    }

    public void setServiceId(int service_id) {
        this.service_id = service_id;
    }

    public int getDirectionId() {
        return direction_id;
    }

    public void setDirectionId(int direction_id) {
        this.direction_id = direction_id;
    }

    public String getTripHeadsign() {
        return trip_headsign;
    }

    public void setTripHeadsign(String trip_headsign) {
        this.trip_headsign = trip_headsign;
    }



}
