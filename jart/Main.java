import java.awt.*;
import java.util.Random;

interface Displayable {
    void display(int x, int y);
    void save(String string);
}

interface Drawable {
    void draw(Displayable displayable);
    default Color getColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
}

public class Main {
    public static void main(String[] args) {

        Image image = new Image(1000, 1000);

        Rectangle rectangle = new Rectangle(Point.random(image.getWidth(), image.getHeight()),
            Point.random(image.getWidth(), image.getHeight()));
        rectangle.draw(image);

        Triangle triangle = new Triangle(Point.random(image.getWidth(), image.getHeight()),
            Point.random(image.getWidth(), image.getHeight()),
            Point.random(image.getWidth(), image.getHeight()));
        triangle.draw(image);

        for (int i = 0; i < 50; i++) {
            Circle circle = Circle.random(image.getWidth(), image.getHeight());
            circle.draw(image);
        }

        for(int i = 0; i < 5; i++){
            Pentagon pentagon = new Pentagon(
                    Point.random(image.getWidth(), image.getHeight()),
                    new Random().nextInt(200)
            );
            pentagon.draw(image);
        }

        for(int i = 0; i < 5; i++){
            Cube cube = new Cube(Point.random(image.getWidth(), image.getHeight()), new Random().nextInt(300));
            cube.draw(image);
        }

        for(int i = 0; i < 3; i++) {
            Line line = new Line(
                    Point.random(image.getWidth(), image.getHeight()),
                    Point.random(image.getWidth(), image.getHeight())
            );
            line.draw(image);
        }

        image.save("image.png");
    }
}
