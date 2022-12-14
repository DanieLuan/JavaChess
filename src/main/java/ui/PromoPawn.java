package ui;

import pieces.*;
import util.Color;
import util.Type;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PromoPawn extends JFrame implements ActionListener {
    JButton queenButton = new JButton("Queen");
    JButton bishopButton = new JButton("Bishop");
    JButton rookButton = new JButton("Rook");
    JButton knightButton = new JButton("Knight");

    private util.Type type = util.Type.BISHOP;

    private boolean isFinished;

    public PromoPawn(){
        isFinished = true;
        setTitle("Promoção de Peão");
        setSize(416, 139);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);

        queenButton.setBounds(0,0,100,100);
        add(queenButton);
        bishopButton.setBounds(100,0,100,100);
        add(bishopButton);
        rookButton.setBounds(200,0,100,100);
        add(rookButton);
        knightButton.setBounds(300,0,100,100);
        add(knightButton);
    }

    public util.Type typeRequired(){
        return type;
    }

    public boolean isFinished(){
        return isFinished;
    }

    public Piece pieceToPromo(int xPromo, int yPromo, util.Type type, Color color){
        if(type == util.Type.QUEEN){
            isFinished = true;
            return new Queen(color, xPromo, yPromo);
        }
        if(type == util.Type.BISHOP){
            isFinished = true;
            return new Bishop(color, xPromo, yPromo);
        }
        if(type == util.Type.ROOK){
            isFinished = true;
            return new Rook(color, xPromo, yPromo);
        }
        if(type == util.Type.KNIGHT){
            isFinished = true;
            return new Knight(color, xPromo, yPromo);

        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == queenButton){
            type = util.Type.QUEEN;
        }
        if( e.getSource() == bishopButton){
            type = util.Type.BISHOP;
        }
        if( e.getSource() == rookButton){
            type = util.Type.ROOK;
        }
        if( e.getSource() == knightButton){
            type = util.Type.KNIGHT;
        }

    }
}
