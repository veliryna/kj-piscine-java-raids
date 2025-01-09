import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Vehicle extends Rectangle {
    private double velocity;
    private String route; // "left", "right", "straight"
    public boolean hasTurned = false; // Track if the vehicle has completed a turn
    public String direction; // "north", "south", "east", "west"
    //private final TrafficSimulation trafficSimulation;

    public Vehicle(double x, double y, Color color, String route, String direction, boolean hasTurned/*, TrafficSimulation trafficSimulation*/) {
        super(30, 30, color); // Vehicle size and color
        //this.trafficSimulation = trafficSimulation;
        this.setX(x);
        this.setY(y);
        this.velocity = 5; // Fixed velocity
        this.route = route;
        this.direction = direction;
        this.hasTurned = hasTurned;
    }
    public void stop() {
        this.velocity = 0.0;
    }
    public void move() {

        switch (route) {
            case "left":
                if (!this.hasTurned && isInIntersection()) {
                    // Perform the left turn once at the intersection
                    if (direction.equals("south") && getY() == 260) {
                        this.route = "straight";
                        this.hasTurned = true;
                        turnLeft();
                    } else if (direction.equals("north") && getY() == 310) {
                        this.hasTurned = true;
                        this.route = "straight";
                        turnLeft();
                    } else if (direction.equals("east") && getX() == 410) {
                        this.hasTurned = true;
                        this.route = "straight";
                        turnLeft();
                    } else if (direction.equals("west") && getX() == 360) {
                        this.hasTurned = true;
                        this.route = "straight";
                        turnLeft();
                    }
                }
                break;
            case "right":
                if (!this.hasTurned && isInIntersection()) {
                    // Perform the right turn once at the intersection
                    if (direction.equals("south") && getY() == 310) {
                        this.hasTurned = true;
                        this.route = "straight";
                        turnRight();
                    } else if (direction.equals("north") && getY() == 260) {
                        this.hasTurned = true;
                        this.route = "straight";
                        turnRight();
                    } else if (direction.equals("east") && getX() == 360) {
                        this.hasTurned = true;
                        this.route = "straight";
                        turnRight();
                    } else if (direction.equals("west") && getX() == 410) {
                        this.hasTurned = true;
                        this.route = "straight";
                        turnRight();
                    }
                }
                break;
        }
        goStraight();
    }
    private void goStraight() {
        // Move straight based on the initial direction (north, south, east, west)
        this.velocity = 5;
        switch (direction) {
            case "north":
                setY(getY() + velocity); // Moving north to south
                break;
            case "south":
                setY(getY() - velocity); // Moving south to north
                break;
            case "east":
                setX(getX() - velocity); // Moving east to west
                break;
            case "west":
                setX(getX() + velocity); // Moving west to east
                break;
        }
    }
    private void turnLeft() {
        // Handle the left turn based on the direction the vehicle is coming from
        switch (direction) {
            case "north":
                this.direction = "west";
                //setX(getX() - velocity); // Turn left from north to west
                break;
            case "south":
                this.direction = "east";
                //setX(getX() + velocity); // Turn left from south to east
                break;
            case "east":
                this.direction = "south";
                //setY(getY() - velocity); // Turn left from east to north
                break;
            case "west":
                this.direction = "north";
                //setY(getY() + velocity); // Turn left from west to south
                break;
        }
    }
    private void turnRight() {
        // Handle the right turn based on the direction the vehicle is coming from
        switch (direction) {
            case "north":
                this.direction = "east";
                //setX(getX() + velocity); // Turn right from north to east
                break;
            case "south":
                this.direction = "west";
                //setX(getX() - velocity); // Turn right from south to west
                break;
            case "east":
                this.direction = "north";
                //setY(getY() + velocity); // Turn right from east to south
                break;
            case "west":
                this.direction = "south";
                //setY(getY() - velocity); // Turn right from west to north
                break;
        }
    }
    private boolean isInIntersection() {
        // Check if the vehicle is at the intersection (rough check based on coordinates)
        return getX() >= 300 && getX() <= 450 && getY() >= 250 && getY() <= 350;
    }
    public String getDirection() {
        return this.direction;
    }
    public String getRoute() {
        return this.route;
    }
    public boolean getTurned() {
        return this.hasTurned;
    }
}
