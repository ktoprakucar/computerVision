import Operations.RotationMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by toprak on 3/13/2017.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        String imagePath = "C:\\Users\\toprak\\Projects\\ComputerVision\\src\\main\\resources\\leffe.jpg";
        BufferedImage img = ImageIO.read(new File(imagePath));
        RotationMatrix app = new RotationMatrix(img, "corner");
        app.rotatePicture(10);
        app.displayImage();
    }
}

