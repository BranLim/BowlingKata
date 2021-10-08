package com.layhill.bowlinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void givenFirstFrame_whenBallHits5PinsOnFirstRollAnd5PinsOnSecondRoll_thenTotalScoreShouldBe10() {
        game.roll(5);
        game.roll(5);
        int score = game.score();
        assertEquals(10, score);
    }

    @Test
    void givenFirstFrameIsSpareWithBothRowsKnocking5PinsEach_whenBallHits2PinsOnFirstRollInSecondFrame_thenTotalScoreShouldBe14() {
        game.roll(5);
        game.roll(5);
        game.roll(2);
        int score = game.score();
        assertEquals(14, score);
    }

    @Test
    void givenFirstRowInIsGutterAndSecondRowIsSpareInFirstFrame_whenBallHits2PinsOnFirstRollAnd2PinsOnSecondRollInSecondFrame_thenTotalScoreShouldbe14(){
        game.roll(0);
        game.roll(10);
        game.roll(2);
        game.roll(2);
        int score = game.score();
        assertEquals(16, score);
    }

    @Test
    void givenFirstFrameIsStrikeOnFirstRow_whenBallHits2PinsOnFirstRollAnd2PinsOnSecondRollInSecondFrame_thenTotalScoreShouldBe14() {
        game.roll(10);
        game.roll(2);
        game.roll(2);
        int score = game.score();
        assertEquals(18, score);
    }

    @Test
    void givenFirstFrameIsStrikeOnFirstRow_whenBallHits3PinsOnFirstRollAnd6PinsOnSecondRollInSecondFrame_thenTotalScoreShouldBe14() {
        game.roll(10);
        game.roll(3);
        game.roll(6);
        int score = game.score();
        assertEquals(28, score);
    }


}
