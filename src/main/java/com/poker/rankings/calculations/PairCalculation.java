package com.poker.rankings.calculations;

import java.util.List;

import com.poker.card.Card;
import com.poker.rankings.HandRanking;
import com.poker.rankings.utils.RankUtils;

public class PairCalculation extends Hand {

	public PairCalculation(List<Card> cards) {
		super(cards);
	}

	@Override
	int calculateScore() {
		return RankUtils.calculateSameCardRankAndKickerScore(cards, 2);
	}

	@Override
	HandRanking getHandRank() {
		return HandRanking.PAIR;
	}

}
