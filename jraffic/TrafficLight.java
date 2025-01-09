import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TrafficLight extends Circle {
    private boolean isGreen;

    public TrafficLight(double x, double y) {
        setRadius(15);
        setCenterX(x);
        setCenterY(y);
        setFill(Color.RED); // Start with a red light
        isGreen = false;
    }

    // Switch the light between red and green
    public void switchLight() {
        if (isGreen) {
            setRed();
        } else {
            setGreen();
        }
    }

    // Explicitly set the light to green
    public void setGreen() {
        setFill(Color.GREEN);
        isGreen = true;
    }

    // Explicitly set the light to red
    public void setRed() {
        setFill(Color.RED);
        isGreen = false;
    }

    // Check if the light is currently green
    public boolean isGreen() {
        return isGreen;
    }
}
