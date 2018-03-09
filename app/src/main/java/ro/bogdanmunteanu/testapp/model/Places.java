package ro.bogdanmunteanu.testapp.model;

//this will hold the combination of location and walks
public class Places {

    private Walk walk;
    private Location location;

    public Places(Walk walk, Location location) {
        this.walk = walk;
        this.location = location;
    }

    public Walk getWalk() {
        return walk;
    }

    public void setWalk(Walk walk) {
        this.walk = walk;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Places{");
        sb.append("walk=").append(walk);
        sb.append(", location=").append(location);
        sb.append('}');
        return sb.toString();
    }
}
