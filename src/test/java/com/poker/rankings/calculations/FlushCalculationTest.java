package com.poker.rankings.calculations;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.card.Suit;

class FlushCalculationTest extends ScoreTest{

	private List<Card> FLUSH_HIGH_HAND = List.of(new Card(Rank.THREE, Suit.CLUB), new Card(Rank.TWO, Suit.CLUB), new Card(Rank.ACE, Suit.CLUB), new Card(Rank.NINE, Suit.CLUB), new Card(Rank.SIX, Suit.CLUB));
	private List<Card> FLUSH_LOW_HAND = List.of(new Card(Rank.KING, Suit.CLUB), new Card(Rank.QUEEN, Suit.CLUB), new Card(Rank.JACK, Suit.CLUB), new Card(Rank.NINE, Suit.CLUB), new Card(Rank.SIX, Suit.CLUB));
	
	@Test
	void calculateFlushScore() {
		score = new FlushCalculation(getModifiableList(FLUSH_HIGH_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(65468866, calculatedScore);
	}

	@Test
	void calculateNonFlushScore() {
		score = new FlushCalculation(getModifiableList(RANDOM_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(0, calculatedScore);
	}
	
	@Test
	void compareFlushScore() {
		Score scoreHigh = new FlushCalculation(getModifiableList(FLUSH_HIGH_HAND));
		Score scoreLow = new FlushCalculation(getModifiableList(FLUSH_LOW_HAND));
		int calculatedHighScore = scoreHigh.calculateTotalScore();
		int calculatedLowScore = scoreLow.calculateTotalScore();

		assertTrue(calculatedHighScore > calculatedLowScore);
	}
}
