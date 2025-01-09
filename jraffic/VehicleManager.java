import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class VehicleManager {
    private List<Vehicle> vehicles = new ArrayList<>();
    private Pane root;
    private Random random = new Random(); // For random route and direction generation
    public VehicleManager(Pane root) {
        this.root = root;
    }
    // Handle keyboard input to spawn vehicles at the correct position
    public void handleKeyPress(KeyEvent event) {
        Vehicle vehicle = null;
        String route = getRandomRoute(); // Each vehicle gets a random route
        // Handle direction keys

        if (event.getCode() == KeyCode.UP && vehicles.size() < 8) {
            vehicle = new Vehicle(410, 500, Color.BLUE, route, "south", false); // Coming from the south
        } else if (event.getCode() == KeyCode.DOWN && vehicles.size() < 8) {
            vehicle = new Vehicle(360, 0, Color.RED, route, "north", false); // Coming from the north
        } else if (event.getCode() == KeyCode.LEFT && vehicles.size() < 8) {
            vehicle = new Vehicle(700, 260, Color.YELLOW, route, "east", false); // Coming from the east
        } else if (event.getCode() == KeyCode.RIGHT && vehicles.size() < 8) {
            vehicle = new Vehicle(50, 310, Color.GREEN, route, "west", false); // Coming from the west
        } else if (event.getCode() == KeyCode.R && vehicles.size() < 8) {
            // Spawn from a random direction
            int direction = random.nextInt(4);
            switch (direction) {
                case 0:
                    vehicle = new Vehicle(410, 500, Color.BLUE, route, "south", false); // From the south
                    break;
                case 1:
                    vehicle = new Vehicle(360, 0, Color.RED, route, "north", false); // From the north
                    break;
                case 2:
                    vehicle = new Vehicle(700, 260, Color.YELLOW, route, "east", false); // From the east
                    break;
                case 3:
                    vehicle = new Vehicle(50, 310, Color.GREEN, route, "west", false); // From the west
                    break;
            }
        } else if (event.getCode() == KeyCode.ESCAPE) {
            // Exit the simulation
            System.exit(0);
        } else if (event.getCode() == KeyCode.SPACE) {
            // Clear all vehicles when Spacebar is pressed
            clearAllVehicles();
        }
        // Add the new vehicle to the simulation if created
        if (vehicle != null) {
            vehicles.add(vehicle);
            root.getChildren().add(vehicle);
        }
    }
    // Move vehicles on each frame update
    /*public void moveVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }*/
    // Clear all vehicles from the scene and the list
    private void clearAllVehicles() {
        for (Vehicle vehicle : vehicles) {
            root.getChildren().remove(vehicle); // Remove from Pane
        }
        vehicles.clear(); // Clear the list
    }
    // Randomly choose a route for each vehicle
    private String getRandomRoute() {
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return "straight";
            case 1:
                return "left";
            case 2:
                return "right";
        }
        return "straight"; // Default to straight if something goes wrong
    }
    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }
}