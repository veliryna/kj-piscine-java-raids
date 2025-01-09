import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class TrafficSimulator extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        // Root pane for the simulation
        Pane root = new Pane();
        // Create the road intersection and add to the root pane
        RoadIntersection intersection = new RoadIntersection();
        root.getChildren().add(intersection);
        // Create the vehicle manager
        VehicleManager vehicleManager = new VehicleManager(root);
        LightManager lightManager = new LightManager(root);
        // Create the traffic simulation with vehicle and traffic light management
        TrafficSimulation simulation = new TrafficSimulation(lightManager, vehicleManager);
        // Set up the scene and stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Traffic Control Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
        // Set focus on the root to receive key inputs
        root.requestFocus();
        // Handle key presses to spawn vehicles and exit simulation
        root.setOnKeyPressed(event -> vehicleManager.handleKeyPress(event));
    }
}