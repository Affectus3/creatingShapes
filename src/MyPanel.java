import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;

public class MyPanel extends JPanel {


    static Graphics2D g2;

    public void paintComponent(Graphics g) {

        g2 = (Graphics2D) g;
        super.paintComponent(g2);

        try {
            int[] inputs = MyFrame.getFieldText(MyFrame.Shapes);
            drawShape();

        }catch (Exception ex){
            ex.getStackTrace();
        }

        g2.translate(100.0f,200.0f);
        g2.scale(1.2f,1.2f);
        g2.setColor(Color.PINK);
        g2.setStroke(new BasicStroke(6.0f));

    }

    public static void drawShape(MyFrame.Shapes shape){
        switch (shape){
            case LINE:
                Shape drawingLine = new Line2D.Double(0,-40,0,-90);   //It's drawn with using the Library Classes(all top shapes were drawn using Direct library classes)
                g2.draw(drawingLine);
                break;
            case RECTANGLE:
                Shape drawingRectangle = new Rectangle(50,-90,50,50);   //It's drawn with using the Library Classes
                g2.draw(drawingRectangle);
                break;
            case CIRCLE:
                Shape drawingCircle = new Ellipse2D.Double(140, -90, 50, 50);    //It's drawn with using the Library Classes
                g2.draw(drawingCircle);
                break;
            default:
        }
    }
}