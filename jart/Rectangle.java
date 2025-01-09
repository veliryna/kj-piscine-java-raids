import java.awt.*;

class Rectangle implements Drawable {
    Point a;
    Point b;
    public Rectangle(Point a, Point b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public void draw(Displayable displayable) {
        Graphics g = ((Image) displayable).graphics;
        g.setColor(getColor());
        g.drawRect(a.x, a.y, Math.abs(b.x - a.x), Math.abs(b.y - a.y));
    }
}
