package com.poker.rankings.calculations;

import java.util.ArrayList;
import java.util.List;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.card.Suit;

public class ScoreTest {

	protected List<Card> ROYAL_FLUSH_HAND = List.of(new Card(Rank.ACE, Suit.CLUB), new Card(Rank.KING, Suit.CLUB), new Card(Rank.QUEEN, Suit.CLUB), new Card(Rank.JACK, Suit.CLUB), new Card(Rank.TEN, Suit.CLUB));
	protected List<Card> RANDOM_HAND = List.of(new Card(Rank.ACE, Suit.CLUB), new Card(Rank.THREE, Suit.HEART), new Card(Rank.NINE, Suit.CLUB), new Card(Rank.FIVE, Suit.DIAMOND), new Card(Rank.JACK, Suit.SPAID));

	protected Score score;

	protected List<Card> getModifiableList(List<Card> cards) {
		return new ArrayList<Card>(cards);
	}
}
