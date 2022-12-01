package ui;

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;

public class PiecesUI {
    public PiecesUI(){



    }
    public JLabel Pawn(boolean isBlack) {
        JLabel Pawn = new JLabel("P");
        //ImageIcon wPawn =  new ImageIcon("src/main/java/art/wPawn.png");
        //label.setIcon(wPawn);
        Pawn.setFont(new Font("Italic", Font.BOLD, 70));

        return Pawn;

    }
}
