import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;

public class MyPanel extends JPanel {


    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);

        try {
            fieldText fieldText1 = MyFrame.getFieldText();
            System.out.println(fieldText1);
        }catch (Exception ex){
            ex.getStackTrace();
        }

        Shape drawingLine = new Line2D.Double(0,-40,0,-90);   //It's drawn with using the Library Classes(all top shapes were drawn using Direct library classes)
        Shape drawingRectangle = new Rectangle(50,-90,50,50);   //It's drawn with using the Library Classes
        Shape drawingCircle = new Ellipse2D.Double(140, -90, 50, 50);    //It's drawn with using the Library Classes
        g2.translate(100.0f,200.0f);
        g2.scale(1.2f,1.2f);

        g2.setColor(Color.PINK);
        g2.setStroke(new BasicStroke(6.0f));
        g2.draw(drawingLine);
        g2.draw(drawingRectangle);
        g2.draw(drawingCircle);

    }
}