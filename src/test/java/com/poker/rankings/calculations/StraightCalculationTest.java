package com.poker.rankings.calculations;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.card.Suit;

class StraightCalculationTest extends ScoreTest {

	private List<Card> STRAIGHT_HIGH_HAND = List.of(new Card(Rank.KING, Suit.CLUB), new Card(Rank.QUEEN, Suit.CLUB), new Card(Rank.NINE, Suit.DIAMOND), new Card(Rank.JACK, Suit.HEART), new Card(Rank.TEN, Suit.DIAMOND));
	private List<Card> STRAIGHT_LOW_HAND = List.of(new Card(Rank.ACE, Suit.CLUB), new Card(Rank.THREE, Suit.CLUB), new Card(Rank.FOUR, Suit.DIAMOND), new Card(Rank.FIVE, Suit.HEART), new Card(Rank.TWO, Suit.DIAMOND));

	@Test
	void calculateStraightScore() {
		score = new StraightCalculation(getModifiableList(STRAIGHT_HIGH_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(50000055, calculatedScore);
	}

	@Test
	void calculateNonStraightScore() {
		score = new StraightCalculation(getModifiableList(RANDOM_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(0, calculatedScore);
	}
	
	@Test
	void compareStraightScore() {
		Score scoreHigh = new StraightCalculation(getModifiableList(STRAIGHT_HIGH_HAND));
		Score scoreLow = new StraightCalculation(getModifiableList(STRAIGHT_LOW_HAND));
		int calculatedHighScore = scoreHigh.calculateTotalScore();
		int calculatedLowScore = scoreLow.calculateTotalScore();

		assertTrue(calculatedHighScore > calculatedLowScore);
	}
}
