package com.toprak.main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by toprak on 3/1/2017.
 */
public class RotationMatrix {
    final BufferedImage image;
    BufferedImage rotatedImage;
    final String rotateFrom;
    JFrame frame = new JFrame();
    double width;
    double heigth;

    public RotationMatrix(BufferedImage image, String rotateFrom) {
        this.image = image;
        this.rotateFrom = rotateFrom;
    }

    public void rotatePicture(int degree) {
        calculateDimensions();
        rotate(degree);
    }

    private void rotate(int degree) {

        rotatedImage = reshapePicture(image, (int) width, (int) heigth);
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                rotatedImage.setRGB(i, j, 0);
            }
        }

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                rotatedImage.setRGB((int) (oldX(i, j, degree)), (int) (oldY(i, j, degree) + Math.sin(Math.toRadians(degree)) * image.getWidth()), image.getRGB(i, j));
            }
        }
    }

    public static BufferedImage reshapePicture(BufferedImage img, int newW, int newH) {
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(null, 0, 0, null);
        g2d.dispose();
        return dimg;
    }

    private void calculateDimensions() {
        if ("center".equalsIgnoreCase(rotateFrom)) {
            int edge = (image.getHeight() > image.getWidth()) ? image.getHeight() : image.getWidth();
            double hypotenuse = calculateHypotenuse(edge, edge);
            width = hypotenuse;
            heigth = hypotenuse;
        } else {
            double hypotenuse = calculateHypotenuse(image.getHeight(), image.getWidth());
            width = hypotenuse;
            heigth = hypotenuse;
        }
    }

    public double calculateHypotenuse(int edge1, int edge2) {
        double hypotenuse = Math.sqrt((Math.pow(edge1, 2) + Math.pow(edge2, 2)));
        return hypotenuse;
    }

    public void displayImage() {
        ImageIcon icon = new ImageIcon(rotatedImage);
        frame.setLayout(new BorderLayout());
        frame.setSize((int) width, (int) heigth);
        JLabel label = new JLabel();
        label.setSize((int) width, (int) heigth);
        label.setIcon(icon);
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static double oldX(int x, int y, double degree) {
        return Math.cos(Math.toRadians(-degree)) * x - Math.sin(Math.toRadians(-degree)) * y;
    }

    public static double oldY(int x, int y, double degree) {
        return Math.sin(Math.toRadians(-degree)) * x + Math.cos(Math.toRadians(-degree)) * y;
    }


}
