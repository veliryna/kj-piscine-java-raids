import java.util.Random;

class Point implements Drawable {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static Point random(int width, int height) {
        Random rand = new Random();
        int x = rand.nextInt(width);
        int y = rand.nextInt(height);
        return new Point(x, y);
    }
    @Override
    public void draw(Displayable displayable) {
        displayable.display(x, y);
    }
}