import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Chaikin {
    public static void transformPoints () {
        List<Point> currentPoints = Canvas.getPoints();
        List<Point> newPoints = new ArrayList<>();

        for (int i = 0; i < currentPoints.size() - 1; i++) {
            Point p0 = currentPoints.get(i);
            Point p1 = currentPoints.get(i + 1);

            Point q = new Point(
                    (int) (0.75 * p0.x + 0.25 * p1.x),
                    (int) (0.75 * p0.y + 0.25 * p1.y)
            );
            Point r = new Point(
                    (int) (0.25 * p0.x + 0.75 * p1.x),
                    (int) (0.25 * p0.y + 0.75 * p1.y)
            );

            newPoints.add(q);
            newPoints.add(r);
        }
        Canvas.setPoints(newPoints);
    }
}
