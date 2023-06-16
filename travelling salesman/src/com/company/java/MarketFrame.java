package com.company.java;

import javax.swing.*;

public class MarketFrame extends JFrame {

    MarketPanel marketPanel;

    ImageIcon icon = new ImageIcon("images\\black market icon.png");

    public MarketFrame (String playerName) {
        marketPanel = new MarketPanel(playerName);
        this.setIconImage(icon.getImage());
        this.setTitle("Market");
        this.add(marketPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
