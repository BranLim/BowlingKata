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
    void givenFirstFrame_whenBallIsInGutter_thenScoreShouldBe0() {
        game.roll(0);
        int score = game.score();
        assertEquals(0, score);
    }

    @Test
    void givenFirstFrame_whenBallHits1Pin_thenScoreShouldBe0() {
        game.roll(1);
        int score = game.score();
        assertEquals(0, score);
    }

    @Test
    void givenFirstFrame_whenBallHits1PinsOnFirstRollAndballHits1PinsOnSecondRoll_thenScoreShouldBe2() {
        game.roll(1);
        game.roll(1);
        int score = game.score();
        assertEquals(2, score);

    }
}
