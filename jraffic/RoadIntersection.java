import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RoadIntersection extends Pane {

    public RoadIntersection() {
        // Horizontal and vertical roads with two lanes in each direction
        Rectangle roadHorizontal = new Rectangle(0, 250, 800, 100);
        Rectangle roadVertical = new Rectangle(350, 0, 100, 600);

        roadHorizontal.setFill(Color.GRAY);
        roadVertical.setFill(Color.GRAY);

        // Add the roads to the pane
        getChildren().addAll(roadHorizontal, roadVertical);

        // Traffic lights for each direction
        TrafficLight northLight = new TrafficLight(300, 200);
        TrafficLight southLight = new TrafficLight(500, 400);
        TrafficLight eastLight = new TrafficLight(500, 200);
        TrafficLight westLight = new TrafficLight(300, 400);

        // Add the traffic lights to the pane
        getChildren().addAll(northLight, southLight, eastLight, westLight);
    }
}
