package Operations;

import Spaces.ThreeDSpace;

/**
 * Created by toprak on 15-Mar-17.
 */
public class Calculations {

  /*
  [r1 r2 r3] [ c + t*x^2      x*y*t + s*z     c*t*x - s*y ]
             [ t*y*z + s*z    c + t*y^2       t*z*y - s*x ]
             [ t*x*z + s*y    t*y*z - s*z     c + t* z^2  ]
   */
  public static ThreeDSpace calculateThreeDRotation(double r1, double r2, double r3, double x, double y, double z, double degree) {
    ThreeDSpace space = new ThreeDSpace();
    double c = Math.cos(degree);
    double s = Math.sin(degree);
    double t = 1 - c;
    space.coefficientI = r1*c+t*(r1*x+r2*y+r3*z)*x+s*(r2*z-r3*y);
    space.coefficientJ = r2*c+t*(r1*x+r2*y+r3*z)*y+s*(r1*z-r3*x);
    space.coefficientK = r3*c+t*(r1*x+r2*y+r3*z)*z+s*(r1*y-r2*z);
    return space;
  }


  public static double calculateHypotenuse(int edge1, int edge2) {
    double hypotenuse = Math.sqrt((Math.pow(edge1, 2) + Math.pow(edge2, 2)));
    return hypotenuse;
  }

}
