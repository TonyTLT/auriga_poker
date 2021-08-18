package com.poker.rankings.calculations;

import java.util.List;

import com.poker.card.Card;
import com.poker.rankings.HandRanking;
import com.poker.rankings.utils.RankUtils;

public class StraightCalculation extends Hand {

	public StraightCalculation(List<Card> cards) {
		super(cards);
	}

	@Override
	int calculateScore() {
		return RankUtils.getStraightScore(cards);
	}

	@Override
	HandRanking getHandRank() {
		return HandRanking.STRAIGHT;
	}

}
