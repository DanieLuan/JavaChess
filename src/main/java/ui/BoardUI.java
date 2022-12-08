package ui;

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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

        //teste glasspaenl
        JPanel glassPanel = new JPanel();
        glassPanel.setOpaque(false);
        glassPanel.setBounds(0,0,100,100);


        frame.add(glassPanel);
        frame.revalidate();
        frame.repaint();

        //teste glasspaenl

        //test Mouse Piece Render
        JLabel pieceRenderMouse = new JLabel();
        pieceRenderMouse.setIcon(null);
        glassPanel.add(pieceRenderMouse);
        //test Mouse Piece Render

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
                        pieceRenderMouse.setIcon(pieceSelected.getPieceImage());
                        glassPanel.setBounds(x -50,y  -100,100,100);
                        Houses[xBoard][yBoard].removeAll();

                        reMoveAndPaint(xBoard, yBoard);
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pieceRenderMouse.setIcon(null);
                int x = e.getX();
                int y = e.getY();
                int xBoard = ((x-16)/100);
                int yBoard = 7-((y-39)/100);
                if(xBoard < 0 || xBoard > 7 || yBoard < 0 || yBoard > 7){
                    System.out.println("Invalid Move");
                    addHousesPieceLabel(pieceSelectedXPos, pieceSelectedYPos, pieceSelected);
                    return;
                }
                if(pieceSelected != null){
                    Houses[pieceSelectedXPos][pieceSelectedYPos].removeAll();
                    reMoveAndPaint(xBoard, yBoard);

                    if(!boardGame.isOccupied(xBoard, yBoard)){ //Verificar se a peça está no mesmo canto
                        System.out.println("Movimento valido : casa vazia");
                        boardGame.movePiece(pieceSelectedXPos, pieceSelectedYPos, xBoard, yBoard);
                        addHousesPieceLabel(xBoard, yBoard, pieceSelected);

                    }
                    else{
                        if(!boardGame.isEnemy(xBoard, yBoard, pieceSelected)){
                            System.out.println("Movimento invalido : peça aliada no caminho");
                            addHousesPieceLabel(pieceSelectedXPos, pieceSelectedYPos, pieceSelected);

                        } else {
                            System.out.println("Movimento valido : comer peça inimiga");
                            boardGame.movePiece(pieceSelectedXPos, pieceSelectedYPos, xBoard, yBoard);
                            removeHousesPieceLabel(xBoard, yBoard);
                            addHousesPieceLabel(xBoard, yBoard, pieceSelected);
                        }
                    }
                }

                pieceSelected = null;
                pieceSelectedXPos = -1;
                pieceSelectedYPos = -1;
            }

            private void addHousesPieceLabel(int x, int y, PieceUI piece) {
                Houses[x][y].add(piece.getPieceLabel());
                reMoveAndPaint(x, y);
            }

            private void removeHousesPieceLabel(int x, int y) {
                Houses[x][y].removeAll();
                reMoveAndPaint(x, y);
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

                int x = e.getX() - 50;
                int y = e.getY() - 100;

                if (pieceSelected != null){
                    pieceRenderMouse.setLocation(100,100);
                    pieceRenderMouse.setIcon(pieceSelected.getPieceImage());
                    glassPanel.setBounds(x,y,100,100);

                    frame.revalidate();
                    frame.repaint();

                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    private void reMoveAndPaint(int x, int y) {
        Houses[x][y].revalidate();
        Houses[x][y].repaint();
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
