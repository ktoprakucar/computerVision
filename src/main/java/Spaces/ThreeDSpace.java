package Spaces;

/**
 * Created by toprak on 15-Mar-17.
 */
public class ThreeDSpace {
  public double coefficientI, coefficientJ, coefficientK;
  public double i, j, k;

  public void multipleValuesWithCoefficients() {
    i = i * coefficientI;
    j = j * coefficientJ;
    k = k * coefficientK;
  }
}
