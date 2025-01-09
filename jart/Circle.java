import java.awt.*;
import java.util.Random;

class Circle implements Drawable {
    Point center;
    int radius;
    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void draw(Displayable displayable) {
        Graphics g = ((Image) displayable).graphics;
        g.setColor(getColor());
        g.drawOval(center.x - radius, center.y - radius, radius * 2, radius * 2);
    }
    public static Circle random(int width, int height) {
        Point center = Point.random(width, height);
        Random rand = new Random();
        int radius = rand.nextInt(100);
        return new Circle(center, radius);
    }
}