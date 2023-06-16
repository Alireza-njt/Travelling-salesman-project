package com.company.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CastleFrame extends JFrame {

    public CastleFrame() {
        CastlePanel castlePanel = new CastlePanel();
        this.setTitle("Castle");
        ImageIcon imageicon = new ImageIcon("images\\treasure images\\golden glass.png");
        this.setIconImage(imageicon.getImage());
        this.add(castlePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(new Color(250,218,94));
        g2D.fillRect(0,0,1000,1000);
        g2D.setColor(new Color(48,25,52));
        g2D.setFont(new Font("Ink free" , Font.BOLD,30));
        g2D.drawString("The name of the treasure : " , 20,70);
        g2D.setFont(new Font("Ink free" , Font.BOLD,20));
        g2D.drawString("Diamond Ring" , 25 , 110);
        g2D.drawString("Jeweled Sword" , 165 , 110);
        g2D.drawString("Golden Glass" , 325, 110);
        g2D.drawString("Glass Cup", 485 , 110);
        g2D.drawString("Wooden Bow" , 25 , 220);
        g2D.drawString("Steel Shield" , 175,220);
        g2D.drawString("Golden Key" , 330 , 220);
        g2D.drawString("Dragon Scroll" , 475 , 220);
        g2D.fillRect(50,120,65,65);
        g2D.fillRect(200,120,65,65);
        g2D.fillRect(350,120,65,65);
        g2D.fillRect(500,120,65,65);
        g2D.fillRect(50,230,65,65);
        g2D.fillRect(200,230,65,65);
        g2D.fillRect(350,230,65,65);
        g2D.fillRect(500,230,65,65);
    }
}
