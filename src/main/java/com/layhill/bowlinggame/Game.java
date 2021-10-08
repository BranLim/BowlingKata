package com.layhill.bowlinggame;

public class Game {

    private final int maximumRolls = 21;
    private final int maximumFrame = 10;
    private final int maxPins = 10;

    private int currentRoll = 0;
    private int[] rolls = new int[maximumRolls];

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int currentFrame = 0; currentFrame < maximumFrame; currentFrame++) {
            if (isSpare(frameIndex)) {
                score += 10 + rolls[frameIndex + 2];
                frameIndex += 2;
            } else if (isStrike(frameIndex)) {
                score += 10 + rolls[frameIndex + 2] + rolls[frameIndex + 3];
                frameIndex += 2;
            } else {
                score += rolls[frameIndex] + rolls[frameIndex + 1];
                frameIndex += 2;
            }
        }
        return score;
    }

    public void roll(int pinsKnockedDown) {
        if (currentRoll == 20 && (!isStrike(currentRoll - 2) || !isSpare(currentRoll-2))) {
            throw new GameFoulException();
        }
        rolls[currentRoll++] = pinsKnockedDown;
        if (pinsKnockedDown == maxPins && currentRoll % 2 != 0) {
            rolls[currentRoll++] = pinsKnockedDown;
        }
    }

    private boolean isSpare(int currentFrame) {
        return rolls[currentFrame] + rolls[currentFrame + 1] == 10;
    }

    private boolean isStrike(int currentFrame) {
        return rolls[currentFrame] == 10;
    }
}
