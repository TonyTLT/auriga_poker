package com.poker.rankings.calculations;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.card.Suit;

class PairCalculationTest extends ScoreTest {

	private List<Card> PAIR_HIGH_HAND = List.of(new Card(Rank.KING, Suit.CLUB), new Card(Rank.FOUR, Suit.CLUB), new Card(Rank.TWO, Suit.DIAMOND), new Card(Rank.KING, Suit.HEART), new Card(Rank.JACK, Suit.DIAMOND));
	private List<Card> PAIR_LOW_HAND = List.of(new Card(Rank.ACE, Suit.CLUB), new Card(Rank.QUEEN, Suit.CLUB), new Card(Rank.JACK, Suit.DIAMOND), new Card(Rank.QUEEN, Suit.HEART), new Card(Rank.NINE, Suit.DIAMOND));

	@Test
	void calculateThreeOfAKindScore() {
		score = new PairCalculation(getModifiableList(PAIR_HIGH_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(20376506, calculatedScore);
	}

	@Test
	void calculateNonThreeOfAKindScore() {
		score = new PairCalculation(getModifiableList(RANDOM_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(0, calculatedScore);
	}

	@Test
	void compareThreeOfAKindScore() {
		Score scoreHigh = new PairCalculation(getModifiableList(PAIR_HIGH_HAND));
		Score scoreLow = new PairCalculation(getModifiableList(PAIR_LOW_HAND));
		int calculatedHighScore = scoreHigh.calculateTotalScore();
		int calculatedLowScore = scoreLow.calculateTotalScore();

		assertTrue(calculatedHighScore > calculatedLowScore);
	}
}
