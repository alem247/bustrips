package entity;

public class Route {

    private int route_id;
    private String route_short_name;
    private String route_long_name;
    private int route_type;

    public Route(int route_id, String route_short_name, String route_long_name, int route_type) {
        this.route_id = route_id;
        this.route_short_name = route_short_name;
        this.route_long_name = route_long_name;
        this.route_type = route_type;
    }

    public int getRouteId() {
        return route_id;
    }

    public void setRouteId(int route_id) {
        this.route_id = route_id;
    }

    public String getRouteShortName() {
        return route_short_name;
    }

    public void setRouteShortName(String route_short_name) {
        this.route_short_name = route_short_name;
    }

    public String getRouteLongName() {
        return route_long_name;
    }

    public void setRouteLongName(String route_long_name) {
        this.route_long_name = route_long_name;
    }

    public int getRouteType() {
        return route_type;
    }

    public void setRouteType(int route_type) {
        this.route_type = route_type;
    }


}
