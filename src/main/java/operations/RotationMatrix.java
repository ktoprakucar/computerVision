package operations;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by toprak on 3/13/2017.
 */

public class RotationMatrix {
  Color blackColor = new Color(0, 0, 0);
  final BufferedImage image;
  BufferedImage rotatedImage;
  final String rotateFrom;
  JFrame frame = new JFrame();

  public RotationMatrix(BufferedImage image, String rotateFrom) {
    this.image = image;
    this.rotateFrom = rotateFrom;
  }

  public void rotate(int degree) {
    rotatedImage = reshapePicture(image, image.getWidth(), image.getHeight());
    paintEmptyImage();
    if ("center".equalsIgnoreCase(rotateFrom))
      rotateFromCenter(degree);
    else if ("corner".equalsIgnoreCase(rotateFrom))
      rotateFromCorner(degree);
  }

  private void rotateFromCenter(int degree) {
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        int originedX = i - (image.getWidth() / 2);
        int originedY = j - (image.getHeight() / 2);
        if (isOutOfBound(degree, originedX, originedY))
          continue;
        rotatedImage.setRGB((int) (calculateNewXValue(originedX, originedY, degree)) + rotatedImage.getWidth() / 2, (int) (calculateNewYValue(originedX, originedY, degree)) + rotatedImage.getHeight() / 2, image.getRGB(i, j));
      }
    }
  }

  private void rotateFromCorner(int degree) {
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        if (isOutOfBound(degree, i, j))
          continue;
        rotatedImage.setRGB((int) (calculateNewXValue(i, j, degree)), (int) (calculateNewYValue(i, j, degree)), image.getRGB(i, j));
      }
    }
  }

  private void paintEmptyImage() {
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getHeight(); j++) {
        rotatedImage.setRGB(i, j, blackColor.getRGB());
      }
    }
  }

  private boolean isOutOfBound(int degree, int i, int j) {
    if ("corner".equalsIgnoreCase(rotateFrom))
      return isXOutOfBoundForCornerRotation(degree, i, j) || isYOutOfBoundForCornerRotation(degree, i, j);
    return isXOutOfBoundForCenterRotation(degree, i, j) || isYOutOfBoundForCenterRotation(degree, i, j);
  }

  private boolean isYOutOfBoundForCenterRotation(int degree, int i, int j) {
    return calculateNewYValue(i, j, degree) + rotatedImage.getHeight() / 2 > rotatedImage.getHeight() || calculateNewYValue(i, j, degree)+ rotatedImage.getHeight() / 2 < 0;
  }

  private boolean isXOutOfBoundForCenterRotation(int degree, int i, int j) {
    return calculateNewXValue(i, j, degree) + rotatedImage.getWidth() / 2 > rotatedImage.getWidth() || calculateNewXValue(i, j, degree) + rotatedImage.getWidth()/2< 0;
  }

  private boolean isYOutOfBoundForCornerRotation(int degree, int i, int j) {
    return calculateNewYValue(i, j, degree) > rotatedImage.getHeight() || calculateNewYValue(i, j, degree) < 0;
  }

  private boolean isXOutOfBoundForCornerRotation(int degree, int i, int j) {
    return calculateNewXValue(i, j, degree) > rotatedImage.getWidth() || calculateNewXValue(i, j, degree) < 0;
  }

  public static BufferedImage reshapePicture(BufferedImage img, int newW, int newH) {
    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = dimg.createGraphics();
    g2d.drawImage(null, 0, 0, null);
    g2d.dispose();
    return dimg;
  }

  public void displayImage() {
    ImageIcon icon = new ImageIcon(rotatedImage);
    frame.setLayout(new BorderLayout());
    JLabel label = new JLabel();
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
