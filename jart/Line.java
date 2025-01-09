import java.awt.*;
class Line implements Drawable {
    Point a;
    Point b;
    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }
    
    public static Line random(int width, int height) {
        return new Line(
                Point.random(width, height),
                Point.random(width, height)
        );
    }
    @Override
    public void draw(Displayable displayable) {
        Graphics g = ((Image) displayable).graphics;
        g.setColor(getColor());
        g.drawLine(a.x, a.y, b.x, b.y);
    }
}