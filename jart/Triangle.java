import java.awt.*;

class Triangle implements Drawable {
    Point a;
    Point b;
    Point c;
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public void draw(Displayable displayable) {
        Graphics g = ((Image) displayable).graphics;
        g.setColor(getColor());
        int[] xPoints = {a.x, b.x, c.x};
        int[] yPoints = {a.y, b.y, c.y};
        g.drawPolygon(xPoints, yPoints, 3);
    }
}
