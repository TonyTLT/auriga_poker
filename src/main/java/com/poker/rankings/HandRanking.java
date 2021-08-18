package com.poker.rankings;

import java.util.List;

public enum HandRanking {

	ROYAL_FLUSH(10),
	STRAIGHT_FLUSH(9),
	FOUR_OF_A_KIND(8),
	FULL_HOUSE(7),
	FLUSH(6),
	STRAIGHT(5),
	THREE_OF_A_KIND(4),
	TWO_PAIR(3),
	PAIR(2),
	HIGHEST_CARD(1);

	private int handRank;
	private static List<HandRanking> RANKINGS = List.of(HandRanking.ROYAL_FLUSH, HandRanking.STRAIGHT_FLUSH, HandRanking.FOUR_OF_A_KIND, HandRanking.FULL_HOUSE, HandRanking.FLUSH, HandRanking.STRAIGHT, HandRanking.THREE_OF_A_KIND,
			HandRanking.TWO_PAIR, HandRanking.PAIR, HandRanking.HIGHEST_CARD);

	HandRanking(int handRank) {
		this.handRank = handRank;
	}
	
	public int getHandRank() {
		return handRank;
	}

	public static List<HandRanking> listByRanking() {
		return RANKINGS;
	}
}
