import java.awt.*;

class Pentagon implements Drawable{
    Point center;
    int distance;
    public Pentagon(Point c, int d){
        this.center = c;
        this.distance = d;
    }
    @Override
    public void draw(Displayable displayable) {
        Graphics g = ((Image) displayable).graphics;
        g.setColor(getColor());

        int x1 = center.x;
        int y1 = center.y+distance;
        int x2 = (int) (center.x + distance*Math.sin(2*Math.PI/5));
        int y2 = (int) (center.y + distance*Math.cos(2*Math.PI/5));
        int x3 = (int) (center.x + distance*Math.sin(4*Math.PI/5));
        int y3 = (int) (center.y + distance*Math.cos(4*Math.PI/5));
        int x4 = (int) (center.x + distance*Math.sin(6*Math.PI/5));
        int y4 = (int) (center.y + distance*Math.cos(6*Math.PI/5));
        int x5 = (int) (center.x + distance*Math.sin(8*Math.PI/5));
        int y5 = (int) (center.y + distance*Math.cos(8*Math.PI/5));

        g.drawPolygon(new int[]{x1,x2,x3,x4,x5}, new int[]{y1,y2,y3,y4,y5}, 5);
    }
}
