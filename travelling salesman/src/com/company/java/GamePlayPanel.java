
//Formula to find house number based on X and y coordinates : N = ((X-10)/60)-((Y-10)/6)+91

/*Coordinates of vertical and horizontal lines :
//********************************************************************************************
//Vertical lines :
//1st line : X=10 , 2nd line : X=70 , 3rd line : X=130 , 4th line : X=190 , 5th line : X=250
//6th line : X=310 , 7th line : X=370 , 8th line : X=430 , 9th line : X=490 , 10th line : X=550
//********************************************************************************************
//Horizontal lines :
//1st line : Y=10 , 2nd line : Y=70 , 3rd line : Y=130 , 4th line : Y=190 , 5th line : Y=250
//6th line : Y=310 , 7th line : Y=370 , 8th line : Y=430 , 9th line : Y=490 , 10th line : Y=550
//********************************************************************************************/

package com.company.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GamePlayPanel extends JPanel implements ActionListener {

    //Create an object from Random class
    private static Random randomNumMake = new Random();
    //The final variables related to setting the positions of the game board components
    final static private int INVISIBLE = 10000;
    final private int VISIBLE_DICE_BLUE = 645;
    final private int VISIBLE_DICE_RED = 1160;
    final private int VISIBLE_BLUE_UP_BOX = 150;
    final private int VISIBLE_BLUE_DOWN_BOX = 195;
    final private int VISIBLE_BLUE_LEFT_BOX = 240;
    final private int VISIBLE_BLUE_RIGHT_BOX = 285;
    final private int VISIBLE_BLUE_SKIP_BOX = 330;
    final private int VISIBLE_RED_UP_BOX = 375;
    final private int VISIBLE_RED_DOWN_BOX = 420;
    final private int VISIBLE_RED_LEFT_BOX = 465;
    final private int VISIBLE_RED_RIGHT_BOX = 510;
    final private int VISIBLE_RED_SKIP_BOX = 555;
    final private int X_POSITION_FIRST_STEP = 10;
    final private int Y_POSITION_FIRST_STEP = 550;
    final private int BLUE_xPOSITION_TICK = 680;
    final private int RED_xPOSITION_TICK = 1180;
    final private int X_POSITION_INFORMATION_TEXT = 780;
    final private int X_POSITION_QUEST = 850 ;
    //Variables that are assigned a random number between 1 and 6 at each step of the dice roll
    private static int blueDiceNumber = -1;
    private static int redDiceNumber = -1;
    //A variable that controls the order of operations in the game
    private static int gameplayTurn;
    //Clock variables
    private static int seconds;
    private static int minutes;
    private static int hours;
    private String seconds_string;
    private String minutes_string;
    private String hours_string;
    //Score board variables
    private static int blueScore ;
    private static int blueMoney;
    private static int bluePower;
    private static int blueTreasureNo;
    private static int redScore;
    private static int redMoney;
    private static int redPower;
    private static int redTreasureNo;
    private String blueScore_string ;
    private String blueMoney_string ;
    private String bluePower_string ;
    private String blueTreasureNo_string;
    private String redScore_string ;
    private String redMoney_string ;
    private String redPower_string ;
    private String redTreasureNo_string;
    //Button variables
    final private JButton blueRollTheDiceButton;
    final private JButton redRollTheDiceButton;
    final private JButton marketButton;
    final private JButton exitButton;
    final private JButton blueUpButton;
    final private JButton blueDownButton;
    final private JButton blueLeftButton;
    final private JButton blueRightButton;
    final private JButton blueSkipButton;
    final private JButton redUpButton;
    final private JButton redDownButton;
    final private JButton redRightButton;
    final private JButton redLeftButton;
    final private JButton redSkipButton;
    final private JButton soundButton;
    //The position variables of the blue and red dice faces
    private static int positionXDiceB1;
    private static int positionXDiceB2;
    private static int positionXDiceB3;
    private static int positionXDiceB4;
    private static int positionXDiceB5;
    private static int positionXDiceB6;
    private static int positionXDiceR1;
    private static int positionXDiceR2;
    private static int positionXDiceR3;
    private static int positionXDiceR4;
    private static int positionXDiceR5;
    private static int positionXDiceR6;
    //The tick position variable indicates the turn of the players
    private int tickXPosition;
    //Position variables of blue and red player movement boxes
    private int positionXBlueUpBox;
    private int positionXBlueDownBox;
    private int positionXBlueLeftBox;
    private int positionXBlueRightBox;
    private int positionXBlueSkipBox;
    private int positionXRedUpBox;
    private int positionXRedDownBox;
    private int positionXRedLeftBox;
    private int positionXRedRightBox;
    private int positionXRedSkipBox;
    //Array of position variables of game information messages
    private int xPositionInformationList[] = new int[34];
    private static int informationTextSW;
    //Variable array of positions of Quests declared by the computer
    private int xPositionQuest[] = new int[8];
    //Arrays of position variables of blue and red player footprints
    private static int positionXBlueFootPrint[] = new int[6];
    private static int positionYBlueFootPrint[] = new int[6];
    private static int positionXRedFootPrint[] =new int[6];
    private static int positionYRedFootPrint[] = new int[6];
    //Variables for proper access to the blue and red player footprint array members
    private int blueFootPrintSW = 0;
    private int redFootPrintSW = 0;
    //Variables to adjust the display of the castle panel for blue and red players
    private boolean blueCastleSW;
    private boolean redCastleSW;
    //Variable for random selection of Quest game
    private static int questSW;
    //An array of Boolean variables to identify sold treasures
    private static boolean[] usedQuestSW = new boolean[8];
    //a boolean variable to detect the end of the game
    private static boolean gameFinishSW = false;
    //8 Boolean variables to detect whether the treasures are used or not
    private static boolean usedDiamondRingSW;
    private static boolean usedJeweledSwordSW;
    private static boolean usedGoldenGlassSW;
    private static boolean usedGlassCupSW;
    private static boolean usedWoodenBowSW;
    private static boolean usedSteelShieldSW;
    private static boolean usedGoldenKeySW;
    private static boolean usedDragonScrollSW;
    //8 integer variables to identify who found the treasure
    private static int diamondRingOwner ;
    private static int jeweledSwordOwner ;
    private static int goldenGlassOwner ;
    private static int glassCupOwner  ;
    private static int woodenBowOwner ;
    private static int steelShieldOwner ;
    private static int goldenKeyOwner ;
    private static int dragonScrollOwner ;
    //Variables to adjust the messages of the sold treasure table
    private static int positionYBlueSoldItText1;
    private static int positionYBlueSoldItText2;
    private static int positionYBlueSoldItText3;
    private static int positionYBlueSoldItText4;
    private static int positionYBlueSoldItText5;
    private static int positionYBlueSoldItText6;
    private static int positionYBlueSoldItText7;
    private static int positionYBlueSoldItText8;
    private static int positionYRedSoldItText1;
    private static int positionYRedSoldItText2;
    private static int positionYRedSoldItText3;
    private static int positionYRedSoldItText4;
    private static int positionYRedSoldItText5;
    private static int positionYRedSoldItText6;
    private static int positionYRedSoldItText7;
    private static int positionYRedSoldItText8;
    //Variables for setting the movement of players' pieces on the game board
    private static int positionXBlue;
    private static int positionYBlue;
    private static int positionXRed;
    private static int positionYRed;
    //Variables related to the walls of the game board for the blue player
    private static int wallNumberBlue;
    private int xPositionWallBlue;
    private int yPositionWallBlue;
    private static int[] xPositionWallListBlue = null;
    private static int[] yPositionWallListBlue = null;
    //Variables related to the walls of the game board for the red player
    private static int wallNumberRed ;
    private int xPositionWallRed;
    private int yPositionWallRed;
    private static int xPositionWallListRed[] = null;
    private static int yPositionWallListRed[] = null;
    //Variables related to the traps of the game board
    private static int trapNumber;
    private int xPositionTrap;
    private int yPositionTrap;
    private static int xPositionTrapList[] = null;
    private static int yPositionTrapList[] = null;
    private static boolean showTrapSW[] = null;
    private static boolean usedTrapSW[] = null;
    //Variables related to the market icons of the game board
    private static final int marketNumber = 5;
    private int xPositionMarket;
    private int yPositionMarket;
    private static int xPositionMarketList[] = null;
    private static int yPositionMarketList[] = null;
    //Variables related to the loots of the game board
    private static final int lootNumber = 13;
    private int xPositionLoot;
    private int yPositionLoot;
    private static int xPositionLootList[] = null;
    private static int yPositionLootList[] = null;
    private static boolean showLootSW[] = null;
    private static boolean usedLootSW[] = null;
    //Variables related to x and y coordinates of treasures
    private static int xPositionDiamondRing;
    private static int yPositionDiamondRing;
    private static int xPositionJeweledSword;
    private static int yPositionJeweledSword;
    private static int xPositionGoldenGlass;
    private static int yPositionGoldenGlass;
    private static int xPositionGlassCup;
    private static int yPositionGlassCup;
    private static int xPositionWoodenBow;
    private static int yPositionWoodenBow;
    private static int xPositionSteelShield;
    private static int yPositionSteelShield;
    private static int xPositionGoldenKey;
    private static int yPositionGoldenKey;
    private static int xPositionDragonScroll;
    private static int yPositionDragonScroll;
    //Image variables
    Image gameBackgroundImage =
            new ImageIcon("images\\game play panel components images\\game background.png").getImage();
    Image bluePlayerImage =
            new ImageIcon("images\\blue player.png").getImage();
    Image redPlayerImage =
            new ImageIcon("images\\red player.png").getImage();
    Image blueGamePiece =
            new ImageIcon("images\\game board components images\\blue game piece.png").getImage();
    Image redGamePiece =
            new ImageIcon("images\\game board components images\\red game piece.png").getImage();
    Image diceB1 =
            new ImageIcon("images\\dice images\\blue dice images\\blue dice face 1.png").getImage();
    Image diceB2 =
            new ImageIcon("images\\dice images\\blue dice images\\blue dice face 2.png").getImage();
    Image diceB3 =
            new ImageIcon("images\\dice images\\blue dice images\\blue dice face 3.png").getImage();
    Image diceB4 =
            new ImageIcon("images\\dice images\\blue dice images\\blue dice face 4.png").getImage();
    Image diceB5 =
            new ImageIcon("images\\dice images\\blue dice images\\blue dice face 5.png").getImage();
    Image diceB6 =
            new ImageIcon("images\\dice images\\blue dice images\\blue dice face 6.png").getImage();
    Image diceR1 =
            new ImageIcon("images\\dice images\\red dice images\\red dice face 1.png").getImage();
    Image diceR2 =
            new ImageIcon("images\\dice images\\red dice images\\red dice face 2.png").getImage();
    Image diceR3 =
            new ImageIcon("images\\dice images\\red dice images\\red dice face 3.png").getImage();
    Image diceR4 =
            new ImageIcon("images\\dice images\\red dice images\\red dice face 4.png").getImage();
    Image diceR5 =
            new ImageIcon("images\\dice images\\red dice images\\red dice face 5.png").getImage();
    Image diceR6 =
            new ImageIcon("images\\dice images\\red dice images\\red dice face 6.png").getImage();
    Image castleImage =
            new ImageIcon("images\\game board components images\\castle.png").getImage();
    Image tickImage =
            new ImageIcon("images\\game play panel components images\\tick.png").getImage();
    ImageIcon blueUpArrowImage =
            new ImageIcon("images\\movement arrow images\\blue movement arrow images\\blue up arrow.png");
    ImageIcon blueRightArrowImage =
            new ImageIcon("images\\movement arrow images\\blue movement arrow images\\blue right arrow.png");
    ImageIcon blueDownArrowImage =
            new ImageIcon("images\\movement arrow images\\blue movement arrow images\\blue down arrow.png");
    ImageIcon blueLeftArrowImage =
            new ImageIcon("images\\movement arrow images\\blue movement arrow images\\blue left arrow.png");
    ImageIcon blueSkipImage =
            new ImageIcon("images\\movement arrow images\\blue movement arrow images\\blue skip.png");
    ImageIcon redSkipImage =
            new ImageIcon("images\\movement arrow images\\red movement arrow images\\red skip.png");
    ImageIcon redUpArrowImage =
            new ImageIcon("images\\movement arrow images\\red movement arrow images\\red up arrow.png");
    ImageIcon redRightArrowImage =
            new ImageIcon("images\\movement arrow images\\red movement arrow images\\red right arrow.png");
    ImageIcon redDownArrowImage =
            new ImageIcon("images\\movement arrow images\\red movement arrow images\\red down arrow.png");
    ImageIcon redLeftArrowImage =
            new ImageIcon("images\\movement arrow images\\red movement arrow images\\red left arrow.png");
    Image WallImage =
            new ImageIcon("images\\game board components images\\Wall.png").getImage();
    Image trapImage =
            new ImageIcon("images\\game board components images\\trap.png").getImage();
    Image moneyBagImage =
            new ImageIcon("images\\game board components images\\money bag.png").getImage();
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
    Image whiteMarketImag =
            new ImageIcon("images\\game board components images\\white market icon.png").getImage();
    //Timer variable
    private static Timer timer;
    //CastleFrame variable
    static private CastleFrame castleFrame;
    //Get methods
    public static int getBlueDiceNumber() {
        return blueDiceNumber;
    }

    public static int getRedDiceNumber() {
        return redDiceNumber;
    }

    public static int getSeconds() {
        return seconds;
    }

    public static int getMinutes() {
        return minutes;
    }

    public static int getHours() {
        return hours;
    }

    static public CastleFrame getCastleFrame () {return castleFrame;}

    static public int getXPositionDiamondRing() {
        return xPositionDiamondRing;
    }

    static public int getYPositionDiamondRing() {
        return yPositionDiamondRing;
    }

    static public int getXPositionJeweledSword() {
        return xPositionJeweledSword;
    }

    static public int getYPositionJeweledSword() {
        return yPositionJeweledSword;
    }

    static public int getXPositionGoldenGlass () { return xPositionGoldenGlass; }

    static public int getYPositionGoldenGlass () {
        return yPositionGoldenGlass;
    }

    static public int getXPositionGlassCup () {
        return xPositionGlassCup;
    }

    static public int getYPositionGlassCup () {
        return yPositionGlassCup;
    }

    static public int getXPositionWoodenBow () {
        return xPositionWoodenBow;
    }

    static public int getYPositionWoodenBow() {
        return yPositionWoodenBow;
    }

    static public int getXPositionSteelShield() {
        return xPositionSteelShield;
    }

    static public int getYPositionSteelShield () {
        return yPositionSteelShield;
    }

    static public int getXPositionGoldenKey () {
        return xPositionGoldenKey;
    }

    static public int getYPositionGoldenKey () {
        return yPositionGoldenKey;
    }

    static public int getXPositionDragonScroll() {
        return xPositionDragonScroll;
    }

    static public int getYPositionDragonScroll () {
        return yPositionDragonScroll;
    }

    static public int getGameplayTurn () {
        return gameplayTurn;
    }

    public static int getBlueScore() {
        return blueScore;
    }

    public static int getRedScore() {
        return redScore;
    }

    static public int getBlueMoney () { return blueMoney; }

    static public int getRedMoney () { return redMoney; }

    static public int getBluePower() { return bluePower;  }

    static public int getRedPower() { return redPower; }

    public static int getBlueTreasureNo() {
        return blueTreasureNo;
    }

    public static int getRedTreasureNo() {
        return redTreasureNo;
    }

    static public int getPositionXBlue () {
        return positionXBlue;
    }

    static public int getPositionYBlue () {
        return positionYBlue;
    }

    static public int getPositionXRed () {
        return positionXRed;
    }

    static public int getPositionYRed () {
        return positionYRed;
    }

    static public boolean getUsedDiamondRingSW () {return usedDiamondRingSW;}

    static public boolean getUsedJeweledSwordSW () {return  usedJeweledSwordSW;}

    static public boolean getUsedGoldenGlassSW () {return usedGoldenGlassSW;}

    static public boolean getUsedGlassCupSW () {return usedGlassCupSW;}

    static public boolean getUsedWoodenBowSW () {return usedWoodenBowSW;}

    static public boolean getUsedSteelShieldSW () {return usedSteelShieldSW;}

    static public boolean getUsedGoldenKeySW () {return usedGoldenKeySW;}

    static public boolean getUsedDragonScrollSW () {return usedDragonScrollSW;}

    static public int getDiamondRingOwner () {return diamondRingOwner;}

    static public int getJeweledSwordOwner () {return  jeweledSwordOwner;}

    static public int getGoldenGlassOwner () {return goldenGlassOwner;}

    static public int getGlassCupOwner () {return glassCupOwner;}

    static public int getWoodenBowOwner () {return woodenBowOwner;}

    static public int getSteelShieldOwner () {return steelShieldOwner;}

    static public int getGoldenKeyOwner () {return goldenKeyOwner;}

    static public int getDragonScrollOwner () {return dragonScrollOwner;}

    static public int getPositionYBlueSoldItText1 () {return positionYBlueSoldItText1;}

    static public int getPositionYBlueSoldItText2 () {return positionYBlueSoldItText2;}

    static public int getPositionYBlueSoldItText3 () {return positionYBlueSoldItText3;}

    static public int getPositionYBlueSoldItText4 () {return positionYBlueSoldItText4;}

    static public int getPositionYBlueSoldItText5 () {return positionYBlueSoldItText5;}

    static public int getPositionYBlueSoldItText6 () {return positionYBlueSoldItText6;}

    static public int getPositionYBlueSoldItText7 () {return positionYBlueSoldItText7;}

    static public int getPositionYBlueSoldItText8 () {return positionYBlueSoldItText8;}

    static public int getPositionYRedSoldItText1 () {return positionYRedSoldItText1;}

    static public int getPositionYRedSoldItText2 () {return positionYRedSoldItText2;}

    static public int getPositionYRedSoldItText3 () {return positionYRedSoldItText3;}

    static public int getPositionYRedSoldItText4 () {return positionYRedSoldItText4;}

    static public int getPositionYRedSoldItText5 () {return positionYRedSoldItText5;}

    static public int getPositionYRedSoldItText6 () {return positionYRedSoldItText6;}

    static public int getPositionYRedSoldItText7 () {return positionYRedSoldItText7;}

    static public int getPositionYRedSoldItText8 () {return positionYRedSoldItText8;}

    static public int getWallNumberBlue () {return wallNumberBlue;}

    static public int getXPositionWallListBlue (int number) {return xPositionWallListBlue[number];}

    static public int getYPositionWallListBlue (int number) {return yPositionWallListBlue[number];}

    static public int getWallNumberRed () {return wallNumberRed;}

    static public int getXPositionWallListRed (int number) {return xPositionWallListRed[number];}

    static public int getYPositionWallListRed (int number) {return yPositionWallListRed[number];}

    static public int getTrapNumber ()  {return trapNumber;}

    static public int getMarketNumber () {return marketNumber;}

    static public int getLootNumber () {return lootNumber;}

    static public int getXPositionTrapList (int number) {return xPositionTrapList[number];}

    static public int getYPositionTrapList (int number) {return yPositionTrapList[number];}

    static public boolean getShowTrapSW (int number) {return showTrapSW[number];}

    static public boolean getUsedTrapSW (int number) {return usedTrapSW[number];}

    static public int getXPositionMarketList (int number) {return xPositionMarketList[number];}

    static public int getYPositionMarketList (int number) {return yPositionMarketList[number];}

    static public int getXPositionLootList (int number) {return xPositionLootList[number];}

    static public int getYPositionLootList (int number) {return yPositionLootList[number];}

    static public boolean getShowLootSW (int number) {return showLootSW[number];}

    static public boolean getUsedLootSW (int number) {return usedLootSW[number];}

    static public boolean getUsedQuestSW (int number) {
        return usedQuestSW[number];
    }

    static public int getQuestSW () {
        return questSW;
    }

    public static int getPositionXDiceB1() {
        return positionXDiceB1;
    }

    public static int getPositionXDiceB2() {
        return positionXDiceB2;
    }

    public static int getPositionXDiceB3() {
        return positionXDiceB3;
    }

    public static int getPositionXDiceB4() {
        return positionXDiceB4;
    }

    public static int getPositionXDiceB5() {
        return positionXDiceB5;
    }

    public static int getPositionXDiceB6() {
        return positionXDiceB6;
    }

    public static int getPositionXDiceR1() {
        return positionXDiceR1;
    }

    public static int getPositionXDiceR2() {
        return positionXDiceR2;
    }

    public static int getPositionXDiceR3() {
        return positionXDiceR3;
    }

    public static int getPositionXDiceR4() {
        return positionXDiceR4;
    }

    public static int getPositionXDiceR5() {
        return positionXDiceR5;
    }

    public static int getPositionXDiceR6() {
        return positionXDiceR6;
    }

    public static int getInformationTextSW() {
        return informationTextSW;
    }

    public static int getPositionXBlueFootPrint(int number) {
        return positionXBlueFootPrint[number];
    }

    public static int getPositionYBlueFootPrint(int number) {
        return positionYBlueFootPrint[number];
    }

    public static int getPositionXRedFootPrint(int number) {
        return positionXRedFootPrint[number];
    }

    public static int getPositionYRedFootPrint(int number) {
        return positionYRedFootPrint[number];
    }

    //Set methods
    public static void setBlueDiceNumber(int blueDiceNumber) {
        GamePlayPanel.blueDiceNumber = blueDiceNumber;
    }

    public static void setRedDiceNumber(int redDiceNumber) {
        GamePlayPanel.redDiceNumber = redDiceNumber;
    }

    public static void setGameplayTurn(int gameplayTurn) {
        GamePlayPanel.gameplayTurn = gameplayTurn;
    }

    public static void setSeconds(int seconds) {
        GamePlayPanel.seconds = seconds;
    }

    public static void setMinutes(int minutes) {
        GamePlayPanel.minutes = minutes;
    }

    public static void setHours(int hours) {
        GamePlayPanel.hours = hours;
    }

    public static void setBlueScore(int blueScore) {
        GamePlayPanel.blueScore = blueScore;
    }

    public static void setRedScore(int redScore) {
        GamePlayPanel.redScore = redScore;
    }

    static public void setBlueMoney(int blueMoney) {
        GamePlayPanel.blueMoney = blueMoney;
    }

    static public void setRedMoney(int redMoney) {
        GamePlayPanel.redMoney = redMoney;
    }

    static public void setBluePower(int bluePower) {
        GamePlayPanel.bluePower = bluePower;
    }

    static public void setRedPower(int redPower) {
        GamePlayPanel.redPower = redPower;
    }

    public static void setBlueTreasureNo(int blueTreasureNo) {
        GamePlayPanel.blueTreasureNo = blueTreasureNo;
    }

    public static void setRedTreasureNo(int redTreasureNo) {
        GamePlayPanel.redTreasureNo = redTreasureNo;
    }

    static public void setUsedDiamondRingSW(boolean usedDiamondRingSW) {
        GamePlayPanel.usedDragonScrollSW = usedDiamondRingSW;
    }

    static public void setUsedJeweledSwordSW (boolean usedJeweledSwordSW) {
        GamePlayPanel.usedJeweledSwordSW = usedJeweledSwordSW;
    }

    static public void setUsedGoldenGlassSW (boolean usedGoldenGlassSW) {
        GamePlayPanel.usedGoldenGlassSW = usedGoldenGlassSW;
    }

    static public void setUsedGlassCupSW (boolean usedGlassCupSW) {
        GamePlayPanel.usedGlassCupSW = usedGlassCupSW;
    }

    static public void setUsedWoodenBowSW (boolean usedWoodenBowSW) {
        GamePlayPanel.usedWoodenBowSW = usedWoodenBowSW;
    }

    static public void setUsedSteelShieldSW (boolean usedSteelShieldSW) {
        GamePlayPanel.usedSteelShieldSW = usedSteelShieldSW;
    }

    static public void setUsedGoldenKeySW (boolean usedGoldenKeySW) {
        GamePlayPanel.usedGoldenKeySW = usedGoldenKeySW;
    }

    static public void setUsedDragonScrollSW (boolean usedDragonScrollSW) {
        GamePlayPanel.usedDragonScrollSW = usedDragonScrollSW;
    }

    static public void setDiamondRingOwner (int diamondRingOwner) {
        GamePlayPanel.diamondRingOwner = diamondRingOwner;
    }

    static public void setJeweledSwordOwner (int jeweledSwordOwner) {
        GamePlayPanel.jeweledSwordOwner = jeweledSwordOwner;
    }

    static public void setGoldenGlassOwner (int goldenGlassOwner) {
        GamePlayPanel.goldenGlassOwner = goldenGlassOwner;
    }

    static public void setGlassCupOwner (int glassCupOwner) {
        GamePlayPanel.glassCupOwner = glassCupOwner;
    }

    static public void setWoodenBowOwner (int woodenBowOwner) {
        GamePlayPanel.woodenBowOwner = woodenBowOwner;
    }

    static public void setSteelShieldOwner (int steelShieldOwner) {
        GamePlayPanel.steelShieldOwner = steelShieldOwner;
    }

    static public void setGoldenKeyOwner (int goldenKeyOwner) {
        GamePlayPanel.goldenKeyOwner = goldenKeyOwner;
    }

    static public void setDragonScrollOwner (int dragonScrollOwner) {
        GamePlayPanel.dragonScrollOwner = dragonScrollOwner; }


    static public void setUsedQuestSW (int number , boolean SW) {
        usedQuestSW[number] = SW;
    }

    static public void setGameFinishSW (boolean SW) {
        gameFinishSW = SW ;
    }


    static public void setQuestSW (int questSW) {
        GamePlayPanel.questSW = questSW;
    }

    static public void setPositionYBlueSoldItText1 (int position) {
        positionYBlueSoldItText1 = position;
    }

    static public void setPositionYBlueSoldItText2 (int position) {
        positionYBlueSoldItText2 = position;
    }

    static public void setPositionYBlueSoldItText3 (int position) {
        positionYBlueSoldItText3 = position;
    }

    static public void setPositionYBlueSoldItText4 (int position) {
        positionYBlueSoldItText4 = position;
    }

    static public void setPositionYBlueSoldItText5 (int position) {
        positionYBlueSoldItText5 = position;
    }

    static public void setPositionYBlueSoldItText6 (int position) {
        positionYBlueSoldItText6 = position;
    }

    static public void setPositionYBlueSoldItText7 (int position) {
        positionYBlueSoldItText7 = position;
    }

    static public void setPositionYBlueSoldItText8 (int position) {
        positionYBlueSoldItText8 = position;
    }

    static public void setPositionYRedSoldItText1 (int position) {
        positionYRedSoldItText1 = position;
    }

    static public void setPositionYRedSoldItText2 (int position) {
        positionYRedSoldItText2 = position;
    }

    static public void setPositionYRedSoldItText3 (int position) {
        positionYRedSoldItText3 = position;
    }

    static public void setPositionYRedSoldItText4 (int position) {
        positionYRedSoldItText4 = position;
    }

    static public void setPositionYRedSoldItText5 (int position) {
        positionYRedSoldItText5 = position;
    }

    static public void setPositionYRedSoldItText6 (int position) {
        positionYRedSoldItText6 = position;
    }

    static public void setPositionYRedSoldItText7 (int position) {
        positionYRedSoldItText7 = position;
    }

    static public void setPositionYRedSoldItText8 (int position) {
        positionYRedSoldItText8 = position;
    }

    static public void setPositionXBlue (int position) {positionXBlue=position;}

    static public void setPositionYBlue (int position) {positionYBlue=position;}

    static public void setPositionXRed (int position) {positionXRed=position;}

    static public void setPositionYRed (int position) {positionYRed=position;}

    static public void setWallNumberBlue (int number) {wallNumberBlue=number;}

    static public void setXPositionWallListBlue (int number , int position) {xPositionWallListBlue[number]=position;}

    static public void setYPositionWallListBlue (int number , int position) {yPositionWallListBlue[number]=position;}

    static public void setWallNumberRed (int number) {wallNumberRed=number;}

    static public void setXPositionWallListRed (int number , int position) {xPositionWallListRed[number]=position;}

    static public void setYPositionWallListRed (int number , int position) {yPositionWallListRed[number]=position;}

    static public void setTrapNumber (int number) {trapNumber=number;}

    static public void setXPositionTrapList (int number , int position) {xPositionTrapList[number]=position;}

    static public void setYPositionTrapList (int number , int position) {yPositionTrapList[number]=position;}

    static public void setShowTrapSW (int number , boolean SW) {showTrapSW[number]=SW;}

    static public void setUsedTrapSW (int number , boolean SW) {usedTrapSW[number]=SW;}

    static public void setXPositionMarketList (int number , int position) {xPositionMarketList[number]=position;}

    static public void setYPositionMarketList(int number , int position) {yPositionMarketList[number]=position;}

    static public void setXPositionLootList(int number , int position) {xPositionLootList[number]=position;}

    static public void setYPositionLootList(int number , int position) {yPositionLootList[number]=position;}

    static public void setShowLootSW (int number , boolean SW) {showLootSW[number]=SW;}

    static public void setUsedLootSW (int number , boolean SW) {usedLootSW[number]=SW;}

    static public void setPositionXBlueFootPrint(int position,int number) {
        positionXBlueFootPrint[number] = position;
    }

    static public void setPositionYBlueFootPrint(int position,int number) {
        positionYBlueFootPrint[number] = position;
    }

    static public void setPositionXRedFootPrint(int position,int number) {
        positionXRedFootPrint[number] = position;
    }

    static public void setPositionYRedFootPrint(int position,int number) {
        positionYRedFootPrint[number] = position;
    }

    static public void setXPositionDiamondRing (int position) {xPositionDiamondRing=position;}

    static public void setYPositionDiamondRing (int position) {yPositionDiamondRing=position;}

    static public void setXPositionJeweledSword (int position) {xPositionJeweledSword=position;}

    static public void setYPositionJeweledSword (int position) {yPositionJeweledSword=position;}

    static public void setXPositionGoldenGlass (int position) {xPositionGoldenGlass=position;}

    static public void setYPositionGoldenGlass (int position) {yPositionGoldenGlass=position;}

    static public void setXPositionGlassCup (int position) {xPositionGlassCup=position;}

    static public void setYPositionGlassCup (int position) {yPositionGlassCup=position;}

    static public void setXPositionWoodenBow(int position) {xPositionWoodenBow=position;}

    static public void setYPositionWoodenBow(int position) {yPositionWoodenBow=position;}

    static public void setXPositionSteelShield (int position) {xPositionSteelShield=position;}

    static public void setYPositionSteelShield (int position) {yPositionSteelShield=position;}

    static public void setXPositionGoldenKey (int position) {xPositionGoldenKey=position;}

    static public void setYPositionGoldenKey (int position) {yPositionGoldenKey=position;}

    static public void setXPositionDragonScroll (int position) {xPositionDragonScroll=position;}

    static public void setYPositionDragonScroll(int position) {yPositionDragonScroll=position;}

    public static void setPositionXDiceB1(int positionXDiceB1) {
        GamePlayPanel.positionXDiceB1 = positionXDiceB1;
    }

    public static void setPositionXDiceB2(int positionXDiceB2) {
        GamePlayPanel.positionXDiceB2 = positionXDiceB2;
    }

    public static void setPositionXDiceB3(int positionXDiceB3) {
        GamePlayPanel.positionXDiceB3 = positionXDiceB3;
    }

    public static void setPositionXDiceB4(int positionXDiceB4) {
        GamePlayPanel.positionXDiceB4 = positionXDiceB4;
    }

    public static void setPositionXDiceB5(int positionXDiceB5) {
        GamePlayPanel.positionXDiceB5 = positionXDiceB5;
    }

    public static void setPositionXDiceB6(int positionXDiceB6) {
        GamePlayPanel.positionXDiceB6 = positionXDiceB6;
    }

    public static void setPositionXDiceR1(int positionXDiceR1) {
        GamePlayPanel.positionXDiceR1 = positionXDiceR1;
    }

    public static void setPositionXDiceR2(int positionXDiceR2) {
        GamePlayPanel.positionXDiceR2 = positionXDiceR2;
    }

    public static void setPositionXDiceR3(int positionXDiceR3) {
        GamePlayPanel.positionXDiceR3 = positionXDiceR3;
    }

    public static void setPositionXDiceR4(int positionXDiceR4) {
        GamePlayPanel.positionXDiceR4 = positionXDiceR4;
    }

    public static void setPositionXDiceR5(int positionXDiceR5) {
        GamePlayPanel.positionXDiceR5 = positionXDiceR5;
    }

    public static void setPositionXDiceR6(int positionXDiceR6) {
        GamePlayPanel.positionXDiceR6 = positionXDiceR6;
    }

    public static void setInformationTextSW(int informationTextSW) {
        GamePlayPanel.informationTextSW = informationTextSW;
    }

    public GamePlayPanel(int gameplayTurn) {
        this.setPreferredSize(new Dimension(1400, 850));
        this.setLayout(null);
        //---------"Blue Roll the Dice" Button-----------------
        blueRollTheDiceButton = new JButton("Roll the dice !");
        blueRollTheDiceButton.setBounds(625, 490, 135, 30);
        blueRollTheDiceButton.setFocusable(false);
        blueRollTheDiceButton.addActionListener(this);
        blueRollTheDiceButton.setBackground(new Color(0, 165, 114));
        blueRollTheDiceButton.setForeground(Color.white);
        blueRollTheDiceButton.setFont(new Font("Modern No. 20", Font.BOLD, 13));
        blueRollTheDiceButton.setEnabled(false);
        //---------"Red Roll the Dice" Button-------------------
        redRollTheDiceButton = new JButton("Roll the dice !");
        redRollTheDiceButton.setBounds(1140, 490, 135, 30);
        redRollTheDiceButton.setFocusable(false);
        redRollTheDiceButton.addActionListener(this);
        redRollTheDiceButton.setBackground(new Color(200, 38, 40));
        redRollTheDiceButton.setForeground(Color.WHITE);
        redRollTheDiceButton.setFont(new Font("Modern No. 20", Font.BOLD, 13));
        redRollTheDiceButton.setEnabled(false);
        //-----------"Blue Up" Button ----------------------------
        blueUpButton = new JButton();
        blueUpButton.setIcon(blueUpArrowImage);
        blueUpButton.setBounds(150, 640, 40, 40);
        blueUpButton.setFocusable(false);
        blueUpButton.addActionListener(this);
        blueUpButton.setBackground(Color.BLACK);
        blueUpButton.setEnabled(false);
        //----------"Blue Down" Button -----------------------------
        blueDownButton = new JButton();
        blueDownButton.setIcon(blueDownArrowImage);
        blueDownButton.setBounds(195, 640, 40, 40);
        blueDownButton.setFocusable(false);
        blueDownButton.addActionListener(this);
        blueDownButton.setBackground(Color.BLACK);
        blueDownButton.setEnabled(false);
        //----------"Blue Left" Button ------------------------------
        blueLeftButton = new JButton();
        blueLeftButton.setIcon(blueLeftArrowImage);
        blueLeftButton.setBounds(240, 640, 40, 40);
        blueLeftButton.setFocusable(false);
        blueLeftButton.addActionListener(this);
        blueLeftButton.setBackground(Color.BLACK);
        blueLeftButton.setEnabled(false);
        //----------"Blue Right" Button ------------------------------
        blueRightButton = new JButton();
        blueRightButton.setIcon(blueRightArrowImage);
        blueRightButton.setBounds(285, 640, 40, 40);
        blueRightButton.setFocusable(false);
        blueRightButton.addActionListener(this);
        blueRightButton.setBackground(Color.BLACK);
        blueRightButton.setEnabled(false);
        //----------"Blue Skip" Button---------------------------------
        blueSkipButton = new JButton();
        blueSkipButton.setIcon(blueSkipImage);
        blueSkipButton.setBounds(330, 640, 40, 40);
        blueSkipButton.setFocusable(false);
        blueSkipButton.addActionListener(this);
        blueSkipButton.setBackground(Color.BLACK);
        blueSkipButton.setEnabled(false);
        //-----------"Red Up" Button-------------------------------------
        redUpButton = new JButton();
        redUpButton.setIcon(redUpArrowImage);
        redUpButton.setBounds(375, 640, 40, 40);
        redUpButton.setFocusable(false);
        redUpButton.addActionListener(this);
        redUpButton.setBackground(Color.WHITE);
        redUpButton.setEnabled(false);
        //------------"Red Down" Button----------------------------------
        redDownButton = new JButton();
        redDownButton.setIcon(redDownArrowImage);
        redDownButton.setBounds(420, 640, 40, 40);
        redDownButton.setFocusable(false);
        redDownButton.addActionListener(this);
        redDownButton.setBackground(Color.WHITE);
        redDownButton.setEnabled(false);
        //-------------"Red Left" Button----------------------------------
        redLeftButton = new JButton();
        redLeftButton.setIcon(redLeftArrowImage);
        redLeftButton.setBounds(465, 640, 40, 40);
        redLeftButton.setFocusable(false);
        redLeftButton.addActionListener(this);
        redLeftButton.setBackground(Color.WHITE);
        redLeftButton.setEnabled(false);
        //--------------"Red Right" Button--------------------------------
        redRightButton = new JButton();
        redRightButton.setIcon(redRightArrowImage);
        redRightButton.setBounds(510, 640, 40, 40);
        redRightButton.setFocusable(false);
        redRightButton.addActionListener(this);
        redRightButton.setBackground(Color.WHITE);
        redRightButton.setEnabled(false);
        //--------------"Red Skip" Button----------------------------------
        redSkipButton = new JButton();
        redSkipButton.setIcon(redSkipImage);
        redSkipButton.setBounds(555, 640, 40, 40);
        redSkipButton.setFocusable(false);
        redSkipButton.addActionListener(this);
        redSkipButton.setBackground(Color.white);
        redSkipButton.setEnabled(false);
        //---------------"Exit" Button-------------------------------------
        exitButton = new JButton("Exit");
        exitButton.setBounds(1160, 650, 100, 30);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);
        exitButton.setBackground(Color.darkGray);
        exitButton.setForeground(Color.white);
        exitButton.setFont(new Font("Modern No. 20", Font.BOLD, 20));
        //--------------"market" Button--------------------------------------
        marketButton = new JButton("Market");
        marketButton.setBounds(1160, 610, 100, 30);
        marketButton.setFocusable(false);
        marketButton.addActionListener(this);
        marketButton.setBackground(Color.darkGray);
        marketButton.setForeground(Color.white);
        marketButton.setFont(new Font("Modern No. 20", Font.BOLD, 20));
        marketButton.setEnabled(false);
        //-------------"sound" Button ---------------------------------------
        soundButton = new JButton("sound");
        soundButton.setBounds(1160,570,100,30);
        soundButton.setFocusable(false);
        soundButton.addActionListener(this);
        soundButton.setBackground(Color.DARK_GRAY);
        soundButton.setForeground(Color.WHITE);
        soundButton.setFont(new Font("Modern No. 20" , Font.BOLD,20));
        //------------Add Buttons to GamePlayPanel----------------------------
        this.add(blueRollTheDiceButton);
        this.add(redRollTheDiceButton);
        this.add(exitButton);
        this.add(marketButton);
        this.add(blueUpButton);
        this.add(blueDownButton);
        this.add(blueLeftButton);
        this.add(blueRightButton);
        this.add(blueSkipButton);
        this.add(redDownButton);
        this.add(redUpButton);
        this.add(redRightButton);
        this.add(redLeftButton);
        this.add(redSkipButton);
        this.add(soundButton);
        //Initializing variables if the new game button is pressed
        if (gameplayTurn==0 || gameplayTurn==3) {
            GamePlayPanel.gameplayTurn = gameplayTurn;
            seconds=0;
            minutes=0;
            hours=0;
            blueMoney=750;
            redMoney=750;
            bluePower=100;
            redPower=100;
            blueScore=0;
            redScore=0;
            blueTreasureNo=0;
            redTreasureNo=0;
            positionXDiceB1=INVISIBLE;
            positionXDiceB2=INVISIBLE;
            positionXDiceB3=INVISIBLE;
            positionXDiceB4=INVISIBLE;
            positionXDiceB5=INVISIBLE;
            positionXDiceB6=INVISIBLE;
            positionXDiceR1=INVISIBLE;
            positionXDiceR2=INVISIBLE;
            positionXDiceR3=INVISIBLE;
            positionXDiceR4=INVISIBLE;
            positionXDiceR5=INVISIBLE;
            positionXDiceR6=INVISIBLE;
            questSW = randomNumMake.nextInt(8);
            usedQuestSW[questSW] =true;
            usedDiamondRingSW=false;
            usedJeweledSwordSW=false;
            usedGoldenGlassSW=false;
            usedGlassCupSW=false;
            usedWoodenBowSW=false;
            usedSteelShieldSW=false;
            usedGoldenKeySW=false;
            usedDragonScrollSW=false;
            diamondRingOwner=0;
            jeweledSwordOwner=0;
            goldenGlassOwner=0;
            glassCupOwner=0;
            woodenBowOwner=0;
            steelShieldOwner=0;
            goldenKeyOwner=0;
            dragonScrollOwner=0;
            positionXBlue = 10;
            positionYBlue = 620;
            positionXRed = 80;
            positionYRed = 620;
            positionXDiceB1 = INVISIBLE;
            positionXDiceB2 = INVISIBLE;
            positionXDiceB3 = INVISIBLE;
            positionXDiceB4 = INVISIBLE;
            positionXDiceB5 = INVISIBLE;
            positionXDiceB6 = INVISIBLE;
            positionXDiceR1 = INVISIBLE;
            positionXDiceR2 = INVISIBLE;
            positionXDiceR3 = INVISIBLE;
            positionXDiceR4 = INVISIBLE;
            positionXDiceR5 = INVISIBLE;
            positionXDiceR6 = INVISIBLE;
            positionYBlueSoldItText1 = INVISIBLE;
            positionYBlueSoldItText2 = INVISIBLE;
            positionYBlueSoldItText3 = INVISIBLE;
            positionYBlueSoldItText4 = INVISIBLE;
            positionYBlueSoldItText5 = INVISIBLE;
            positionYBlueSoldItText6 = INVISIBLE;
            positionYBlueSoldItText7 = INVISIBLE;
            positionYBlueSoldItText8 = INVISIBLE;
            positionYRedSoldItText1 = INVISIBLE;
            positionYRedSoldItText2 = INVISIBLE;
            positionYRedSoldItText3 = INVISIBLE;
            positionYRedSoldItText4 = INVISIBLE;
            positionYRedSoldItText5 = INVISIBLE;
            positionYRedSoldItText6 = INVISIBLE;
            positionYRedSoldItText7 = INVISIBLE;
            positionYRedSoldItText8 = INVISIBLE;
            wallNumberBlue = randomNumMake.nextInt(10) + 5;
            xPositionWallListBlue = new int[wallNumberBlue];
            yPositionWallListBlue = new int[wallNumberBlue];
            wallNumberRed = randomNumMake.nextInt(10)+5;
            xPositionWallListRed = new int[wallNumberRed];
            yPositionWallListRed = new int[wallNumberRed];
            trapNumber = randomNumMake.nextInt(10)+5;
            xPositionTrapList = new int[trapNumber];
            yPositionTrapList = new int[trapNumber];
            showTrapSW = new boolean[trapNumber];
            usedTrapSW = new boolean[trapNumber];
            xPositionMarketList = new int[marketNumber];
            yPositionMarketList = new int[marketNumber];
            xPositionLootList = new int[lootNumber];
            yPositionLootList = new int[lootNumber];
            showLootSW = new boolean[lootNumber];
            usedLootSW = new boolean[lootNumber];
            if (gameplayTurn==0) informationTextSW=0;
            else informationTextSW=1;
            for (int i = 0; i < 6; i++) {
                positionXBlueFootPrint[i] = INVISIBLE;
                positionXRedFootPrint[i] = INVISIBLE;
                positionYBlueFootPrint[i] = INVISIBLE;
                positionYRedFootPrint[i] = INVISIBLE;
            }
            //Start setting the position of the treasures
            while (true) {
                xPositionDiamondRing = (60 * randomNumMake.nextInt(10)) + 10;
                yPositionDiamondRing = (60 * randomNumMake.nextInt(10)) + 10;
                if (xPositionDiamondRing == 310 && yPositionDiamondRing == 250) {
                } else break;
            }
            while (true) {
                xPositionJeweledSword = (60 * randomNumMake.nextInt(10)) + 10;
                yPositionJeweledSword = (60 * randomNumMake.nextInt(10)) + 10;
                if (xPositionJeweledSword == 310 && yPositionJeweledSword == 250) {
                } else if (xPositionJeweledSword == xPositionDiamondRing && yPositionJeweledSword == yPositionDiamondRing) {
                } else break;
            }
            while (true) {
                xPositionGoldenGlass = (60 * randomNumMake.nextInt(10)) + 10;
                yPositionGoldenGlass = (60 * randomNumMake.nextInt(10)) + 10;
                if (xPositionGoldenGlass == 310 && yPositionGoldenGlass == 250) {
                } else if (xPositionGoldenGlass == xPositionJeweledSword && yPositionGoldenGlass == yPositionJeweledSword) {
                } else if (xPositionGoldenGlass == xPositionDiamondRing && yPositionGoldenGlass == yPositionDiamondRing) {
                } else break;
            }
            while (true) {
                xPositionGlassCup = (60 * randomNumMake.nextInt(10)) + 10;
                yPositionGlassCup = (60 * randomNumMake.nextInt(10)) + 10;
                if (xPositionGlassCup == xPositionDiamondRing && yPositionGlassCup == yPositionDiamondRing) {
                } else if (xPositionGlassCup == xPositionJeweledSword && yPositionGlassCup == yPositionJeweledSword) {
                } else if (xPositionGlassCup == xPositionGoldenGlass && yPositionGlassCup == yPositionGoldenGlass) {
                } else if (xPositionGlassCup == 310 && yPositionGlassCup == 250) {
                } else break;
            }
            while (true) {
                xPositionWoodenBow = (60 * randomNumMake.nextInt(10)) + 10;
                yPositionWoodenBow = (60 * randomNumMake.nextInt(10)) + 10;
                if (xPositionWoodenBow == 310 && yPositionWoodenBow == 250) {
                } else if (xPositionWoodenBow == xPositionDiamondRing && yPositionWoodenBow == yPositionDiamondRing) {
                } else if (xPositionWoodenBow == xPositionJeweledSword && yPositionWoodenBow == yPositionJeweledSword) {
                } else if (xPositionWoodenBow == xPositionGoldenGlass && yPositionWoodenBow == yPositionGoldenGlass) {
                } else if (xPositionWoodenBow == xPositionGlassCup && yPositionWoodenBow == yPositionGlassCup) {
                } else break;
            }
            while (true) {
                xPositionSteelShield = (60 * randomNumMake.nextInt(10)) + 10;
                yPositionSteelShield = (60 * randomNumMake.nextInt(10)) + 10;
                if (xPositionSteelShield == 310 && yPositionSteelShield == 250) {
                } else if (xPositionSteelShield == xPositionDiamondRing && yPositionSteelShield == yPositionDiamondRing) {
                } else if (xPositionSteelShield == xPositionJeweledSword && yPositionSteelShield == yPositionJeweledSword) {
                } else if (xPositionSteelShield == xPositionGoldenGlass && yPositionSteelShield == yPositionGoldenGlass) {
                } else if (xPositionSteelShield == xPositionGlassCup && yPositionSteelShield == yPositionGlassCup) {
                } else if (xPositionSteelShield == xPositionWoodenBow && yPositionSteelShield == yPositionWoodenBow) {
                } else break;
            }
            while (true) {
                xPositionGoldenKey = (60 * randomNumMake.nextInt(10)) + 10;
                yPositionGoldenKey = (60 * randomNumMake.nextInt(10)) + 10;
                if (xPositionGoldenKey == 310 && yPositionGoldenKey == 250) {
                } else if (xPositionGoldenKey == xPositionDiamondRing && yPositionGoldenKey == yPositionDiamondRing) {
                } else if (xPositionGoldenKey == xPositionJeweledSword && yPositionGoldenKey == yPositionJeweledSword) {
                } else if (xPositionGoldenKey == xPositionGoldenGlass && yPositionGoldenKey == yPositionGoldenGlass) {
                } else if (xPositionGoldenKey == xPositionGlassCup && yPositionGoldenKey == yPositionGlassCup) {
                } else if (xPositionGoldenKey == xPositionWoodenBow && yPositionGoldenKey == yPositionWoodenBow) {
                } else if (xPositionGoldenKey == xPositionSteelShield && yPositionGoldenKey == yPositionSteelShield) {
                } else break;
            }
            while (true) {
                xPositionDragonScroll = (60 * randomNumMake.nextInt(10)) + 10;
                yPositionDragonScroll = (60 * randomNumMake.nextInt(10)) + 10;
                if (xPositionDragonScroll == 310 && yPositionDragonScroll == 250) {
                } else if (xPositionDragonScroll == xPositionDiamondRing && yPositionDragonScroll == yPositionDiamondRing) {
                } else if (xPositionDragonScroll == xPositionJeweledSword && yPositionDragonScroll == yPositionJeweledSword) {
                } else if (xPositionDragonScroll == xPositionGoldenGlass && yPositionDragonScroll == yPositionGoldenGlass) {
                } else if (xPositionDragonScroll == xPositionGlassCup && yPositionDragonScroll == yPositionGlassCup) {
                } else if (xPositionDragonScroll == xPositionWoodenBow && yPositionDragonScroll == yPositionWoodenBow) {
                } else if (xPositionDragonScroll == xPositionSteelShield && yPositionDragonScroll == yPositionSteelShield) {
                } else if (xPositionDragonScroll == xPositionGoldenKey && yPositionDragonScroll == yPositionGoldenKey) {
                } else break;
            }
            //Finish setting the positions of treasures
            //Start Setting wall positions for blue and red players
            for (int i = 0; i < wallNumberBlue; i++) {
                boolean drawSW = false;
                while (true) {
                    xPositionWallBlue = (60 * randomNumMake.nextInt(10)) + 10;
                    yPositionWallBlue = (60 * randomNumMake.nextInt(10)) + 10;
                    if (xPositionWallBlue == 10 && yPositionWallBlue == 550) {
                    } else if (xPositionWallBlue == 70 && yPositionWallBlue == 550) {
                    } else if (xPositionWallBlue == 10 && yPositionWallBlue == 490) {
                    } else if (xPositionWallBlue == 70 && yPositionWallBlue == 490) {
                    } else if (xPositionWallBlue == 310 && yPositionWallBlue == 250) {
                    } else break;
                }
                if (i == 0) {
                    xPositionWallListBlue[0] = xPositionWallBlue;
                    yPositionWallListBlue[0] = yPositionWallBlue;
                }
                for (int j = i - 1; j > -1; j--) {
                    if (xPositionWallBlue == xPositionWallListBlue[j] && yPositionWallBlue == yPositionWallListBlue[j]) {
                        i--;
                        break;
                    }
                    if (j == 0) drawSW = true;
                }
                if (drawSW) {
                    xPositionWallListBlue[i] = xPositionWallBlue;
                    yPositionWallListBlue[i] = yPositionWallBlue;
                    drawSW = false;
                }
            }
            for (int i = 0; i < wallNumberRed; i++) {
                boolean drawSW = false;
                while (true) {
                    xPositionWallRed = 60 * randomNumMake.nextInt(10) + 10;
                    yPositionWallRed = 60 * randomNumMake.nextInt(10) + 10;
                    if (xPositionWallRed == 10 && yPositionWallRed == 550) {
                    } else if (xPositionWallRed == 70 && yPositionWallRed == 550) {
                    } else if (xPositionWallRed == 10 && yPositionWallRed == 490) {
                    } else if (xPositionWallRed == 70 && yPositionWallRed == 490) {
                    } else if (xPositionWallRed == 310 && yPositionWallRed == 250) {
                    } else break;
                }
                if (i == 0) {
                    xPositionWallListRed[0] = xPositionWallRed;
                    yPositionWallListRed[0] = yPositionWallRed;
                }
                for (int j = i - 1; j > -1; j--) {
                    if (xPositionWallRed == xPositionWallListRed[j] && yPositionWallRed == yPositionWallListRed[j]) {
                        i--;
                        break;
                    }
                    if (j == 0) drawSW = true;
                }
                if (drawSW) {
                    xPositionWallListRed[i] = xPositionWallRed;
                    yPositionWallListRed[i] = yPositionWallRed;
                    drawSW = false;
                }
            }
            //Finish Setting wall positions for blue and red players
            //Start setting the positions of the traps
            for (int i = 0; i < trapNumber; i++) {
                boolean drawSW = false;
                while (true) {
                    xPositionTrap = (60 * randomNumMake.nextInt(10)) + 10;
                    yPositionTrap = (60 * randomNumMake.nextInt(10)) + 10;
                    if (xPositionTrap == 310 && yPositionTrap == 250) continue;
                    if (i == 0) {
                        xPositionTrapList[0] = xPositionTrap;
                        yPositionTrapList[0] = yPositionTrap;
                        break;
                    }
                    for (int j = i - 1; j > -1; j--) {
                        if (xPositionTrap == xPositionTrapList[j] && yPositionTrap == yPositionTrapList[j]) {
                            i--;
                            break;
                        }
                        if (j == 0) drawSW = true;
                    }
                    if (drawSW) {
                        xPositionTrapList[i] = xPositionTrap;
                        yPositionTrapList[i] = yPositionTrap;
                        break;
                    }
                }
            }
            //Finish setting the positions of the traps
            //Start setting the positions of markets
            for (int i = 0; i < marketNumber; i++) {
                boolean drawSW = false;
                while (true) {
                    xPositionMarket = (60 * randomNumMake.nextInt(10)) + 10;
                    yPositionMarket = (60 * randomNumMake.nextInt(10)) + 10;
                    if (xPositionMarket == 310 && yPositionMarket == 250) {
                    } else break;
                }
                if (i == 0) {
                    xPositionMarketList[0] = xPositionMarket;
                    yPositionMarketList[0] = yPositionMarket;
                } else {
                    for (int j = i - 1; j > -1; j--) {
                        if (xPositionMarket == xPositionMarketList[j] && yPositionMarket == yPositionMarketList[j]) {
                            i--;
                            break;
                        }
                        if (j == 0) drawSW = true;
                    }
                }
                if (drawSW) {
                    xPositionMarketList[i] = xPositionMarket;
                    yPositionMarketList[i] = yPositionMarket;
                }
            }
            //Finish setting the positions of markets
            //Start setting the position of loots
            for (int i = 0; i < lootNumber; i++) {
                boolean drawSW = false;
                while (true) {
                    xPositionLoot = (60 * randomNumMake.nextInt(10)) + 10;
                    yPositionLoot = (60 * randomNumMake.nextInt(10)) + 10;
                    if (xPositionLoot == 310 && yPositionLoot == 250) {
                    } else break;
                }
                if (i == 0) {
                    xPositionLootList[0] = xPositionLoot;
                    yPositionLootList[0] = yPositionLoot;
                } else {
                    for (int j = i - 1; j > -1; j--) {
                        if (xPositionLoot == xPositionLootList[j] && yPositionLoot == yPositionLootList[j]) {
                            i--;
                            break;
                        }
                        if (j == 0) drawSW = true;
                    }
                }
                if (drawSW) {
                    xPositionLootList[i] = xPositionLoot;
                    yPositionLootList[i] = yPositionLoot;
                    drawSW = false;
                }
            }
            //Finish setting the positions of loots
        }
        //Initializing variables if the load game button is pressed
        else if (gameplayTurn==-1) {
            xPositionWallListBlue = new int[100];
            yPositionWallListBlue = new int[100];
            xPositionWallListRed = new int[100];
            yPositionWallListRed = new int[100];
            xPositionTrapList = new int[100];
            yPositionTrapList = new int[100];
            showTrapSW = new boolean[100];
            usedTrapSW = new boolean[100];
            xPositionMarketList = new int[marketNumber];
            yPositionMarketList = new int[marketNumber];
            xPositionLootList = new int[lootNumber];
            yPositionLootList = new int[lootNumber];
            showLootSW = new boolean[lootNumber];
            usedLootSW = new boolean[lootNumber];
            try {
                SaveGame.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //set Timer
        timer = new Timer(1000, this);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                if (seconds == 60) {
                    seconds = 0;
                    minutes++;
                }
                if (minutes == 60) {
                    minutes = 0;
                    hours++;
                }
                repaint();
            }
        });
        timer.start();
    }

    public void paint(Graphics graphics) {
        //Setting the movement of the tick indicating the turn of the players
        if (gameplayTurn % 6 == 0 || gameplayTurn % 6 == 1 || gameplayTurn % 6 == 2) {
            tickXPosition = BLUE_xPOSITION_TICK;
        } else if (gameplayTurn % 6 == 3 || gameplayTurn % 6 == 4 || gameplayTurn % 6 == 5) {
            tickXPosition = RED_xPOSITION_TICK;
        }
        //Adjusting the display of blue and red players' movement squares
        if (gameplayTurn%6 == 0) {
            positionXBlueUpBox = INVISIBLE;
            positionXBlueDownBox = INVISIBLE;
            positionXBlueLeftBox = INVISIBLE;
            positionXBlueRightBox = INVISIBLE;
            positionXBlueSkipBox = INVISIBLE;
            positionXRedUpBox = INVISIBLE;
            positionXRedDownBox = INVISIBLE;
            positionXRedRightBox = INVISIBLE;
            positionXRedLeftBox = INVISIBLE;
            positionXRedSkipBox = INVISIBLE;
        }
        else if (gameplayTurn % 6 == 1) {
            positionXBlueUpBox = VISIBLE_BLUE_UP_BOX;
            positionXBlueDownBox = VISIBLE_BLUE_DOWN_BOX;
            positionXBlueLeftBox = VISIBLE_BLUE_LEFT_BOX;
            positionXBlueRightBox = VISIBLE_BLUE_RIGHT_BOX;
            positionXBlueSkipBox = INVISIBLE;
            positionXRedUpBox = INVISIBLE;
            positionXRedDownBox = INVISIBLE;
            positionXRedRightBox = INVISIBLE;
            positionXRedLeftBox = INVISIBLE;
            positionXRedSkipBox = INVISIBLE;
        }
        else if (gameplayTurn%6==2) {
            positionXBlueUpBox = INVISIBLE;
            positionXBlueDownBox = INVISIBLE;
            positionXBlueLeftBox = INVISIBLE;
            positionXBlueRightBox = INVISIBLE;
            positionXBlueSkipBox = VISIBLE_BLUE_SKIP_BOX;
            positionXRedUpBox = INVISIBLE;
            positionXRedDownBox = INVISIBLE;
            positionXRedRightBox = INVISIBLE;
            positionXRedLeftBox = INVISIBLE;
            positionXRedSkipBox = INVISIBLE;
        }
        else if (gameplayTurn%6 == 3) {
            positionXRedUpBox = INVISIBLE;
            positionXRedDownBox = INVISIBLE;
            positionXRedLeftBox = INVISIBLE;
            positionXRedRightBox = INVISIBLE;
            positionXRedSkipBox = INVISIBLE;
            positionXBlueUpBox = INVISIBLE;
            positionXBlueDownBox = INVISIBLE;
            positionXBlueLeftBox = INVISIBLE;
            positionXBlueRightBox = INVISIBLE;
            positionXBlueSkipBox = INVISIBLE;
        }
        else if (gameplayTurn % 6 == 4) {
            positionXRedUpBox = VISIBLE_RED_UP_BOX;
            positionXRedDownBox = VISIBLE_RED_DOWN_BOX;
            positionXRedLeftBox = VISIBLE_RED_LEFT_BOX;
            positionXRedRightBox = VISIBLE_RED_RIGHT_BOX;
            positionXRedSkipBox = INVISIBLE;
            positionXBlueUpBox = INVISIBLE;
            positionXBlueDownBox = INVISIBLE;
            positionXBlueLeftBox = INVISIBLE;
            positionXBlueRightBox = INVISIBLE;
            positionXBlueSkipBox = INVISIBLE;
        }
        else if (gameplayTurn%6 == 5) {
            positionXRedUpBox = INVISIBLE;
            positionXRedDownBox = INVISIBLE;
            positionXRedLeftBox = INVISIBLE;
            positionXRedRightBox = INVISIBLE;
            positionXRedSkipBox = VISIBLE_RED_SKIP_BOX;
            positionXBlueUpBox = INVISIBLE;
            positionXBlueDownBox = INVISIBLE;
            positionXBlueLeftBox = INVISIBLE;
            positionXBlueRightBox = INVISIBLE;
            positionXBlueSkipBox = INVISIBLE;
        }
        //Setting the display of rectangular information messages
        for (int i=0;i<34;i++) {
            xPositionInformationList[i]=INVISIBLE;
        }
        xPositionInformationList[informationTextSW]=X_POSITION_INFORMATION_TEXT;
        //Adjust the display of quests
        for (int i=0 ; i<8 ; i++) {
            xPositionQuest[i] = INVISIBLE;
        }
        xPositionQuest[questSW] = X_POSITION_QUEST;
        //Erasing the footprints of players after changing turns
        if (gameplayTurn % 6 == 3) {
            for (int i = 0; i < 6; i++) {
                positionXBlueFootPrint[i] = INVISIBLE;
                positionYBlueFootPrint[i] = INVISIBLE;
            }
        } else if (gameplayTurn % 6 == 0) {
            for (int i = 0; i < 6; i++) {
                positionXRedFootPrint[i] = INVISIBLE;
                positionYRedFootPrint[i] = INVISIBLE;
            }
        }
        //Start setting the activation of the roll the dice buttons
        if (gameplayTurn%6==0) blueRollTheDiceButton.setEnabled(true);
        else blueRollTheDiceButton.setEnabled(false);
        if (gameplayTurn%6==3) redRollTheDiceButton.setEnabled(true);
        else redRollTheDiceButton.setEnabled(false);
        //Start Setting the activation of the Blue player movement buttons
        if (gameplayTurn%6==1) {
            blueUpButton.setEnabled(true);
            blueDownButton.setEnabled(true);
            blueRightButton.setEnabled(true);
            blueLeftButton.setEnabled(true);
        }
        else {
            blueUpButton.setEnabled(false);
            blueDownButton.setEnabled(false);
            blueRightButton.setEnabled(false);
            blueLeftButton.setEnabled(false);
        }
        if (gameplayTurn%6==4) {
            redUpButton.setEnabled(true);
            redDownButton.setEnabled(true);
            redRightButton.setEnabled(true);
            redLeftButton.setEnabled(true);
        }
        else {
            redUpButton.setEnabled(false);
            redDownButton.setEnabled(false);
            redRightButton.setEnabled(false);
            redLeftButton.setEnabled(false);
        }
        //Start setting the activation of the Blue and red skip buttons
        if (gameplayTurn%6==2) blueSkipButton.setEnabled(true);
        else blueSkipButton.setEnabled(false);
        if (gameplayTurn%6==5) redSkipButton.setEnabled(true);
        else redSkipButton.setEnabled(false);
        //Start Setting the activation of the market button
        if (gameplayTurn%6==0 || gameplayTurn%6==1 || gameplayTurn%6==2) {
            marketButton.setEnabled(false);
            for (int i = 0; i < marketNumber; i++) {
                if (positionXBlue == xPositionMarketList[i] && positionYBlue == yPositionMarketList[i]) {
                    marketButton.setEnabled(true);
                    break;
                }
                if (i == marketNumber - 1) marketButton.setEnabled(false);
            }
        }
        else if (gameplayTurn%6==3 || gameplayTurn%6==4 || gameplayTurn%6==5) {
            marketButton.setEnabled(false);
            for (int i = 0; i < marketNumber; i++) {
                if (positionXRed == xPositionMarketList[i] && positionYRed == yPositionMarketList[i]) {
                    marketButton.setEnabled(true);
                    break;
                }
                if (i == marketNumber - 1) marketButton.setEnabled(false);
            }
        }
        //Start setting the activation of the traps in game board
            if (gameplayTurn % 6 == 0 || gameplayTurn % 6 == 1 || gameplayTurn % 6 == 2) {
                for (int i = 0; i < trapNumber; i++) {
                    if (positionXBlue == xPositionTrapList[i] && positionYBlue == yPositionTrapList[i]) {
                        if (!showTrapSW[i]) {
                            showTrapSW[i] = true;
                        }
                        if (!usedTrapSW[i]) {
                            informationTextSW = 4;
                            new GameSound("trap");
                            usedTrapSW[i] = true;
                            blueMoney-=100;
                            break;
                        }
                    }
                }
            } else if (gameplayTurn % 6 == 3 || gameplayTurn % 6 == 4 || gameplayTurn % 6 == 5) {
                for (int i = 0; i < trapNumber; i++) {
                    if (positionXRed == xPositionTrapList[i] && positionYRed == yPositionTrapList[i]) {
                        if (!showTrapSW[i]) {
                            showTrapSW[i] = true;
                        }
                        if (!usedTrapSW[i]) {
                            informationTextSW = 5;
                            new GameSound("trap");
                            usedTrapSW[i] = true;
                            redMoney-=100;
                            break;
                        }
                    }
                }
            }
        //Start setting the activation of the loots in game board
        if (gameplayTurn % 6 == 0 || gameplayTurn % 6 == 1 || gameplayTurn%6 == 2) {
            for (int i=0 ; i<lootNumber;i++) {
                if (positionXBlue == xPositionLootList[i] && positionYBlue==yPositionLootList[i]) {
                    if (!showLootSW[i]) {
                        showLootSW[i]=true;
                    }
                    if (!usedLootSW[i]) {
                        informationTextSW = i+8;
                        new GameSound("success");
                        usedLootSW[i] = true;
                        blueMoney+=(i+1)*100;
                        break;
                    }
                }
            }
        }
        else if (gameplayTurn%6 == 3 || gameplayTurn%6 == 4 || gameplayTurn%6 == 5) {
            for (int i=0 ; i<lootNumber;i++) {
                if (positionXRed == xPositionLootList[i] && positionYRed == yPositionLootList[i]) {
                    if (!showLootSW[i]) {
                        showLootSW[i]=true;
                    }
                    if (!usedLootSW[i]) {
                        informationTextSW = i+21;
                        new GameSound("success");
                        usedLootSW[i] = true;
                        redMoney+=(i+1)*100;
                        break;
                    }
                }
            }
        }
        //Start setting the activation of the treasure
        if (gameplayTurn%6 ==0 || gameplayTurn%6==1 || gameplayTurn%6==2) {
            if (positionXBlue == xPositionDiamondRing && positionYBlue == yPositionDiamondRing) {
                if (diamondRingOwner == 0 && questSW == 0) {
                    diamondRingOwner = 1;
                    usedQuestSW[0] = true;
                }
                if (!usedDiamondRingSW && questSW == 0) {
                    new GameSound("victory");
                    usedDiamondRingSW = true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (MarketPanel.getTicksListSW(0)!=2 && questSW==0)
                    MarketPanel.setTicksListSW(0,1);
            }
            else if (positionXBlue==xPositionJeweledSword && positionYBlue==yPositionJeweledSword) {
                if (jeweledSwordOwner==0 && questSW==1) {
                    jeweledSwordOwner=1;
                    usedQuestSW[1]=true;
                }
                if (!usedJeweledSwordSW && questSW==1) {
                    new GameSound("victory");
                    usedJeweledSwordSW=true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (MarketPanel.getTicksListSW(1)!=2 && questSW==1)
                    MarketPanel.setTicksListSW(1,1);
            }
            else if (positionXBlue==xPositionGoldenGlass && positionYBlue==yPositionGoldenGlass) {
                if (goldenGlassOwner==0 && questSW==2) {
                    goldenGlassOwner=1;
                    usedQuestSW[2]=true;
                }
                if (!usedGoldenGlassSW && questSW==2) {
                    new GameSound("victory");
                    usedGoldenGlassSW=true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (MarketPanel.getTicksListSW(2)!=2 && questSW==2)
                    MarketPanel.setTicksListSW(2,1);
             }
            else if (positionXBlue==xPositionGlassCup && positionYBlue==yPositionGlassCup) {
                if (glassCupOwner==0 && questSW==3) {
                    glassCupOwner=1;
                    usedQuestSW[3]=true;
                }
                if (!usedGlassCupSW && questSW==3) {
                    new GameSound("victory");
                    usedGlassCupSW = true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (MarketPanel.getTicksListSW(3)!=2 && questSW==3)
                    MarketPanel.setTicksListSW(3,1);
            }
            else if (positionXBlue==xPositionWoodenBow && positionYBlue==yPositionWoodenBow) {
                if (woodenBowOwner==0 && questSW==4) {
                    woodenBowOwner=1;
                    usedQuestSW[4] = true;
                }
                if (!usedWoodenBowSW && questSW==4) {
                    new GameSound("victory");
                    usedWoodenBowSW=true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (MarketPanel.getTicksListSW(4)!=2 && questSW==4)
                    MarketPanel.setTicksListSW(4,1);
            }
            else if (positionXBlue==xPositionSteelShield && positionYBlue==yPositionSteelShield) {
                if (steelShieldOwner==0 && questSW==5) {
                    steelShieldOwner=1;
                    usedQuestSW[5]=true;
                }
                if (!usedSteelShieldSW && questSW==5) {
                    new GameSound("victory");
                    usedSteelShieldSW=true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (MarketPanel.getTicksListSW(5)!=2 && questSW==5)
                    MarketPanel.setTicksListSW(5,1);
            }
            else if (positionXBlue==xPositionGoldenKey && positionYBlue==yPositionGoldenKey) {
                if (goldenKeyOwner==0 && questSW==6) {
                    goldenKeyOwner=1;
                    usedQuestSW[6] = true;
                }
                if (!usedGoldenKeySW && questSW==6) {
                    new GameSound("victory");
                    usedGoldenKeySW=true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (MarketPanel.getTicksListSW(6)!=2 && questSW==6)
                    MarketPanel.setTicksListSW(6,1);
            }
            else if (positionXBlue==xPositionDragonScroll && positionYBlue==yPositionDragonScroll) {
                if (dragonScrollOwner==0 && questSW==7) {
                    dragonScrollOwner=1;
                    usedQuestSW[7]=true;
                }
                if (!usedDragonScrollSW && questSW==7) {
                    new GameSound("victory");
                    usedDragonScrollSW=true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (MarketPanel.getTicksListSW(7)!=2 && questSW==7)
                    MarketPanel.setTicksListSW(7,1);
            }
        } else if (gameplayTurn % 6 == 3 || gameplayTurn % 6 == 4 || gameplayTurn %6==5) {
            if (positionXRed==xPositionDiamondRing && positionYRed==yPositionDiamondRing) {
                if (diamondRingOwner==0 && questSW==0) {
                    diamondRingOwner=2;
                    usedQuestSW[0] = true;
                }
                if (!usedDiamondRingSW && questSW==0) {
                    new GameSound("victory");
                    usedDiamondRingSW=true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (MarketPanel.getTicksListSW(0)!=2 && questSW==0)
                    MarketPanel.setTicksListSW(0,1);
            }
            else if (positionXRed==xPositionJeweledSword && positionYRed==yPositionJeweledSword) {
                if (jeweledSwordOwner==0 && questSW==1) {
                    jeweledSwordOwner=2;
                    usedQuestSW[1] = true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (!usedJeweledSwordSW && questSW==1) {
                    new GameSound("victory");
                    usedJeweledSwordSW=true;
                }
                if (MarketPanel.getTicksListSW(1)!=2 && questSW==1)
                    MarketPanel.setTicksListSW(1,1);
            }
            else if (positionXRed==xPositionGoldenGlass && positionYRed==yPositionGoldenGlass) {
                if (goldenGlassOwner==0 && questSW==2) {
                    goldenGlassOwner=2;
                    usedQuestSW[2] = true;
                }
                if (!usedGoldenGlassSW && questSW==2) {
                    new GameSound("victory");
                    usedGoldenGlassSW=true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (MarketPanel.getTicksListSW(2)!=2 && questSW==2)
                    MarketPanel.setTicksListSW(2,1);
            }
            else if (positionXRed==xPositionGlassCup && positionYRed==yPositionGlassCup) {
                if (glassCupOwner==0 && questSW==3) {
                    glassCupOwner=2;
                    usedQuestSW[3] = true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (!usedGlassCupSW && questSW==3) {
                    new GameSound("victory");
                    usedGlassCupSW=true;
                }
                if (MarketPanel.getTicksListSW(3)!=2 && questSW==3)
                    MarketPanel.setTicksListSW(3,1);
            }
            else if (positionXRed==xPositionWoodenBow && positionYRed==yPositionWoodenBow) {
                if (woodenBowOwner==0 && questSW==4) {
                    woodenBowOwner=2;
                    usedQuestSW[4] = true;
                }
                if (!usedWoodenBowSW && questSW==4) {
                    new GameSound("victory");
                    usedWoodenBowSW=true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (MarketPanel.getTicksListSW(4)!=2 && questSW==4)
                    MarketPanel.setTicksListSW(4,1);
            }
            else if (positionXRed==xPositionSteelShield && positionYRed==yPositionSteelShield) {
                if (steelShieldOwner==0 && questSW==5) {
                    steelShieldOwner=2;
                    usedQuestSW[5] = true;
                }
                if (!usedSteelShieldSW && questSW==5) {
                    new GameSound("victory");
                    usedSteelShieldSW=true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (MarketPanel.getTicksListSW(5)!=2 && questSW==5)
                    MarketPanel.setTicksListSW(5,1);
            }
            else if (positionXRed==xPositionGoldenKey && positionYRed==yPositionGoldenKey) {
                if (goldenKeyOwner==0 && questSW==6) {
                    goldenKeyOwner=2;
                    usedQuestSW[6] = true;
                }
                if (!usedGoldenKeySW && questSW==6) {
                    new GameSound("victory");
                    usedGoldenKeySW=true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (MarketPanel.getTicksListSW(6)!=2 && questSW==6)
                    MarketPanel.setTicksListSW(6,1);
            }
            else if (positionXRed==xPositionDragonScroll && positionYRed==yPositionDragonScroll) {
                if (dragonScrollOwner==0 && questSW==7) {
                    dragonScrollOwner=2;
                    usedQuestSW[7] = true;
                }
                if (!usedDragonScrollSW && questSW==7) {
                    new GameSound("victory");
                    usedDragonScrollSW=true;
                    JOptionPane.showOptionDialog(
                            null,
                            "You found the treasure, go to the castle square and sell the treasure!",
                            "The treasure was found!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                if (MarketPanel.getTicksListSW(7)!=2 && questSW==7)
                    MarketPanel.setTicksListSW(7,1);
            }
        }
        //Enable castle frame display when players reach the castle square
        if (positionXBlue==310 && positionYBlue==250 && blueCastleSW) {
            castleFrame = new CastleFrame();
            blueCastleSW =false;
        }
        else if (positionXBlue!=310 || positionYBlue!=250) blueCastleSW=true;
        if (positionXRed==310 && positionYRed==250 && redCastleSW) {
            castleFrame = new CastleFrame();
            redCastleSW=false;
        }
        else if (positionXRed!=310 || positionYRed!=250) redCastleSW=true;
        //-----------------------------------------------------------------------------------------
        Graphics2D g2D = (Graphics2D) graphics;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //create "Digital Font" with size 18 and 23
        String filenameDigitalFont = "fonts\\digital-7 (mono).ttf";
        Font fontDigital23 = null;
        Font fontDigital18 = null;
        try {
            fontDigital23 = Font.createFont(Font.TRUETYPE_FONT, new File(filenameDigitalFont));
            fontDigital18=Font.createFont(Font.TRUETYPE_FONT, new File(filenameDigitalFont));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fontDigital23 = fontDigital23.deriveFont(Font.BOLD, 23);
        fontDigital18 = fontDigital18.deriveFont(Font.BOLD,18);
        ge.registerFont(fontDigital23);
        ge.registerFont(fontDigital18);
        //create "Japanese Font" with size 22 and 25
        String filenameJapaneseFont = "fonts\\Japanese 3017.ttf";
        Font fontJapanese25 = null;
        Font fontJapanese22 = null;
        try {
            fontJapanese25 = Font.createFont(Font.TRUETYPE_FONT, new File(filenameJapaneseFont));
            fontJapanese22 = Font.createFont(Font.TRUETYPE_FONT, new File(filenameJapaneseFont));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fontJapanese25 = fontJapanese25.deriveFont(Font.BOLD, 25);
        fontJapanese22 = fontJapanese22.deriveFont(Font.BOLD, 22);
        ge.registerFont(fontJapanese25);
        ge.registerFont(fontJapanese22);
        //---------------Draw the game background-----------------------------------------
        g2D.drawImage(gameBackgroundImage, 0, 0, 1400, 850, 0, 0, 1920, 1183, null);
        //%%%%%%%%%%%%%%%%%%%%%%% Start drawing the game board %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
        g2D.setPaint(new Color(0, 0, 0, 175));
        g2D.fillRect(10, 10, 600, 600);
        //----------------------Draw vertical lines----------------------------------------------
        for (int i = 10; i <= 610; i += 60) {
            if (i == 10 || i == 610) {
                g2D.setStroke(new BasicStroke(4));
                g2D.setColor(new Color(219, 172, 52));
            } else {
                g2D.setStroke(new BasicStroke(2));
                g2D.setPaint(Color.white);
            }
            g2D.drawLine(i, 10, i, 610);
        }
        //---------------------Draw horizontal lines--------------------------------------------
        for (int j = 10; j <= 610; j += 60) {
            if (j == 10 || j == 610) {
                g2D.setStroke(new BasicStroke(4));
                g2D.setColor(new Color(219, 172, 52));
            } else {
                g2D.setStroke(new BasicStroke(2));
                g2D.setPaint(Color.white);
            }
            g2D.drawLine(10, j, 610, j);
        }
        g2D.setFont(new Font("Ink free", Font.BOLD, 17));
        g2D.setColor(Color.GRAY);
        for (int number = 1; number < 101; ) {
            String numberSTRING = String.valueOf(number);
            for (int j = 580; j >= 40; j -= 60) {
                for (int i = 15; i < 615; i += 60) {
                    numberSTRING = String.valueOf(number);
                    g2D.drawString(numberSTRING, i, j);
                    number++;
                }
            }
        }
        //%%%%%%%%%%%%%%%%%%%%% Finish drawing the game board %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
        //--------------------------Draw characters-------------------------------------------
        if (gameplayTurn % 6 == 0 || gameplayTurn % 6 == 1 || gameplayTurn % 6 == 2) {
            g2D.drawImage(bluePlayerImage, 500, 40, 900, 415, 0, 0, 700, 700, null);
        } else if (gameplayTurn % 6 == 3 || gameplayTurn % 6 == 4 || gameplayTurn % 6 == 5) {
            g2D.drawImage(redPlayerImage, 1100, 70, 1300, 380, 0, 0, 2700, 4800, null);
        }
        //--------------------------Start drawing the scoreboard-----------------------------------------------------
        g2D.setColor(new Color(27, 27, 27, 225));
        g2D.fillRect(775, 77, 350, 340);
        g2D.setColor(new Color(0x10382d));
        g2D.fillRect(775, 10, 350, 67);
        g2D.setColor(new Color(212, 175, 55));
        g2D.setStroke(new BasicStroke(4));
        g2D.drawRect(775, 10, 350, 407);
        g2D.drawLine(950, 10, 950, 417);
        g2D.drawLine(775, 77, 1125, 77);
        g2D.drawLine(775,140,1125,140);
        g2D.drawLine(775,220,1125,220);
        g2D.drawLine(775,300,1125,300);
        g2D.setColor(new Color(0x5ecfaf));
        g2D.setFont(fontJapanese22);
        g2D.drawString("Blue Player", 785, 50);
        g2D.setFont(fontJapanese22);
        g2D.drawString("Red Player", 967, 50);
        g2D.setPaint(new Color(0, 142, 128, 150));
        g2D.fillRect(630, 10, 130, 60);
        g2D.setPaint(Color.white);
        g2D.setStroke(new BasicStroke(1));
        g2D.drawRect(630, 10, 130, 60);
        g2D.setFont(fontJapanese22);
        g2D.drawString("Blue Turn", 633, 50);
        g2D.setPaint(new Color(255, 38, 40, 100));
        g2D.fillRect(1140, 10, 130, 60);
        g2D.setPaint(Color.white);
        g2D.drawRect(1140, 10, 130, 60);
        g2D.setFont(fontJapanese25);
        g2D.drawString("Red Turn", 1142, 50);
        g2D.drawImage(tickImage, tickXPosition, 15, 50, 50, null);
        g2D.setFont(fontJapanese22);
        g2D.setColor(new Color(0, 142, 200));
        g2D.drawString("Score :", 785, 100);
        g2D.drawString("Money :", 785, 175);
        g2D.drawString("Power :", 785, 250);
        g2D.drawString("Number of", 785, 325);
        g2D.drawString("treasures", 785, 350);
        g2D.drawString("found :", 785, 375);
        g2D.setColor(new Color(255, 38, 40));
        g2D.drawString("Score :", 960, 100);
        g2D.drawString("Money :", 960, 175);
        g2D.drawString("Power :", 960, 250);
        g2D.drawString("Number of", 960, 325);
        g2D.drawString("treasures", 960, 350);
        g2D.drawString("found :", 960, 375);
        g2D.setFont(fontDigital23);
        blueScore_string = String.format("%05d", blueScore);
        blueMoney_string = String.format("%05d", blueMoney);
        bluePower_string = String.format("%05d", bluePower);
        blueTreasureNo_string = String.format("%02d", blueTreasureNo);
        redScore_string = String.format("%05d", redScore);
        redMoney_string = String.format("%05d", redMoney);
        redPower_string = String.format("%05d", redPower);
        redTreasureNo_string = String.format("%02d", redTreasureNo);
        g2D.setColor(new Color(0, 142, 200));
        g2D.drawString(blueScore_string, 785, 125);
        if (gameplayTurn%6==0 || gameplayTurn%6==1 || gameplayTurn%6==2) {
        g2D.drawString(blueMoney_string, 785, 200);
        g2D.setColor(new Color(255,38,40));
        g2D.drawString("Hidden!" ,960,200);
        g2D.setColor(new Color(0,142,200));
        }
        g2D.drawString(bluePower_string, 785, 275);
        g2D.drawString(blueTreasureNo_string, 785, 400);
        g2D.setColor(new Color(255, 38, 40));
        g2D.drawString(redScore_string, 960, 125);
        if (gameplayTurn%6==3 || gameplayTurn%6==4 || gameplayTurn%6==5){
            g2D.drawString(redMoney_string, 960, 200);
            g2D.setColor(new Color(0,142,200));
            g2D.drawString("Hidden!" ,785,200);
            g2D.setColor(new Color(255,38,40));
        }
        g2D.drawString(redPower_string, 960, 275);
        g2D.drawString(redTreasureNo_string, 960, 400);
        //-----------------------Finish drawing the scoreboard-----------------------------
        //-------------Start drawing blue and red "roll the dice" Rectangle---------------------
        g2D.setColor(new Color(0, 165, 114));
        g2D.fillRect(625, 490, 135, 30);
        g2D.setColor(new Color(200, 38, 40));
        g2D.fillRect(1140, 490, 135, 30);
        //-------------Finish drawing blue and red "roll the dice" Rectangle---------------------
        //-------------Start drawing "Exit" and "Sound" Rectangle--------------------------------
        g2D.setColor(Color.darkGray);
        g2D.fillRect(1160, 570, 100, 30);
        g2D.fillRect(1160, 610, 100, 30);
        g2D.fillRect(1160,650,100,30);
        //-------------Finish drawing "Exit" and "Sound" Rectangle-------------------------------
        //-------------Start drawing Blue and Red arrow Rectangle--------------------------------
        g2D.setStroke(new BasicStroke(2));
        g2D.setColor(Color.WHITE);
        g2D.drawRect(150, 640, 40, 40);
        g2D.drawRect(195, 640, 40, 40);
        g2D.drawRect(240, 640, 40, 40);
        g2D.drawRect(285, 640, 40, 40);
        g2D.drawRect(330, 640, 40, 40);
        g2D.setColor(Color.BLACK);
        g2D.drawRect(375, 640, 40, 40);
        g2D.drawRect(420, 640, 40, 40);
        g2D.drawRect(465, 640, 40, 40);
        g2D.drawRect(510, 640, 40, 40);
        g2D.drawRect(555, 640, 40, 40);
        g2D.setPaint(new Color(84, 76, 74));
        g2D.fillRect(positionXBlueUpBox, 640, 40, 40);
        g2D.fillRect(positionXBlueDownBox, 640, 40, 40);
        g2D.fillRect(positionXBlueLeftBox, 640, 40, 40);
        g2D.fillRect(positionXBlueRightBox, 640, 40, 40);
        g2D.fillRect(positionXBlueSkipBox, 640, 40, 40);
        g2D.setColor(new Color(0, 165, 114));
        g2D.drawRect(positionXBlueUpBox, 640, 40, 40);
        g2D.drawRect(positionXBlueDownBox, 640, 40, 40);
        g2D.drawRect(positionXBlueLeftBox, 640, 40, 40);
        g2D.drawRect(positionXBlueRightBox, 640, 40, 40);
        g2D.drawRect(positionXBlueSkipBox, 640, 40, 40);
        g2D.setFont(new Font("Ink free", Font.BOLD, 25));
        g2D.drawString("U", positionXBlueUpBox + 10, 670);
        g2D.drawString("D", positionXBlueDownBox + 10, 670);
        g2D.drawString("L", positionXBlueLeftBox + 10, 670);
        g2D.drawString("R", positionXBlueRightBox + 10, 670);
        g2D.drawString("Sk", positionXBlueSkipBox + 5, 670);
        g2D.setColor(Color.white);
        g2D.fillRect(positionXRedUpBox, 640, 40, 40);
        g2D.fillRect(positionXRedDownBox, 640, 40, 40);
        g2D.fillRect(positionXRedLeftBox, 640, 40, 40);
        g2D.fillRect(positionXRedRightBox, 640, 40, 40);
        g2D.fillRect(positionXRedSkipBox, 640, 40, 40);
        g2D.setColor(new Color(200, 38, 40));
        g2D.drawRect(positionXRedUpBox, 640, 40, 40);
        g2D.drawRect(positionXRedDownBox, 640, 40, 40);
        g2D.drawRect(positionXRedLeftBox, 640, 40, 40);
        g2D.drawRect(positionXRedRightBox, 640, 40, 40);
        g2D.drawRect(positionXRedSkipBox, 640, 40, 40);
        g2D.drawString("U", positionXRedUpBox + 10, 670);
        g2D.drawString("D", positionXRedDownBox + 10, 670);
        g2D.drawString("L", positionXRedLeftBox + 10, 670);
        g2D.drawString("R", positionXRedRightBox + 10, 670);
        g2D.drawString("Sk", positionXRedSkipBox + 5, 670);
        //-------------------------------------------------------------------
        //-------------Start drawing blue dice and red dice------------------
        g2D.setStroke(new BasicStroke(7));
        g2D.setColor(new Color(0, 165, 114));
        g2D.drawRect(645, 388, 90, 90);
        g2D.setPaint(new Color(84, 76, 74));
        g2D.fillRect(645, 388, 90, 90);
        g2D.setPaint(new Color(200, 38, 40));
        g2D.drawRect(1160, 388, 90, 90);
        g2D.setPaint(new Color(255, 255, 255));
        g2D.fillRect(1160, 388, 90, 90);
        // %%%%%%%%%%%%%%%%%%%%%%%%%% blue dice Image %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
        g2D.drawImage(diceB1, positionXDiceB1, 388, 90, 90, null);
        g2D.drawImage(diceB2, positionXDiceB2, 388, 90, 90, null);
        g2D.drawImage(diceB3, positionXDiceB3, 388, 90, 90, null);
        g2D.drawImage(diceB4, positionXDiceB4, 388, 90, 90, null);
        g2D.drawImage(diceB5, positionXDiceB5, 388, 90, 90, null);
        g2D.drawImage(diceB6, positionXDiceB6, 388, 90, 90, null);
        // %%%%%%%%%%%%%%%%%%%%%%%%%% red dice images %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
        g2D.drawImage(diceR1, positionXDiceR1, 388, 90, 90, null);
        g2D.drawImage(diceR2, positionXDiceR2, 388, 90, 90, null);
        g2D.drawImage(diceR3, positionXDiceR3, 388, 90, 90, null);
        g2D.drawImage(diceR4, positionXDiceR4, 388, 90, 90, null);
        g2D.drawImage(diceR5, positionXDiceR5, 388, 90, 90, null);
        g2D.drawImage(diceR6, positionXDiceR6, 388, 90, 90, null);
        //--------Finish drawing blue dice and red dice----------------------------------
        //-------------Start drawing the "start squares"---------------------------------
        g2D.setStroke(new BasicStroke(4));
        g2D.setPaint(new Color(0, 142, 128));
        g2D.drawRect(10, 620, 60, 60);
        g2D.setStroke(new BasicStroke(1));
        g2D.setPaint(new Color(0x544C4A));
        g2D.fillRect(10, 620, 60, 60);
        g2D.setStroke(new BasicStroke(4));
        g2D.setPaint(new Color(255, 38, 40));
        g2D.drawRect(80, 620, 60, 60);
        g2D.setStroke(new BasicStroke(1));
        g2D.setPaint(new Color(255, 255, 255));
        g2D.fillRect(80, 620, 60, 60);
        g2D.setPaint(new Color(255, 38, 40));
        g2D.setFont(new Font("MV Boli", Font.BOLD, 20));
        g2D.drawString("Start", 80, 655);
        g2D.setPaint(new Color(0, 142, 128));
        g2D.setFont(new Font("MV Boli", Font.BOLD, 20));
        g2D.drawString("Start", 10, 655);
        //------------Finish drawing the "start squares"--------------------------------------
        //------------Start drawing the details of the game board------------------------------
        //****************Start drawing the castle in the middle of the game board*****************
        g2D.setColor(new Color(219, 172, 52));
        g2D.fillRect(311, 251, 58, 59);
        g2D.drawImage(castleImage, 310, 250, 370, 310, 0, 0, 1000, 864, null);
        //****************Finish drawing the castle in the middle of the game board*****************
        //****************Start drawing treasures***************************************************
        if (diamondRingOwner == 1) {
            if (gameplayTurn % 6 == 0 || gameplayTurn %6 == 1 || gameplayTurn %6 == 2) {
                g2D.drawImage(diamondRingImage, xPositionDiamondRing, yPositionDiamondRing, 60, 60, null);
            }
        } else if (diamondRingOwner == 2) {
            if (gameplayTurn % 6 == 3 || gameplayTurn %6== 4 || gameplayTurn %6== 5) {
                g2D.drawImage(diamondRingImage, xPositionDiamondRing, yPositionDiamondRing, 60, 60, null);
            }
        }
        if (jeweledSwordOwner == 1) {
            if (gameplayTurn % 6 == 0 || gameplayTurn % 6 == 1 || gameplayTurn % 6 == 2) {
                g2D.drawImage(jeweledSwordImage, xPositionJeweledSword, yPositionJeweledSword, 60, 60, null);
            }
        } else if (jeweledSwordOwner == 2) {
            if (gameplayTurn % 6 == 3 || gameplayTurn % 6 == 4 || gameplayTurn % 6 == 5) {
                g2D.drawImage(jeweledSwordImage, xPositionJeweledSword, yPositionJeweledSword, 60, 60, null);
            }
        }
        if (goldenGlassOwner == 1) {
            if (gameplayTurn % 6 == 0 || gameplayTurn % 6 == 1 || gameplayTurn % 6 == 2) {
                g2D.drawImage(goldenGlassImage, xPositionGoldenGlass, yPositionGoldenGlass, 60, 60, null);
            }
        } else if (goldenGlassOwner == 2) {
            if (gameplayTurn % 6 == 3 || gameplayTurn % 6 == 4 || gameplayTurn % 6 == 5) {
                g2D.drawImage(goldenGlassImage, xPositionGoldenGlass, yPositionGoldenGlass, 60, 60, null);
            }
        }
        if (glassCupOwner == 1) {
            if (gameplayTurn % 6 == 0 || gameplayTurn % 6 == 1 || gameplayTurn % 6 == 2) {
                g2D.drawImage(glassCupImage, xPositionGlassCup, yPositionGlassCup, 60, 60, null);
            }
        } else if (glassCupOwner == 2) {
            if (gameplayTurn % 6 == 3 || gameplayTurn % 6 == 4 || gameplayTurn % 6 == 5) {
                g2D.drawImage(glassCupImage, xPositionGlassCup, yPositionGlassCup, 60, 60, null);
            }
        }
        if (woodenBowOwner == 1) {
            if (gameplayTurn % 6 == 0 || gameplayTurn % 6 == 1 || gameplayTurn % 6 == 2) {
                g2D.drawImage(woodenBowImage, xPositionWoodenBow, yPositionWoodenBow, 60, 60, null);
            }
        } else if (woodenBowOwner == 2) {
            if (gameplayTurn % 6 == 3 || gameplayTurn % 6 == 4 || gameplayTurn % 6 == 5) {
                g2D.drawImage(woodenBowImage, xPositionWoodenBow, yPositionWoodenBow, 60, 60, null);
            }
        }
        if (steelShieldOwner == 1) {
            if (gameplayTurn % 6 == 0 || gameplayTurn % 6 == 1 || gameplayTurn % 6 == 2) {
                g2D.drawImage(steelShieldImage, xPositionSteelShield, yPositionSteelShield, 60, 60, null);
            }
        } else if (steelShieldOwner == 2) {
            if (gameplayTurn % 6 == 3 || gameplayTurn % 6 == 4 || gameplayTurn % 6 == 5) {
                g2D.drawImage(steelShieldImage, xPositionSteelShield, yPositionSteelShield, 60, 60, null);
            }
        }
        if (goldenKeyOwner == 1) {
            if (gameplayTurn % 6 == 0 || gameplayTurn % 6 == 1 || gameplayTurn % 6 == 2) {
                g2D.drawImage(goldenKeyImage, xPositionGoldenKey, yPositionGoldenKey, 60, 60, null);
            }
        } else if (goldenKeyOwner == 2) {
            if (gameplayTurn % 6 == 3 || gameplayTurn % 6 == 4 || gameplayTurn % 6 == 5) {
                g2D.drawImage(goldenKeyImage, xPositionGoldenKey, yPositionGoldenKey, 60, 60, null);
            }
        }
        if (dragonScrollOwner == 1) {
            if (gameplayTurn % 6 == 0 || gameplayTurn % 6 == 1 || gameplayTurn % 6 == 2) {
                g2D.drawImage(dragonScrollImage, xPositionDragonScroll, yPositionDragonScroll, 60, 60, null);
            }
        } else if (dragonScrollOwner == 2) {
            if (gameplayTurn % 6 == 3 || gameplayTurn % 6 == 4 || gameplayTurn % 6 == 5) {
                g2D.drawImage(dragonScrollImage, xPositionDragonScroll, yPositionDragonScroll, 60, 60, null);
            }
        }
        //****************Finish drawing treasures***************************************************
        //****************Start drawing market icons in game board **********************************
        for (int i = 0; i < marketNumber; i++) {
            g2D.drawImage(whiteMarketImag, xPositionMarketList[i], yPositionMarketList[i], 60, 60, null);
        }
        //**************Finish drawing market icon in game board ************************************
        //****************Start drawing money bags****************************************************
        for (int i = 0; i < lootNumber; i++) {
            if (showLootSW[i]) {
                g2D.drawImage(moneyBagImage, xPositionLootList[i], yPositionLootList[i], 60, 60, null);
            }
        }
        //***************Finish drawing money bags****************************************************
        //************** Start drawing walls for blue and red players ********************************
        if (gameplayTurn % 6 == 0 || gameplayTurn % 6 == 1 || gameplayTurn % 6 == 2) {
            for (int i = 0; i < wallNumberBlue; i++) {
                g2D.drawImage(WallImage, xPositionWallListBlue[i], yPositionWallListBlue[i], 60, 60, null);
            }
        } else if (gameplayTurn % 6 == 3 || gameplayTurn % 6 == 4 || gameplayTurn % 6 == 5) {
            for (int i = 0; i < wallNumberRed; i++) {
                g2D.drawImage(WallImage, xPositionWallListRed[i], yPositionWallListRed[i], 60, 60, null);
            }
        }
        //************** Finish drawing walls for blue and red players ********************************
        //************** Start drawing traps **********************************************************
        for (int i = 0; i < trapNumber; i++) {
            if (showTrapSW[i]) {
                g2D.drawImage(trapImage, xPositionTrapList[i], yPositionTrapList[i], 60, 60, null);
            }
        }
        //****************Finish drawing traps *****************************************************
        //************************Start drawing Blue and Red Game piece ********************************
        if (gameplayTurn%6==0 || gameplayTurn%6==1 || gameplayTurn%6==2) {
        g2D.drawImage(blueGamePiece, positionXBlue, positionYBlue, 55, 55, null);}
        else if (gameplayTurn%6 == 3 || gameplayTurn%6==4 || gameplayTurn%6==5) {
            g2D.drawImage(redGamePiece, positionXRed, positionYRed, 55, 55, null);}
        //************************Finish drawing Blue and Red Game piece*********************************
        //************************Start drawing the treasure finder board********************************
        g2D.setColor(new Color(0, 30, 30, 225));
        g2D.fillRect(625, 525, 500, 155);
        g2D.setColor(new Color(211, 211, 211));
        g2D.setStroke(new BasicStroke(4));
        g2D.drawRect(625, 525, 500, 155);
        g2D.setFont(new Font("Ink free", Font.BOLD, 15));
        g2D.setColor(new Color(255, 215, 0));
        g2D.drawString("Diamond Ring", 680, 570);
        g2D.drawString("Jeweled Sword", 680, 600);
        g2D.drawString("Golden Glass", 680, 630);
        g2D.drawString("Glass Cup", 680, 660);
        g2D.drawString("Wooden Bow", 920, 570);
        g2D.drawString("Steel Shield", 920, 600);
        g2D.drawString("Golden Key", 920, 630);
        g2D.drawString("Dragon Scroll", 920, 660);
        g2D.setFont(new Font("Ink free" , Font.BOLD,12));
        g2D.setColor(Color.WHITE);
        g2D.drawString("+8000 Point" , 680,582);
        g2D.drawString("+7000 Point" , 680 , 612);
        g2D.drawString("+6000 Point" , 680 , 642);
        g2D.drawString("+2000 Point" , 680 , 672);
        g2D.drawString("+1000 Point" , 920 , 582);
        g2D.drawString("+3000 Point" , 920,612);
        g2D.drawString("+5000 Point" , 920,642);
        g2D.drawString("+4000 Point" , 920,672);
        g2D.drawImage(diamondRingImage, 645, 550, 30, 30, null);
        g2D.drawImage(jeweledSwordImage, 635, 580, 40, 40, null);
        g2D.drawImage(goldenGlassImage, 645, 605, 30, 35, null);
        g2D.drawImage(glassCupImage, 645, 640, 30, 35, null);
        g2D.drawImage(woodenBowImage, 885, 550, 33, 33, null);
        g2D.drawImage(steelShieldImage, 885, 580, 30, 30, null);
        g2D.drawImage(goldenKeyImage, 885, 610, 30, 35, null);
        g2D.drawImage(dragonScrollImage, 865, 640, 50, 40, null);
        g2D.setColor(new Color(0, 142, 128));
        g2D.drawString(": Blue sold it !!!", 770, positionYBlueSoldItText1);
        g2D.drawString(": Blue sold it !!!", 780, positionYBlueSoldItText2);
        g2D.drawString(": Blue sold it !!!", 768, positionYBlueSoldItText3);
        g2D.drawString(": Blue sold it !!!", 747, positionYBlueSoldItText4);
        g2D.drawString(": Blue sold it !!!", 1000, positionYBlueSoldItText5);
        g2D.drawString(": Blue sold it !!!", 1000, positionYBlueSoldItText6);
        g2D.drawString(": Blue sold it !!!", 995, positionYBlueSoldItText7);
        g2D.drawString(": Blue sold it !!!", 1010, positionYBlueSoldItText8);
        g2D.setColor(new Color(200, 38, 40));
        g2D.drawString(": Red sold it !!!", 770, positionYRedSoldItText1);
        g2D.drawString(": Red sold it !!!", 780, positionYRedSoldItText2);
        g2D.drawString(": Red sold it !!!", 768, positionYRedSoldItText3);
        g2D.drawString(": Red sold it !!!", 747, positionYRedSoldItText4);
        g2D.drawString(": Red sold it !!!", 1000, positionYRedSoldItText5);
        g2D.drawString(": Red sold it !!!", 1000, positionYRedSoldItText6);
        g2D.drawString(": Red sold it !!!", 995, positionYRedSoldItText7);
        g2D.drawString(": Red sold it !!!", 1010, positionYRedSoldItText8);
        g2D.setColor(new Color(0x7FFF00));
        g2D.setFont(new Font("Ink free", Font.BOLD, 22));
        g2D.drawString("List of precious treasures:", 650, 545);
        //************************Finish drawing the treasure finder board********************************
        //************************Start drawing players' footprints***************************************
        g2D.drawImage(diceB1, positionXBlueFootPrint[0], positionYBlueFootPrint[0], 60, 60, null);
        g2D.drawImage(diceB1, positionXBlueFootPrint[1], positionYBlueFootPrint[1], 60, 60, null);
        g2D.drawImage(diceB1, positionXBlueFootPrint[2], positionYBlueFootPrint[2], 60, 60, null);
        g2D.drawImage(diceB1, positionXBlueFootPrint[3], positionYBlueFootPrint[3], 60, 60, null);
        g2D.drawImage(diceB1, positionXBlueFootPrint[4], positionYBlueFootPrint[4], 60, 60, null);
        g2D.drawImage(diceB1, positionXBlueFootPrint[5], positionYBlueFootPrint[5], 60, 60, null);
        g2D.drawImage(diceR1, positionXRedFootPrint[0], positionYRedFootPrint[0], 60, 60, null);
        g2D.drawImage(diceR1, positionXRedFootPrint[1], positionYRedFootPrint[1], 60, 60, null);
        g2D.drawImage(diceR1, positionXRedFootPrint[2], positionYRedFootPrint[2], 60, 60, null);
        g2D.drawImage(diceR1, positionXRedFootPrint[3], positionYRedFootPrint[3], 60, 60, null);
        g2D.drawImage(diceR1, positionXRedFootPrint[4], positionYRedFootPrint[4], 60, 60, null);
        g2D.drawImage(diceR1, positionXRedFootPrint[5], positionYRedFootPrint[5], 60, 60, null);
        //************************* Finish drawing players' footprints **************************************
        //************************* Start drawing the game timer *********************************************
        g2D.setColor(new Color(0, 0, 0));
        g2D.fillRect(1160, 525, 100, 40);
        g2D.setColor(new Color(0x046307));
        g2D.setStroke(new BasicStroke(2));
        g2D.drawRect(1160, 525, 100, 40);
        g2D.setFont(fontDigital23);
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        g2D.drawString(hours_string + ":" + minutes_string + ":" + seconds_string, 1165, 553);
        //************************ Finish drawing the game timer **********************************************
        //************************ Start drawing the game information board ***********************************
        g2D.setColor(new Color(255, 255, 255, 200));
        g2D.fillRect(773, 482, 353, 38);
        g2D.setFont(fontDigital18);
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(4));
        g2D.drawRect(773,482,353,38);
        g2D.drawString("Blue Player Starts the game!:)", xPositionInformationList[0], 510);
        g2D.drawString("Red Player Starts the game!:)", xPositionInformationList[1], 510);
        g2D.drawString("Blue Player sold a treasure!:)", xPositionInformationList[2], 510);
        g2D.drawString("Red Player sold a treasure!:)", xPositionInformationList[3], 510);
        g2D.drawString("Blue Player is trapped and Lost 100$:(", xPositionInformationList[4], 510);
        g2D.drawString("Red Player is trapped and Lost 100$:(", xPositionInformationList[5], 510);
        g2D.drawString("The blue player won the game!:)", xPositionInformationList[6], 510);
        g2D.drawString("The red player won the game!:)", xPositionInformationList[7], 510);
        g2D.drawString("the blue player won 100$!:)", xPositionInformationList[8], 510);
        g2D.drawString("the blue player won 200$!:)", xPositionInformationList[9], 510);
        g2D.drawString("the blue player won 300$!:)", xPositionInformationList[10], 510);
        g2D.drawString("the blue player won 400$!:)", xPositionInformationList[11], 510);
        g2D.drawString("the blue player won 500$!:)", xPositionInformationList[12], 510);
        g2D.drawString("the blue player won 600$!:)", xPositionInformationList[13], 510);
        g2D.drawString("the blue player won 700$!:)", xPositionInformationList[14], 510);
        g2D.drawString("the blue player won 800$!:)", xPositionInformationList[15], 510);
        g2D.drawString("the blue player won 900$!:)", xPositionInformationList[16], 510);
        g2D.drawString("the blue player won 1000$!:)", xPositionInformationList[17], 510);
        g2D.drawString("the blue player won 1100$!:)", xPositionInformationList[18], 510);
        g2D.drawString("the blue player won 1200$!:)", xPositionInformationList[19], 510);
        g2D.drawString("the blue player won 1300$!:)" , xPositionInformationList[20],510);
        g2D.drawString("the red player won 100$!:)", xPositionInformationList[21], 510);
        g2D.drawString("the red player won 200$!:)", xPositionInformationList[22], 510);
        g2D.drawString("the red player won 300$!:)", xPositionInformationList[23], 510);
        g2D.drawString("the red player won 400$!:)", xPositionInformationList[24], 510);
        g2D.drawString("the red player won 500$!:)", xPositionInformationList[25], 510);
        g2D.drawString("the red player won 600$!:)", xPositionInformationList[26], 510);
        g2D.drawString("the red player won 700$!:)", xPositionInformationList[27], 510);
        g2D.drawString("the red player won 800$!:)", xPositionInformationList[28], 510);
        g2D.drawString("the red player won 900$!:)", xPositionInformationList[29], 510);
        g2D.drawString("the red player won 1000$!:)", xPositionInformationList[30], 510);
        g2D.drawString("the red player won 1100$!:)", xPositionInformationList[31], 510);
        g2D.drawString("the red player won 1200$!:)", xPositionInformationList[32], 510);
        g2D.drawString("the red player won 1300$!:)",xPositionInformationList[33],510);
        //********************** Finish drawing the game information board **************************************
        //********************** Start drawing the Quest board **************************************************\
        g2D.setColor(new Color(0,0,0,225));
        g2D.fillRect(775,425,350,50);
        g2D.setStroke(new BasicStroke(4));
        g2D.setColor(Color.white);
        g2D.drawRect(775,425,350,50);
        g2D.setFont(fontDigital23);
        g2D.setColor(Color.WHITE);
        g2D.drawString("Quest:", 782,455);
        g2D.setColor(new Color(212,175,55));
        g2D.drawString("Diamond Ring" , xPositionQuest[0],455);
        g2D.drawString("Jeweled Sword" , xPositionQuest[1],455);
        g2D.drawString("Golden Glass" , xPositionQuest[2],455);
        g2D.drawString("Glass Cup" , xPositionQuest[3],455);
        g2D.drawString("Wooden Bow" , xPositionQuest[4],455);
        g2D.drawString("Steel Shield" , xPositionQuest[5],455);
        g2D.drawString("Golden Key" , xPositionQuest[6],455);
        g2D.drawString("Dragon Scroll" , xPositionQuest[7],455);
        //********************** Finish drawing the Quest board *************************************************
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redRollTheDiceButton) {
            new GameSound("rolling dice");
            positionXDiceB1 = INVISIBLE;
            positionXDiceB2 = INVISIBLE;
            positionXDiceB3 = INVISIBLE;
            positionXDiceB4 = INVISIBLE;
            positionXDiceB5 = INVISIBLE;
            positionXDiceB6 = INVISIBLE;
            redDiceNumber = randomNumMake.nextInt(6) + 1;

            switch (redDiceNumber) {
                case 1:
                    positionXDiceR1 = VISIBLE_DICE_RED;
                    break;
                case 2:
                    positionXDiceR2 = VISIBLE_DICE_RED;
                    break;
                case 3:
                    positionXDiceR3 = VISIBLE_DICE_RED;
                    break;
                case 4:
                    positionXDiceR4 = VISIBLE_DICE_RED;
                    break;
                case 5:
                    positionXDiceR5 = VISIBLE_DICE_RED;
                    break;
                case 6:
                    positionXDiceR6 = VISIBLE_DICE_RED;
                    break;
            }
            gameplayTurn++;
        } else if (e.getSource() == blueRollTheDiceButton) {
            new GameSound("rolling dice");
            positionXDiceR1 = INVISIBLE;
            positionXDiceR2 = INVISIBLE;
            positionXDiceR3 = INVISIBLE;
            positionXDiceR4 = INVISIBLE;
            positionXDiceR5 = INVISIBLE;
            positionXDiceR6 = INVISIBLE;
            blueDiceNumber = randomNumMake.nextInt(6) + 1;

            switch (blueDiceNumber) {
                case 1:
                    positionXDiceB1 = VISIBLE_DICE_BLUE;
                    break;
                case 2:
                    positionXDiceB2 = VISIBLE_DICE_BLUE;
                    break;
                case 3:
                    positionXDiceB3 = VISIBLE_DICE_BLUE;
                    break;
                case 4:
                    positionXDiceB4 = VISIBLE_DICE_BLUE;
                    break;
                case 5:
                    positionXDiceB5 = VISIBLE_DICE_BLUE;
                    break;
                case 6:
                    positionXDiceB6 = VISIBLE_DICE_BLUE;
                    break;
            }
            gameplayTurn++;
        }else if (e.getSource() == soundButton) {
            ImageIcon speakerIcon = new ImageIcon("images\\speaker.png");
            String[] optionsList = {"Sound On", "Sound Off"};
            while (true) {
                int answer = JOptionPane.showOptionDialog(null,
                        "Is the sound on or not?",
                        "Sound setting",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        speakerIcon,
                        optionsList,
                        0);
                if (answer == 0) {
                    GameSound.setSoundSW(true);
                    break;
                } else if (answer == 1) {
                    GameSound.setSoundSW(false);
                    break;
                }
            }
        }
        else if (e.getSource() == marketButton) {
            int answer = JOptionPane.showOptionDialog(null,
                    "Do you want to go to the market?",
                    "going to the Market",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    0);
            if (answer==0 && gameplayTurn%6==1 || gameplayTurn%6==2) new MarketFrame("blue");
            if (answer==0 && gameplayTurn%6==4 || gameplayTurn%6==5) new MarketFrame("red");
        } else if (e.getSource() == exitButton) {
            String[] responses = {"Exit without Save", "Save & Exit", "Cancel"};
            while (true) {
                int exitSW = JOptionPane.showOptionDialog(null,
                        "How do you want to Exit?",
                        "Exit",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        responses,
                        0);
                if (exitSW==0) {
                    timer.stop();
                    MenuFrame.getGamePlayFrame().dispose();
                    new MenuFrame();
                    break;
                }
                else if (exitSW==1) {
                    SaveGame.deleteFile();
                    try {
                        SaveGame.save();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    timer.stop();
                    MenuFrame.getGamePlayFrame().dispose();
                    new MenuFrame();
                    break;
                }
                else if (exitSW==2) break;
            }
        } else if (e.getSource() == blueUpButton) {
            if (positionXBlue == 10 && positionYBlue == 620) {
                positionXBlue = X_POSITION_FIRST_STEP;
                positionYBlue = Y_POSITION_FIRST_STEP;
            } else {
                positionYBlue -= 60;
                positionXBlueFootPrint[blueFootPrintSW] = positionXBlue;
                positionYBlueFootPrint[blueFootPrintSW] = positionYBlue + 60;
                blueFootPrintSW++;
            }
            if (positionYBlue < 10) {
                positionYBlue += 60;
                blueDiceNumber++;
                blueFootPrintSW--;
                positionXBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                positionYBlueFootPrint[blueFootPrintSW] = INVISIBLE;
            }
            for (int i = 0; i < wallNumberBlue; i++) {
                if (positionXBlue == xPositionWallListBlue[i] && positionYBlue == yPositionWallListBlue[i]) {
                    positionYBlue += 60;
                    blueDiceNumber++;
                    blueFootPrintSW--;
                    positionXBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    positionYBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    break;
                }
            }
            for (int i=0 ; i<6;i++) {
                if (positionXBlue == positionXBlueFootPrint[i] && positionYBlue == positionYBlueFootPrint[i]) {
                    positionYBlue += 60;
                    blueDiceNumber++;
                    blueFootPrintSW--;
                    positionXBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    positionYBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    new GameSound("error");
                    JOptionPane.showOptionDialog(null,
                            "You can't go back!",
                            "Unauthorized movement",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    break;
                }
            }
            if (positionXBlue==positionXRed && positionYBlue==positionYRed){
                if (bluePower>=redPower) {
                    float battleFormula_float = (float) (bluePower-redPower)/(bluePower+redPower)*redMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    blueMoney+=battleFormula_int;
                    redMoney-=battleFormula_int;
                    bluePower-=redPower;
                    redPower=0;
                    positionXRed=80;
                    positionYRed=620;
                    JOptionPane.showOptionDialog(
                            null,
                            "congratulations ! You fought with the red player and won the fight ! :)))",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                else {
                    float battleFormula_float = (float) (redPower-bluePower)/(bluePower+redPower)*blueMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    redMoney+=battleFormula_int;
                    blueMoney-=battleFormula_int;
                    redPower-=bluePower;
                    bluePower=0;
                    positionXBlue=10;
                    positionYBlue=620;
                    JOptionPane.showOptionDialog(
                            null,
                            "You fought the red player and lost the fight :(((",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
            }
            if (blueDiceNumber == 1) {
                gameplayTurn++;
                blueFootPrintSW = 0;
            }
            blueDiceNumber--;
        } else if (e.getSource() == blueDownButton) {
            if (positionXBlue == 10 && positionYBlue == 620) {
                blueDiceNumber++;
            } else {
                positionYBlue += 60;
                positionXBlueFootPrint[blueFootPrintSW] = positionXBlue;
                positionYBlueFootPrint[blueFootPrintSW] = positionYBlue - 60;
                blueFootPrintSW++;
            }
            if (positionYBlue > 550 && positionYBlue != 620) {
                positionYBlue -= 60;
                blueFootPrintSW--;
                positionXBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                positionYBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                blueDiceNumber++;
            }
            for (int i = 0; i < wallNumberBlue; i++) {
                if (positionXBlue == xPositionWallListBlue[i] && positionYBlue == yPositionWallListBlue[i]) {
                    positionYBlue -= 60;
                    blueDiceNumber++;
                    blueFootPrintSW--;
                    positionXBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    positionYBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    break;
                }
            }
            for (int i=0 ; i<6;i++) {
                if (positionXBlue == positionXBlueFootPrint[i] && positionYBlue == positionYBlueFootPrint[i]) {
                    positionYBlue -= 60;
                    blueDiceNumber++;
                    blueFootPrintSW--;
                    positionXBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    positionYBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    new GameSound("error");
                    JOptionPane.showOptionDialog(null,
                            "You can't go back!",
                            "Unauthorized movement",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    break;
                }
            }
            if (positionXBlue==positionXRed && positionYBlue==positionYRed){
                if (bluePower>=redPower) {
                    float battleFormula_float = (float) (bluePower-redPower)/(bluePower+redPower)*redMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    blueMoney+=battleFormula_int;
                    redMoney-=battleFormula_int;
                    positionXRed=80;
                    positionYRed=620;
                    bluePower-=redPower;
                    redPower=0;
                    JOptionPane.showOptionDialog(
                            null,
                            "congratulations ! You fought with the red player and won the fight ! :)))",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                else {
                    float battleFormula_float = (float) (redPower-bluePower)/(bluePower+redPower)*blueMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    redMoney+=battleFormula_int;
                    blueMoney-=battleFormula_int;
                    positionXBlue=10;
                    positionYBlue=620;
                    redPower-=bluePower;
                    bluePower=0;
                    JOptionPane.showOptionDialog(
                            null,
                            "You fought the red player and lost the fight :(((",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
            }
            if (blueDiceNumber == 1) {
                gameplayTurn++;
                blueFootPrintSW = 0;
            }
            blueDiceNumber--;
        } else if (e.getSource() == blueRightButton) {
            if (positionXBlue == 10 && positionYBlue == 620) {
                blueDiceNumber++;
            } else {
                positionXBlue += 60;
                positionXBlueFootPrint[blueFootPrintSW] = positionXBlue - 60;
                positionYBlueFootPrint[blueFootPrintSW] = positionYBlue;
                blueFootPrintSW++;
            }
            if (positionXBlue > 550) {
                positionXBlue -= 60;
                blueFootPrintSW--;
                positionXBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                positionYBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                blueDiceNumber++;
            }
            for (int i = 0; i < wallNumberBlue; i++) {
                if (positionXBlue == xPositionWallListBlue[i] && positionYBlue == yPositionWallListBlue[i]) {
                    positionXBlue -= 60;
                    blueFootPrintSW--;
                    positionXBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    positionYBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    blueDiceNumber++;
                    break;
                }
            }
            for (int i=0 ; i<6;i++) {
                if (positionXBlue == positionXBlueFootPrint[i] && positionYBlue == positionYBlueFootPrint[i]) {
                    positionXBlue -= 60;
                    blueDiceNumber++;
                    blueFootPrintSW--;
                    positionXBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    positionYBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    new GameSound("error");
                    JOptionPane.showOptionDialog(null,
                            "You can't go back!",
                            "Unauthorized movement",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    break;
                }
            }
            if (positionXBlue==positionXRed && positionYBlue==positionYRed){
                if (bluePower>=redPower) {
                    float battleFormula_float = (float) (bluePower-redPower)/(bluePower+redPower)*redMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    blueMoney+=battleFormula_int;
                    redMoney-=battleFormula_int;
                    positionXRed=80;
                    positionYRed=620;
                    bluePower-=redPower;
                    redPower=0;
                    JOptionPane.showOptionDialog(
                            null,
                            "congratulations ! You fought with the red player and won the fight ! :)))",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                else {
                    float battleFormula_float = (float) (redPower-bluePower)/(bluePower+redPower)*blueMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    redMoney+=battleFormula_int;
                    blueMoney-=battleFormula_int;
                    positionXBlue=10;
                    positionYBlue=620;
                    redPower-=bluePower;
                    bluePower=0;
                    JOptionPane.showOptionDialog(
                            null,
                            "You fought the red player and lost the fight :(((",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
            }
            if (blueDiceNumber == 1) {
                gameplayTurn++;
                blueFootPrintSW = 0;
            }
            blueDiceNumber--;
        } else if (e.getSource() == blueLeftButton) {
            if (positionXBlue == 10 && positionYBlue == 620) {
                blueDiceNumber++;
            } else {
                positionXBlue -= 60;
                positionXBlueFootPrint[blueFootPrintSW] = positionXBlue + 60;
                positionYBlueFootPrint[blueFootPrintSW] = positionYBlue;
                blueFootPrintSW++;
            }
            if (positionXBlue < 10) {
                positionXBlue += 60;
                blueFootPrintSW--;
                positionXBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                positionYBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                blueDiceNumber++;
            }
            for (int i = 0; i < wallNumberBlue; i++) {
                if (positionXBlue == xPositionWallListBlue[i] && positionYBlue == yPositionWallListBlue[i]) {
                    positionXBlue += 60;
                    blueFootPrintSW--;
                    positionXBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    positionYBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    blueDiceNumber++;
                    break;
                }
            }
            for (int i=0 ; i<6;i++) {
                if (positionXBlue == positionXBlueFootPrint[i] && positionYBlue == positionYBlueFootPrint[i]) {
                    positionXBlue += 60;
                    blueDiceNumber++;
                    blueFootPrintSW--;
                    positionXBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    positionYBlueFootPrint[blueFootPrintSW] = INVISIBLE;
                    new GameSound("error");
                    JOptionPane.showOptionDialog(null,
                            "You can't go back !",
                            "Unauthorized movement",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    break;
                }
            }
            if (positionXBlue==positionXRed && positionYBlue==positionYRed){
                if (bluePower>=redPower) {
                    float battleFormula_float = (float) (bluePower-redPower)/(bluePower+redPower)*redMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    blueMoney+=battleFormula_int;
                    redMoney-=battleFormula_int;
                    positionXRed=80;
                    positionYRed=620;
                    bluePower-=redPower;
                    redPower=0;
                    JOptionPane.showOptionDialog(
                            null,
                            "congratulations ! You fought with the red player and won the fight ! :)))",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                else {
                    float battleFormula_float = (float) (redPower-bluePower)/(bluePower+redPower)*blueMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    redMoney+=battleFormula_int;
                    blueMoney-=battleFormula_int;
                    positionXBlue=10;
                    positionYBlue=620;
                    redPower-=bluePower;
                    bluePower=0;
                    JOptionPane.showOptionDialog(
                            null,
                            "You fought the red player and lost the fight :(((",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
            }
            if (blueDiceNumber == 1) {
                gameplayTurn++;
                blueFootPrintSW = 0;
            }
            blueDiceNumber--;
        } else if (e.getSource() == blueSkipButton) {
            gameplayTurn++;
        } else if (e.getSource() == redUpButton) {
            if (positionXRed == 80 && positionYRed == 620) {
                positionXRed = X_POSITION_FIRST_STEP;
                positionYRed = Y_POSITION_FIRST_STEP;
            } else {
                positionYRed -= 60;
                positionXRedFootPrint[redFootPrintSW] = positionXRed;
                positionYRedFootPrint[redFootPrintSW] = positionYRed + 60;
                redFootPrintSW++;
            }
            if (positionYRed < 10) {
                positionYRed += 60;
                redFootPrintSW--;
                positionXRedFootPrint[redFootPrintSW] = INVISIBLE;
                positionYRedFootPrint[redFootPrintSW] = INVISIBLE;
                redDiceNumber++;
            }
            for (int i = 0; i < wallNumberRed; i++) {
                if (positionXRed == xPositionWallListRed[i] && positionYRed == yPositionWallListRed[i]) {
                    positionYRed += 60;
                    redDiceNumber++;
                    redFootPrintSW--;
                    positionXRedFootPrint[redFootPrintSW] = INVISIBLE;
                    positionYRedFootPrint[redFootPrintSW] = INVISIBLE;
                    break;
                }
            }
            for (int i=0 ; i<6;i++) {
                if (positionXRed == positionXRedFootPrint[i] && positionYRed == positionYRedFootPrint[i]) {
                    positionYRed += 60;
                    redDiceNumber++;
                    redFootPrintSW--;
                    positionXRedFootPrint[redFootPrintSW] = INVISIBLE;
                    positionYRedFootPrint[redFootPrintSW] = INVISIBLE;
                    new GameSound("error");
                    JOptionPane.showOptionDialog(null,
                            "You can't go back!",
                            "Unauthorized movement",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    break;
                }
            }
            if (positionXBlue==positionXRed && positionYBlue==positionYRed){
                if (redPower>=bluePower) {
                    float battleFormula_float = (float) (redPower-bluePower)/(bluePower+redPower)*blueMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    redMoney+=battleFormula_int;
                    blueMoney-=battleFormula_int;
                    positionXBlue=10;
                    positionYBlue=620;
                    redPower-=bluePower;
                    bluePower=0;
                    JOptionPane.showOptionDialog(
                            null,
                            "congratulations ! You fought with the blue player and won the fight ! :)))",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                else {
                    float battleFormula_float = (float) (bluePower-redPower)/(bluePower+redPower)*redMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    blueMoney+=battleFormula_int;
                    redMoney-=battleFormula_int;
                    positionXRed=80;
                    positionYRed=620;
                    bluePower-=redPower;
                    redPower=0;
                    JOptionPane.showOptionDialog(
                            null,
                            "You fought the blue player and lost the fight :(((",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
            }
            if (redDiceNumber == 1) {
                gameplayTurn++;
                redFootPrintSW = 0;
            }
            redDiceNumber--;
        } else if (e.getSource() == redDownButton) {
            if (positionXRed == 80 && positionYRed == 620) {
                redDiceNumber++;
            } else {
                positionYRed += 60;
                positionXRedFootPrint[redFootPrintSW] = positionXRed;
                positionYRedFootPrint[redFootPrintSW] = positionYRed - 60;
                redFootPrintSW++;
            }
            if (positionYRed > 550 && positionXRed != 80) {
                positionYRed -= 60;
                redFootPrintSW--;
                positionXRedFootPrint[redFootPrintSW] = INVISIBLE;
                positionYRedFootPrint[redFootPrintSW] = INVISIBLE;
                redDiceNumber++;
            }
            for (int i = 0; i < wallNumberRed; i++) {
                if (positionXRed == xPositionWallListRed[i] && positionYRed == yPositionWallListRed[i]) {
                    positionYRed -= 60;
                    redFootPrintSW--;
                    positionXRedFootPrint[redFootPrintSW] = INVISIBLE;
                    positionYRedFootPrint[redFootPrintSW] = INVISIBLE;
                    break;
                }
            }
            for (int i=0 ; i<6;i++) {
                if (positionXRed == positionXRedFootPrint[i] && positionYRed == positionYRedFootPrint[i]) {
                    positionYRed -= 60;
                    redDiceNumber++;
                    redFootPrintSW--;
                    positionXRedFootPrint[redFootPrintSW] = INVISIBLE;
                    positionYRedFootPrint[redFootPrintSW] = INVISIBLE;
                    new GameSound("error");
                    JOptionPane.showOptionDialog(null,
                            "You can't go back!",
                            "Unauthorized movement",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    break;
                }
            }
            if (positionXBlue==positionXRed && positionYBlue==positionYRed){
                if (redPower>=bluePower) {
                    float battleFormula_float = (float) (redPower-bluePower)/(bluePower+redPower)*blueMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    redMoney+=battleFormula_int;
                    blueMoney-=battleFormula_int;
                    positionXBlue=10;
                    positionYBlue=620;
                    redPower-=bluePower;
                    bluePower=0;
                    JOptionPane.showOptionDialog(
                            null,
                            "congratulations ! You fought with the blue player and won the fight ! :)))",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                else {
                    float battleFormula_float = (float) (bluePower-redPower)/(bluePower+redPower)*redMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    blueMoney+=battleFormula_int;
                    redMoney-=battleFormula_int;
                    positionXRed=80;
                    positionYRed=620;
                    bluePower-=redPower;
                    redPower=0;
                    JOptionPane.showOptionDialog(
                            null,
                            "You fought the blue player and lost the fight :(((",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
            }
            if (redDiceNumber == 1) {
                gameplayTurn++;
                redFootPrintSW = 0;
            }
            redDiceNumber--;
        } else if (e.getSource() == redRightButton) {
            if (positionXRed == 80 && positionYRed == 620) {
                redDiceNumber++;
            } else {
                positionXRed += 60;
                positionXRedFootPrint[redFootPrintSW] = positionXRed - 60;
                positionYRedFootPrint[redFootPrintSW] = positionYRed;
                redFootPrintSW++;
            }
            if (positionXRed > 550) {
                positionXRed -= 60;
                redFootPrintSW--;
                positionXRedFootPrint[redFootPrintSW] = INVISIBLE;
                positionYRedFootPrint[redFootPrintSW] = INVISIBLE;
                redDiceNumber++;
            }
            for (int i = 0; i < wallNumberRed; i++) {
                if (positionXRed == xPositionWallListRed[i] && positionYRed == yPositionWallListRed[i]) {
                    positionXRed -= 60;
                    redFootPrintSW--;
                    positionXRedFootPrint[redFootPrintSW] = INVISIBLE;
                    positionYRedFootPrint[redFootPrintSW] = INVISIBLE;
                    redDiceNumber++;
                    break;
                }
            }
            for (int i=0 ; i<6;i++) {
                if (positionXRed == positionXRedFootPrint[i] && positionYRed == positionYRedFootPrint[i]) {
                    positionXRed -= 60;
                    redDiceNumber++;
                    redFootPrintSW--;
                    positionXRedFootPrint[redFootPrintSW] = INVISIBLE;
                    positionYRedFootPrint[redFootPrintSW] = INVISIBLE;
                    new GameSound("error");
                    JOptionPane.showOptionDialog(null,
                            "You can't go back!",
                            "Unauthorized movement",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    break;
                }
            }
            if (positionXBlue==positionXRed && positionYBlue==positionYRed){
                if (redPower>=bluePower) {
                    float battleFormula_float = (float) (redPower-bluePower)/(bluePower+redPower)*blueMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    redMoney+=battleFormula_int;
                    blueMoney-=battleFormula_int;
                    positionXBlue=10;
                    positionYBlue=620;
                    redPower-=bluePower;
                    bluePower=0;
                    JOptionPane.showOptionDialog(
                            null,
                            "congratulations ! You fought with the blue player and won the fight ! :)))",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                else {
                    float battleFormula_float = (float) (bluePower-redPower)/(bluePower+redPower)*redMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    blueMoney+=battleFormula_int;
                    redMoney-=battleFormula_int;
                    positionXRed=80;
                    positionYRed=620;
                    bluePower-=redPower;
                    redPower=0;
                    JOptionPane.showOptionDialog(
                            null,
                            "You fought the blue player and lost the fight :(((",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
            }
            if (redDiceNumber == 1) {
                gameplayTurn++;
                redFootPrintSW = 0;
            }
            redDiceNumber--;
        } else if (e.getSource() == redLeftButton) {
            if (positionXRed == 80 && positionYRed == 620) {
                redDiceNumber++;
            } else {
                positionXRed -= 60;
                positionXRedFootPrint[redFootPrintSW] = positionXRed + 60;
                positionYRedFootPrint[redFootPrintSW] = positionYRed;
                redFootPrintSW++;
            }
            if (positionXRed < 10) {
                positionXRed += 60;
                redFootPrintSW--;
                positionXRedFootPrint[redFootPrintSW] = INVISIBLE;
                positionYRedFootPrint[redFootPrintSW] = INVISIBLE;
                redDiceNumber++;
            }
            for (int i = 0; i < wallNumberRed; i++) {
                if (positionXRed == xPositionWallListRed[i] && positionYRed == yPositionWallListRed[i]) {
                    positionXRed += 60;
                    redFootPrintSW--;
                    positionXRedFootPrint[redFootPrintSW] = INVISIBLE;
                    positionYRedFootPrint[redFootPrintSW] = INVISIBLE;
                    redDiceNumber++;
                    break;
                }
            }
            for (int i=0 ; i<6;i++) {
                if (positionXRed == positionXRedFootPrint[i] && positionYRed == positionYRedFootPrint[i]) {
                    positionXRed += 60;
                    redDiceNumber++;
                    redFootPrintSW--;
                    positionXRedFootPrint[redFootPrintSW] = INVISIBLE;
                    positionYRedFootPrint[redFootPrintSW] = INVISIBLE;
                    new GameSound("error");
                    JOptionPane.showOptionDialog(null,
                            "You can't go back!",
                            "Unauthorized movement",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                    break;
                }
            }
            if (positionXBlue==positionXRed && positionYBlue==positionYRed){
                if (redPower>=bluePower) {
                    float battleFormula_float = (float) (redPower-bluePower)/(bluePower+redPower)*blueMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    redMoney+=battleFormula_int;
                    blueMoney-=battleFormula_int;
                    positionXBlue=10;
                    positionYBlue=620;
                    redPower-=bluePower;
                    bluePower=0;
                    JOptionPane.showOptionDialog(
                            null,
                            "congratulations ! You fought with the blue player and won the fight ! :)))",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
                else {
                    float battleFormula_float = (float) (bluePower-redPower)/(bluePower+redPower)*redMoney;
                    int battleFormula_int = (int) battleFormula_float ;
                    blueMoney+=battleFormula_int;
                    redMoney-=battleFormula_int;
                    positionXRed=80;
                    positionYRed=620;
                    bluePower-=redPower;
                    redPower=0;
                    JOptionPane.showOptionDialog(
                            null,
                            "You fought the blue player and lost the fight :(((",
                            "Fight Time !!!",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            null,
                            0);
                }
            }
            if (redDiceNumber == 1) {
                gameplayTurn++;
                redFootPrintSW = 0;
            }
            redDiceNumber--;
        } else if (e.getSource() == redSkipButton) {
            gameplayTurn++;
        }
        if (gameFinishSW) {
            gameplayTurn=-1000;
            if (blueTreasureNo>redTreasureNo) new VictoryFrame("Blue",0);
            else if (redTreasureNo>blueTreasureNo) new VictoryFrame("Red" , 0);
            else if (redTreasureNo==blueTreasureNo) {
                if (blueScore>redScore) new VictoryFrame("Blue" , 1);
                else if (redScore>blueScore) new VictoryFrame("Red" , 1);
                else if (redScore==blueScore) {
                    if (positionYBlueSoldItText1==570) 
                        new VictoryFrame("Blue" , 2);// "positionYBlueSoldItText1" being equal to 570 means that it is the blue player who sold the most valuable treasure in the game (diamond ring)
                    else if (positionYRedSoldItText1==570)
                        new VictoryFrame("Red" , 2); // "positionYRedSoldItText1" being equal to 570 means that it is the red player who sold the most valuable treasure in the game (diamond ring)
                }
            }
            gameFinishSW=false;
        }
        repaint();
    }
}
