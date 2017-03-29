package operations;

/**
 * Created by toprak on 29-Mar-17.
 */
public class Editings {

  public static int[][] fillOutOfMatrix(int filterSize, int[][] matrix) {
    int expansionSize = calculateAdditionalPixelsForEachDimension(filterSize);
    int[][] filledMatrix = new int[matrix.length + expansionSize * 2][matrix[0].length + expansionSize * 2];
    for (int i = 0; i < filledMatrix.length; i++) {
      for (int j = 0; j < filledMatrix[0].length; j++) {
        if (i < expansionSize || j < expansionSize || i > filledMatrix.length - expansionSize -1 || j > filledMatrix[0].length - expansionSize - 1) {
          filledMatrix[j][i] = 0;
        } else {
          filledMatrix[i][j] = matrix[i - expansionSize][j - expansionSize];
        }
      }
    }
    return filledMatrix;
  }

  public static int calculateAdditionalPixelsForEachDimension(int filterSize) {
    return (int) Math.ceil(filterSize / 2);
  }
}
