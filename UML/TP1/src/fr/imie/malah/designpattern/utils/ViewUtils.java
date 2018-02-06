package fr.imie.malah.designpattern.utils;

import javax.swing.*;
import java.awt.*;

public class ViewUtils {
    /**
     * Configure the jFrame and the jPanel
     *
     * @param frame
     *            a JFrame to configure
     *
     */
    public static void configure(JFrame frame) {
        int frameWidth = 1000;
        int frameHeight = 600;
        int maxFrameWidth = 1500;
        int maxFrameHeight = 900;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(frameWidth, frameHeight));
        frame.setMaximumSize(new Dimension(maxFrameWidth, maxFrameHeight));
        center(frame);
        EventQueue.invokeLater(() -> {
            try {
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        frame.setContentPane(new JPanel());
    }

    /**
     * Center a frame
     *
     * @param frame
     */
    public static void center(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        int posWidth = (screenWidth - frame.getWidth()) / 2;
        int posHeight = (screenHeight - frame.getHeight()) / 2;
        frame.setBounds(posWidth, posHeight, frame.getWidth(), frame.getHeight());
    }
}
