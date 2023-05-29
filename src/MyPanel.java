import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class MyPanel extends JPanel {
    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(1560,700));
    }
    public Dimension getPrefferedSize() {
        return new Dimension(1560,700);
    }
    private int x = 100;
    private int y = 100;
    private int width = 50;
    private int height = 100;
    private int step = 30;
    private int delta = 3;

    private ArrayList<Rectangle> outlist = new ArrayList<Rectangle>();

    public void setSymbols(String parm){
        String[] arr = parm.replace(",", "").split(" ");
        outlist.clear();
        for (String cifra: arr){
            switch (cifra){
                case "К":
                    segment(6);
                    segment(7);
                    segment(8);
                    segment(9);
                    break;
                case "к":
                    segment(6);
                    segment(10);
                    segment(11);
                    break;
                case "Л":
                    segment(1);
                    segment(2);
                    segment(4);
                    segment(6);
                    segment(7);
                    segment(12);
                    break;
                case "л":
                    segment(3);
                    segment(4);
                    segment(6);
                    segment(12);
                    break;
                case "М":
                    segment(2);
                    segment(4);
                    segment(6);
                    segment(7);
                    segment(13);
                    segment(14);
                    break;
                case "м":
                    segment(4);
                    segment(6);
                    segment(15);
                    segment(16);
                    break;
                case "Ь":
                    segment(3);
                    segment(4);
                    segment(5);
                    segment(6);
                    segment(7);
                    break;
                case "ь":
                    segment(6);
                    segment(17);
                    segment(18);
                    segment(19);
                    break;
                case "Ъ":
                    segment(3);
                    segment(4);
                    segment(5);
                    segment(6);
                    segment(7);
                    segment(20);
                    break;
                case "ъ":
                    segment(6);
                    segment(17);
                    segment(18);
                    segment(19);
                    segment(21);
                    break;
            }
            x = x + step + width;
        }
    }
    public void segment(int number){
        switch (number) {
            case 1: outlist.add(new Rectangle(x + delta, y, x+ width - delta, y));
                break;
            case 3: outlist.add(new Rectangle(x + delta, y + height / 2, x + width - delta, y + height / 2));
                break;
            case 5: outlist.add(new Rectangle(x + delta, y + height, x + width - delta, y + height));
                break;
            case 2: outlist.add(new Rectangle(x + width, y + delta, x + width, y + (height / 2) - delta));
                break;
            case 4: outlist.add(new Rectangle(x + width, y + (height / 2) + delta, x + width, y + height - delta));
                break;
            case 6: outlist.add(new Rectangle(x, y + (height / 2) + delta, x, y + height - delta));
                break;
            case 7: outlist.add(new Rectangle(x, y + delta, x, y + (height / 2) - delta));
                break;

            case 8:
                outlist.add(new Rectangle(x, y + height / 2 ,x + width - delta, y));
                break;
            case 9:
                outlist.add(new Rectangle(x, y + height / 2 ,x + width - delta, y + height));
                break;
            case 10:
                outlist.add(new Rectangle(x, y + height / 2 + (height / 4) ,x + (width / 2) - delta + 5, y + height / 2));
                break;
            case 11:
                outlist.add(new Rectangle(x, y + height / 2 + (height / 4) ,x + (width / 2) - delta + 5, y + height));
                break;
            case 12:
                outlist.add(new Rectangle(x + delta - 3, y + height, x - 8 - delta, y + height));
                break;
            case 13:
                outlist.add(new Rectangle(x + delta, y, x + (width / 2) - delta + 3, y + height / 2));
                break;
            case 14:
                outlist.add(new Rectangle(x + (width / 2) - delta + 3, y + height / 2, x + width - delta, y));
                break;
            case 15:
                outlist.add(new Rectangle(x + delta, y + height / 2, x + (width / 2) - delta + 3, y + height));
                break;
            case 16:
                outlist.add(new Rectangle(x + (width / 2) - delta + 3, y + height, x + width - delta, y + height / 2));
                break;
            case 17:
                outlist.add(new Rectangle(x, y + height / 2 + (height / 4) ,x + (width / 2) - delta, y + height / 2 + (height / 4)));
                break;
            case 18:
                outlist.add(new Rectangle(x + (width / 2) - delta, y + height / 2 + (height / 4) ,x + (width / 2) - delta, y + height));
                break;
            case 19:
                outlist.add(new Rectangle(x, y + height ,x + (width / 2) - delta, y + height));
                break;
            case 20:
                outlist.add(new Rectangle(x + delta - 3, y, x - 5 - delta, y));
                break;
            case 21:
                outlist.add(new Rectangle(x + delta - 3, y + height / 2, x - 5 - delta, y + height / 2));
                break;
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Rectangle rect: outlist) {
            g.drawLine(rect.x, rect.y, rect.width, rect.height);
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setStep(int step) {
        this.step = step;
    }
}