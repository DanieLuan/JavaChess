package ui;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import pieces.*;
import board.*;

public class BoardUI {

    private final Board boardGame;
    private PieceUI pieceSelected = null;
    private Integer pieceXIndexSave;
    private Integer pieceYIndexSave;

    //matrix of Jpanels
    private final JPanel[][] Houses = new JPanel[8][8];
    //generate Jframe
    private final JFrame frame = new JFrame();

    public BoardUI(Board boardGame){
        this.boardGame = boardGame;
    }

    public void PrintBoard() {
        Color black = Color.decode("#769656");
        Color white = Color.decode("#eeeed2");
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

        mouseEvents();
    }

    private void mouseEvents(){


        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){

                int finalX = x;
                int finalY = y;

                Houses[x][y].addMouseMotionListener(new MouseMotionListener() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        if(pieceSelected != null){
                            System.out.println("mexendo na peça " + pieceSelected);

                            pieceXIndexSave = finalX;
                            pieceYIndexSave = finalY;

                            clearImageLabel(finalX,finalY);
                            frame.repaint();

                            ImageIcon pieceImage = imageFromPiece(pieceSelected);

                        }
                    }

                    @Override
                    public void mouseMoved(MouseEvent e) {

                    }
                });

                Houses[x][y].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        for(Piece p : boardGame.piecesInGame){
                            if(p.getPosX() == finalX && p.getPosY() == finalY){
                                System.out.println(p);
                                pieceSelected = p;
                            }
                        }
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        if(pieceSelected != null){
                            if(validMove()){
                                System.out.println("JAJA");
                            } else {
                                spawnPiece(pieceSelected, pieceXIndexSave, pieceYIndexSave);
                                frame.repaint();
                            }
                        }
                        pieceSelected = null;
                        pieceXIndexSave = null;
                        pieceYIndexSave = null;
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
            }
        }
    }

    private boolean validMove() {
        //implementar!!! (obviamente) nao nessa classe
        return false;
    }

    public void clearImageLabel(int x, int y){
        Houses[x][y].removeAll();
    }

    public void spawnPiecesStarter(){
        for(Piece p : boardGame.piecesInGame){
            spawnPiece(p, p.getPosX(), p.getPosY());
        }
    }

    public void spawnPiece(Piece piece,int x,int y){
        JLabel jPiece = new JLabel();

        ImageIcon pieceImage = imageFromPiece(piece);

        jPiece.setIcon(pieceImage);

        Houses[x][y].add(jPiece);
        frame.setVisible(true);
        frame.repaint();

    }

    private ImageIcon imageFromPiece(Piece piece){
        ImageIcon pieceImage = new ImageIcon(piece.getImagePath());
        pieceImage = pieceImageResize(pieceImage);
        return pieceImage;
    }

    public ImageIcon pieceImageResize(ImageIcon pieceImage){
        Image imageIconConverted = pieceImage.getImage();
        Image imageResized = imageIconConverted.getScaledInstance(Houses[0][0].getWidth(),Houses[0][0].getHeight(), Image.SCALE_SMOOTH);
        pieceImage = new ImageIcon(imageResized);

        return pieceImage;
    }

}
