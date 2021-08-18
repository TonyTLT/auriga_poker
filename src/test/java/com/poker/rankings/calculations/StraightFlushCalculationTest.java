package com.poker.rankings.calculations;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.card.Suit;

class StraightFlushCalculationTest extends ScoreTest {

	private List<Card> STRAIGHT_FLUSH_HIGH_HAND = List.of(new Card(Rank.KING, Suit.CLUB), new Card(Rank.JACK, Suit.CLUB), new Card(Rank.QUEEN, Suit.CLUB), new Card(Rank.NINE, Suit.CLUB), new Card(Rank.TEN, Suit.CLUB));
	private List<Card> STRAIGHT_FLUSH_LOW_HAND = List.of(new Card(Rank.FOUR, Suit.CLUB), new Card(Rank.TWO, Suit.CLUB), new Card(Rank.ACE, Suit.CLUB), new Card(Rank.FIVE, Suit.CLUB), new Card(Rank.THREE, Suit.CLUB));

	@Test
	void calculateStraightFlushScore() {
		score = new StraightFlushCalculation(getModifiableList(STRAIGHT_FLUSH_HIGH_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(90000055, calculatedScore);
	}

	@Test
	void calculateNonStraightFlushScore() {
		score = new StraightFlushCalculation(getModifiableList(RANDOM_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(0, calculatedScore);
	}

	@Test
	void compareStraightFlushScore() {
		Score scoreHigh = new StraightFlushCalculation(getModifiableList(STRAIGHT_FLUSH_HIGH_HAND));
		Score scoreLow = new StraightFlushCalculation(getModifiableList(STRAIGHT_FLUSH_LOW_HAND));
		int calculatedHighScore = scoreHigh.calculateTotalScore();
		int calculatedLowScore = scoreLow.calculateTotalScore();

		assertTrue(calculatedHighScore > calculatedLowScore);
	}
}
