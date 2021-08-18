package com.poker.comparaitor;

import java.util.Comparator;

import com.poker.card.Rank;

public class RankComparator implements Comparator<Rank> {

	@Override
	public int compare(Rank rank1, Rank rank2) {
		return rank1.getValue() > rank1.getValue() ? -1 : rank1.getValue() < rank1.getValue() ? +1 : 0;
	}

}
