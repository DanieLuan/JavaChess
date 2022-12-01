package ui;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class BoardUI {
    public BoardUI(){}
    public void PrintBoard() {

        var black = Color.decode("#769656");
        var white = Color.decode("#eeeed2");
        boolean isBlack = true;

        //matrix of Jpanels
        JPanel[][] Houses = new JPanel[8][8];

        //generate chessBoard
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(816,839);
        frame.setResizable(false);
        //generate Squares
        for (int y = 0; y<=7;y++){
            for (int x = 0; x<=7;x++){
                Houses[x][y] = new JPanel();
                Color desiredColor;
                if (isBlack){
                    desiredColor = black;
                }
                else {
                    desiredColor = white;
                }
                isBlack = !isBlack;
                Houses[x][y].setBackground(desiredColor);
                Houses[x][y].setBounds(100 * x,700-(100 * y),100,100);
                frame.add(Houses[x][y]);
            }
            isBlack = !isBlack;
        }

        frame.setVisible(true);
    }
    public void SpawnPiece(){


    }

}
