package com.company.java;

import java.io.*;

public abstract class SaveGame {

    public static void save() throws IOException {
        File file = new File("SavedGame.bin");
        file.createNewFile();
        DataOutputStream output
                = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        output.writeInt(GamePlayPanel.getBlueDiceNumber());
        output.writeInt(GamePlayPanel.getRedDiceNumber());
        output.writeInt(GamePlayPanel.getGameplayTurn());
        output.writeInt(GamePlayPanel.getSeconds());
        output.writeInt(GamePlayPanel.getMinutes());
        output.writeInt(GamePlayPanel.getHours());
        output.writeInt(GamePlayPanel.getBlueScore());
        output.writeInt(GamePlayPanel.getBlueMoney());
        output.writeInt(GamePlayPanel.getBluePower());
        output.writeInt(GamePlayPanel.getBlueTreasureNo());
        output.writeInt(GamePlayPanel.getRedScore());
        output.writeInt(GamePlayPanel.getRedMoney());
        output.writeInt(GamePlayPanel.getRedPower());
        output.writeInt(GamePlayPanel.getRedTreasureNo());
        output.writeInt(GamePlayPanel.getQuestSW());
        for (int i=0;i<8;i++){
            output.writeBoolean(GamePlayPanel.getUsedQuestSW(i));
        }
        output.writeBoolean(GamePlayPanel.getUsedDiamondRingSW());
        output.writeBoolean(GamePlayPanel.getUsedJeweledSwordSW());
        output.writeBoolean(GamePlayPanel.getUsedGoldenGlassSW());
        output.writeBoolean(GamePlayPanel.getUsedGlassCupSW());
        output.writeBoolean(GamePlayPanel.getUsedWoodenBowSW());
        output.writeBoolean(GamePlayPanel.getUsedSteelShieldSW());
        output.writeBoolean(GamePlayPanel.getUsedGoldenKeySW());
        output.writeBoolean(GamePlayPanel.getUsedDragonScrollSW());
        output.writeInt(GamePlayPanel.getDiamondRingOwner());
        output.writeInt(GamePlayPanel.getJeweledSwordOwner());
        output.writeInt(GamePlayPanel.getGoldenGlassOwner());
        output.writeInt(GamePlayPanel.getGlassCupOwner());
        output.writeInt(GamePlayPanel.getWoodenBowOwner());
        output.writeInt(GamePlayPanel.getSteelShieldOwner());
        output.writeInt(GamePlayPanel.getGoldenKeyOwner());
        output.writeInt(GamePlayPanel.getDragonScrollOwner());
        output.writeInt(GamePlayPanel.getPositionYBlueSoldItText1());
        output.writeInt(GamePlayPanel.getPositionYBlueSoldItText2());
        output.writeInt(GamePlayPanel.getPositionYBlueSoldItText3());
        output.writeInt(GamePlayPanel.getPositionYBlueSoldItText4());
        output.writeInt(GamePlayPanel.getPositionYBlueSoldItText5());
        output.writeInt(GamePlayPanel.getPositionYBlueSoldItText6());
        output.writeInt(GamePlayPanel.getPositionYBlueSoldItText7());
        output.writeInt(GamePlayPanel.getPositionYBlueSoldItText8());
        output.writeInt(GamePlayPanel.getPositionYRedSoldItText1());
        output.writeInt(GamePlayPanel.getPositionYRedSoldItText2());
        output.writeInt(GamePlayPanel.getPositionYRedSoldItText3());
        output.writeInt(GamePlayPanel.getPositionYRedSoldItText4());
        output.writeInt(GamePlayPanel.getPositionYRedSoldItText5());
        output.writeInt(GamePlayPanel.getPositionYRedSoldItText6());
        output.writeInt(GamePlayPanel.getPositionYRedSoldItText7());
        output.writeInt(GamePlayPanel.getPositionYRedSoldItText8());
        output.writeInt(GamePlayPanel.getPositionXBlue());
        output.writeInt(GamePlayPanel.getPositionYBlue());
        output.writeInt(GamePlayPanel.getPositionXRed());
        output.writeInt(GamePlayPanel.getPositionYRed());
        output.writeInt(GamePlayPanel.getWallNumberBlue());
        for (int i=0 ; i<GamePlayPanel.getWallNumberBlue();i++) {
            output.writeInt(GamePlayPanel.getXPositionWallListBlue(i));
        }
        for (int i=0;i<GamePlayPanel.getWallNumberBlue();i++) {
            output.writeInt(GamePlayPanel.getYPositionWallListBlue(i));
        }
        output.writeInt(GamePlayPanel.getWallNumberRed());
        for (int i=0 ; i<GamePlayPanel.getWallNumberRed();i++) {
            output.writeInt(GamePlayPanel.getXPositionWallListRed(i));
        }
        for (int i=0; i<GamePlayPanel.getWallNumberRed();i++) {
            output.writeInt(GamePlayPanel.getYPositionWallListRed(i));
        }
        output.writeInt(GamePlayPanel.getTrapNumber());
        for (int i=0 ; i<GamePlayPanel.getTrapNumber();i++) {
            output.writeInt(GamePlayPanel.getXPositionTrapList(i));
        }
        for (int i=0 ; i<GamePlayPanel.getTrapNumber();i++) {
            output.writeInt(GamePlayPanel.getYPositionTrapList(i));
        }
        for (int i=0 ; i<GamePlayPanel.getTrapNumber();i++) {
            output.writeBoolean(GamePlayPanel.getShowTrapSW(i));
        }
        for (int i=0 ; i<GamePlayPanel.getTrapNumber();i++) {
            output.writeBoolean(GamePlayPanel.getUsedTrapSW(i));
        }
        for (int i=0 ; i<GamePlayPanel.getMarketNumber();i++) {
            output.writeInt(GamePlayPanel.getXPositionMarketList(i));
        }
        for (int i=0 ; i<GamePlayPanel.getMarketNumber();i++) {
            output.writeInt(GamePlayPanel.getYPositionMarketList(i));
        }
        for (int i=0 ; i<GamePlayPanel.getLootNumber();i++) {
            output.writeInt(GamePlayPanel.getXPositionLootList(i));
        }
        for (int i=0 ; i<GamePlayPanel.getLootNumber();i++) {
            output.writeInt(GamePlayPanel.getYPositionLootList(i));
        }
        for (int i=0 ; i<GamePlayPanel.getLootNumber();i++) {
            output.writeBoolean(GamePlayPanel.getShowLootSW(i));
        }
        for (int i=0 ; i<GamePlayPanel.getLootNumber();i++) {
            output.writeBoolean(GamePlayPanel.getUsedLootSW(i));
        }
        output.writeInt(GamePlayPanel.getXPositionDiamondRing());
        output.writeInt(GamePlayPanel.getYPositionDiamondRing());
        output.writeInt(GamePlayPanel.getXPositionJeweledSword());
        output.writeInt(GamePlayPanel.getYPositionJeweledSword());
        output.writeInt(GamePlayPanel.getXPositionGoldenGlass());
        output.writeInt(GamePlayPanel.getYPositionGoldenGlass());
        output.writeInt(GamePlayPanel.getXPositionGlassCup());
        output.writeInt(GamePlayPanel.getYPositionGlassCup());
        output.writeInt(GamePlayPanel.getXPositionWoodenBow());
        output.writeInt(GamePlayPanel.getYPositionWoodenBow());
        output.writeInt(GamePlayPanel.getXPositionSteelShield());
        output.writeInt(GamePlayPanel.getYPositionSteelShield());
        output.writeInt(GamePlayPanel.getXPositionGoldenKey());
        output.writeInt(GamePlayPanel.getYPositionGoldenKey());
        output.writeInt(GamePlayPanel.getXPositionDragonScroll());
        output.writeInt(GamePlayPanel.getYPositionDragonScroll());
        output.writeInt(GamePlayPanel.getPositionXDiceB1());
        output.writeInt(GamePlayPanel.getPositionXDiceB2());
        output.writeInt(GamePlayPanel.getPositionXDiceB3());
        output.writeInt(GamePlayPanel.getPositionXDiceB4());
        output.writeInt(GamePlayPanel.getPositionXDiceB5());
        output.writeInt(GamePlayPanel.getPositionXDiceB6());
        output.writeInt(GamePlayPanel.getPositionXDiceR1());
        output.writeInt(GamePlayPanel.getPositionXDiceR2());
        output.writeInt(GamePlayPanel.getPositionXDiceR3());
        output.writeInt(GamePlayPanel.getPositionXDiceR4());
        output.writeInt(GamePlayPanel.getPositionXDiceR5());
        output.writeInt(GamePlayPanel.getPositionXDiceR6());
        output.writeInt(GamePlayPanel.getInformationTextSW());
        for (int i=0;i<6;i++){
            output.writeInt(GamePlayPanel.getPositionXBlueFootPrint(i));
        }
        for (int i=0;i<6;i++){
            output.writeInt(GamePlayPanel.getPositionYBlueFootPrint(i));
        }
        for (int i=0;i<6;i++){
            output.writeInt(GamePlayPanel.getPositionXRedFootPrint(i));
        }
        for (int i=0;i<6;i++){
            output.writeInt(GamePlayPanel.getPositionYRedFootPrint(i));
        }
        output.close();
    }

    public static void load() throws IOException {
        File file = new File("SavedGame.bin");
        file.createNewFile();
        DataInputStream input
                = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        GamePlayPanel.setBlueDiceNumber(input.readInt());
        GamePlayPanel.setRedDiceNumber(input.readInt());
        GamePlayPanel.setGameplayTurn(input.readInt());
        GamePlayPanel.setSeconds(input.readInt());
        GamePlayPanel.setMinutes(input.readInt());
        GamePlayPanel.setHours(input.readInt());
        GamePlayPanel.setBlueScore(input.readInt());
        GamePlayPanel.setBlueMoney(input.readInt());
        GamePlayPanel.setBluePower(input.readInt());
        GamePlayPanel.setBlueTreasureNo(input.readInt());
        GamePlayPanel.setRedScore(input.readInt());
        GamePlayPanel.setRedMoney(input.readInt());
        GamePlayPanel.setRedPower(input.readInt());
        GamePlayPanel.setRedTreasureNo(input.readInt());
        GamePlayPanel.setQuestSW(input.readInt());
        for (int i=0;i<8;i++) {
            GamePlayPanel.setUsedQuestSW(i,input.readBoolean());
        }
        GamePlayPanel.setUsedDiamondRingSW(input.readBoolean());
        GamePlayPanel.setUsedJeweledSwordSW(input.readBoolean());
        GamePlayPanel.setUsedGoldenGlassSW(input.readBoolean());
        GamePlayPanel.setUsedGlassCupSW(input.readBoolean());
        GamePlayPanel.setUsedWoodenBowSW(input.readBoolean());
        GamePlayPanel.setUsedSteelShieldSW(input.readBoolean());
        GamePlayPanel.setUsedGoldenKeySW(input.readBoolean());
        GamePlayPanel.setUsedDragonScrollSW(input.readBoolean());
        GamePlayPanel.setDiamondRingOwner(input.readInt());
        GamePlayPanel.setJeweledSwordOwner(input.readInt());
        GamePlayPanel.setGoldenGlassOwner(input.readInt());
        GamePlayPanel.setGlassCupOwner(input.readInt());
        GamePlayPanel.setWoodenBowOwner(input.readInt());
        GamePlayPanel.setSteelShieldOwner(input.readInt());
        GamePlayPanel.setGoldenKeyOwner(input.readInt());
        GamePlayPanel.setDragonScrollOwner(input.readInt());
        GamePlayPanel.setPositionYBlueSoldItText1(input.readInt());
        GamePlayPanel.setPositionYBlueSoldItText2(input.readInt());
        GamePlayPanel.setPositionYBlueSoldItText3(input.readInt());
        GamePlayPanel.setPositionYBlueSoldItText4(input.readInt());
        GamePlayPanel.setPositionYBlueSoldItText5(input.readInt());
        GamePlayPanel.setPositionYBlueSoldItText6(input.readInt());
        GamePlayPanel.setPositionYBlueSoldItText7(input.readInt());
        GamePlayPanel.setPositionYBlueSoldItText8(input.readInt());
        GamePlayPanel.setPositionYRedSoldItText1(input.readInt());
        GamePlayPanel.setPositionYRedSoldItText2(input.readInt());
        GamePlayPanel.setPositionYRedSoldItText3(input.readInt());
        GamePlayPanel.setPositionYRedSoldItText4(input.readInt());
        GamePlayPanel.setPositionYRedSoldItText5(input.readInt());
        GamePlayPanel.setPositionYRedSoldItText6(input.readInt());
        GamePlayPanel.setPositionYRedSoldItText7(input.readInt());
        GamePlayPanel.setPositionYRedSoldItText8(input.readInt());
        GamePlayPanel.setPositionXBlue(input.readInt());
        GamePlayPanel.setPositionYBlue(input.readInt());
        GamePlayPanel.setPositionXRed(input.readInt());
        GamePlayPanel.setPositionYRed(input.readInt());
        GamePlayPanel.setWallNumberBlue(input.readInt());
        for (int i=0;i<GamePlayPanel.getWallNumberBlue();i++) {
            GamePlayPanel.setXPositionWallListBlue(i,input.readInt());
        }
        for (int i=0;i<GamePlayPanel.getWallNumberBlue();i++) {
            GamePlayPanel.setYPositionWallListBlue(i,input.readInt());
        }
        GamePlayPanel.setWallNumberRed(input.readInt());
        for (int i=0;i<GamePlayPanel.getWallNumberRed();i++) {
            GamePlayPanel.setXPositionWallListRed(i,input.readInt());
        }
        for (int i=0;i<GamePlayPanel.getWallNumberRed();i++) {
            GamePlayPanel.setYPositionWallListRed(i,input.readInt());
        }
        GamePlayPanel.setTrapNumber(input.readInt());
        for (int i=0 ; i<GamePlayPanel.getTrapNumber();i++) {
            GamePlayPanel.setXPositionTrapList(i,input.readInt());
        }
        for (int i=0;i<GamePlayPanel.getTrapNumber();i++) {
            GamePlayPanel.setYPositionTrapList(i,input.readInt());
        }
        for (int i=0;i<GamePlayPanel.getTrapNumber();i++) {
            GamePlayPanel.setShowTrapSW(i,input.readBoolean());
        }
        for (int i=0;i<GamePlayPanel.getTrapNumber();i++) {
            GamePlayPanel.setUsedTrapSW(i,input.readBoolean());
        }
        for (int i=0;i<GamePlayPanel.getMarketNumber();i++) {
            GamePlayPanel.setXPositionMarketList(i,input.readInt());
        }
        for (int i=0;i<GamePlayPanel.getMarketNumber();i++) {
            GamePlayPanel.setYPositionMarketList(i,input.readInt());
        }
        for (int i=0;i<GamePlayPanel.getLootNumber();i++) {
            GamePlayPanel.setXPositionLootList(i,input.readInt());
        }
        for (int i=0;i<GamePlayPanel.getLootNumber();i++) {
            GamePlayPanel.setYPositionLootList(i,input.readInt());
        }
        for (int i=0;i<GamePlayPanel.getLootNumber();i++) {
            GamePlayPanel.setShowLootSW(i,input.readBoolean());
        }
        for (int i=0;i<GamePlayPanel.getLootNumber();i++) {
            GamePlayPanel.setUsedLootSW(i,input.readBoolean());
        }
        GamePlayPanel.setXPositionDiamondRing(input.readInt());
        GamePlayPanel.setYPositionDiamondRing(input.readInt());
        GamePlayPanel.setXPositionJeweledSword(input.readInt());
        GamePlayPanel.setYPositionJeweledSword(input.readInt());
        GamePlayPanel.setXPositionGoldenGlass(input.readInt());
        GamePlayPanel.setYPositionGoldenGlass(input.readInt());
        GamePlayPanel.setXPositionGlassCup(input.readInt());
        GamePlayPanel.setYPositionGlassCup(input.readInt());
        GamePlayPanel.setXPositionWoodenBow(input.readInt());
        GamePlayPanel.setYPositionWoodenBow(input.readInt());
        GamePlayPanel.setXPositionSteelShield(input.readInt());
        GamePlayPanel.setYPositionSteelShield(input.readInt());
        GamePlayPanel.setXPositionGoldenKey(input.readInt());
        GamePlayPanel.setYPositionGoldenKey(input.readInt());
        GamePlayPanel.setXPositionDragonScroll(input.readInt());
        GamePlayPanel.setYPositionDragonScroll(input.readInt());
        GamePlayPanel.setPositionXDiceB1(input.readInt());
        GamePlayPanel.setPositionXDiceB2(input.readInt());
        GamePlayPanel.setPositionXDiceB3(input.readInt());
        GamePlayPanel.setPositionXDiceB4(input.readInt());
        GamePlayPanel.setPositionXDiceB5(input.readInt());
        GamePlayPanel.setPositionXDiceB6(input.readInt());
        GamePlayPanel.setPositionXDiceR1(input.readInt());
        GamePlayPanel.setPositionXDiceR2(input.readInt());
        GamePlayPanel.setPositionXDiceR3(input.readInt());
        GamePlayPanel.setPositionXDiceR4(input.readInt());
        GamePlayPanel.setPositionXDiceR5(input.readInt());
        GamePlayPanel.setPositionXDiceR6(input.readInt());
        GamePlayPanel.setInformationTextSW(input.readInt());
        for (int i=0;i<6;i++) {
            GamePlayPanel.setPositionXBlueFootPrint(input.readInt(),i);
        }
        for (int i=0;i<6;i++) {
            GamePlayPanel.setPositionYBlueFootPrint(input.readInt(),i);
        }
        for (int i=0;i<6;i++) {
            GamePlayPanel.setPositionXRedFootPrint(input.readInt(),i);
        }
        for (int i=0;i<6;i++) {
            GamePlayPanel.setPositionYRedFootPrint(input.readInt(),i);
        }
        input.close();
        file.delete();
    }

    public static void deleteFile () {
        File file = new File("SavedGame.bin");
        file.delete();
    }
    
    public static boolean existFile () {
        File file = new File("SavedGame.bin");
        return file.exists();
    }
}
