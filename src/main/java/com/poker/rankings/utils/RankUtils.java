package com.poker.rankings.utils;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.card.Suit;
import com.poker.comparaitor.RankComparator;

@Component
public class RankUtils {

	private static final int CARD_NUMBER = 13;
	public static final int INITIAL_SCORE_VALUE_DIGIT = 6;

	public static int getStraightScore(List<Card> cards) {
		int score = 0;
		int lastCardScore = 0;
		for (Card card : cards) {
			if (lastCardScore == 0 || lastCardScore - 1 == card.getRank().getValue()) {
				lastCardScore = card.getRank().getValue();
				score += lastCardScore;
			} else if (lastCardScore == Rank.ACE.getValue() && card.getRank() == Rank.FIVE) {
				lastCardScore = card.getRank().getValue();
				score += lastCardScore - Rank.ACE.getValue() + 1;
			} else {
				return 0;
			}
		}
		return score;
	}

	public static boolean isFlush(List<Card> cards) {
		Suit suit = null;
		for (Card card : cards) {
			if (suit == null) {
				suit = card.getSuit();
				continue;
			}
			if (suit != card.getSuit()) {
				return false;
			}
		}
		return true;
	}

	public static int getFlushScore(List<Card> cards) {
		int score = 0;
		if (!isFlush(cards)) {
			return 0;
		}
		for (int i = 0; i < cards.size(); i++) {
			int tarpinis = getPriorityIndex(cards.size() - i) * cards.get(i).getRank().getValue();
			score += tarpinis;
		}
		return score;
	}

	public static Map<Rank, Integer> getCardsInMap(List<Card> cards) {
		Map<Rank, Integer> map = new EnumMap<>(Rank.class);
		cards.stream().forEach(card -> map.put(card.getRank(), map.containsKey(card.getRank()) ? map.get(card.getRank()) + 1 : 1));
		return map;
	}

	private static Stream<Entry<Rank, Integer>> getCardsStreamByCount(int count, Map<Rank, Integer> cardsMap) {
		return cardsMap.entrySet().stream().filter(item -> item.getValue() == count);
	}

	public static Optional<Entry<Rank, Integer>> getCardsByCount(int count, Map<Rank, Integer> cardsMap) {
		return getCardsStreamByCount(count, cardsMap).findFirst();
	}

	public static boolean isTwoPair(Map<Rank, Integer> cardsMap) {
		Stream<Entry<Rank, Integer>> cardStream = getCardsStreamByCount(2, cardsMap);
		return cardStream.count() == 2;
	}

	public static int calculateSameCardRankAndKickerScore(List<Card> cards, int sameCardCount) {
		return calculateSameCardRankScore(cards, sameCardCount, true);
	}

	public static int calculateSameCardRankScore(List<Card> cards, int sameCardCount, boolean isKickerCounting) {
		Map<Rank, Integer> cardsMap = getCardsInMap(cards);
		Optional<Entry<Rank, Integer>> value = cardsMap.entrySet().stream().filter(item -> item.getValue() == sameCardCount).findFirst();
		if (value.isPresent()) {
			int kickerCount = 0;
			if (isKickerCounting) {
				kickerCount = countKickerScore(cardsMap.entrySet().stream().filter(item -> item.getValue() == 1).map(item -> item.getKey()).collect(Collectors.toList()));
			}
			return calculateRankScore(value.get()) + kickerCount;
		} else {
			return 0;
		}
	}

	public static int calculateRankScore(Rank rank, int priorityLevel) {
		return getPriorityIndex(priorityLevel) * rank.getValue();
	}

	private static int calculateRankScore(Entry<Rank, Integer> entry) {
		return getPriorityIndex(INITIAL_SCORE_VALUE_DIGIT - entry.getValue()) * entry.getKey().getValue();
	}

	private static int countKickerScore(List<Rank> rankList) {
		Collections.sort(rankList, new RankComparator());
		int score = 0;
		for (int i = 0; i < rankList.size(); i++) {
			score += getPriorityIndex(rankList.size() - i) * rankList.get(i).getValue();
		}
		return score;
	}

	/**
	 * Calculates priority index. If some combination have higher priority it will have bigger score.
	 *
	 *  @param index - priority level.
	 *  @return calculated priority index
	 */
	private static int getPriorityIndex(int index) {
		return (int) Math.pow(CARD_NUMBER, index);
	}
}
