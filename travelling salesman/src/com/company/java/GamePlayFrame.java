
package com.company.java;

import javax.swing.*;

public class GamePlayFrame extends JFrame {
    GamePlayPanel gamePlayPanel ;

    GamePlayFrame(int gameStartSW) {
        if(gameStartSW==0) {gamePlayPanel = new GamePlayPanel(0);}
        else if (gameStartSW==1) {gamePlayPanel = new GamePlayPanel(3);}
        else if (gameStartSW==2) {gamePlayPanel = new GamePlayPanel(-1);}
        if (gameStartSW==0 || gameStartSW==1) new GameSound("start the game");
        else if (gameStartSW==2) new GameSound("success");
        ImageIcon imageicon = new ImageIcon("images\\treasure images\\golden glass.png");
        this.setIconImage(imageicon.getImage());
        this.setTitle("Travelling Salesman");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.add(gamePlayPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}