package com.company.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CastlePanel extends JPanel implements ActionListener {

    final private JButton diamondRingButton;
    final private JButton jeweledSwordButton;
    final private JButton goldenGlassButton;
    final private JButton glassCupButton;
    final private JButton woodenBowButton;
    final private JButton steelShieldButton;
    final private JButton goldenKeyButton;
    final private JButton dragonScrollButton;

    private static boolean buttonsActivitySW;

    public static void setButtonsActivitySW(boolean buttonsActivitySW) {
        CastlePanel.buttonsActivitySW = buttonsActivitySW;
    }

    public CastlePanel() {
        this.setPreferredSize(new Dimension(600,320));
        this.setLayout(null);
        buttonsActivitySW = true;
        //***
        diamondRingButton = new JButton("Press");
        diamondRingButton.setBounds(43,90,65,65);
        diamondRingButton.setFocusable(false);
        diamondRingButton.addActionListener(this);
        diamondRingButton.setBackground(new Color(48,25,52));
        diamondRingButton.setForeground(new Color(250,218,94));
        diamondRingButton.setFont(new Font("Ink free",Font.BOLD,13));
        //***
        jeweledSwordButton = new JButton("Press");
        jeweledSwordButton.setBounds(193,90,65,65);
        jeweledSwordButton.setFocusable(false);
        jeweledSwordButton.addActionListener(this);
        jeweledSwordButton.setBackground(new Color(48,25,52));
        jeweledSwordButton.setForeground(new Color(250,218,94));
        jeweledSwordButton.setFont(new Font("Ink free",Font.BOLD,13));
        //***
        goldenGlassButton = new JButton("Press");
        goldenGlassButton.setBounds(343,90,65,65);
        goldenGlassButton.setFocusable(false);
        goldenGlassButton.addActionListener(this);
        goldenGlassButton.setBackground(new Color(48,25,52));
        goldenGlassButton.setForeground(new Color(250,218,94));
        goldenGlassButton.setFont(new Font("Ink free",Font.BOLD,13));
        //***
        glassCupButton = new JButton("Press");
        glassCupButton.setBounds(493,90,65,65);
        glassCupButton.setFocusable(false);
        glassCupButton.addActionListener(this);
        glassCupButton.setBackground(new Color(48,25,52));
        glassCupButton.setForeground(new Color(250,218,94));
        glassCupButton.setFont(new Font("Ink free",Font.BOLD,13));
        //***
        woodenBowButton = new JButton("Press");
        woodenBowButton.setBounds(43,200,65,65);
        woodenBowButton.setFocusable(false);
        woodenBowButton.addActionListener(this);
        woodenBowButton.setBackground(new Color(48,25,52));
        woodenBowButton.setForeground(new Color(250,218,94));
        woodenBowButton.setFont(new Font("Ink free",Font.BOLD,13));
        //***
        steelShieldButton = new JButton("Press");
        steelShieldButton.setBounds(193,200,65,65);
        steelShieldButton.setFocusable(false);
        steelShieldButton.addActionListener(this);
        steelShieldButton.setBackground(new Color(48,25,52));
        steelShieldButton.setForeground(new Color(250,218,94));
        steelShieldButton.setFont(new Font("Ink free",Font.BOLD,13));
        //***
        goldenKeyButton = new JButton("Press");
        goldenKeyButton.setBounds(343,200,65,65);
        goldenKeyButton.setFocusable(false);
        goldenKeyButton.addActionListener(this);
        goldenKeyButton.setBackground(new Color(48,25,52));
        goldenKeyButton.setForeground(new Color(250,218,94));
        goldenKeyButton.setFont(new Font("Ink free",Font.BOLD,13));
        //***
        dragonScrollButton = new JButton("Press");
        dragonScrollButton.setBounds(493,200,65,65);
        dragonScrollButton.setFocusable(false);
        dragonScrollButton.addActionListener(this);
        dragonScrollButton.setBackground(new Color(48,25,52));
        dragonScrollButton.setForeground(new Color(250,218,94));
        dragonScrollButton.setFont(new Font("Ink free",Font.BOLD,13));
        //***
        this.add(diamondRingButton);
        this.add(jeweledSwordButton);
        this.add(goldenGlassButton);
        this.add(glassCupButton);
        this.add(woodenBowButton);
        this.add(steelShieldButton);
        this.add(goldenKeyButton);
        this.add(dragonScrollButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==diamondRingButton && GamePlayPanel.getQuestSW()==0 && buttonsActivitySW) {
            new TreasureLocationTextFields(0);
        }
        else if (e.getSource()==jeweledSwordButton && GamePlayPanel.getQuestSW()==1 && buttonsActivitySW) {
            new TreasureLocationTextFields(1);
        }
        else if (e.getSource()==goldenGlassButton && GamePlayPanel.getQuestSW()==2 && buttonsActivitySW) {
            new TreasureLocationTextFields(2);
        }
        else if (e.getSource()==glassCupButton && GamePlayPanel.getQuestSW()==3 && buttonsActivitySW) {
            new TreasureLocationTextFields(3);
        }
        else if (e.getSource()==woodenBowButton && GamePlayPanel.getQuestSW()==4 && buttonsActivitySW) {
            new TreasureLocationTextFields(4);
        }
        else if (e.getSource()==steelShieldButton && GamePlayPanel.getQuestSW()==5 && buttonsActivitySW){
            new TreasureLocationTextFields(5);
        }
        else if (e.getSource()==goldenKeyButton && GamePlayPanel.getQuestSW()==6 && buttonsActivitySW) {
            new TreasureLocationTextFields(6);
        }
        else if (e.getSource()==dragonScrollButton && GamePlayPanel.getQuestSW()==7 && buttonsActivitySW) {
            new TreasureLocationTextFields(7);
        }
    }
}
