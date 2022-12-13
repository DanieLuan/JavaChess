package ui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import game.GameRules;
import pieces.*;
import board.*;
import util.ImageThreatment;
import util.Type;

/**
 * Class that represents the Board rendered in the UI.
 * Has a board of pieces and a matrix of JPanels.
 */

public class BoardUI {

    private static final int BOARD_SIZE_HEIGHT = 839;
    private static final int BOARD_SIZE_WIDTH = 816;
    private static final Color BLACK = Color.decode("#769656");
    private static final Color BLACK_HIGHLIGHT = Color.decode("#baca2b");
    private static final Color WHITE = Color.decode("#eeeed2");
    private static final Color WHITE_HIGHLIGHT = Color.decode("#f6f669");
    private static final Color RED_WHITE = Color.decode("#E08080");
    private static final Color RED_BLACK = Color.decode("#CC7575");
    public static int JPANEL_WIDTH;
    public static int JPANEL_HEIGHT;
    private final Board boardGame;
    private PieceUI pieceSelected = null;
    private int pieceSelectedXPos;
    private int pieceSelectedYPos;
    private LinkedList<Spot> pieceSelectedPossibleMoves;
    private final JLayeredPane[][] boardGameUI = new JLayeredPane[Board.BOARD_SIZE][Board.BOARD_SIZE];
    private final JFrame boardGameChessFrame = new JFrame();
    private static JLayeredPane glassPanel;

    private static JPanel pickLayout = new JPanel() ;
    private static JLabel pieceRenderMouse;
    private  static  JLabel[] numbersLabelBackground = new JLabel[Board.BOARD_SIZE];
    private  static  JLabel[] lettersLabelBackground = new JLabel[Board.BOARD_SIZE];

    /**
     * Constructor of the BoardUI class. Receive a boardGame to render using Javax Swing.
     * @param boardGame a boardGame to render.
     */
    public BoardUI(Board boardGame) {
        this.boardGame = boardGame;

        pieceSelectedPossibleMoves = new LinkedList<>();

        changeIconFrame();
        playStartGamePieceSFX();

        // Glass Panel to put the Label of the mouse
        glassPanel = new JLayeredPane();
        glassPanel.setOpaque(false);
        glassPanel.setLayout(pickLayout.getLayout());
        glassPanel.highestLayer();
        glassPanel.setBounds(0,0,100,100);

        boardGameChessFrame.add(glassPanel);
        boardGameChessFrame.revalidate();
        boardGameChessFrame.repaint();

        // Label to render the piece anchored in the mouse
        pieceRenderMouse = new JLabel();
        pieceRenderMouse.setIcon(null);
        glassPanel.add(pieceRenderMouse);

        //generate chessBoard and set properties
        boardGameChessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardGameChessFrame.setLayout(null);
        boardGameChessFrame.setSize(BOARD_SIZE_WIDTH,BOARD_SIZE_HEIGHT);
        boardGameChessFrame.setResizable(false);

        //generate Squares
        generateChessBackground();

        JPANEL_HEIGHT = boardGameUI[0][0].getHeight();
        JPANEL_WIDTH = boardGameUI[0][0].getWidth();

        boardGameChessFrame.setVisible(true);

        boardGameChessFrame.addMouseListener(mouseListenerCreator());
        boardGameChessFrame.addMouseMotionListener(mouseMotionListenerCreator());
    }

    /**
     * Method that spawn pieces in the board game UI.
     */
    public void spawnPiecesStarter() {
        for(Piece p : boardGame.piecesInGame){
            spawnPiece(p,p.getPosX(),p.getPosY());
        }
    }
    public void changeIconFrame(){
        ImageIcon img = new ImageIcon("resources/pawn_icon.png");
        JTextField myTitle = myTitle = new JTextField("JavaChess");
        boardGameChessFrame.setTitle(myTitle.getText());
        boardGameChessFrame.setIconImage(img.getImage());
    }
    /**
     * Method that adds a piece's label to the current position.
     * @param spotPosX position of the X axis of the boardGameUI.
     * @param spotPosY position of the Y axis of the boardGameUI.
     * @param piece piece to be added.
     */
    private void addBoardGamePieceLabel(int spotPosX, int spotPosY, PieceUI piece) {
        if(piece != null){
            boardGameUI[spotPosX][spotPosY].add(piece.getPieceLabel());
            reMoveAndPaint(spotPosX, spotPosY);
        }
    }

    /**
     * Method that sets the JLabel's background to black or white.
     */
    private void generateChessBackground(){
        boolean isBlack = true;
        for (int y = 0; y<=7;y++){
            for (int x = 0; x<=7;x++){
                boardGameUI[x][y] = new JLayeredPane();
                boardGameUI[x][y].setLayout(pickLayout.getLayout());
                if (isBlack){
                    boardGameUI[x][y].setBackground(BLACK);
                } else {
                    boardGameUI[x][y].setBackground(WHITE);
                }
                isBlack = !isBlack;
                boardGameUI[x][y].lowestLayer();
                boardGameUI[x][y].setOpaque(true);

                boardGameUI[x][y].setBounds(100 * x,700-(100 * y), 100, 100);
                boardGameChessFrame.add(boardGameUI[x][y]);
            }
            isBlack = !isBlack;
        }
    }

    /**
     * Create a mouseListener to the boardGameChessFrame.
     * @return MouseListener object.
     */
    private MouseListener mouseListenerCreator(){
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int mouseOnFramePosX = e.getX();
                int mouseOnFramePosY = e.getY();
                int spotPosX = ((mouseOnFramePosX-16)/100);
                int spotPosY = 7-((mouseOnFramePosY-39)/100);
                repaintBackground(BLACK,WHITE);
                removePossiblePositions(pieceSelectedPossibleMoves);
                //TODO: usar Board.getPieceInPos
                for (Piece p : boardGame.piecesInGame) {
                    if (p.getPosX() == spotPosX && p.getPosY() == spotPosY) {
                        pieceSelected = new PieceUI(p, mouseOnFramePosX, mouseOnFramePosY);
                        highlightSpot(spotPosX,spotPosY,BLACK_HIGHLIGHT,WHITE_HIGHLIGHT);

                        pieceSelectedXPos = spotPosX;
                        pieceSelectedYPos = spotPosY;

                        System.out.println(pieceSelected);
                        if (preventWrongTurnMove()){
                            return;
                        }

                        pieceRenderMouse.setIcon(pieceSelected.getPieceImage());
                        glassPanel.setBounds(mouseOnFramePosX-50,mouseOnFramePosY-100, JPANEL_WIDTH, JPANEL_HEIGHT);

                        boardGameChessFrame.revalidate();
                        boardGameChessFrame.repaint();
                        boardGameUI[spotPosX][spotPosY].removeAll();



                        pieceSelectedPossibleMoves = boardGame.getPieceInPos(pieceSelectedXPos,pieceSelectedYPos).getPossibleMoves(boardGame);
                        insertPossiblePositions(pieceSelectedPossibleMoves);
                        for(Spot spot : pieceSelectedPossibleMoves){
                            System.out.println(spot);
                        }

                        //TODO: colocar possíveis posições onde a peça pode ir

                        reMoveAndPaint(spotPosX, spotPosY);
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pieceRenderMouse.setIcon(null);
                int mouseOnFramePosX = e.getX();
                int mouseOnFramePosY = e.getY();

                int spotPosX = ((mouseOnFramePosX-16)/100);
                int spotPosY = 7-((mouseOnFramePosY-39)/100);

                if(spotPosX < 0 || spotPosX > 7 || spotPosY < 0 || spotPosY > 7){
                    System.out.println("Invalid Move - Out of board");
                    addBoardGamePieceLabel(pieceSelectedXPos, pieceSelectedYPos, pieceSelected);
                    pieceSelected = null;
                    return;
                }
                if(pieceSelected != null){
                    boardGameUI[pieceSelectedXPos][pieceSelectedYPos].removeAll();
                    if (preventWrongTurnMove()){
                        return;
                    }
                    reMoveAndPaint(spotPosX, spotPosY);
                    if(!boardGame.isOccupied(spotPosX, spotPosY)){ //Verificar se a peça está no mesmo canto                        
                        if (boardGame.rules.moveIsValid(spotPosX, spotPosY, boardGame.getPieceInPos(pieceSelected.getPosX(), pieceSelected.getPosY()), boardGame)){
                            System.out.println("Movimento valido");

                            removePossiblePositions(pieceSelectedPossibleMoves);

                            boardGame.movePiece(pieceSelected.getPosX() , pieceSelected.getPosY(), spotPosX, spotPosY);
                            addBoardGamePieceLabel(spotPosX, spotPosY, pieceSelected);
                            playMovePieceSFX();
                            highlightSpot(spotPosX,spotPosY,BLACK_HIGHLIGHT,WHITE_HIGHLIGHT);
                        } else {
                            addBoardGamePieceLabel(pieceSelected.getPosX(), pieceSelected.getPosY(), pieceSelected);
                        }
                        
                        /*System.out.println("Movimento valido : casa vazia");
                        boardGame.movePiece(pieceSelectedXPos, pieceSelectedYPos, spotPosX, spotPosY);
                        addBoardGamePieceLabel(spotPosX, spotPosY, pieceSelected);
                        playMovePieceSFX();
                        highlightSpot(spotPosX,spotPosY,blackHighlight,whiteHighlight);*/
                    }
                    else{
                        if(!boardGame.isEnemy(spotPosX, spotPosY, pieceSelected)){
                            if(spotPosX == pieceSelected.getPosX() && spotPosY == pieceSelected.getPosY()){
                            }
                            else{
                                System.out.println("Movimento invalido : peça aliada no caminho");
                            }
                            boardGame.movePiece(pieceSelectedXPos, pieceSelectedYPos, spotPosX, spotPosY);
                            addBoardGamePieceLabel(pieceSelectedXPos, pieceSelectedYPos, pieceSelected);
                        } else {
                            if (pieceSelected.getType() == Type.PAWN){
                                if (boardGame.rules.pawnCaptureIsValid(spotPosX, spotPosY, pieceSelected)){

                                    //TODO: porque um tratamento difente para o peão?

                                    System.out.println("Movimento valido : comer peça inimiga");
                                    removePossiblePositions(pieceSelectedPossibleMoves);
                                    boardGame.movePiece(pieceSelectedXPos, pieceSelectedYPos, spotPosX, spotPosY);
                                    removeBoardGamePieceLabel(spotPosX, spotPosY);
                                    addBoardGamePieceLabel(spotPosX, spotPosY, pieceSelected);
                                    playCapturePieceSFX();
                                    highlightSpot(spotPosX,spotPosY,BLACK_HIGHLIGHT,WHITE_HIGHLIGHT);
                                } else {
                                    addBoardGamePieceLabel(pieceSelected.getPosX(), pieceSelected.getPosY(), pieceSelected);
                                }
                            } else {
                                if (boardGame.rules.moveIsValid(spotPosX, spotPosY, boardGame.getPieceInPos(pieceSelected.getPosX(), pieceSelected.getPosY()), boardGame)){
                                    System.out.println("Movimento valido : comer peça inimiga");
                                    removePossiblePositions(pieceSelectedPossibleMoves);
                                    boardGame.movePiece(pieceSelectedXPos, pieceSelectedYPos, spotPosX, spotPosY);
                                    removeBoardGamePieceLabel(spotPosX, spotPosY);
                                    addBoardGamePieceLabel(spotPosX, spotPosY, pieceSelected);
                                    playCapturePieceSFX();
                                    highlightSpot(spotPosX, spotPosY, BLACK_HIGHLIGHT, WHITE_HIGHLIGHT);
                                } else {
                                    addBoardGamePieceLabel(pieceSelected.getPosX(), pieceSelected.getPosY(), pieceSelected);
                                }
                            }
                            
                            /*System.out.println("Movimento valido : comer peça inimiga");
                            boardGame.movePiece(pieceSelectedXPos, pieceSelectedYPos, spotPosX, spotPosY);
                            removeBoardGamePieceLabel(spotPosX, spotPosY);
                            addBoardGamePieceLabel(spotPosX, spotPosY, pieceSelected);
                            playCapturePieceSFX();
                            highlightSpot(spotPosX,spotPosY,blackHighlight,whiteHighlight);*/
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
        };
    }

    /**
     * Create a mouseMotionListener to the boardGameChessFrame.
     * @return MouseMotionListener object.
     */
    private MouseMotionListener mouseMotionListenerCreator(){
        return new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int mouseOnFramePosX = e.getX() - 50; //Magic Number to center the piece in the mouse in x axis.
                int mouseOnFramePosY = e.getY() - 100; //Magic Number to center the piece in the mouse in y axis.
                if (pieceSelected != null){
                    pieceRenderMouse.setIcon(pieceSelected.getPieceImage());
                    glassPanel.setBounds(mouseOnFramePosX,mouseOnFramePosY,JPANEL_WIDTH,JPANEL_HEIGHT);
                    boardGameChessFrame.revalidate();
                    boardGameChessFrame.repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        };
    }

    /**
     * Remove the label of a spot of the boardGameUI.
     * @param spotPosX
     * @param spotPosY
     */
    private void removeBoardGamePieceLabel(int spotPosX, int spotPosY) {
        boardGameUI[spotPosX][spotPosY].removeAll();
        reMoveAndPaint(spotPosX, spotPosY);
    }

    /**
     * Reset background of the boardGameUI to black and white.
     * @param black
     * @param white
     */
    public void repaintBackground(Color black,Color white){
        boolean isBlack = true;
        for (int y = 0; y<=7;y++){
            for (int x = 0; x<=7;x++){
                Color desiredColor;
                if (isBlack){
                    desiredColor = black;
                }
                else {
                    desiredColor = white;
                }
                isBlack = !isBlack;
                boardGameUI[x][y].setBackground(desiredColor);
                boardGameUI[x][y].setBounds(100 * x,700-(100 * y),100,100);
            }
            isBlack = !isBlack;
        }

    }

    /**
     * Highlight a spot of the boardGameUI.
     * @param xBoard
     * @param yBoard
     * @param blackHighlight
     * @param whiteHighlight
     */
    public void highlightSpot(int xBoard,int yBoard,Color blackHighlight,Color whiteHighlight){
        if(xBoard % 2 == 0){
            if(yBoard % 2 == 0){
                boardGameUI[xBoard][yBoard].setBackground(blackHighlight);

            }else{
                boardGameUI[xBoard][yBoard].setBackground(whiteHighlight);

            }
        }else {
            if(yBoard % 2 == 0){
                boardGameUI[xBoard][yBoard].setBackground(whiteHighlight);

            }else{
                boardGameUI[xBoard][yBoard].setBackground(blackHighlight);

            }
        }

    }

    /**
     * Repaint one spot of the BoardGame UI.
     * @param x X position of the spot.
     * @param y Y position of the spot.
     */
    private void reMoveAndPaint(int x, int y) {
        boardGameUI[x][y].revalidate();
        boardGameUI[x][y].repaint();
    }

    /**
     * Don't allow to move the piece of the other player's round.
     * @return false if the player is trying to move the piece of the other player's round.
     */
    private boolean preventWrongTurnMove(){
        if(boardGame.rules.isWhiteTurn()){
            if(pieceSelected.getColor() != util.Color.WHITE){
                pieceSelected = null;
                return true;
            }
        } else {
            if(pieceSelected.getColor() != util.Color.BLACK){
                pieceSelected = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Receives a Piece and puts it in the BoardGame UI respective position.
     * @param piece Piece to be spawned.
     * @param spotPosX X position of the spot.
     * @param spotPosY Y position of the spot.
     */
    private void spawnPiece(Piece piece,int spotPosX,int spotPosY){
        PieceUI pieceUi = new PieceUI(piece, JPANEL_WIDTH*piece.getPosX(), JPANEL_HEIGHT*piece.getPosY());

        JLabel jPiece = new JLabel();
        jPiece.setIcon(pieceUi.getPieceImage());

        boardGameUI[spotPosX][spotPosY].add(jPiece);
        boardGameUI[spotPosX][spotPosY].moveToFront(jPiece);

        boardGameChessFrame.setVisible(true);
        boardGameChessFrame.repaint();
    }

    private void insertPossiblePositions(LinkedList<Spot> positions){
        for (Spot spot : positions){
            if(boardGame.isEnemy(spot.getPosX(), spot.getPosY(), pieceSelected)){
                highlightSpot(spot.getPosX(), spot.getPosY(), RED_BLACK, RED_WHITE);
            } else {
                boardGameUI[spot.getPosX()][spot.getPosY()].add(highlightCircle());
            }
        }
            boardGameChessFrame.setVisible(true);
            boardGameChessFrame.revalidate();
            boardGameChessFrame.repaint();
    }

    private void removePossiblePositions(LinkedList<Spot> positions){
        for (Spot spot : positions){
            if(!boardGame.isOccupied(spot.getPosX(), spot.getPosY())){
                boardGameUI[spot.getPosX()][spot.getPosY()].removeAll();
            }
        }
        boardGameChessFrame.setVisible(true);
        boardGameChessFrame.revalidate();
        boardGameChessFrame.repaint();
    }

    private JLabel highlightCircle(){
        JLabel highlightLabel = new JLabel();
        ImageIcon highlightIcon = new ImageIcon("resources/highlight-position.png");

        highlightIcon = ImageThreatment.pieceImageResize(highlightIcon, 90, 90);

        highlightLabel.setIcon(highlightIcon);

        return highlightLabel;

    }


    private void playMovePieceSFX(){
        File soundFilePath = new File("resources/sfx/move-self.wav");

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(soundFilePath);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void playCapturePieceSFX(){
        File soundFilePath = new File("resources/sfx/capture.wav");

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(soundFilePath);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void playCheckPieceSFX(){
        File soundFilePath = new File("resources/sfx/check.wav");

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(soundFilePath);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void playStartGamePieceSFX(){
        File soundFilePath = new File("resources/sfx/startgame.wav");

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(soundFilePath);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void playGameOverPieceSFX(){
        File soundFilePath = new File("resources/sfx/game-over.wav");

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(soundFilePath);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void playRockyPieceSFX(){
        File soundFilePath = new File("resources/sfx/rocky.wav");

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(soundFilePath);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
