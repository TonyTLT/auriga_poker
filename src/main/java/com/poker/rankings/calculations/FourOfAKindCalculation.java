package com.poker.rankings.calculations;

import java.util.List;

import com.poker.card.Card;
import com.poker.rankings.HandRanking;
import com.poker.rankings.utils.RankUtils;

public class FourOfAKindCalculation extends Hand {

	public FourOfAKindCalculation(List<Card> cards) {
		super(cards);
	}

	@Override
	int calculateScore() {
		return RankUtils.calculateSameCardRankAndKickerScore(cards, 4);
	}

	@Override
	HandRanking getHandRank() {
		return HandRanking.FOUR_OF_A_KIND;
	}

}
