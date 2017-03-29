package operations;

/**
 * Created by toprak on 29-Mar-17.
 */
public class Editings {

  public int[][] fillOutOfMatrix(int filterSize, int[][] matrix){
    int expansionSize = calculateAdditionalPixelsForEachDimension(filterSize);
    return null;
  }

  public static int calculateAdditionalPixelsForEachDimension(int filterSize) {
    return (int) Math.ceil(filterSize/2);
  }
}
