package com.poker.rankings.calculations;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.card.Suit;

class FullHouseCalculationTest extends ScoreTest {

	private List<Card> FULL_HOUSE_HIGH_HAND = List.of(new Card(Rank.ACE, Suit.CLUB), new Card(Rank.ACE, Suit.DIAMOND), new Card(Rank.TWO, Suit.HEART), new Card(Rank.ACE, Suit.SPAID), new Card(Rank.TWO, Suit.CLUB));
	private List<Card> FULL_HOUSE_LOW_HAND = List.of(new Card(Rank.KING, Suit.CLUB), new Card(Rank.KING, Suit.DIAMOND), new Card(Rank.QUEEN, Suit.HEART), new Card(Rank.KING, Suit.SPAID), new Card(Rank.QUEEN, Suit.CLUB));

	@Test
	void calculateFullHouseScore() {
		score = new FullHouseCalculation(getModifiableList(FULL_HOUSE_HIGH_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(70001402, calculatedScore);
	}

	@Test
	void calculateNonFullHouseScore() {
		score = new FullHouseCalculation(getModifiableList(RANDOM_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(0, calculatedScore);
	}
	
	@Test
	void compareFullHouseScore() {
		Score scoreHigh = new FullHouseCalculation(getModifiableList(FULL_HOUSE_HIGH_HAND));
		Score scoreLow = new FullHouseCalculation(getModifiableList(FULL_HOUSE_LOW_HAND));
		int calculatedHighScore = scoreHigh.calculateTotalScore();
		int calculatedLowScore = scoreLow.calculateTotalScore();

		assertTrue(calculatedHighScore > calculatedLowScore);
	}
}
