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
    public static int JPANEL_WIDTH;
    public static int JPANEL_HEIGHT;
    private final Board boardGame;
    private PieceUI pieceSelected = null;
    private final JPanel[][] Houses = new JPanel[Board.BOARD_SIZE][Board.BOARD_SIZE];
    private final JFrame frame = new JFrame();
    private final LinkedList<PieceUI> pieceUIS = new LinkedList<>();
    public BoardUI(Board boardGame){
        this.boardGame = boardGame;
    }

    public void CreateBoard() {
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
        JPANEL_HEIGHT = Houses[0][0].getHeight();
        JPANEL_WIDTH = Houses[0][0].getWidth();
        frame.setVisible(true);

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int xBoard = (x/100);
                int yBoard = 7-(y/100);
                System.out.println("(" + xBoard + "," + yBoard + ")");
                for (PieceUI pieceUI : pieceUIS) {
                    if (pieceUI.getCoordUIX() == xBoard && pieceUI.getCoordUIY() == yBoard) {
                        pieceSelected = pieceUI;
                        System.out.println(pieceSelected);
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (pieceSelected != null){
                    //delete current jpanel icon image
                    Houses[pieceSelected.getCoordUIX()][pieceSelected.getCoordUIY()].removeAll();

                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    private boolean validMove() {
        //implementar!!! (obviamente) nao nessa classe
        return true;
    }

    public void clearImageLabel(int x, int y){
        Houses[x][y].removeAll();
    }

    public void spawnPiecesStarter(){
        for(Piece p : boardGame.piecesInGame){
            spawnPiece(p,p.getPosX(),p.getPosY());
        }
    }

    public void spawnPiece(Piece piece,int x,int y){
        PieceUI pieceUi = new PieceUI(piece, JPANEL_WIDTH*piece.getPosX(), JPANEL_HEIGHT*piece.getPosY());
        pieceUIS.add(pieceUi);

        JLabel jPiece = new JLabel();
        jPiece.setIcon(pieceUi.getPieceImage());

        Houses[x][y].add(jPiece);
        frame.setVisible(true);
        frame.repaint();

    }


}
