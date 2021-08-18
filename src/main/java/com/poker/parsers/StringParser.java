package com.poker.parsers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.poker.card.Card;
import com.poker.card.Rank;
import com.poker.card.Suit;

@Component
public class StringParser {

	private static final String SPACE = " ";

	public Map<List<Card>, List<Card>> parseHandsFromString(String hands) {
		Map<List<Card>, List<Card>> handMap = new LinkedHashMap<>();
		Scanner scanner = new Scanner(hands);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] cards = line.split(SPACE);
			putToMap(cards, handMap);
		}
		scanner.close();
		return handMap;
	}

	private void putToMap(String[] cards, Map<List<Card>, List<Card>> handMap) {
		List<Card> playerOneCards = new ArrayList<>();
		List<Card> playerTwoCards = new ArrayList<>();
		for (int i = 0; i < cards.length; i++) {
			if (i < 5) {
				playerOneCards.add(getCard(cards[i]));
			} else {
				playerTwoCards.add(getCard(cards[i]));
			}
		}
		handMap.put(playerOneCards, playerTwoCards);
	}

	private Card getCard(String card) {
		return new Card(Rank.fromString(String.valueOf(card.charAt(0))), Suit.fromString(String.valueOf(card.charAt(1))));
	}
}
