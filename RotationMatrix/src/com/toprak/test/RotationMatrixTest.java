package com.toprak.test;

import com.toprak.main.RotationMatrix;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by toprak on 3/1/2017.
 */
public class RotationMatrixTest {

    @Test
    public void test_calculate_hypotenuse(){
        RotationMatrix rotationMatrix = new RotationMatrix(null, null);
        double hypotenuse = rotationMatrix.calculateHypotenuse(3, 4);
        assertEquals(hypotenuse, 10.0);
    }
}
