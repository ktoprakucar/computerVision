import operations.ConvolutionMatrix;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by toprak on 04-Apr-17.
 */
public class ConvolutionTest {
  File lennon;
  BufferedImage img;
  ConvolutionMatrix convolutionMatrix;

  @Before
  public void setUp() throws IOException {
    lennon = new File(ComputerVisionTest.class.getClassLoader().getResource("leffe.jpg").getFile());
    img = ImageIO.read(lennon);
    convolutionMatrix = new ConvolutionMatrix(img);
  }

  @Test
  public void test_extend_image_matrix() {
    int filterSize = 11;
    convolutionMatrix.convolveImage(filterSize);
    assertEquals(convolutionMatrix.extendedMatrix.length, img.getHeight() + filterSize - 1);
    assertEquals(convolutionMatrix.extendedMatrix[0].length, img.getHeight()+filterSize - 1);
  }

  @Test
  public void test_display_extended_image_matrix() throws InterruptedException {
    int filterSize = 11;
    convolutionMatrix.convolveImage(filterSize);
    convolutionMatrix.convolveWithFilter();
    convolutionMatrix.generateImageFromMatrix(convolutionMatrix.extendedMatrix);
    convolutionMatrix.displayImage();
    //Thread.sleep(10000);
    }
}
