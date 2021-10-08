package com.layhill.bowlinggame;

public class Game {

    private final int maximumRolls = 21;
    private final int maximumFrame = 10;
    private final int maxPins = 10;

    private int currentRoll = 0;
    private int[] rolls = new int[maximumRolls];

    public int score() {
        int score = 0;
        for (int currentFrame = 0; currentFrame < maximumFrame; currentFrame += 2) {
            if (isSpare(currentFrame)) {
                score += 10 + rolls[currentFrame + 2];
            } else if (isStrike(currentFrame)) {
                score += 10 + rolls[currentFrame + 2] + rolls[currentFrame + 3];
            } else {
                score += rolls[currentFrame] + rolls[currentFrame + 1];
            }
            currentFrame += 2;
        }
        return score;
    }

    public void roll(int pinsKnockedDown) {
        rolls[currentRoll++] = pinsKnockedDown;
        if (pinsKnockedDown == maxPins && currentRoll % 2 != 0) {
            rolls[currentRoll++] = pinsKnockedDown;
        }

    }

    private boolean isSpare(int currentFrame) {
        return rolls[currentFrame] + rolls[currentFrame + 1] == 10;
    }

    private boolean isStrike(int currentFrame) {
        return rolls[currentFrame] == 10 || rolls[currentFrame + 1] == 10;
    }
}
