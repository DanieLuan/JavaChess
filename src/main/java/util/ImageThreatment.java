package util;

import javax.swing.*;
import java.awt.*;

/**
 * Class that has methods to modify images.
 */
public class ImageThreatment {

    /**
     * Method that resizes an image.
     * @param pieceImage
     * @param width
     * @param height
     * @return pieceImage resized
     */
    public static ImageIcon pieceImageResize(ImageIcon pieceImage, int width, int height){
        Image imageIconConverted = pieceImage.getImage();
        Image imageResized = imageIconConverted.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        pieceImage = new ImageIcon(imageResized);

        return pieceImage;
    }

}
