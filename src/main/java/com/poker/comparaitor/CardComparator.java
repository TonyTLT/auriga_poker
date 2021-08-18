package com.poker.comparaitor;

import java.util.Comparator;

import com.poker.card.Card;

public class CardComparator implements Comparator<Card> {

	@Override
	public int compare(Card card1, Card card2) {
		 return card1.getRank().getValue() > card2.getRank().getValue() ? -1 : card1.getRank().getValue() < card2.getRank().getValue() ? +1 : 0;
	}

}
