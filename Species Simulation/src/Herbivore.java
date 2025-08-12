import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Herbivore extends JPanel {

    public int RandomSize() {
        Random rand = new Random();
        int randomNum = rand.nextInt(100 - 50 + 1) + 50;
        return randomNum;
    }

    Herbivore() {
        int size = RandomSize();
        this.setSize(size, size);
        this.setBackground(Color.RED);
        this.setLocation(10,10);
    }
}
