package com.poker.rankings.calculations;

import java.util.List;

import com.poker.card.Card;
import com.poker.rankings.HandRanking;
import com.poker.rankings.utils.RankUtils;

public class ThreeOfAKindCalculation extends Hand {

	public ThreeOfAKindCalculation(List<Card> cards) {
		super(cards);
	}

	@Override
	int calculateScore() {
		return RankUtils.calculateSameCardRankAndKickerScore(cards, 3);
	}

	@Override
	HandRanking getHandRank() {
		return HandRanking.THREE_OF_A_KIND;
	}

}
