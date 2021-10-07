package com.layhill.bowlinggame;

public class Game {

    private final int maximumRolls = 21;
    private final int maximumFrame = 10;

    private int currentRoll = 0;
    private int[] rolls = new int[maximumRolls];

    public int score() {
        int score = 0;
        if (currentRoll % 2 == 0) {
            for (int currentFrame = 0; currentFrame < maximumFrame; currentFrame++) {
                for (int roll = 0; roll < 2; roll++) {
                    if (!isSpare(currentFrame)) {
                        score += rolls[(currentFrame * 2) + roll];
                    }
                }
            }
        }
        return score;
    }

    public void roll(int pinsKnockedDown) {
        rolls[currentRoll++] = pinsKnockedDown;
    }

    private boolean isSpare(int currentFrame) {
        return rolls[(currentFrame * 2)] + rolls[(currentFrame * 2 + 1)] == 10;
    }
}
