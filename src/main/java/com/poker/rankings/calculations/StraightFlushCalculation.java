package com.poker.rankings.calculations;

import java.util.List;

import com.poker.card.Card;
import com.poker.rankings.HandRanking;
import com.poker.rankings.utils.RankUtils;

public class StraightFlushCalculation extends Hand {

	public StraightFlushCalculation(List<Card> cards) {
		super(cards);
	}

	@Override
	int calculateScore() {
		if (RankUtils.isFlush(cards)) {
			int straightScore = RankUtils.getStraightScore(cards);
			if (straightScore != 0) {
				return straightScore;
			}
		}
		return 0;
	}

	@Override
	HandRanking getHandRank() {
		return HandRanking.STRAIGHT_FLUSH;
	}

}
