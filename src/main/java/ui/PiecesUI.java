package ui;

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;

public class PiecesUI {
    PiecesUI(){



    }
    public JLabel Pawn() {
        JLabel Pawn = new JLabel("P");
        //ImageIcon wPawn =  new ImageIcon("src/Art/wPawn.png");
        //label.setIcon(wPawn);
        Pawn.setFont(new Font("Italic", Font.BOLD, 70));

        /*
        Houses[1][1].add(new JLabel("P"));
        Houses[3][1].add(P1);
        Houses[2][1].add(P2);
        frame.setVisible(true);
        */
        return Pawn;

    }
}
