package com.toprak.main;

import java.awt.image.BufferedImage;

/**
 * Created by toprak on 3/1/2017.
 */
public class RotationMatrix {
    final BufferedImage image;
    final String rotateFrom;
    int width;
    int heigth;

    public RotationMatrix(BufferedImage image, String rotateFrom) {
        this.image = image;
        this.rotateFrom = rotateFrom;
    }

    public void rotatePicture(){
        calculateDimensions();
    }

    private void calculateDimensions() {
        if("center".equalsIgnoreCase(rotateFrom)){
            int edge = (image.getHeight() > image.getWidth()) ? image.getHeight() : image.getWidth();
            double hypotenuse = calculateHypotenuse(edge, edge);
        }
    }

    public double calculateHypotenuse(int edge1, int edge2) {
        double hypotenuse = Math.sqrt((Math.pow(edge1,2) + Math.pow(edge2,2)));
        return hypotenuse*2;
    }
}
