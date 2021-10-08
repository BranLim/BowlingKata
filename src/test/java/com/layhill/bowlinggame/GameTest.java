package com.layhill.bowlinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void givenFirstFrame_whenBallIsInGutter_thenTotalScoreShouldBe0() {
        game.roll(0);
        int score = game.score();
        assertEquals(0, score);
    }

    @Test
    void givenFirstFrameAndFirstRoll_whenBallHits1Pin_thenTotalScoreShouldBe1() {
        game.roll(1);
        int score = game.score();
        assertEquals(1, score);
    }

    @Test
    void givenFirstFrame_whenBallHits1PinsOnFirstRollAnd1PinsOnSecondRoll_thenTotalScoreShouldBe2() {
        game.roll(1);
        game.roll(1);
        int score = game.score();
        assertEquals(2, score);
    }

    @Test
    void givenFirstFrame_whenRollSpare_thenTotalScoreShouldBe10() {
        rollSpare();
        int score = game.score();
        assertEquals(10, score);
    }

    @Test
    void givenFirstFrameIsSpare_whenBallHits2PinsOnFirstRollInSecondFrame_thenTotalScoreShouldBe14() {
        rollSpare();
        game.roll(2);
        int score = game.score();
        assertEquals(14, score);
    }


    @Test
    void givenFirstRowInIsGutterAndSecondRowIsSpareInFirstFrame_whenBallHits2PinsOnFirstRollAnd2PinsOnSecondRollInSecondFrame_thenTotalScoreShouldbe14() {
        game.roll(0);
        game.roll(10);
        game.roll(2);
        game.roll(2);
        int score = game.score();
        assertEquals(16, score);
    }

    @Test
    void givenFirstFrameIsStrikeOnFirstRow_whenBallHits2PinsOnFirstRollAnd2PinsOnSecondRollInSecondFrame_thenTotalScoreShouldBe14() {
        rollStrike();
        game.roll(2);
        game.roll(2);
        int score = game.score();
        assertEquals(18, score);
    }

    @Test
    void givenFirstFrameIsStrikeOnFirstRow_whenBallHits3PinsOnFirstRollAnd6PinsOnSecondRollInSecondFrame_thenTotalScoreShouldBe28() {
        rollStrike();
        game.roll(3);
        game.roll(6);
        int score = game.score();
        assertEquals(28, score);
    }

    @Test
    void givenGutterBallInFirstNineFrames_whenBallHitsNoPinsInFirstTwoRolls_thenTotalScoreShouldBe0() {
        rollMultiples(18, 0);
        game.roll(0);
        game.roll(0);
        int score = game.score();
        assertEquals(0, score);
    }

    @Test
    void givenGutterBallInFirstNineFramesAndNotASpareInLastFrame_whenAdditionalRollInLastFrame_thenWillThrowAGameFoulException() {
        rollMultiples(18, 0);
        game.roll(4);
        game.roll(4);
        assertThrows(GameFoulException.class, ()->game.roll(4),"Committed a game foul.");
    }

    private void rollSpare() {
        game.roll(4);
        game.roll(6);
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollMultiples(int numberOfRolls, int pinsKnockedDown) {
        for (int i = 0; i < numberOfRolls; i++) {
            game.roll(pinsKnockedDown);
        }
    }
}
