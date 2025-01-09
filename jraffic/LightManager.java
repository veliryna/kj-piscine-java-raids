import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.util.Random;

public class LightManager {
    private final TrafficLight northLight = new TrafficLight(300.0, 200.0);
    private final TrafficLight southLight = new TrafficLight(500.0, 400.0);
    private final TrafficLight eastLight = new TrafficLight(500.0, 200.0);
    private final TrafficLight westLight = new TrafficLight(300.0, 400.0);
    private final Random random = new Random();
    private Timeline lightTimeline;
    private boolean isBufferPeriod = false;

    public LightManager(Pane root) {
        double randomDuration = 1 + (random.nextDouble() * 2);
        root.getChildren().addAll(new Node[]{this.northLight, this.southLight, this.eastLight, this.westLight});
        // Initialize the timeline
        lightTimeline = new Timeline();  // Ensure lightTimeline is instantiated here

        // Start the first light switch
        switchLights();
    }

    private void switchLights() {

        if (isBufferPeriod) {
            // End of buffer period, randomly select one light to turn green
            turnRandomLightGreen();
            isBufferPeriod = false;  // Exit buffer period
        } else {
            // Start buffer period - set all lights to red
            this.northLight.setRed();
            this.southLight.setRed();
            this.eastLight.setRed();
            this.westLight.setRed();

            isBufferPeriod = true;  // Indicate that we are now in the buffer period
        }

        // Randomly select one of the four lights to turn green
        double randomDuration = isBufferPeriod ? 2.0 : 1 + (random.nextDouble() * 2); // 2 seconds buffer or random green duration

        // Reset the timeline for the next switch
        lightTimeline.stop();  // Stop the current timeline
        lightTimeline.getKeyFrames().clear();  // Clear previous key frames

        // Add a new key frame with the random duration
        lightTimeline.getKeyFrames().add(new KeyFrame(Duration.seconds(randomDuration), event -> {
            this.switchLights();  // Switch lights after the random duration
        }));

        lightTimeline.play();
    }

    private void turnRandomLightGreen() {
        int randomLightIndex = random.nextInt(4);  // Generates a number between 0 and 3

        switch (randomLightIndex) {
            case 0:
                this.northLight.setGreen();
                break;
            case 1:
                this.southLight.setGreen();
                break;
            case 2:
                this.eastLight.setGreen();
                break;
            case 3:
                this.westLight.setGreen();
                break;
        }
    }

    public TrafficLight getNorthLight() {
        return this.northLight;
    }

    public TrafficLight getSouthLight() {
        return this.southLight;
    }

    public TrafficLight getEastLight() {
        return this.eastLight;
    }

    public TrafficLight getWestLight() {
        return this.westLight;
    }
}
//public class LightManager {
//    private final TrafficLight northLight = new TrafficLight(300.0, 200.0);
//    private final TrafficLight southLight = new TrafficLight(500.0, 400.0);
//    private final TrafficLight eastLight = new TrafficLight(500.0, 200.0);
//    private final TrafficLight westLight = new TrafficLight(300.0, 400.0);
//
//    public LightManager(Pane root) {
//        root.getChildren().addAll(new Node[]{this.northLight, this.southLight, this.eastLight, this.westLight});
//        Timeline lightTimeline = new Timeline(new KeyFrame[]{new KeyFrame(Duration.seconds(3.0), (event) -> {
//            this.switchLights();
//        }, new KeyValue[0])});
//        lightTimeline.setCycleCount(-1);
//        lightTimeline.play();
//    }
//
//    private void switchLights() {
//        if (this.northLight.isGreen()) {
//            this.northLight.setRed();
//            this.southLight.setRed();
//            this.eastLight.setGreen();
//            this.westLight.setGreen();
//        } else {
//            this.northLight.setGreen();
//            this.southLight.setGreen();
//            this.eastLight.setRed();
//            this.westLight.setRed();
//        }
//
//    }
//
//    public TrafficLight getNorthLight() {
//        return this.northLight;
//    }
//
//    public TrafficLight getSouthLight() {
//        return this.southLight;
//    }
//
//    public TrafficLight getEastLight() {
//        return this.eastLight;
//    }
//
//    public TrafficLight getWestLight() {
//        return this.westLight;
//    }
//}