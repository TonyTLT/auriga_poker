package com.poker.rankings.calculations;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.card.Suit;

class HighestCardCalculationTest extends ScoreTest {

	protected List<Card> HIGHEST_CARD_HIGH_HAND = List.of(new Card(Rank.SIX, Suit.CLUB), new Card(Rank.ACE, Suit.CLUB), new Card(Rank.SEVEN, Suit.DIAMOND), new Card(Rank.THREE, Suit.HEART), new Card(Rank.TWO, Suit.DIAMOND));
	protected List<Card> HIGHEST_CARD_LOW_HAND = List.of(new Card(Rank.ACE, Suit.CLUB), new Card(Rank.QUEEN, Suit.CLUB), new Card(Rank.KING, Suit.DIAMOND), new Card(Rank.SIX, Suit.HEART), new Card(Rank.EIGHT, Suit.DIAMOND));

	@Test
	void calculateHighestCardScore() {
		score = new HighestCardCalculation(getModifiableList(HIGHEST_CARD_HIGH_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(15411744, calculatedScore);
	}

	@Test
	void compareHighestCardScore() {
		Score scoreHigh = new HighestCardCalculation(getModifiableList(HIGHEST_CARD_HIGH_HAND));
		Score scoreLow = new HighestCardCalculation(getModifiableList(HIGHEST_CARD_LOW_HAND));
		int calculatedHighScore = scoreHigh.calculateTotalScore();
		int calculatedLowScore = scoreLow.calculateTotalScore();

		assertTrue(calculatedHighScore > calculatedLowScore);
	}
}
