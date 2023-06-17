package com.company.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class VictoryFrame extends JFrame {

    private int massageSW ;

    String playerName;

    String textR1 = String.format("The number of treasures found by the red player is %d,"
            , GamePlayPanel.getRedTreasureNo());
    String textR2 = String.format("and the number of treasures found by the blue player is %d,"
            ,GamePlayPanel.getBlueTreasureNo());
    String textR3 = String.format("but because the score of the red player is %d",
            GamePlayPanel.getRedScore());
    String textR4 = String.format("and the score of the blue player is %d,",
            GamePlayPanel.getBlueScore());
    String textB1 = String.format("The number of treasures found by the blue player is %d",
            GamePlayPanel.getBlueTreasureNo());
    String textB2 = String.format("and the number of treasures found by the red player is %d,",
            GamePlayPanel.getRedTreasureNo());
    String textB3 = String.format("but because the score of the blue player is %d" ,
            GamePlayPanel.getBlueScore());
    String textB4 = String.format("and the score of the red player is %d," , GamePlayPanel.getRedScore());

    ImageIcon imageIcon = new ImageIcon("images\\treasure images\\golden glass.png");

    Image palaceImage = new ImageIcon("images\\victory frame images\\palace.png").getImage();
    Image bluePlayerImage = new ImageIcon("images\\blue player.png").getImage();
    Image redPlayerImage = new ImageIcon("images\\red player.png").getImage();
    Image medal1Image = new ImageIcon("images\\victory frame images\\1st medal.png").getImage();
    Image medal2Image = new ImageIcon("images\\victory frame images\\2nd medal.png").getImage();
    Image bluePieceImage = new ImageIcon("images\\game board components images\\blue game piece.png").getImage();
    Image redPieceImage = new ImageIcon("images\\game board components images\\red game piece.png").getImage();
    Image crownImage = new ImageIcon("images\\victory frame images\\crown.png").getImage();

    public VictoryFrame(String playerName , int massageSW) {
        this.massageSW = massageSW;
        this.playerName = playerName;
        new GameSound("victory");
        this.setIconImage(imageIcon.getImage());
        if (playerName.equals("Blue") || playerName.equals("blue")) {
            this.setTitle("the blue player wins !!! :)))");
        } else if (playerName.equals("Red") || playerName.equals("red")) {
            this.setTitle("the red player wins !!! :)))");
        }
        this.setSize(1100, 575);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                while (true) {
                    String[] option = {"Exit", "View board", "Back to menu"};
                    int answer = JOptionPane.showOptionDialog(null,
                            "What Do you want?",
                            "Select Exit Mode",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            option,
                            0);
                    if (answer == 0) {
                        System.exit(0);
                        break;
                    } else if (answer == 1) {
                        break;
                    } else if (answer == 2) {
                        MenuFrame.getGamePlayFrame().dispose();
                        new MenuFrame();
                        break;
                    }
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //------------------ create "Middle Ages Font" with size 50---------------------
        String filenameMiddleAgesFont = "fonts\\MiddleAgesDeco_PERSONAL_USE.ttf";
        Font fontMiddleAges50 = null;
        try {
            fontMiddleAges50 = Font.createFont(Font.TRUETYPE_FONT, new File(filenameMiddleAgesFont));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fontMiddleAges50 = fontMiddleAges50.deriveFont(Font.BOLD, 50);
        ge.registerFont(fontMiddleAges50);
        //-------------------------------------------------------------------------
        g2D.drawImage(palaceImage, 0, 0, 1100, 575, null);
        g2D.setFont(fontMiddleAges50);
        if (playerName.equals("Red") || playerName.equals("red")) {
            g2D.setColor(new Color(255,255,255,130));
            g2D.fillRect(240, 50, 675, 100);
            g2D.drawImage(redPlayerImage, 10, 75, 250, 500, null);
            g2D.drawImage(bluePlayerImage, 150, 215, 320, 390, null);
            g2D.setColor(new Color(255, 38, 40));
            g2D.drawString("The Red player wins !", 250, 117);
            g2D.drawImage(medal1Image, 100, 425, 75, 113, null);
            g2D.drawImage(medal2Image, 270, 425, 75, 113, null);
            g2D.drawImage(redPieceImage,850,338,225,225,null);
            g2D.setFont(new Font("Modern No. 20" , Font.BOLD , 19));
            g2D.setColor(Color.WHITE);
            if (massageSW==0) {
            g2D.drawString("The reason why the red player wins :" , 370,415);
            g2D.drawString(textR1, 370,445);
            g2D.drawString(textR2, 370,475);
            g2D.drawString("and due to the difference in the number of treasures found,",370,505);
            g2D.drawString("the red player wins." , 370,535);
            }
            else if (massageSW==1) {
                g2D.drawString("The reason why the red player wins :", 370, 385);
                g2D.drawString("The number of treasures found by the red player and", 370, 415);
                g2D.drawString("the number of treasures found by the blue player are equal,", 370, 445);
                g2D.drawString(textR3, 370, 475);
                g2D.drawString(textR4, 370, 505);
                g2D.drawString("then the red player is the winner.", 370, 535);
            }
            else if (massageSW==2) {
                g2D.drawString("The reason why the red player wins : ", 370, 385);
                g2D.drawString("The number of treasures found by the red player and", 370, 415);
                g2D.drawString("the number of treasures found by the blue player are equal,", 370, 445);
                g2D.drawString("and the points of the red player and the blue player are equal,", 370, 475);
                g2D.drawString("but because the red player found the most valuable treasure of", 370, 505);
                g2D.drawString("the game (diamond ring), the red player wins.", 370, 535);
            }
        } else if (playerName.equals("Blue") || playerName.equals("blue")) {
            g2D.setColor(new Color(0,0,0,165));
            g2D.fillRect(240, 50, 675, 100);
            g2D.drawImage(bluePlayerImage, -95, 43, 475, 580, null);
            g2D.drawImage(redPlayerImage, 200, 250, 170, 320, null);
            g2D.setColor(new Color(0, 142, 200));
            g2D.drawString("The Blue player wins !", 250, 117);
            g2D.drawImage(medal1Image, 90, 425, 75, 113, null);
            g2D.drawImage(medal2Image, 252, 425, 75, 113, null);
            g2D.drawImage(bluePieceImage,853,338,225,225,null);
            g2D.setFont(new Font("Modern No. 20" , Font.BOLD , 19));
            g2D.setColor(Color.WHITE);
            if (massageSW==0) {
                g2D.drawString("The reason why the blue player wins :", 370, 415);
                g2D.drawString(textB1, 370, 445);
                g2D.drawString(textB2, 370, 475);
                g2D.drawString("and due to the difference in the number of treasures found,", 370, 505);
                g2D.drawString("the blue player wins.", 370, 535);
            }
            else if (massageSW==1) {
                g2D.drawString("The reason why the blue player wins : ", 370, 385);
                g2D.drawString("The number of treasures found by the blue player and", 370, 415);
                g2D.drawString("the number of treasures found by the red player are equal,", 370, 445);
                g2D.drawString(textB3, 370, 475);
                g2D.drawString(textB4, 370, 505);
                g2D.drawString("then the blue player is the winner.", 370, 535);
            }
            else if (massageSW==2) {
                g2D.drawString("The reason why the blue player wins: ", 370, 385);
                g2D.drawString("The number of treasures found by the blue player and", 370, 415);
                g2D.drawString("the number of treasures found by the red player are equal,", 370, 445);
                g2D.drawString("and the points of the blue player and the red player are equal,", 370, 475);
                g2D.drawString("but because the blue player found the most valuable treasure of", 370, 505);
                g2D.drawString("the game (diamond ring), the blue player wins.", 370, 535);
            }
        }
        g2D.drawImage(crownImage,850,163,225,175,null);
    }

}
