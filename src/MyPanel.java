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
    int width = 50;
    int height = 100;
    int step = 30;
    int delta = 5;
    private final ArrayList<Rectangle> outlist = new ArrayList<>();
    public void setSymbols(String parm){
        String[] arr = parm.replace( "," , "").split("");
        for (String cifra:arr) {
            switch (cifra) {
                case "1" -> {
                    segment(2);
                    segment(4);
                }
                case "2" -> {
                    segment(1);
                    segment(2);
                    segment(3);
                    segment(6);
                    segment(5);
                }
                case "3" -> {
                    segment(1);
                    segment(2);
                    segment(3);
                    segment(4);
                    segment(6);
                }
            }
            x = x + step + width;
        }

    }
    private void segment(int number){
        switch (number) {
            case 1 -> outlist.add(new Rectangle(x + delta, y, x+width - delta, y));
            case 2 -> outlist.add(new Rectangle(x+width, y + delta,x+width, y + (height / 2) - delta));
            case 3 -> outlist.add(new Rectangle(x + delta, y + height / 2, x+width - delta, y + height / 2));
            case 4 -> outlist.add(new Rectangle(x+width, y + (height / 2) + delta, x+width, y + height - delta));
            case 5 -> outlist.add(new Rectangle(x + delta, y + height, x+width - delta, y + height));
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
