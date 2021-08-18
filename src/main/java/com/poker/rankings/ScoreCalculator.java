package com.poker.rankings;

import java.util.List;

import org.springframework.stereotype.Component;

import com.poker.card.Card;
import com.poker.rankings.calculations.FlushCalculation;
import com.poker.rankings.calculations.FourOfAKindCalculation;
import com.poker.rankings.calculations.FullHouseCalculation;
import com.poker.rankings.calculations.HighestCardCalculation;
import com.poker.rankings.calculations.PairCalculation;
import com.poker.rankings.calculations.RoyalFlushCalculation;
import com.poker.rankings.calculations.Score;
import com.poker.rankings.calculations.StraightCalculation;
import com.poker.rankings.calculations.StraightFlushCalculation;
import com.poker.rankings.calculations.ThreeOfAKindCalculation;
import com.poker.rankings.calculations.TwoPairCalculation;

@Component
public class ScoreCalculator {

	/**
	 * Calculator iterates thru the list of hand ranks from the highest. It will calculate hand score.
	 * Each hand has its own rate, by how strong it is. Actual hand also evaluates it's cards combination
	 * and returns score depending on how strong hand is.
	 * @return calculated hand score 
	 */
	public int calculateHandScore(List<Card> cards) {
		for (HandRanking ranking : HandRanking.listByRanking()) {
			int score = calculateHandByRank(ranking, cards);
			if (score != 0) {
				return score;
			}
		}
		return 0;
	}

	private int calculateHandByRank(HandRanking handRanking, List<Card> cards) {
		Score score = null;
		switch (handRanking) {
		case ROYAL_FLUSH:
			score = new RoyalFlushCalculation(cards);
			break;
		case STRAIGHT_FLUSH:
			score = new StraightFlushCalculation(cards);
			break;
		case FOUR_OF_A_KIND:
			score = new FourOfAKindCalculation(cards);
			break;
		case FULL_HOUSE:
			score = new FullHouseCalculation(cards);
			break;
		case FLUSH:
			score = new FlushCalculation(cards);
			break;
		case STRAIGHT:
			score = new StraightCalculation(cards);
			break;
		case THREE_OF_A_KIND:
			score = new ThreeOfAKindCalculation(cards);
			break;
		case TWO_PAIR:
			score = new TwoPairCalculation(cards);
			break;
		case PAIR:
			score = new PairCalculation(cards);
			break;
		case HIGHEST_CARD:
			score = new HighestCardCalculation(cards);
			break;
		default:
			return 0;
		}
		return score.calculateTotalScore();
	}
}
