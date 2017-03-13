package Operations;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by toprak on 3/13/2017.
 */

public class RotationMatrix {
    Color blackColor = new Color(0,0,0);
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
        rotate(degree);
    }

    private void rotate(int degree) {
        rotatedImage = reshapePicture(image, image.getWidth(), image.getHeight());
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                rotatedImage.setRGB(i, j, blackColor.getRGB());
            }
        }

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                if(isOutOfBound(degree, i, j))
                    continue;
                rotatedImage.setRGB((int) (calculateNewXValue(i, j, degree)), (int) (calculateNewYValue(i, j, degree) + Math.sin(Math.toRadians(degree)) * image.getWidth()), image.getRGB(i, j));
            }
        }
    }

    private boolean isOutOfBound(int degree, int i, int j) {
        return calculateNewXValue(i, j, degree) > rotatedImage.getWidth() ||  (calculateNewYValue(i, j, degree) + Math.sin(Math.toRadians(degree)) * image.getWidth()) > rotatedImage.getHeight();
    }

    public static BufferedImage reshapePicture(BufferedImage img, int newW, int newH) {
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(null, 0, 0, null);
        g2d.dispose();
        return dimg;
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

    public static double calculateNewXValue(int x, int y, double degree) {
        double value = Math.cos(Math.toRadians(-degree)) * x - Math.sin(Math.toRadians(-degree)) * y;
        return value;
    }

    public static double calculateNewYValue(int x, int y, double degree) {
        double value = Math.sin(Math.toRadians(-degree)) * x + Math.cos(Math.toRadians(-degree)) * y;
        return value;
    }


}
