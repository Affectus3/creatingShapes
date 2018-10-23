import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame {
    static JTextField textField1;
    static JTextField textField2;
    static JTextField textField3;
    static JTextField textField4;
    public enum Shapes { LINE, RECTANGLE, CIRCLE }
    static Shapes shape = Shapes.LINE;

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


        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();

        //Setting textfields for the line button
        String[] lineTextFieldSetText = new String[]{"Enter x1", "Enter y1", "Enter x2", "Enter y2"};
        int[][] lineTextFieldBounds = new int[][]{
                {40,100,80,20},
                {40,150,80,20},
                {40,200,80,20},
                {40,250,80,20}
        };

        //Setting textfields for the rectangle button
        String[] rectTextFieldSetText = new String[]{"Enter x", "Enter y", "Enter width", "Enter height"};
        int[][] rectTextFieldBounds = new int[4][4];

        //Setting textfields for the circle button
        String[] circleTextFieldSetText = new String[]{"Enter x", "Enter y", "Enter width", "Enter height"};
        int[][] circleTextFieldBounds = new int[4][4];


        for(int i = 0; i <= 3; i++){
            for (int j = 0; j <= 3; j++){
                if((i == 0 && j == 0) || (i == 1 && j == 0) || (i == 2 && j == 0) || (i == 3 && j ==0)){
                    rectTextFieldBounds[i][j] = lineTextFieldBounds[i][j] + 150;
                    circleTextFieldBounds[i][j] = lineTextFieldBounds[i][j] + 300;
                }
                else{
                    rectTextFieldBounds[i][j] = lineTextFieldBounds[i][j];
                    circleTextFieldBounds[i][j] = lineTextFieldBounds[i][j];
                }
            }
        }
        setVisible(false);
        frame.add(textField1);
        frame.add(textField2);
        frame.add(textField3);
        frame.add(textField4);

        lineBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed (MouseEvent e) {
                setVisible(false);
                setTextandBounds(lineTextFieldSetText, lineTextFieldBounds);
                shape = Shapes.LINE;
                setVisible(true);
            }
        });

        rectangleBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                setTextandBounds(rectTextFieldSetText, rectTextFieldBounds);
                 shape = Shapes.RECTANGLE;
                setVisible(true);
            }
        });
        circleBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                setTextandBounds(circleTextFieldSetText, circleTextFieldBounds);
                shape = Shapes.CIRCLE;
                setVisible(true);
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

    public static int[] getFieldText(){
        int[] array = new int[4];
        array[0] = Integer.parseInt(textField1.getText());
        array[1] = Integer.parseInt(textField2.getText());
        array[2] = Integer.parseInt(textField3.getText());
        array[3] = Integer.parseInt(textField4.getText());

        return array.clone();
    }

    public static void setVisible(boolean set){
        textField1.setVisible(set);
        textField2.setVisible(set);
        textField3.setVisible(set);
        textField4.setVisible(set);
    }

    public static void setTextandBounds(String[] texts, int[][] bounds){
        for(int i = 0; i < 1; i++){
            textField1.setText(texts[i]);
            textField2.setText(texts[i + 1]);
            textField3.setText(texts[i + 2]);
            textField4.setText(texts[i + 3]);
            textField1.setBounds(bounds[i][i], bounds[i][i + 1], bounds[i][i + 2], bounds[i][i + 3]);
            textField2.setBounds(bounds[i + 1][i], bounds[i + 1][i + 1], bounds[i + 1][i + 2], bounds[i + 1][i + 3]);
            textField3.setBounds(bounds[i + 2][i], bounds[i + 2][i + 1], bounds[i + 2][i + 2], bounds[i + 2][i + 3]);
            textField4.setBounds(bounds[i + 3][i], bounds[i + 3][i + 1], bounds[i + 3][i + 2], bounds[i + 3][i + 3]);
        }
    }
}
