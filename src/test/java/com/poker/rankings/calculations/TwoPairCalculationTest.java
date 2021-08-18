package com.poker.rankings.calculations;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.card.Suit;

class TwoPairCalculationTest extends ScoreTest {

	protected List<Card> TWO_PAIR_HIGH_HAND = List.of(new Card(Rank.SIX, Suit.CLUB), new Card(Rank.ACE, Suit.CLUB), new Card(Rank.ACE, Suit.DIAMOND), new Card(Rank.TWO, Suit.HEART), new Card(Rank.TWO, Suit.DIAMOND));
	protected List<Card> TWO_PAIR_LOW_HAND = List.of(new Card(Rank.ACE, Suit.CLUB), new Card(Rank.QUEEN, Suit.CLUB), new Card(Rank.QUEEN, Suit.DIAMOND), new Card(Rank.KING, Suit.HEART), new Card(Rank.KING, Suit.DIAMOND));

	@Test
	void calculateTwoPairScore() {
		score = new TwoPairCalculation(getModifiableList(TWO_PAIR_HIGH_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(30031102, calculatedScore);
	}

	@Test
	void calculateNonTwoPairScore() {
		score = new TwoPairCalculation(getModifiableList(RANDOM_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(0, calculatedScore);
	}

	@Test
	void compareTwoPairScore() {
		Score scoreHigh = new TwoPairCalculation(getModifiableList(TWO_PAIR_HIGH_HAND));
		Score scoreLow = new TwoPairCalculation(getModifiableList(TWO_PAIR_LOW_HAND));
		int calculatedHighScore = scoreHigh.calculateTotalScore();
		int calculatedLowScore = scoreLow.calculateTotalScore();

		assertTrue(calculatedHighScore > calculatedLowScore);
	}
}
