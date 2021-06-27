package zork;

public class Location {

    // Row and column positions.
    private Location left;
    private Location right;
    private Location up;
    private Location down;
    private String nameOfLocation;

    public Location(String name, Location left, Location right, Location up, Location down) {
        this.nameOfLocation = name;
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
    }

    public Location getLeft() {
        return left;
    }

    public Location getRight() {
        return right;
    }

    public Location getUp() {
        return up;
    }

    public Location getDown() {
        return down;
    }

    public String getNameOfLocation() {
        return nameOfLocation;
    }
}
