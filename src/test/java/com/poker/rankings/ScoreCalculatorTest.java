package com.poker.rankings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.card.Suit;

@RunWith(SpringRunner.class)
@SpringBootTest
class ScoreCalculatorTest {

	private List<Card> RANDOM_HAND = List.of(new Card(Rank.ACE, Suit.CLUB), new Card(Rank.THREE, Suit.HEART), new Card(Rank.NINE, Suit.CLUB), new Card(Rank.FIVE, Suit.DIAMOND), new Card(Rank.JACK, Suit.SPAID));
	private List<Card> one = List.of(new Card(Rank.FIVE, Suit.CLUB), 
			new Card(Rank.ACE, Suit.DIAMOND), 
			new Card(Rank.FIVE, Suit.DIAMOND),
			new Card(Rank.ACE, Suit.CLUB), 
			new Card(Rank.NINE, Suit.CLUB));
	private List<Card> two = List.of(new Card(Rank.SEVEN, Suit.CLUB), 
			new Card(Rank.FIVE, Suit.HEART), 
			new Card(Rank.EIGHT, Suit.DIAMOND), 
			new Card(Rank.TEN, Suit.DIAMOND), 
			new Card(Rank.KING, Suit.SPAID));
//5C AD 5D AC 9C 7C 5H 8D TD KS
	@Autowired 
	ScoreCalculator scoreCalculator;
	
	@Test
	public void calculateScore() {
		int score = scoreCalculator.calculateHandScore(new ArrayList<>(RANDOM_HAND));
		
		assertEquals(15532930, score);
	}
	
	@Test
	public void calculateWinner() {
		int score1 = scoreCalculator.calculateHandScore(new ArrayList<>(one));
		int score2 = scoreCalculator.calculateHandScore(new ArrayList<>(two));
		
		assertTrue(score1 > score2);
	}
}
