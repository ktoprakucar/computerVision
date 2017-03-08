package com.toprak.main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by toprak on 3/7/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String imagePath = "C:\\Users\\toprak\\Projects\\RotationMatrix\\src\\com\\toprak\\main\\resources\\leffe.jpg";
        BufferedImage img = ImageIO.read(new File(imagePath));
        RotationMatrix app = new RotationMatrix(img, "corner");
        app.rotatePicture(40);
        app.displayImage();
    }
}
