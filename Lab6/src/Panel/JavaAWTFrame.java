package Panel;

import javax.swing.*;
import java.awt.*;


public class JavaAWTFrame extends JFrame {

    public JavaAWTFrame() {

        setSize(new Dimension(720, 720));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel p = new MyPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                this.paint(g2);
            }
        };
        setTitle("My Shapes");
        this.getContentPane().add(p);
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JavaAWTFrame();
            }
        });
    }
}
