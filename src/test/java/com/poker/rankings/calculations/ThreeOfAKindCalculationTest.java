package com.poker.rankings.calculations;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.card.Suit;

public class ThreeOfAKindCalculationTest extends ScoreTest {

	protected List<Card> THREE_OF_A_KIND_HIGH_HAND = List.of(new Card(Rank.KING, Suit.CLUB), new Card(Rank.ACE, Suit.CLUB), new Card(Rank.TWO, Suit.DIAMOND), new Card(Rank.KING, Suit.HEART), new Card(Rank.KING, Suit.DIAMOND));
	protected List<Card> THREE_OF_A_KIND_LOW_HAND = List.of(new Card(Rank.ACE, Suit.CLUB), new Card(Rank.QUEEN, Suit.CLUB), new Card(Rank.JACK, Suit.DIAMOND), new Card(Rank.QUEEN, Suit.HEART), new Card(Rank.QUEEN, Suit.DIAMOND));

	@Test
	void calculateThreeOfAKindScore() {
		score = new ThreeOfAKindCalculation(getModifiableList(THREE_OF_A_KIND_HIGH_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(40030953, calculatedScore);
	}

	@Test
	void calculateNonThreeOfAKindScore() {
		score = new ThreeOfAKindCalculation(getModifiableList(RANDOM_HAND));
		int calculatedScore = score.calculateTotalScore();

		assertEquals(0, calculatedScore);
	}

	@Test
	void compareThreeOfAKindScore() {
		Score scoreHigh = new ThreeOfAKindCalculation(getModifiableList(THREE_OF_A_KIND_HIGH_HAND));
		Score scoreLow = new ThreeOfAKindCalculation(getModifiableList(THREE_OF_A_KIND_LOW_HAND));
		int calculatedHighScore = scoreHigh.calculateTotalScore();
		int calculatedLowScore = scoreLow.calculateTotalScore();

		assertTrue(calculatedHighScore > calculatedLowScore);
	}
}
