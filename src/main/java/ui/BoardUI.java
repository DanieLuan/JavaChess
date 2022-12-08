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
    private int pieceSelectedXPos;
    private int pieceSelectedYPos;
    private final JPanel[][] Houses = new JPanel[Board.BOARD_SIZE][Board.BOARD_SIZE];
    private final JFrame frame = new JFrame();

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
                int xBoard = ((x-16)/100);
                int yBoard = 7-((y-39)/100);
                for (Piece p : boardGame.piecesInGame) {
                    if (p.getPosX() == xBoard && p.getPosY() == yBoard) {
                        pieceSelected = new PieceUI(p, x, y);
                        pieceSelectedXPos = xBoard;
                        pieceSelectedYPos = yBoard;
                        System.out.println(pieceSelected);
                        Houses[xBoard][yBoard].removeAll();
                        Houses[xBoard][yBoard].revalidate();
                        Houses[xBoard][yBoard].repaint();
                        break;
                    }
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int xBoard = ((x-16)/100);
                int yBoard = 7-((y-39)/100);
                if(pieceSelected != null){
                    Houses[pieceSelectedXPos][pieceSelectedYPos].removeAll();
                    Houses[xBoard][yBoard].revalidate();
                    Houses[xBoard][yBoard].repaint();

                    if(!boardGame.isOccupied(xBoard, yBoard)){ //Verificar se a peça está no mesmo canto
                        System.out.println("Movimento valido : casa vazia");
                        boardGame.movePiece(pieceSelectedXPos, pieceSelectedYPos, xBoard, yBoard);
                        Houses[xBoard][yBoard].add(pieceSelected.getPieceLabel());
                        Houses[xBoard][yBoard].revalidate();
                        Houses[xBoard][yBoard].repaint();
                        //remove old piece location

                    }
                    else{
                        if(!boardGame.isEnemy(xBoard, yBoard, pieceSelected)){
                            System.out.println("Movimento invalido : peça aliada no caminho");
                            Houses[pieceSelectedXPos][pieceSelectedYPos].add(pieceSelected.getPieceLabel());
                            Houses[pieceSelectedXPos][pieceSelectedYPos].revalidate();
                            Houses[pieceSelectedXPos][pieceSelectedYPos].repaint();
                        } else {
                            System.out.println("Movimento valido : comer peça inimiga");
                            boardGame.movePiece(pieceSelectedXPos, pieceSelectedYPos, xBoard, yBoard);
                            Houses[xBoard][yBoard].removeAll();
                            Houses[xBoard][yBoard].add(pieceSelected.getPieceLabel());
                            Houses[xBoard][yBoard].revalidate();
                            Houses[xBoard][yBoard].repaint();
                            //remove old piece location

                        }

                    }
                }

                pieceSelected = null;
                pieceSelectedXPos = -1;
                pieceSelectedYPos = -1;
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
                    JPanel pn = new JPanel(){
                        @Override
                        public void paint(Graphics g) {

                            g.drawImage(pieceSelected.getPieceImage().getImage(), e.getX(), e.getY(), this);
                        }
                    };
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    public void removePiece(Piece piece, int x, int y){
        Houses[x][y].removeAll();
        boardGame.piecesInGame.remove(piece.getPiece());

        frame.repaint();
    }

    private boolean validMove() {
        //implementar!!! (obviamente) nao nessa classe
        return true;
    }

    public void clearImageLabel(int x, int y){
        Houses[x][y].removeAll();
    }

    public void spawnPiecesStarter() {
        for(Piece p : boardGame.piecesInGame){
            spawnPiece(p,p.getPosX(),p.getPosY());
        }
    }

    public void spawnPiece(Piece piece,int x,int y){
        PieceUI pieceUi = new PieceUI(piece, JPANEL_WIDTH*piece.getPosX(), JPANEL_HEIGHT*piece.getPosY());

        JLabel jPiece = new JLabel();
        jPiece.setIcon(pieceUi.getPieceImage());

        Houses[x][y].add(jPiece);
        frame.setVisible(true);
        frame.repaint();

    }


}
