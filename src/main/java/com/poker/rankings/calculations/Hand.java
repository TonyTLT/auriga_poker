package com.poker.rankings.calculations;

import java.util.Collections;
import java.util.List;

import com.poker.card.Card;
import com.poker.comparaitor.CardComparator;
import com.poker.rankings.HandRanking;

abstract class Hand implements Score {

	private static final int COUNT_INDEX = 10000000;

	abstract int calculateScore();
	abstract HandRanking getHandRank();

	protected List<Card> cards;

	Hand(List<Card> cards) {
		Collections.sort(cards, new CardComparator());
		this.cards = cards;
	}

	@Override
	public int generateRankScore() {
		return COUNT_INDEX * getHandRank().getHandRank();
	}

	@Override
	public int calculateTotalScore() {
		int calculatedScore = calculateScore();
		if (calculatedScore == 0) {
			return 0;
		} else {
			return calculatedScore + generateRankScore();
		}
	}

}
