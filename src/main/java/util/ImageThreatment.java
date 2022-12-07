package util;

import javax.swing.*;
import java.awt.*;

public class ImageThreatment {

    public static ImageIcon pieceImageResize(ImageIcon pieceImage, int width, int height){
        Image imageIconConverted = pieceImage.getImage();
        Image imageResized = imageIconConverted.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        pieceImage = new ImageIcon(imageResized);

        return pieceImage;
    }

}
