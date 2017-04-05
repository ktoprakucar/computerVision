package operations;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by toprak on 04-Apr-17.
 */
public class ConvolutionMatrix {
  public final BufferedImage image;
  public BufferedImage convolvedImage;
  public JFrame frame = new JFrame();
  public int[][] extendedMatrix;
  public Point[][] filterMatrix;
  public int[][] imageMatrix;

  public ConvolutionMatrix(BufferedImage image) {
    this.image = image;
  }

  public void convolveImage(int filterSize) {
    imageMatrix = getImageToMatrix();
    extendedMatrix = Editings.fillOutOfMatrix(filterSize, imageMatrix);
    filterMatrix = Editings.generateFilterMatrix(filterSize);

  }

  public void displayImage() {
    ImageIcon icon = new ImageIcon(convolvedImage);
    frame.setLayout(new BorderLayout());
    JLabel label = new JLabel();
    label.setIcon(icon);
    frame.add(label);
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public int[][] getImageToMatrix() {
    int[][] imageMatrix = new int[image.getWidth()][image.getHeight()];
    for (int i = 0; i < image.getWidth(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        imageMatrix[i][j] = image.getRGB(i, j);
      }
    }
    return imageMatrix;
  }

  public void generateImageFromMatrix(int[][] imageToBeConverted) {
    convolvedImage = new BufferedImage(imageToBeConverted.length, imageToBeConverted.length, BufferedImage.TYPE_INT_ARGB);
    for (int i = 0; i < imageToBeConverted.length; i++) {
      for (int j = 0; j < imageToBeConverted[0].length; j++) {
        convolvedImage.setRGB(i, j, extendedMatrix[i][j]);
      }
    }
  }

  public void convolveWithFilter() {
    int xCounter = 0;
    int yCounter = 0;
    int filterSize = (int) Math.ceil(filterMatrix.length / 2);
    for (int i = 0; i < extendedMatrix.length; i++) {
      for (int j = 0; j < extendedMatrix[0].length; j++) {
        if (i < extendedMatrix.length - filterMatrix.length && j < extendedMatrix[0].length - filterMatrix.length) {
          int convolvedValue = 0;
          for (int fx = 0; fx < filterMatrix.length; fx++) {
            for (int fy = 0; fy < filterMatrix[0].length; fy++) {
              convolvedValue += (filterMatrix[fx][fy].x * extendedMatrix[fx + xCounter][fy + yCounter]) / Math.pow(filterMatrix.length,2);
              convolvedValue += (filterMatrix[fx][fy].y * extendedMatrix[fx + xCounter][fy + yCounter]) / Math.pow(filterMatrix.length,2);
            }
          }
          extendedMatrix[i + filterSize][j + filterSize] = convolvedValue;
          yCounter++;
        }
      }
      xCounter++;
      yCounter = 0;
    }
  }
}
