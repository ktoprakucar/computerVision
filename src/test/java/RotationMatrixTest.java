import Operations.RotationMatrix;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by toprak on 3/13/2017.
 */
public class RotationMatrixTest {

    String imagePath = "C:\\Users\\toprak\\Projects\\ComputerVision\\src\\main\\resources\\leffe.jpg";

    @Test
    public void test_calculate_hypotenuse(){
        RotationMatrix rotationMatrix = new RotationMatrix(null, null);
        double hypotenuse = rotationMatrix.calculateHypotenuse(3, 4);
        assertEquals(hypotenuse, 5.0);
    }

    @Test
    public void test_rotate_picture() throws IOException {
        BufferedImage img = ImageIO.read(new File(imagePath));
        RotationMatrix app = new RotationMatrix(img, "center");
    }
}
