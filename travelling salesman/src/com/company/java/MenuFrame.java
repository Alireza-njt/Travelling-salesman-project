
package com.company.java;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class MenuFrame extends JFrame implements ActionListener {

    final private JButton newGameButton;
    final private JButton loadGameButton;
    final private JButton exitButton;
    final private JButton soundButton;

    static private GamePlayFrame gamePlayFrame;

    public static GamePlayFrame getGamePlayFrame() {
        return gamePlayFrame;
    }

    ImageIcon imageicon =
            new ImageIcon("images\\treasure images\\golden glass.png");
    Image menuWallpaperImage =
            new ImageIcon("images\\menu frame components images\\menu wallpaper.png").getImage();
    Image DragonScrollImage =
            new ImageIcon("images\\treasure images\\Dragon scroll.png").getImage();
    Image redDragonImage =
            new ImageIcon("images\\menu frame components images\\red dragon.png").getImage();
    Image goldenGlassImage =
            new ImageIcon("images\\treasure images\\golden glass.png").getImage();

    public MenuFrame() {
        this.setLayout(null);
        //----"New Game" Button------
        newGameButton = new JButton("New Game");
        newGameButton.setBounds(140, 270, 100, 60);
        newGameButton.setFocusable(false);
        newGameButton.addActionListener(this);
        newGameButton.setBackground(new Color(243, 112, 66));
        newGameButton.setForeground(Color.BLACK);
        newGameButton.setFont(new Font("Modern No. 20", Font.BOLD, 15));
        //----"Load Game" Button---------------------
        loadGameButton = new JButton("Load Game");
        loadGameButton.setBounds(140, 370, 100, 60);
        loadGameButton.setFocusable(false);
        loadGameButton.addActionListener(this);
        loadGameButton.setBackground(new Color(243, 112, 66));
        loadGameButton.setForeground(Color.black);
        loadGameButton.setFont(new Font("Modern No. 20", Font.BOLD, 14));
        //-----"Exit Game" Button-----------
        exitButton = new JButton("Exit");
        exitButton.setBounds(140, 470, 100, 60);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);
        exitButton.setBackground(new Color(243, 112, 66));
        exitButton.setForeground(Color.black);
        exitButton.setFont(new Font("Modern No. 20", Font.BOLD, 25));
        //-----"Sound" Button------------
        soundButton = new JButton("Sound");
        soundButton.setBounds(110, 590, 100, 60);
        soundButton.setFocusable(false);
        soundButton.addActionListener(this);
        soundButton.setBackground(new Color(0x1035AC));
        soundButton.setForeground(Color.white);
        soundButton.setFont(new Font("Modern No. 20", Font.BOLD, 20));
        //*********add buttons to Menu Frame*********************************
        this.add(newGameButton);
        this.add(loadGameButton);
        this.add(exitButton);
        this.add(soundButton);
        //*******************************************************************
        this.setTitle("Travelling Salesman");
        this.setSize(1400, 850);
        this.setResizable(false);
        this.setIconImage(imageicon.getImage());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        new GameSound("chinese music");
    }


    public void paint(Graphics graphics) {
        Graphics2D g2D = (Graphics2D) graphics;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //------------- create "Japanese Font" with size 60 -----------------------
        String filenameJapaneseFont = "fonts\\Japanese 3017.ttf";
        Font fontJapanese60 = null;
        try {
            fontJapanese60 = Font.createFont(Font.TRUETYPE_FONT, new File(filenameJapaneseFont));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        fontJapanese60 = fontJapanese60.deriveFont(Font.BOLD, 60);
        ge.registerFont(fontJapanese60);
        //------------------- End of create "Japanese Font" ----------------------
        g2D.drawImage(menuWallpaperImage, 0, 0, 1400, 850, 0, 0, 6500, 4701, null);
        g2D.drawImage(DragonScrollImage, 100, 260, 300, 400, 0, 0, 658, 419, null);
        g2D.drawImage(DragonScrollImage, 100, 360, 300, 500, 0, 0, 658, 419, null);
        g2D.drawImage(DragonScrollImage, 100, 460, 300, 600, 0, 0, 658, 419, null);
        g2D.drawImage(redDragonImage, 350, 160, 850, 680, 0, 0, 714, 1000, null);
        g2D.drawImage(goldenGlassImage, 30, 30, 130, 200, 0, 0, 1200, 1600, null);
        g2D.setFont(fontJapanese60);
        g2D.setColor(new Color(205, 7, 30));
        g2D.drawString("Travelling Salesman", 105, 150);
        g2D.setFont(new Font("Ink free" , Font.BOLD,15));
        g2D.drawString("by : Alireza Nejati" , 115,165);
        g2D.setColor(new Color(0x1035AC));
        g2D.fillRect(115, 620, 100, 60);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGameButton) {
            String[] responses = {"Blue Player", "Red Player", "Cancel"};
            while (true) {
                int startSW = JOptionPane.showOptionDialog(null,
                        "Which player starts the game?",
                        "Start the game",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        responses,
                        0);
                if (startSW == 0) {
                    gamePlayFrame = new GamePlayFrame(0);
                    SaveGame.deleteFile();
                    this.dispose();
                    break;

                } else if (startSW == 1) {
                    gamePlayFrame = new GamePlayFrame(1);
                    SaveGame.deleteFile();
                    this.dispose();
                    break;
                } else if (startSW == 2) break;
            }
        } else if (e.getSource() == loadGameButton) {
            while (true) {
                int startSW = JOptionPane.showOptionDialog(null,
                        "Do you want to resume the saved game?",
                        "Resume saved game",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null,
                        0);
                if (startSW == 0) {
                    if (!SaveGame.existFile()) {
                            JOptionPane.showOptionDialog(
                            null,
                            "There are no saved games. Press the new game button and start a new game!",
                            "No saved game",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    }
                    else {
                        gamePlayFrame = new GamePlayFrame(2);
                        this.dispose();
                    }
                    break;
                }
                else if (startSW == 1) break;
            }
        } else if (e.getSource() == exitButton) {
            while (true) {
                int exitSW = JOptionPane.showOptionDialog(null,
                        "Do you want to Exit?",
                        "Exit",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null,
                        0);
                if (exitSW == 0) {
                    System.exit(0);
                    break;
                } else if (exitSW == 1) {
                    break;
                }
            }
        } else if (e.getSource() == soundButton) {
            ImageIcon speakerIcon = new ImageIcon("images\\speaker.png");
            String[] optionsList = {"Sound On" , "Sound Off"};
            while (true) {
                int answer = JOptionPane.showOptionDialog(null,
                        "Is the sound on or not?",
                        "Sound setting",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        speakerIcon,
                        optionsList,
                        0);
                if (answer==0) {GameSound.setSoundSW(true); break;}
                else if (answer==1) {GameSound.setSoundSW(false); break;}
            }
        }
    }
}

