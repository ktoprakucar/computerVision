package operations;

import java.awt.*;

/**
 * Created by toprak on 29-Mar-17.
 */
public class Editings {

  public static int[][] fillOutOfMatrix(int filterSize, int[][] matrix) {
    int expansionSize = calculateAdditionalPixelsForEachDimension(filterSize);
    int[][] filledMatrix = new int[matrix.length + expansionSize * 2][matrix[0].length + expansionSize * 2];
    for (int i = 0; i < filledMatrix.length; i++) {
      for (int j = 0; j < filledMatrix[0].length; j++) {
        if (i < expansionSize || j < expansionSize || i > filledMatrix.length - expansionSize - 1 || j > filledMatrix[0].length - expansionSize - 1) {
          filledMatrix[j][i] = 0;
        } else {
          filledMatrix[i][j] = matrix[i - expansionSize][j - expansionSize];
        }
      }
    }
    return filledMatrix;
  }

  public static int calculateAdditionalPixelsForEachDimension(int filterSize) {
    return (int) Math.ceil( filterSize / 2);
  }

  public static Point[][] generateFilterMatrix(int filterSize) {
    int expansionSize = calculateAdditionalPixelsForEachDimension(filterSize);
    int newY = expansionSize;
    int newX = -expansionSize;
    Point[][] filterMatrix = new Point[filterSize][filterSize];
    for (int i = 0; i < filterMatrix.length; i++) {
      for (int j = 0; j < filterMatrix[0].length; j++) {
        filterMatrix[i][j] = new Point();
        filterMatrix[i][j].y = newY--;
        filterMatrix[i][j].x = newX;
      }
      newY = expansionSize;
      newX++;
    }
    return filterMatrix;
  }
}
