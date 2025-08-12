import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainScreen extends JFrame implements KeyListener {
    Herbivore herbivorePanel;
    Image image;

    MainScreen() {
        image = new ImageIcon(getClass().getResource("resources\\grassImage.png")).getImage();

        this.setTitle("Main Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.addKeyListener(this);
        this.setResizable(false);
        this.setAlwaysOnTop(false);

        herbivorePanel = new Herbivore();

        this.add(herbivorePanel);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(image, 0, 0, this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //paint(this.getGraphics());
        //repaint();
    }

    public int CheckBorderPosition(int x, int y) {
        if (x == 1000 || y == 10) {
            return 0;
        } else {
            System.out.println("X: " + x + " Y: " + y + " | " + " x: " + this.getX() + " y: " + "10");
            paint(this.getGraphics());
            return 1;
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
                System.out.println("w");
                int checkBorder = CheckBorderPosition(herbivorePanel.getX(), herbivorePanel.getY());
                if (checkBorder == 0) {
                    System.out.println("END");
                    herbivorePanel.setLocation(herbivorePanel.getX(), herbivorePanel.getY());
                    paint(herbivorePanel.getGraphics());
                    break;
                } else {
                    herbivorePanel.setLocation(herbivorePanel.getX(), herbivorePanel.getY()-10);
                    break;
                }
            case 's':
                System.out.println("s");
                herbivorePanel.setLocation(herbivorePanel.getX(), herbivorePanel.getY()+10);
                paint(herbivorePanel.getGraphics());
                break;
            case 'a':
                System.out.println("a");
                herbivorePanel.setLocation(herbivorePanel.getX()-10, herbivorePanel.getY());
                break;
            case 'd':
                System.out.println("d");
                herbivorePanel.setLocation(herbivorePanel.getX()+10, herbivorePanel.getY());
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
