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
        File file = new File(Main.class.getClassLoader().getResource("leffe.jpg").getFile());
        BufferedImage img = ImageIO.read(file);
        RotationMatrix app = new RotationMatrix(img, "corner");
        app.rotatePicture(15);
        app.displayImage();
    }
}

