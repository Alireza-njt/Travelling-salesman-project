
package com.company.java;


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameSound {

    private String name;
    private static boolean soundSW = false;

    public static void setSoundSW(boolean soundSW) {
        GameSound.soundSW = soundSW;
    }

    File chineseMusicFile = new File("sound effects\\chinese music.mp3");
    File rollingDiceSoundEffectFile = new File("sound effects\\rolling dice sound effect.mp3");
    File startTheGameFile = new File("sound effects\\start the game.mp3");
    File successFile = new File("sound effects\\success.mp3");
    File trapFile = new File("sound effects\\trap sound.mp3");
    File victorySongFile = new File("sound effects\\victory song.mp3");
    File errorFile = new File("sound effects\\Error.mp3");

    private Player playerChineseMusic;
    private Player playerRollingDice;
    private Player playerStartTheGame;
    private Player playerSuccess;
    private Player playerTrap;
    private Player playerVictory;
    private Player playerError;

    public GameSound(String name) {

        this.name = name;
        if (soundSW) {
            if (name.equals("chinese music")) {
                try {
                    FileInputStream fileInputStreamChineseMusic = new FileInputStream(chineseMusicFile);
                    BufferedInputStream bufferedInputStreamChineseMusic = new BufferedInputStream(fileInputStreamChineseMusic);
                    try {
                        playerChineseMusic = new Player(bufferedInputStreamChineseMusic);
                        playerChineseMusic.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (name.equals("start the game")) {
                try {
                    FileInputStream fileInputStreamStartTheGame = new FileInputStream(startTheGameFile);
                    BufferedInputStream bufferedInputStreamStartTheGame = new BufferedInputStream(fileInputStreamStartTheGame);
                    try {
                        playerStartTheGame = new Player(bufferedInputStreamStartTheGame);
                        playerStartTheGame.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (name.equals("rolling dice")) {
                try {
                    FileInputStream fileInputStreamRollingDiceSoundEffect = new FileInputStream(rollingDiceSoundEffectFile);
                    BufferedInputStream bufferedInputStreamRollingDiceSoundEffect = new BufferedInputStream(fileInputStreamRollingDiceSoundEffect);
                    try {
                        playerRollingDice = new Player(bufferedInputStreamRollingDiceSoundEffect);
                        playerRollingDice.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (name.equals("success")) {
                try {
                    FileInputStream fileInputStreamSuccess = new FileInputStream(successFile);
                    BufferedInputStream bufferedInputStreamSuccess = new BufferedInputStream(fileInputStreamSuccess);
                    try {
                        playerSuccess = new Player(bufferedInputStreamSuccess);
                        playerSuccess.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (name.equals("victory")) {
                try {
                    FileInputStream fileInputStreamVictorySong = new FileInputStream(victorySongFile);
                    BufferedInputStream bufferedInputStreamVictorySong = new BufferedInputStream(fileInputStreamVictorySong);
                    try {
                        playerVictory = new Player(bufferedInputStreamVictorySong);
                        playerVictory.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (name.equals("trap")) {
                try {
                    FileInputStream fileInputStreamTrap = new FileInputStream(trapFile);
                    BufferedInputStream bufferedInputStreamTrap = new BufferedInputStream(fileInputStreamTrap);
                    try {
                        playerTrap = new Player(bufferedInputStreamTrap);
                        playerTrap.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (name.equals("error")) {
                try {
                    FileInputStream fileInputStreamError = new FileInputStream(errorFile);
                    BufferedInputStream bufferedInputStreamError = new BufferedInputStream(fileInputStreamError);
                    try {
                        playerError = new Player(bufferedInputStreamError);
                        playerError.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



