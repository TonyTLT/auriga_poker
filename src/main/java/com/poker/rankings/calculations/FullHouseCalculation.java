package com.poker.rankings.calculations;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.rankings.HandRanking;
import com.poker.rankings.utils.RankUtils;

public class FullHouseCalculation extends Hand {

	public FullHouseCalculation(List<Card> cards) {
		super(cards);
	}

	@Override
	int calculateScore() {
		Map<Rank, Integer> cardsMap = RankUtils.getCardsInMap(cards);
		Optional<Entry<Rank, Integer>> valueThreeCards = RankUtils.getCardsByCount(3, cardsMap);
		if (valueThreeCards.isPresent()) {
			Optional<Entry<Rank, Integer>> valueTwoCards = RankUtils.getCardsByCount(2, cardsMap);
			if (valueTwoCards.isPresent()) {
				return 100 * valueThreeCards.get().getKey().getValue() + valueTwoCards.get().getKey().getValue();
			}

		}
		return 0;
	}

	@Override
	HandRanking getHandRank() {
		return HandRanking.FULL_HOUSE;
	}

}
