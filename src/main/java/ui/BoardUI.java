package ui;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.LinkedList;

import pieces.*;
import board.*;

public class BoardUI {

    private final Board boardGame;

    //matrix of Jpanels
    private final JPanel[][] Houses = new JPanel[8][8];
    //generate Jframe
    private final JFrame frame = new JFrame();

    public BoardUI(Board boardGame){
        this.boardGame = boardGame;
    }

    public void PrintBoard() {

        var black = Color.decode("#769656");
        var white = Color.decode("#eeeed2");
        boolean isBlack = true;

        //generate chessBoard

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

    public void spawnPiecesStarter(){
        for(Piece p : boardGame.piecesInGame){
            spawnPiece(p, p.getPosX(), p.getPosY());
        }
    }

    public void spawnPiece(Piece piece,int x,int y){
        JLabel jPiece = new JLabel();
        ImageIcon pieceImage = new ImageIcon(piece.getImagePath());
        pieceImage = pieceImageResize(pieceImage);
        jPiece.setIcon(pieceImage);

        Houses[x][y].add(jPiece);
        frame.setVisible(true);
        frame.repaint();

    }

    public ImageIcon pieceImageResize(ImageIcon pieceImage){
        Image imageIconConverted = pieceImage.getImage();
        Image imageResized = imageIconConverted.getScaledInstance(Houses[0][0].getWidth(),Houses[0][0].getHeight(), Image.SCALE_SMOOTH);
        pieceImage = new ImageIcon(imageResized);

        return pieceImage;
    }

}
