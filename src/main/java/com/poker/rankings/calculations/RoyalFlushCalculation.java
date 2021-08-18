package com.poker.rankings.calculations;

import java.util.List;
import java.util.Optional;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.card.Suit;
import com.poker.rankings.HandRanking;

public class RoyalFlushCalculation extends Hand {

	private List<Rank> ROYAL_FLUSH_PATTERN = List.of(Rank.ACE, Rank.KING, Rank.QUEEN, Rank.JACK, Rank.TEN);

	public RoyalFlushCalculation(List<Card> cards) {
		super(cards);
	}

	@Override
	protected int calculateScore() {
		Suit royalFlushSuit = null;
		for (Rank rank : ROYAL_FLUSH_PATTERN) {
			Optional<Card> value = cards.stream().filter(card -> card.getRank() == rank).findFirst();
			if (value.isPresent()) {
				Suit suit = value.get().getSuit();
				if (royalFlushSuit != null && royalFlushSuit != suit) {
					return 0;
				}
				if (royalFlushSuit != null) {
					royalFlushSuit = suit;}
			} else {
				return 0;
			}
		}
		return 1;
	}

	@Override
	HandRanking getHandRank() {
		return HandRanking.ROYAL_FLUSH;
	}

}
