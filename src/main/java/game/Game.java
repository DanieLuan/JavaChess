package game;

import board.Board;
import ui.BoardUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {


    private Board board;
    private BoardUI boardUI;
    JButton startButton = new JButton("Start Game");
    public Game(){

        setTitle("Chess-Java");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(null);
        startButton.setBounds(75, 50, 100, 50);
        add(startButton);

        startButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            board = new Board();
            boardUI = new BoardUI(board);
            boardUI.spawnPiecesStarter();
        }
    }
}

