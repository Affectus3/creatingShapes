import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame {
    static JTextField[] textFields;
    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        MyPanel myPanel = new MyPanel();


        JButton lineBtn = new JButton("Line");
        lineBtn.setBounds(40,20,100,30);
        JButton rectangleBtn = new JButton("Rectangle");
        rectangleBtn.setBounds(190,20,100,30);
        JButton circleBtn = new JButton("Circle");
        circleBtn.setBounds(340,20,100,30);
        JButton drawBtn = new JButton("Draw");
        drawBtn.setBounds(190,370,100,30);

        frame.add(lineBtn);
        frame.add(rectangleBtn);
        frame.add(circleBtn);
        frame.add(drawBtn);


        textFields = new JTextField[4];
        for(int i = 0; i <= 3; i++){
            textFields[i] = new JTextField(i);
        }
        String[] lineTextFieldSetText = new String[]{"Enter x1", "Enter y1", "Enter x2", "Enter y2"};
        int[][] lineTextFieldBounds = new int[][]{
                {40,100,80,20},
                {40,150,80,20},
                {40,200,80,20},
                {40,250,80,20}
        };
        String[] rectTextFieldSetText = new String[]{"Enter x", "Enter y", "Enter width", "Enter height"};
        int[][] rectTextFieldBounds = new int[][]{
                {190,100,80,20},
                {190,150,80,20},
                {190,200,80,20},
                {190,250,80,20}
        };
        String[] circleTextFieldSetText = new String[]{"Enter x", "Enter y", "Enter width", "Enter height"};
        int[][] circleTextFieldBounds = new int[][]{
                {340,100,80,20},
                {340,150,80,20},
                {340,200,80,20},
                {340,250,80,20}
        };

        lineBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setFieldText(frame, textFields, lineTextFieldBounds, lineTextFieldSetText);
            }
        });

        rectangleBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setFieldText(frame, textFields, rectTextFieldBounds, rectTextFieldSetText);
            }
        });
        circleBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setFieldText(frame, textFields, circleTextFieldBounds, circleTextFieldSetText);
            }
        });

        drawBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                getFieldText();
            }
        });

        frame.getContentPane().add(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setBackground(Color.white);
    }
    private static void setFieldText(JFrame frame, JTextField[] textFields, int[][] textFieldBounds, String[] textFieldSetText){
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j < 1; j++){
                textFields[i].setBounds(textFieldBounds[i][j], textFieldBounds[i][j+1], textFieldBounds[i][j+2], textFieldBounds[i][j+3]);
                textFields[i].setText(textFieldSetText[i]);
            }
            frame.add(textFields[i]);
        }
    }
    public static fieldText getFieldText(){
        int[] arrays =  new int[4];
        for (int i = 0; i <= 3; i++){
            arrays[i] = Integer.parseInt(textFields[i].getText());
        }return new fieldText(arrays);
    }
}
