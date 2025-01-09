import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class Image implements Displayable {
    BufferedImage img;
    Graphics graphics;
    public Image(int width, int height) {
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics = img.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, width, height);
    }
    @Override
    public void display(int x, int y) {
        graphics.fillRect(x, y, 1, 1);
    }
    @Override
    public void save(String filename) {
        try {
            ImageIO.write(img, "png", new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getWidth() {
        return img.getWidth();
    }
    public int getHeight() {
        return img.getHeight();
    }
}