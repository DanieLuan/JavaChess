package ui;

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import pieces.*;
public class PiecesUI {
    public PiecesUI(){



    }
    public JLabel Pawn(boolean isBlack) {
        JLabel Pawn;
        if(isBlack == false){
            Pawn = new JLabel("P");
        }
        else {
            Pawn = new JLabel("p");
        }
        Pawn.setFont(new Font("Italic", Font.BOLD, 70));

        //ImageIcon wPawn =  new ImageIcon("src/main/java/art/wPawn.png");
        //label.setIcon(wPawn);


        return Pawn;

    }
}
