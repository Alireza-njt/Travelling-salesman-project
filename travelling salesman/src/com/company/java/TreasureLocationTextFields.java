
package com.company.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TreasureLocationTextFields extends JFrame implements ActionListener {

    ImageIcon imageIcon = new ImageIcon("images\\treasure images\\golden glass.png");
    Random random = new Random();

    private JTextField textField;
    private JButton enterButton;

    final private int Y_POSITION_SOLD_IT_TEXT_1 = 570;
    final private int Y_POSITION_SOLD_IT_TEXT_2 = 600;
    final private int Y_POSITION_SOLD_IT_TEXT_3 = 630;
    final private int Y_POSITION_SOLD_IT_TEXT_4 = 660;

    private int treasureNumber;
    private int gettingGamePlayTurn = GamePlayPanel.getGameplayTurn();

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

    private String stringDiamondRingLoc = Integer.toString(diamondRingLocation);
    private String stringJeweledSwordLoc = Integer.toString(jeweledSwordLocation);
    private String stringGoldenGlassLoc = Integer.toString(goldenGlassLocation);
    private String stringGlassCupLoc = Integer.toString(glassCupLocation);
    private String stringWoodenBowLoc = Integer.toString(woodenBowLocation);
    private String stringSteelShieldLoc = Integer.toString(steelShieldLocation);
    private String stringGoldenKeyLoc = Integer.toString(goldenKeyLocation);
    private String stringDragonScrollLoc = Integer.toString(dragonScrollLocation);

    public TreasureLocationTextFields(int treasureNumber) {
        this.treasureNumber = treasureNumber;
        this.setLayout(new FlowLayout());
        this.setIconImage(imageIcon.getImage());
        switch (treasureNumber) {
            case 0:
                this.setTitle("Enter the location of Diamond Ring");
                break;
            case 1:
                this.setTitle("Enter the location of Jeweled Sword");
                break;
            case 2:
                this.setTitle("Enter the location of Golden Glass");
                break;
            case 3:
                this.setTitle("Enter the location of Glass Cup");
                break;
            case 4:
                this.setTitle("Enter the location of Wooden Bow");
                break;
            case 5:
                this.setTitle("Enter the location of Steel Shield");
                break;
            case 6:
                this.setTitle("Enter the location of Golden Key");
                break;
            case 7:
                this.setTitle("Enter the location of Dragon Scroll");
                break;
        }

        enterButton = new JButton("Enter");
        enterButton.addActionListener(this);
        enterButton.setPreferredSize(new Dimension(80, 80));
        enterButton.setBackground(new Color(250, 218, 94));
        enterButton.setForeground(new Color(48, 25, 52));
        enterButton.setFont(new Font("Modern No. 20", Font.BOLD, 17));


        textField = new JTextField();
        textField.setPreferredSize(new Dimension(375, 80));
        textField.setFont(new Font("Ink free", Font.BOLD, 40));
        textField.setForeground(new Color(250, 218, 94));
        textField.setBackground(new Color(48, 25, 52));
        textField.setCaretColor(Color.WHITE);

        this.add(textField);
        this.add(enterButton);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gettingGamePlayTurn % 6 == 0 || gettingGamePlayTurn % 6 == 1 || gettingGamePlayTurn % 6 == 2) {
            if (e.getSource() == enterButton && treasureNumber == 0) {
                if (textField.getText().equals(stringDiamondRingLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold "
                            + "and you achieve 8000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(0,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setBlueMoney(GamePlayPanel.getBlueMoney()+3000);
                    GamePlayPanel.setBlueScore(GamePlayPanel.getBlueScore()+8000);
                    GamePlayPanel.setBlueTreasureNo(GamePlayPanel.getBlueTreasureNo()+1);
                    GamePlayPanel.setPositionYBlueSoldItText1(Y_POSITION_SOLD_IT_TEXT_1);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the diamond ring is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            } else if (e.getSource() == enterButton && treasureNumber == 1) {
                if (textField.getText().equals(stringJeweledSwordLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold "
                                    + "and you achieve 7000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(1,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setBlueMoney(GamePlayPanel.getBlueMoney()+3000);
                    GamePlayPanel.setBlueScore(GamePlayPanel.getBlueScore()+7000);
                    GamePlayPanel.setBlueTreasureNo(GamePlayPanel.getBlueTreasureNo()+1);
                    GamePlayPanel.setPositionYBlueSoldItText2(Y_POSITION_SOLD_IT_TEXT_2);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the jeweled sword is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            } else if (e.getSource() == enterButton && treasureNumber == 2) {
                if (textField.getText().equals(stringGoldenGlassLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold "
                                    + "and you achieve 6000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(2,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setBlueMoney(GamePlayPanel.getBlueMoney()+3000);
                    GamePlayPanel.setBlueScore(GamePlayPanel.getBlueScore()+6000);
                    GamePlayPanel.setBlueTreasureNo(GamePlayPanel.getBlueTreasureNo()+1);
                    GamePlayPanel.setPositionYBlueSoldItText3(Y_POSITION_SOLD_IT_TEXT_3);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the golden glass is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            } else if (e.getSource() == enterButton && treasureNumber == 3) {
                if (textField.getText().equals(stringGlassCupLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold "
                                    + "and you achieve 2000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(3,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setBlueMoney(GamePlayPanel.getBlueMoney()+3000);
                    GamePlayPanel.setBlueScore(GamePlayPanel.getBlueScore()+2000);
                    GamePlayPanel.setBlueTreasureNo(GamePlayPanel.getBlueTreasureNo()+1);
                    GamePlayPanel.setPositionYBlueSoldItText4(Y_POSITION_SOLD_IT_TEXT_4);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the glass cup is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            } else if (e.getSource() == enterButton && treasureNumber == 4) {
                if (textField.getText().equals(stringWoodenBowLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold " +
                                    "and you achieve 1000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(4,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setBlueMoney(GamePlayPanel.getBlueMoney()+3000);
                    GamePlayPanel.setBlueScore(GamePlayPanel.getBlueScore()+1000);
                    GamePlayPanel.setBlueTreasureNo(GamePlayPanel.getBlueTreasureNo()+1);
                    GamePlayPanel.setPositionYBlueSoldItText5(Y_POSITION_SOLD_IT_TEXT_1);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the wooden bow is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            } else if (e.getSource() == enterButton && treasureNumber == 5) {
                if (textField.getText().equals(stringSteelShieldLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold "
                                    + "and you achieve 3000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(5,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setBlueMoney(GamePlayPanel.getBlueMoney()+3000);
                    GamePlayPanel.setBlueScore(GamePlayPanel.getBlueScore()+3000);
                    GamePlayPanel.setBlueTreasureNo(GamePlayPanel.getBlueTreasureNo()+1);
                    GamePlayPanel.setPositionYBlueSoldItText6(Y_POSITION_SOLD_IT_TEXT_2);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the steel shield is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            } else if (e.getSource() == enterButton && treasureNumber == 6) {
                if (textField.getText().equals(stringGoldenKeyLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold ! "
                                    + "and you achieve 5000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(6,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setBlueMoney(GamePlayPanel.getBlueMoney()+3000);
                    GamePlayPanel.setBlueScore(GamePlayPanel.getBlueScore()+5000);
                    GamePlayPanel.setBlueTreasureNo(GamePlayPanel.getBlueTreasureNo()+1);
                    GamePlayPanel.setPositionYBlueSoldItText7(Y_POSITION_SOLD_IT_TEXT_3);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the golden key is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            } else if (e.getSource() == enterButton && treasureNumber == 7) {
                if (textField.getText().equals(stringDragonScrollLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold "
                            +"and you achieve 4000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(7,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setBlueMoney(GamePlayPanel.getBlueMoney()+3000);
                    GamePlayPanel.setBlueScore(GamePlayPanel.getBlueScore()+4000);
                    GamePlayPanel.setBlueTreasureNo(GamePlayPanel.getBlueTreasureNo()+1);
                    GamePlayPanel.setPositionYBlueSoldItText8(Y_POSITION_SOLD_IT_TEXT_4);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the dragon scroll is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            }
        } else if (gettingGamePlayTurn % 6 == 3 || gettingGamePlayTurn % 6 == 4 || gettingGamePlayTurn % 6 == 5) {
            if (e.getSource() == enterButton && treasureNumber == 0) {
                if (textField.getText().equals(stringDiamondRingLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold "
                            +"and you achieve 8000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(0,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setRedMoney(GamePlayPanel.getRedMoney()+3000);
                    GamePlayPanel.setRedScore(GamePlayPanel.getRedScore()+8000);
                    GamePlayPanel.setRedTreasureNo(GamePlayPanel.getRedTreasureNo()+1);
                    GamePlayPanel.setPositionYRedSoldItText1(Y_POSITION_SOLD_IT_TEXT_1);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the diamond ring is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            } else if (e.getSource() == enterButton && treasureNumber == 1) {
                if (textField.getText().equals(stringJeweledSwordLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold "
                            +"and you achieve 7000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(1,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setRedMoney(GamePlayPanel.getRedMoney()+3000);
                    GamePlayPanel.setRedScore(GamePlayPanel.getRedScore()+7000);
                    GamePlayPanel.setRedTreasureNo(GamePlayPanel.getRedTreasureNo()+1);
                    GamePlayPanel.setPositionYRedSoldItText2(Y_POSITION_SOLD_IT_TEXT_2);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the jeweled sword is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            } else if (e.getSource() == enterButton && treasureNumber == 2) {
                if (textField.getText().equals(stringGoldenGlassLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold "
                                    +"and you achieve 6000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(2,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setRedMoney(GamePlayPanel.getRedMoney()+3000);
                    GamePlayPanel.setRedScore(GamePlayPanel.getRedScore()+6000);
                    GamePlayPanel.setRedTreasureNo(GamePlayPanel.getRedTreasureNo()+1);
                    GamePlayPanel.setPositionYRedSoldItText3(Y_POSITION_SOLD_IT_TEXT_3);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the golden glass is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            } else if (e.getSource() == enterButton && treasureNumber == 3) {
                if (textField.getText().equals(stringGlassCupLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold "
                                    +"and you achieve 2000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(3,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setRedMoney(GamePlayPanel.getRedMoney()+3000);
                    GamePlayPanel.setRedScore(GamePlayPanel.getRedScore()+2000);
                    GamePlayPanel.setRedTreasureNo(GamePlayPanel.getRedTreasureNo()+1);
                    GamePlayPanel.setPositionYRedSoldItText4(Y_POSITION_SOLD_IT_TEXT_4);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the glass cup is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            } else if (e.getSource() == enterButton && treasureNumber == 4) {
                if (textField.getText().equals(stringWoodenBowLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold "
                                    +"and you achieve 1000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(4,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setRedMoney(GamePlayPanel.getRedMoney()+3000);
                    GamePlayPanel.setRedScore(GamePlayPanel.getRedScore()+1000);
                    GamePlayPanel.setRedTreasureNo(GamePlayPanel.getRedTreasureNo()+1);
                    GamePlayPanel.setPositionYRedSoldItText5(Y_POSITION_SOLD_IT_TEXT_1);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the wooden bow is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            } else if (e.getSource() == enterButton && treasureNumber == 5) {
                if (textField.getText().equals(stringSteelShieldLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold "
                                    +"and you achieve 3000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(5,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setRedMoney(GamePlayPanel.getRedMoney()+3000);
                    GamePlayPanel.setRedScore(GamePlayPanel.getRedScore()+3000);
                    GamePlayPanel.setRedTreasureNo(GamePlayPanel.getRedTreasureNo()+1);
                    GamePlayPanel.setPositionYRedSoldItText6(Y_POSITION_SOLD_IT_TEXT_2);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the steel shield is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            } else if (e.getSource() == enterButton && treasureNumber == 6) {
                if (textField.getText().equals(stringGoldenKeyLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold "
                                    +"and you achieve 5000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(6,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setRedMoney(GamePlayPanel.getRedMoney()+3000);
                    GamePlayPanel.setRedScore(GamePlayPanel.getRedScore()+5000);
                    GamePlayPanel.setRedTreasureNo(GamePlayPanel.getRedTreasureNo()+1);
                    GamePlayPanel.setPositionYRedSoldItText7(Y_POSITION_SOLD_IT_TEXT_3);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the golden key is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            } else if (e.getSource() == enterButton && treasureNumber == 7) {
                if (textField.getText().equals(stringDragonScrollLoc)) {
                    JOptionPane.showOptionDialog(
                            null,
                            "Congratulations, the treasure has been successfully sold "
                                    +"and you achieve 4000 points ! :))))",
                            "Right answer ! :)",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    GamePlayPanel.setUsedQuestSW(7,true);
                    While_Loop : while (true){
                        GamePlayPanel.setQuestSW(random.nextInt(8));
                        if (!GamePlayPanel.getUsedQuestSW(GamePlayPanel.getQuestSW())) break;
                        for (int i=0 ; i<8 ; i++) {
                            if (!GamePlayPanel.getUsedQuestSW(i)) break;
                            if (i==7) {
                                GamePlayPanel.setGameFinishSW(true);
                                break While_Loop;
                            }
                        }
                    }
                    GamePlayPanel.setRedMoney(GamePlayPanel.getRedMoney()+3000);
                    GamePlayPanel.setRedScore(GamePlayPanel.getRedScore()+4000);
                    GamePlayPanel.setRedTreasureNo(GamePlayPanel.getRedTreasureNo()+1);
                    GamePlayPanel.setPositionYRedSoldItText8(Y_POSITION_SOLD_IT_TEXT_4);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                } else {
                    JOptionPane.showOptionDialog(
                            null,
                            "The stated position for the dragon scroll is incorrect ! :(",
                            "Wrong answer !",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    CastlePanel.setButtonsActivitySW(false);
                    this.dispose();
                    GamePlayPanel.getCastleFrame().dispose();
                }
            }
        }
    }
}

