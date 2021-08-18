package com.poker.rankings.calculations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RoyalFlushCalculationTest extends ScoreTest {

	@Test
	void calculateRoyalFlushScore() {
		score = new RoyalFlushCalculation(getModifiableList(ROYAL_FLUSH_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(100000001, calculatedScore);
	}

	@Test
	void calculateNonRoyalFlushScore() {
		score = new RoyalFlushCalculation(getModifiableList(RANDOM_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(0, calculatedScore);
	}
}
