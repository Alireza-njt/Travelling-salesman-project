package com.company.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MarketPanel extends JPanel implements ActionListener {

    final private Timer timer;
    Random random = new Random();
    private int marketPaintTurn = 0;
    private String playerName;

    private int diamondRingLocation = ((GamePlayPanel.getXPositionDiamondRing() - 10) / 60)
            - ((GamePlayPanel.getYPositionDiamondRing() - 10) / 6) + 91;

    private int jeweledSwordLocation = ((GamePlayPanel.getXPositionJeweledSword() - 10) / 60)
            - ((GamePlayPanel.getYPositionJeweledSword() - 10) / 6) + 91;

    private int goldenGlassLocation = ((GamePlayPanel.getXPositionGoldenGlass() - 10) / 60)
            - ((GamePlayPanel.getYPositionGoldenGlass() - 10) / 6) + 91;

    private int glassCupLocation = ((GamePlayPanel.getXPositionGlassCup() - 10) / 60)
            - ((GamePlayPanel.getYPositionGlassCup() - 10) / 6) + 91;

    private int woodenBowLocation = ((GamePlayPanel.getXPositionWoodenBow() - 10) / 60)
            - ((GamePlayPanel.getYPositionWoodenBow() - 10) / 6) + 91;

    private int steelShieldLocation = ((GamePlayPanel.getXPositionSteelShield() - 10) / 60)
            - ((GamePlayPanel.getYPositionSteelShield() - 10) / 6) + 91;

    private int goldenKeyLocation = ((GamePlayPanel.getXPositionGoldenKey() - 10) / 60)
            - ((GamePlayPanel.getYPositionGoldenKey() - 10) / 6) + 91;

    private int dragonScrollLocation = ((GamePlayPanel.getXPositionDragonScroll() - 10) / 60)
            - ((GamePlayPanel.getYPositionDragonScroll() - 10) / 6) + 91;

    private String diamondRingLocationString = "The Diamond ring is in square number "
            +diamondRingLocation;
    private String jeweledSwordLocationString = "The Jeweled sword is in square number "
            +jeweledSwordLocation;
    private String goldenGlassLocationString = "The Golden glass is in square number "
            +goldenGlassLocation;
    private String glassCupLocationString = "The Glass cup is in square number "
            +glassCupLocation;
    private String woodenBowLocationString = "The Wooden bow is in square number "
            +woodenBowLocation;
    private String steelShieldLocationString = "The Steel shield is in square number "
            +steelShieldLocation;
    private String goldenKeyLocationString = "The Golden key is in square number "
            +goldenKeyLocation;
    private String dragonScrollLocationString = "The Dragon Scroll is in square number "
            +dragonScrollLocation;


    final private JButton buyGun1Button;  // Revolver buy button (low level gun)
    final private JButton buyGun2Button;  // Machine gun buy button (medium level gun)
    final private JButton buyGun3Button;  // Rocket-propelled grenade (RPG) buy button (high level gun)
    final private JButton buyRandomTreasure;

    private final int INVISIBLE = 10000;
    private final int Y_POSITION_TICK_1 = 185;
    private final int Y_POSITION_TICK_2 = 280;
    private final int Y_POSITION_TICK_3 = 375;
    private final int Y_POSITION_TICK_4 = 470;

    private int yPositionTicksList[][] = new int[3][8];

    private static int ticksListSW[] = new int[8];

    public static int getTicksListSW(int number) {
        return ticksListSW[number];
    }

    public static void setTicksListSW(int number, int SW) {
        ticksListSW[number] = SW;
    }

    Image backGroundImage =
            new ImageIcon("images\\market panel components images\\market.png").getImage();
    Image gun1Image =
            new ImageIcon("images\\gun images\\gun1.png").getImage();
    Image gun2Image =
            new ImageIcon("images\\gun images\\gun2.png").getImage();
    Image gun3Image =
            new ImageIcon("images\\gun images\\gun3.png").getImage();
    Image diamondRingImage =
            new ImageIcon("images\\treasure images\\diamond ring.png").getImage();
    Image jeweledSwordImage =
            new ImageIcon("images\\treasure images\\jeweled sword.png").getImage();
    Image goldenGlassImage =
            new ImageIcon("images\\treasure images\\golden glass.png").getImage();
    Image glassCupImage =
            new ImageIcon("images\\treasure images\\glass cup.png").getImage();
    Image woodenBowImage =
            new ImageIcon("images\\treasure images\\wooden bow.png").getImage();
    Image steelShieldImage =
            new ImageIcon("images\\treasure images\\steel shield.png").getImage();
    Image goldenKeyImage =
            new ImageIcon("images\\treasure images\\golden key.png").getImage();
    Image dragonScrollImage =
            new ImageIcon("images\\treasure images\\dragon scroll.png").getImage();
    Image blackMarketImage =
            new ImageIcon("images\\black market icon.png").getImage();
    Image redTickImage =
            new ImageIcon("images\\market panel components images\\tick-red.png").getImage();
    Image yellowTickImage =
            new ImageIcon("images\\market panel components images\\tick-yellow.png").getImage();
    Image greenTickImage =
            new ImageIcon("images\\market panel components images\\tick-green.png").getImage();
    ImageIcon happyEmoji =
            new ImageIcon("images\\happy emoji icon.png");
    ImageIcon sadIEmoji =
            new ImageIcon("images\\sad emoji icon.png");

    String welcomeMassage;


    public MarketPanel(String playerName) {
        this.playerName = playerName;
        if (playerName.equals("blue") || playerName.equals("Blue"))
            welcomeMassage = "Welcome to the game market , blue player !";
        else if (playerName.equals("red") || playerName.equals("Red"))
            welcomeMassage = "Welcome to the game market , red player !";
        this.setPreferredSize(new Dimension(1050, 640));
        this.setLayout(null);
        timer = new Timer(1000, this);
        timer.start();
        //--------------------------------------------------------------------------------
        buyGun1Button = new JButton("Buy");
        buyGun1Button.setBounds(375, 185, 65, 65);
        buyGun1Button.setFocusable(false);
        buyGun1Button.addActionListener(this);
        buyGun1Button.setBackground(Color.WHITE);
        buyGun1Button.setForeground(Color.black);
        buyGun1Button.setFont(new Font("Modern No. 20", Font.BOLD, 15));
        //---------------------------------------------------------------------------------
        buyGun2Button = new JButton("Buy");
        buyGun2Button.setBounds(375, 320, 65, 65);
        buyGun2Button.setFocusable(false);
        buyGun2Button.addActionListener(this);
        buyGun2Button.setBackground(Color.WHITE);
        buyGun2Button.setForeground(Color.black);
        buyGun2Button.setFont(new Font("Modern No. 20", Font.BOLD, 15));
        //---------------------------------------------------------------------------------
        buyGun3Button = new JButton("Buy");
        buyGun3Button.setBounds(375, 460, 65, 65);
        buyGun3Button.setFocusable(false);
        buyGun3Button.addActionListener(this);
        buyGun3Button.setBackground(Color.WHITE);
        buyGun3Button.setForeground(Color.black);
        buyGun3Button.setFont(new Font("Modern No. 20", Font.BOLD, 15));
        //---------------------------------------------------------------------------------
        buyRandomTreasure = new JButton("Buy");
        buyRandomTreasure.setBounds(845, 135, 85, 30);
        buyRandomTreasure.setFocusable(false);
        buyRandomTreasure.addActionListener(this);
        buyRandomTreasure.setBackground(Color.BLACK);
        buyRandomTreasure.setForeground(Color.WHITE);
        buyRandomTreasure.setFont(new Font("Modern No. 20", Font.BOLD, 13));
        //---------------------------------------------------------------------------------
        this.add(buyGun1Button);
        this.add(buyGun2Button);
        this.add(buyGun3Button);
        this.add(buyRandomTreasure);

    }

    public void paint(Graphics graphics) {
        for (int i = 0; i < 8; i++) {
            int yPosition = 0;
            if (i % 4 == 0) yPosition = Y_POSITION_TICK_1;
            else if (i % 4 == 1) yPosition = Y_POSITION_TICK_2;
            else if (i % 4 == 2) yPosition = Y_POSITION_TICK_3;
            else yPosition = Y_POSITION_TICK_4;
            switch (ticksListSW[i]) {
                case 0:
                    yPositionTicksList[0][i] = yPosition;
                    yPositionTicksList[1][i] = INVISIBLE;
                    yPositionTicksList[2][i] = INVISIBLE;
                    break;
                case 1:
                    yPositionTicksList[0][i] = INVISIBLE;
                    yPositionTicksList[1][i] = yPosition;
                    yPositionTicksList[2][i] = INVISIBLE;
                    break;
                case 2:
                    yPositionTicksList[0][i] = INVISIBLE;
                    yPositionTicksList[1][i] = INVISIBLE;
                    yPositionTicksList[2][i] = yPosition;
                    break;
            }
        }
        Graphics2D g2D = (Graphics2D) graphics;
        g2D.drawImage(backGroundImage, 0, 0, 1050, 640, null);
        g2D.setFont(new Font("Ink free", Font.BOLD, 50));
        g2D.setColor(new Color(36, 36, 36, 200));
        g2D.fillRect(0, 0, 1050, 100);
        if (marketPaintTurn % 7 == 0) {
            g2D.setColor(new Color(148, 0, 211));
            g2D.drawString(welcomeMassage, 33, 68);
        } else if (marketPaintTurn % 7 == 1) {
            g2D.setColor(new Color(75, 0, 130));
            g2D.drawString(welcomeMassage, 33, 68);
        } else if (marketPaintTurn % 7 == 2) {
            g2D.setColor(new Color(0, 0, 255));
            g2D.drawString(welcomeMassage, 33, 68);
        } else if (marketPaintTurn % 7 == 3) {
            g2D.setColor(new Color(0, 255, 0));
            g2D.drawString(welcomeMassage, 33, 68);
        } else if (marketPaintTurn % 7 == 4) {
            g2D.setColor(new Color(255, 255, 0));
            g2D.drawString(welcomeMassage, 33, 68);
        } else if (marketPaintTurn % 7 == 5) {
            g2D.setColor(new Color(255, 122, 0));
            g2D.drawString(welcomeMassage, 33, 68);
        } else if (marketPaintTurn % 7 == 6) {
            g2D.setColor(new Color(255, 0, 0));
            g2D.drawString(welcomeMassage, 33, 68);
        }
        g2D.setColor(new Color(255, 255, 255, 150));
        g2D.fillRect(100, 125, 850, 440);
        g2D.setColor(Color.black);
        g2D.setStroke(new BasicStroke(5));
        g2D.drawRect(100, 125, 850, 440);
        g2D.drawLine(450, 125, 450, 565);
        g2D.drawLine(100, 175, 950, 175);
        g2D.drawLine(710, 175, 710, 565);
        g2D.setFont(new Font("Modern No. 20", Font.BOLD, 30));
        g2D.drawString("Guns", 112, 160);
        g2D.drawString("Precious Treasures", 460, 160);
        g2D.setFont(new Font("Modern No. 20", Font.BOLD, 20));
        g2D.drawString("Revolver (low level gun)", 120, 200);
        g2D.drawString("Machine gun (medium level gun)", 120, 310);
        g2D.drawString("Rocket-propelled grenade (RPG)", 120, 450);
        g2D.drawString("(high level gun)", 120, 470);
        g2D.drawImage(gun1Image, 115, 205, 150, 83, null);
        g2D.drawImage(gun2Image, 115, 315, 188, 113, null);
        g2D.drawImage(gun3Image, 115, 475, 235, 80, null);
        g2D.drawString("Diamond Ring", 475, 200);
        g2D.drawString("Jeweled Sword", 475, 290);
        g2D.drawString("Golden Glass", 475, 380);
        g2D.drawString("Glass Cup", 475, 470);
        g2D.drawString("Wooden Bow", 725, 200);
        g2D.drawString("Steel Shield", 725, 290);
        g2D.drawString("Golden Key", 725, 380);
        g2D.drawString("Dragon Scroll", 725, 470);
        g2D.drawImage(diamondRingImage, 475, 200, 70, 70, null);
        g2D.drawImage(jeweledSwordImage, 475, 295, 70, 70, null);
        g2D.drawImage(goldenGlassImage, 475, 385, 50, 70, null);
        g2D.drawImage(glassCupImage, 475, 475, 70, 70, null);
        g2D.drawImage(woodenBowImage, 725, 200, 70, 70, null);
        g2D.drawImage(steelShieldImage, 725, 295, 70, 70, null);
        g2D.drawImage(goldenKeyImage, 725, 385, 50, 70, null);
        g2D.drawImage(dragonScrollImage, 725, 475, 100, 80, null);
        g2D.setColor(new Color(255, 255, 255));
        g2D.fillRect(635, 205, 50, 50);
        g2D.fillRect(635, 300, 50, 50);
        g2D.fillRect(635, 395, 50, 50);
        g2D.fillRect(635, 490, 50, 50);
        g2D.fillRect(875, 205, 50, 50);
        g2D.fillRect(875, 300, 50, 50);
        g2D.fillRect(875, 395, 50, 50);
        g2D.fillRect(875, 490, 50, 50);
        g2D.fillRect(375, 185, 65, 65);
        g2D.fillRect(375, 320, 65, 65);
        g2D.fillRect(375, 460, 65, 65);
        g2D.drawImage(blackMarketImage, 375, 185, 65, 65, null);
        g2D.drawImage(blackMarketImage, 375, 320, 65, 65, null);
        g2D.drawImage(blackMarketImage, 375, 460, 65, 65, null);
        g2D.setColor(Color.BLACK);
        g2D.fillRect(845, 135, 85, 30);
        g2D.setFont(new Font("Ink free", Font.BOLD, 20));
        g2D.drawString("499.99$", 360, 275);
        g2D.drawString("749.99$", 360, 410);
        g2D.drawString("999.99$", 360, 550);
        g2D.drawString("2999.99$",735,156);
        g2D.setColor(new Color(1, 50, 32));
        g2D.setFont(new Font("Modern No. 20", Font.BOLD, 20));
        g2D.drawString("+25 Power", 257, 272);
        g2D.drawString("+50 Power", 257, 407);
        g2D.drawString("+100 Power", 257, 547);
        g2D.setColor(new Color(255, 255, 255, 140));
        g2D.fillRect(100, 572, 350, 43);
        g2D.setFont(new Font("Ink free", Font.BOLD, 23));
        if (playerName.equals("blue") || playerName.equals("Blue")) {
            g2D.setColor(new Color(16, 53, 172));
            g2D.drawString("Blue player's property : " + GamePlayPanel.getBlueMoney() + "$",
                    100, 600);
        } else if (playerName.equals("red") || playerName.equals("Red")) {
            g2D.setColor(new Color(255, 38, 40));
            g2D.drawString("Red player's property : " + GamePlayPanel.getRedMoney() + "$",
                    105, 600);
        }
        g2D.setColor(new Color(255, 255, 255, 140));
        g2D.fillRect(465, 572, 480, 43);
        g2D.drawImage(redTickImage, 470, 555, 50, 75, null);
        g2D.drawImage(yellowTickImage, 600, 555, 50, 75, null);
        g2D.drawImage(greenTickImage, 740, 555, 50, 75, null);
        g2D.setFont(new Font("modern No. 20", Font.BOLD, 20));
        g2D.setColor(Color.BLACK);
        g2D.drawString(": Sold", 525, 600);
        g2D.drawString(": Found", 650, 600);
        g2D.drawString(": In the sales list", 790, 600);
        g2D.drawImage(greenTickImage, 630, yPositionTicksList[0][0], 60, 90, null);
        g2D.drawImage(greenTickImage, 630, yPositionTicksList[0][1], 60, 90, null);
        g2D.drawImage(greenTickImage, 630, yPositionTicksList[0][2], 60, 90, null);
        g2D.drawImage(greenTickImage, 630, yPositionTicksList[0][3], 60, 90, null);
        g2D.drawImage(greenTickImage, 870, yPositionTicksList[0][4], 60, 90, null);
        g2D.drawImage(greenTickImage, 870, yPositionTicksList[0][5], 60, 90, null);
        g2D.drawImage(greenTickImage, 870, yPositionTicksList[0][6], 60, 90, null);
        g2D.drawImage(greenTickImage, 870, yPositionTicksList[0][7], 60, 90, null);

        g2D.drawImage(yellowTickImage, 630, yPositionTicksList[1][0], 60, 90, null);
        g2D.drawImage(yellowTickImage, 630, yPositionTicksList[1][1], 60, 90, null);
        g2D.drawImage(yellowTickImage, 630, yPositionTicksList[1][2], 60, 90, null);
        g2D.drawImage(yellowTickImage, 630, yPositionTicksList[1][3], 60, 90, null);
        g2D.drawImage(yellowTickImage, 870, yPositionTicksList[1][4], 60, 90, null);
        g2D.drawImage(yellowTickImage, 870, yPositionTicksList[1][5], 60, 90, null);
        g2D.drawImage(yellowTickImage, 870, yPositionTicksList[1][6], 60, 90, null);
        g2D.drawImage(yellowTickImage, 870, yPositionTicksList[1][7], 60, 90, null);

        g2D.drawImage(redTickImage, 630, yPositionTicksList[2][0], 60, 90, null);
        g2D.drawImage(redTickImage, 630, yPositionTicksList[2][1], 60, 90, null);
        g2D.drawImage(redTickImage, 630, yPositionTicksList[2][2], 60, 90, null);
        g2D.drawImage(redTickImage, 630, yPositionTicksList[2][3], 60, 90, null);
        g2D.drawImage(redTickImage, 870, yPositionTicksList[2][4], 60, 90, null);
        g2D.drawImage(redTickImage, 870, yPositionTicksList[2][5], 60, 90, null);
        g2D.drawImage(redTickImage, 870, yPositionTicksList[2][6], 60, 90, null);
        g2D.drawImage(redTickImage, 870, yPositionTicksList[2][7], 60, 90, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        outer_if : if (e.getSource() == buyGun1Button || e.getSource() == buyGun2Button || e.getSource() == buyGun3Button ||
                e.getSource() == buyRandomTreasure) {
            int Answer = JOptionPane.showOptionDialog(
                    null
                    , "Are you sure about buying this item ?"
                    , "Buy item"
                    , JOptionPane.YES_NO_OPTION
                    , JOptionPane.QUESTION_MESSAGE
                    , null
                    , null
                    , 0);
            if (playerName.equals("Blue") || playerName.equals("blue")) {
                if (e.getSource() == buyGun1Button && Answer == 0) {
                    if (GamePlayPanel.getBlueMoney() < 500) {
                        JOptionPane.showOptionDialog(
                                null,
                                "Your balance is not enough to buy the item ! :(",
                                "insufficient funds",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.WARNING_MESSAGE,
                                sadIEmoji,
                                null,
                                0);
                    } else {
                        GamePlayPanel.setBluePower( GamePlayPanel.getBluePower() + 25);
                        GamePlayPanel.setBlueMoney(GamePlayPanel.getBlueMoney() - 500);
                        JOptionPane.showOptionDialog(
                                null,
                                "The purchase was successful and 25 power was added to you :)",
                                "Successful purchase",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                happyEmoji,
                                null,
                                0);
                    }
                } else if (e.getSource() == buyGun2Button && Answer == 0) {
                    if (GamePlayPanel.getBlueMoney() < 750) {
                        JOptionPane.showOptionDialog(
                                null,
                                "Your balance is not enough to buy the item ! :(",
                                "insufficient funds",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.WARNING_MESSAGE,
                                sadIEmoji,
                                null,
                                0);
                    } else {
                        GamePlayPanel.setBluePower(GamePlayPanel.getBluePower() + 50);
                        GamePlayPanel.setBlueMoney(GamePlayPanel.getBlueMoney() - 750);
                        JOptionPane.showOptionDialog(
                                null,
                                "The purchase was successful and 50 power was added to you :)",
                                "Successful purchase",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                happyEmoji,
                                null,
                                0);
                    }
                } else if (e.getSource() == buyGun3Button && Answer == 0) {
                    if (GamePlayPanel.getBlueMoney() < 1000) {
                        JOptionPane.showOptionDialog(
                                null,
                                "Your balance is not enough to buy the item ! :(",
                                "insufficient funds",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.WARNING_MESSAGE,
                                sadIEmoji,
                                null,
                                0);
                    } else{
                        GamePlayPanel.setBluePower(GamePlayPanel.getBluePower() + 100);
                        GamePlayPanel.setBlueMoney(GamePlayPanel.getBlueMoney() - 1000);
                        JOptionPane.showOptionDialog(
                                null,
                                "The purchase was successful and 100 power was added to you :)",
                                "Successful purchase",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                happyEmoji,
                                null,
                                0);
                    }
                }
                else if (e.getSource()==buyRandomTreasure && Answer==0) {
                    if (GamePlayPanel.getBlueMoney() < 2000) {
                        JOptionPane.showOptionDialog(
                                null,
                                "Your balance is not enough to buy the item ! :(",
                                "insufficient funds",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.WARNING_MESSAGE,
                                sadIEmoji,
                                null,
                                0);
                    } else {
                        int randomTreasureNumber = 0;
                        String massage = null;
                        for (int i=0 ;; i++) {
                            randomTreasureNumber = random.nextInt(8);
                            if (ticksListSW[randomTreasureNumber] == 0) break;
                            if (i==8) break outer_if;
                        }
                        switch (randomTreasureNumber) {
                            case 0:
                                massage = diamondRingLocationString;
                                GamePlayPanel.setDiamondRingOwner(1);
                                GamePlayPanel.setUsedDiamondRingSW(true);
                                break;
                            case 1:
                                massage = jeweledSwordLocationString;
                                GamePlayPanel.setJeweledSwordOwner(1);
                                GamePlayPanel.setUsedJeweledSwordSW(true);
                                break;
                            case 2:
                                massage = goldenGlassLocationString;
                                GamePlayPanel.setGoldenGlassOwner(1);
                                GamePlayPanel.setUsedGoldenGlassSW(true);
                                break;
                            case 3:
                                massage = glassCupLocationString;
                                GamePlayPanel.setGlassCupOwner(1);
                                GamePlayPanel.setUsedGlassCupSW(true);
                                break;
                            case 4:
                                massage = woodenBowLocationString;
                                GamePlayPanel.setWoodenBowOwner(1);
                                GamePlayPanel.setUsedWoodenBowSW(true);
                                break;
                            case 5:
                                massage = steelShieldLocationString;
                                GamePlayPanel.setSteelShieldOwner(1);
                                GamePlayPanel.setUsedSteelShieldSW(true);
                                break;
                            case 6:
                                massage = goldenKeyLocationString;
                                GamePlayPanel.setGoldenKeyOwner(1);
                                GamePlayPanel.setUsedGoldenKeySW(true);
                                break;
                            case 7:
                                massage = dragonScrollLocationString;
                                GamePlayPanel.setDragonScrollOwner(1);
                                GamePlayPanel.setUsedDragonScrollSW(true);
                                break;
                        }
                        GamePlayPanel.setBlueMoney(GamePlayPanel.getBlueMoney()-3000);
                        ticksListSW[randomTreasureNumber]=2;
                        JOptionPane.showOptionDialog(
                                null,
                                massage,
                                "Successful purchase",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                happyEmoji,
                                null,
                                0);
                    }
                }
            }
            else if (playerName.equals("Red") || playerName.equals("red")) {
                if (e.getSource() == buyGun1Button && Answer == 0) {
                    if (GamePlayPanel.getRedMoney() < 500) {
                        JOptionPane.showOptionDialog(
                                null,
                                "Your balance is not enough to buy the item ! :(",
                                "insufficient funds",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.WARNING_MESSAGE,
                                sadIEmoji,
                                null,
                                0);
                    } else {
                        GamePlayPanel.setRedPower(GamePlayPanel.getRedPower() + 25);
                        GamePlayPanel.setRedMoney(GamePlayPanel.getRedMoney() - 500);
                        JOptionPane.showOptionDialog(
                                null,
                                "The purchase was successful and 25 power was added to you :)",
                                "Successful purchase",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                happyEmoji,
                                null,
                                0);
                    }
                } else if (e.getSource() == buyGun2Button && Answer == 0) {
                    if (GamePlayPanel.getRedMoney() < 750) {
                        JOptionPane.showOptionDialog(
                                null,
                                "Your balance is not enough to buy the item ! :(",
                                "insufficient funds",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.WARNING_MESSAGE,
                                sadIEmoji,
                                null,
                                0);
                    } else {
                        GamePlayPanel.setRedPower(GamePlayPanel.getRedPower() + 50);
                        GamePlayPanel.setRedMoney(GamePlayPanel.getRedMoney() - 750);
                        JOptionPane.showOptionDialog(
                                null,
                                "The purchase was successful and 50 power was added to you :)",
                                "Successful purchase",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                happyEmoji,
                                null,
                                0);
                    }
                } else if (e.getSource() == buyGun3Button && Answer == 0) {
                    if (GamePlayPanel.getRedMoney() < 1000) {
                        JOptionPane.showOptionDialog(
                                null,
                                "Your balance is not enough to buy the item ! :(",
                                "insufficient funds",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.WARNING_MESSAGE,
                                sadIEmoji,
                                null,
                                0);
                    } else{
                        GamePlayPanel.setRedPower(GamePlayPanel.getRedPower() + 100);
                        GamePlayPanel.setRedMoney(GamePlayPanel.getRedMoney() - 1000);
                        JOptionPane.showOptionDialog(
                                null,
                                "The purchase was successful and 100 power was added to you :)",
                                "Successful purchase",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                happyEmoji,
                                null,
                                0);
                    }
                }
                else if (e.getSource()==buyRandomTreasure && Answer==0) {
                    if (GamePlayPanel.getRedMoney() < 2000) {
                        JOptionPane.showOptionDialog(
                                null,
                                "Your balance is not enough to buy the item ! :(",
                                "insufficient funds",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.WARNING_MESSAGE,
                                sadIEmoji,
                                null,
                                0);
                    } else{
                        int randomTreasureNumber;
                        String massage = null;
                        for (int i=0;;i++) {
                            randomTreasureNumber = random.nextInt(8);
                            if (ticksListSW[randomTreasureNumber] == 0) break;
                            if (i==8) break outer_if;
                        }
                        switch (randomTreasureNumber) {
                            case 0:
                                massage = diamondRingLocationString;
                                GamePlayPanel.setDiamondRingOwner(2);
                                GamePlayPanel.setUsedDiamondRingSW(true);
                                break;
                            case 1:
                                massage = jeweledSwordLocationString;
                                GamePlayPanel.setJeweledSwordOwner(2);
                                GamePlayPanel.setUsedJeweledSwordSW(true);
                                break;
                            case 2:
                                massage = goldenGlassLocationString;
                                GamePlayPanel.setGoldenGlassOwner(2);
                                GamePlayPanel.setUsedGoldenGlassSW(true);
                                break;
                            case 3:
                                massage = glassCupLocationString;
                                GamePlayPanel.setGlassCupOwner(2);
                                GamePlayPanel.setUsedGoldenGlassSW(true);
                                break;
                            case 4:
                                massage = woodenBowLocationString;
                                GamePlayPanel.setWoodenBowOwner(2);
                                GamePlayPanel.setUsedWoodenBowSW(true);
                                break;
                            case 5:
                                massage = steelShieldLocationString;
                                GamePlayPanel.setSteelShieldOwner(2);
                                GamePlayPanel.setUsedSteelShieldSW(true);
                                break;
                            case 6:
                                massage = goldenKeyLocationString;
                                GamePlayPanel.setGoldenKeyOwner(2);
                                GamePlayPanel.setUsedGoldenKeySW(true);
                                break;
                            case 7:
                                massage = dragonScrollLocationString;
                                GamePlayPanel.setDragonScrollOwner(2);
                                GamePlayPanel.setUsedDragonScrollSW(true);
                                break;
                        }
                        GamePlayPanel.setRedMoney(GamePlayPanel.getRedMoney()-3000);
                        ticksListSW[randomTreasureNumber]=2;
                        JOptionPane.showOptionDialog(
                                null,
                                massage,
                                "Successful purchase",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                happyEmoji,
                                null,
                                0);
                    }
                }
            }
        }
        marketPaintTurn++;
        repaint();
    }
}
