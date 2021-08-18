package com.poker.rankings;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.card.Suit;
import com.poker.comparaitor.CardComparator;
import com.poker.rankings.calculations.ScoreTest;
import com.poker.rankings.utils.RankUtils;

public class RankUtilsTest extends ScoreTest {

	protected List<Card> FLUSH_HAND = List.of(new Card(Rank.TWO, Suit.CLUB), new Card(Rank.FOUR, Suit.CLUB), new Card(Rank.SIX, Suit.CLUB), new Card(Rank.FIVE, Suit.CLUB), new Card(Rank.ACE, Suit.CLUB));

	@Test
	public void testFlush() {
		List<Card> list = new ArrayList<Card>(FLUSH_HAND);
		Collections.sort(list, new CardComparator());
		int score = RankUtils.getFlushScore(list);

		assertEquals(5381155, score);
	}
}
