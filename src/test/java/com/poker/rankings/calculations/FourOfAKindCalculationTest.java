package com.poker.rankings.calculations;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.card.Suit;

class FourOfAKindCalculationTest extends ScoreTest {

	private List<Card> FOUR_OF_A_KIND_HIGH_HAND = List.of(new Card(Rank.KING, Suit.CLUB), new Card(Rank.KING, Suit.DIAMOND), new Card(Rank.KING, Suit.HEART), new Card(Rank.KING, Suit.CLUB), new Card(Rank.TWO, Suit.CLUB));
	private List<Card> FOUR_OF_A_KIND_LOW_HAND = List.of(new Card(Rank.TWO, Suit.CLUB), new Card(Rank.TWO, Suit.DIAMOND), new Card(Rank.TWO, Suit.HEART), new Card(Rank.TWO, Suit.CLUB), new Card(Rank.KING, Suit.CLUB));
	
	@Test
	void calculateFourOfAKindScore() {
		score = new FourOfAKindCalculation(getModifiableList(FOUR_OF_A_KIND_HIGH_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(80002223, calculatedScore);
	}

	@Test
	void calculateNonFourOfAKindScore() {
		score = new FourOfAKindCalculation(getModifiableList(RANDOM_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(0, calculatedScore);
	}
	
	@Test
	void compareFourOfAKindScore() {
		Score scoreHigh = new FourOfAKindCalculation(getModifiableList(FOUR_OF_A_KIND_HIGH_HAND));
		Score scoreLow = new FourOfAKindCalculation(getModifiableList(FOUR_OF_A_KIND_LOW_HAND));
		int calculatedHighScore = scoreHigh.calculateTotalScore();
		int calculatedLowScore = scoreLow.calculateTotalScore();

		assertTrue(calculatedHighScore > calculatedLowScore);
	}
}
