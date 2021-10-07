package com.layhill.bowlinggame;

public class Game {

    private final int maximumRolls = 21;
    private final int maximumFrame = 10;

    private int currentRoll = 0;
    private int[] rolls = new int[maximumRolls];

    public int score() {
        int score = 0;
        int spareFrame = 0;
        for (int currentFrame = 0; currentFrame < maximumFrame; currentFrame++) {
            if (isSpare(spareFrame)) {
                score += 10 + rolls[spareFrame + 2];
            } else {
                score += rolls[spareFrame] + rolls[spareFrame + 1];
            }
            spareFrame += 2;
        }
        return score;
    }

    public void roll(int pinsKnockedDown) {
        rolls[currentRoll++] = pinsKnockedDown;
    }

    private boolean isSpare(int currentFrame) {
        return rolls[currentFrame] + rolls[currentFrame + 1] == 10;
    }
}
