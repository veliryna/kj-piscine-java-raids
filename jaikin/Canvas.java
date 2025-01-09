import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
    private static List<Point> points, originalPoints;
    private boolean drawLines;
    private Timer animationTimer;
    private Point selectedPoint = null;
    private static final int POINT_RADIUS = 10;

    public Canvas() {
        points = new ArrayList<>();
        originalPoints = new ArrayList<>();
        setBackground(Color.BLACK);
        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        addMouseMotionListener(this);
        requestFocusInWindow();
    }

    public static List<Point> getPoints() { return points; }
    public static void setPoints(List<Point> newPoints) { points = newPoints; }
    public static void setOriginalPoints(List<Point> newPoints) { originalPoints = newPoints; }

    public void paintComponent(Graphics g) {
        // drawing points and lines
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        for (Point point : points) {
            g.fillOval(point.x - 5, point.y - 5, 10, 10);
        }
        if (drawLines && points.size() > 1) {
            for (int i = 0; i < points.size() - 1; i++) {
                Point p1 = points.get(i);
                Point p2 = points.get(i + 1);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }

    public void drawLine(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            points.add(e.getPoint());
            repaint();
        }
    }

    public void drawAnimation() {
        animationTimer = new Timer(1000, new ActionListener() {
            int step = 0;

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (step < 7) {
                    Chaikin.transformPoints();
                    repaint();
                    step++;
                } else {
                    animationTimer.stop();
                    drawLines = false;
                }
            }
        });
        animationTimer.start();
    }
    
    public void cleanCanvas() {
        points.clear();
        originalPoints.clear();
        drawLines = false;
        if (animationTimer != null && animationTimer.isRunning()) {
            animationTimer.stop();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        // chaikin algorithm animation
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(!points.isEmpty()) {
                setOriginalPoints(points);
                drawLines = true;
                repaint();
                if(points.size() > 2) {
                    drawAnimation();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Draw some points for Chaikin algorithm animation");
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_R) {
            cleanCanvas();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            if (animationTimer == null || !animationTimer.isRunning()) {
                if (!originalPoints.isEmpty()) {
                    setPoints(originalPoints);
                }
                selectedPoint = getSelectedPoint(e.getPoint());
                drawLines = false;
                if (selectedPoint == null) {
                    drawLine(e); 
                }
            }
        } else {
            points.remove(getSelectedPoint(e.getPoint()));
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        selectedPoint = null;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (selectedPoint != null) {
            selectedPoint.setLocation(e.getPoint());
            repaint(); 
        }
    }

    private Point getSelectedPoint(Point clickPoint) {
        for (Point point : points) {
            if (clickPoint.distance(point) < POINT_RADIUS) {
                return point; 
            }
        }
        return null; 
    }

    // interfaces methods
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void mouseMoved(MouseEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Chaikin's Algorithm");
            Canvas canvas = new Canvas();
            frame.add(canvas);
            frame.setSize(700, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
