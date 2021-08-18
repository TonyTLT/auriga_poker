package com.poker.rankings.calculations;

import java.util.List;

import com.poker.card.Card;
import com.poker.rankings.HandRanking;
import com.poker.rankings.utils.RankUtils;

public class FlushCalculation extends Hand {

	public FlushCalculation(List<Card> cards) {
		super(cards);
	}

	@Override
	int calculateScore() {
		return RankUtils.getFlushScore(cards);
	}

	@Override
	HandRanking getHandRank() {
		return HandRanking.FLUSH;
	}

}
