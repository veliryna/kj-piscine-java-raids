import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.animation.KeyValue;
import java.util.ArrayList;
import java.util.List;

public class TrafficSimulation {
    private final LightManager lightManager;
    private final VehicleManager vehicleManager;

    public TrafficSimulation(LightManager lightManager, VehicleManager vehicleManager) {
        this.lightManager = lightManager;
        this.vehicleManager = vehicleManager;
        Timeline vehicleTimeline = new Timeline(new KeyFrame[]{new KeyFrame(Duration.millis(50.0), (event) -> {
            this.moveTraffic();
        }, new KeyValue[0])});
        vehicleTimeline.setCycleCount(-1);
        vehicleTimeline.play();
    }

    public void moveTraffic() {
        List<Vehicle> vehicles = this.vehicleManager.getVehicles();
        List<Vehicle> vehiclesToRemove = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {

            boolean carInFront = false;
            TrafficLight eastLight = this.lightManager.getEastLight();
            TrafficLight westLight = this.lightManager.getWestLight();
            TrafficLight northLight = this.lightManager.getNorthLight();
            TrafficLight southLight = this.lightManager.getSouthLight();

            for (Vehicle vehicle2 : vehicles) {

                if (vehicle != vehicle2 && vehicle.getDirection().equals(vehicle2.getDirection())) {

                    if ("east".equals(vehicle.getDirection())) {
                        double xDistance = vehicle.getX() - vehicle2.getX();
                        if (xDistance > 0 && xDistance < 70) {
                            carInFront = true;
                            break;
                        }
                    }
                    if ("west".equals(vehicle.getDirection())) {
                        double xDistance = vehicle2.getX() - vehicle.getX();
                        if (xDistance > 0 && xDistance < 70) {
                            carInFront = true;
                            break;
                        }
                    }

                    if ("north".equals(vehicle.getDirection())) {
                        double yDistance = vehicle2.getY() - vehicle.getY();
                        if (yDistance > 0 && yDistance < 70) {
                            carInFront = true;
                            break;
                        }
                    }
                    if ("south".equals(vehicle.getDirection())) {
                        double yDistance = vehicle.getY() - vehicle2.getY();
                        if (yDistance > 0 && yDistance < 70 ) {
                            carInFront = true;
                            break;
                        }
                    }
                }
            }

            // Traffic light logic
            boolean shouldStopForLight = false;
            if ("west".equals(vehicle.getDirection()) && !westLight.isGreen() && vehicle.getX() == 300 && !vehicle.getTurned()) {
                shouldStopForLight = true;
            } else if ("east".equals(vehicle.getDirection()) && !eastLight.isGreen() && vehicle.getX() == 470 && !vehicle.getTurned()) {
                shouldStopForLight = true;
            } else if ("north".equals(vehicle.getDirection()) && !northLight.isGreen() && vehicle.getY() == 200 && !vehicle.getTurned()) {
                shouldStopForLight = true;
            } else if ("south".equals(vehicle.getDirection()) && !southLight.isGreen() && vehicle.getY() == 370 && !vehicle.getTurned()) {
                shouldStopForLight = true;
            }

            if (shouldStopForLight) {
                vehicle.stop();
            } else if (carInFront) {
                vehicle.stop();
            } else {
                vehicle.move();
            }
            if ("east".equals(vehicle.getDirection()) && vehicle.getX() == -30) {
                vehiclesToRemove.add(vehicle);
            }
            if ("west".equals(vehicle.getDirection()) && vehicle.getX() == 800) {
                vehiclesToRemove.add(vehicle);
            }
            if ("north".equals(vehicle.getDirection()) && vehicle.getY() == 600) {
                vehiclesToRemove.add(vehicle);
            }
            if ("south".equals(vehicle.getDirection()) && vehicle.getY() == -30) {
                vehiclesToRemove.add(vehicle);
            }
        }
        vehicles.removeAll(vehiclesToRemove);
    }
}
