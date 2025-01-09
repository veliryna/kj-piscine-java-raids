import java.awt.*;

class Cube implements Drawable {
    Point center;
    int distance;

    public Cube(Point c, int d) {
        this.center = c;
        this.distance = d;
    }

    @Override
    public void draw(Displayable displayable) {
        Graphics g = ((Image) displayable).graphics;
        g.setColor(getColor());

        //create 2 squares to resemble 3D effect
        int frontLeftX = center.x - distance / 2;
        int frontTopY = center.y - distance / 2;
        int frontRightX = center.x + distance / 2;
        int frontBottomY = center.y + distance / 2;

        int offset = distance / 3;

        int backLeftX = frontLeftX + offset;
        int backTopY = frontTopY - offset;
        int backRightX = frontRightX + offset;
        int backBottomY = frontBottomY - offset;

        //draw those 2 squares
        g.drawRect(frontLeftX, frontTopY, distance, distance);
        g.drawRect(backLeftX, backTopY, distance, distance);


        //connect 2 squares with lines to complete 3D view
        g.drawLine(frontLeftX, frontTopY, backLeftX, backTopY);
        g.drawLine(frontRightX, frontTopY, backRightX, backTopY);
        g.drawLine(frontRightX, frontBottomY, backRightX, backBottomY);
        g.drawLine(frontLeftX, frontBottomY, backLeftX, backBottomY);
    }
}
