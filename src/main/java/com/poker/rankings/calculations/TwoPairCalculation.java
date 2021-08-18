package com.poker.rankings.calculations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.comparaitor.RankComparator;
import com.poker.exception.MissingKickerException;
import com.poker.rankings.HandRanking;
import com.poker.rankings.utils.RankUtils;

public class TwoPairCalculation extends Hand {

	public TwoPairCalculation(List<Card> cards) {
		super(cards);
	}

	@Override
	int calculateScore() {
		Map<Rank, Integer> cardsMap = RankUtils.getCardsInMap(cards);
		if (RankUtils.isTwoPair(cardsMap)) {
			List<Rank> twoPairRankList = new ArrayList<>();
			Rank kicker = null;
			for (Entry<Rank, Integer> entry : cardsMap.entrySet()) {
				if (entry.getValue() == 2) {
					twoPairRankList.add(entry.getKey());
				} else {
					kicker = entry.getKey();
				}
			}
			Collections.sort(twoPairRankList, new RankComparator());
			int score = 0;
			for (int i = 0; i < twoPairRankList.size(); i++) {
				score += RankUtils.calculateRankScore(twoPairRankList.get(i), 3-i);
			}
			if (kicker != null) {
				score += kicker.getValue();
			} else {
				throw new MissingKickerException();
			}
			return score;
		}
		return 0;
	}

	@Override
	HandRanking getHandRank() {
		return HandRanking.TWO_PAIR;
	}

}
