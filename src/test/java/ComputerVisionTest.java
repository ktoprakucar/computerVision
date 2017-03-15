import Operations.RotationMatrix;
import org.junit.Ignore;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by toprak on 3/13/2017.
 */
public class ComputerVisionTest {
    File file = new File(ComputerVisionTest.class.getClassLoader().getResource("leffe.jpg").getFile());

    @Test
    public void test_calculate_hypotenuse(){
        RotationMatrix rotationMatrix = new RotationMatrix(null, null);
        double hypotenuse = rotationMatrix.calculateHypotenuse(3, 4);
        assertEquals(hypotenuse, 5.0);
    }

    @Test
    public void test_rotate_picture() throws IOException {
        BufferedImage img = ImageIO.read(file);
        RotationMatrix app = new RotationMatrix(img, "center");
    }

    @Ignore
    @Test
    public void test_rotate_from_center() throws IOException, InterruptedException {
        File file = new File(ComputerVisionTest.class.getClassLoader().getResource("leffe.jpg").getFile());
        BufferedImage img = ImageIO.read(file);
        RotationMatrix app = new RotationMatrix(img, "center");
        app.rotate(45);
        app.displayImage();
        Thread.sleep(100000);
    }

    @Ignore
    @Test
    public void test_rotate_from_corner() throws IOException, InterruptedException {
        File file = new File(ComputerVisionTest.class.getClassLoader().getResource("leffe.jpg").getFile());
        BufferedImage img = ImageIO.read(file);
        RotationMatrix app = new RotationMatrix(img, "corner");
        app.rotate(45);
        app.displayImage();
        Thread.sleep(100000);
    }
}
