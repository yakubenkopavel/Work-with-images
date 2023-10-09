package bsu.Study.reading;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import bsu.Study.reading.ReadingFile;

public class OutputImage {

    public static void output(BufferedImage bImage){
        JFrame frame = new JFrame();
        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bImage, 0, 0, null);
            }
        };


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(bImage.getWidth(), bImage.getHeight());
        frame.add(pane);
        frame.setVisible(true);
    }
}
