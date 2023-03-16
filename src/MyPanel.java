import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {return new Dimension(1500, 700);}

    int x = 100;
    int y = 100;
    int width = 200;
    int height = 200;
    int delta = 10;
    private final ArrayList<Rectangle> outlist = new ArrayList<>();
    public void setSymbols(String ignoredParm){
        segment(1);
        segment(2);
        segment(3);
        segment(4);
        segment(5);
        segment(6);
        segment(7);
    }
    private void segment(int number){
        switch (number) {
            case 1 -> outlist.add(new Rectangle(x + delta, y, width - delta, y));
            case 2 -> outlist.add(new Rectangle(width, y + delta, width, y + (height / 2) - delta));
            case 3 -> outlist.add(new Rectangle(x + delta, y + height / 2, width - delta, y + height / 2));
            case 4 -> outlist.add(new Rectangle(width, y + (height / 2) + delta, width, y + height - delta));
            case 5 -> outlist.add(new Rectangle(x + delta, y + height, width - delta, y + height));
            case 6 -> outlist.add(new Rectangle(x, y + (height / 2) + delta, x, y + (height / 2) - delta));
            case 7 -> outlist.add(new Rectangle(x, y + delta, x, y + (height / 2) - delta));
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Rectangle rect:outlist){
            g.drawLine(rect.x,rect.y,rect.width,rect.height);

        }
     }
}


