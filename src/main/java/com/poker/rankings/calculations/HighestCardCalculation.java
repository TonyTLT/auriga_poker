package com.poker.rankings.calculations;

import java.util.List;

import com.poker.card.Card;
import com.poker.rankings.HandRanking;
import com.poker.rankings.utils.RankUtils;

public class HighestCardCalculation extends Hand {

	public HighestCardCalculation(List<Card> cards) {
		super(cards);
	}

	@Override
	int calculateScore() {
		int score = 0;
		for (int i = 0; i < cards.size(); i++) {
			score += RankUtils.calculateRankScore(cards.get(i).getRank(), cards.size() - i);
		}
		return score;
	}

	@Override
	HandRanking getHandRank() {
		return HandRanking.HIGHEST_CARD;
	}

}
