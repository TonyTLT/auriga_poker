package com.poker.rankings.calculations.battle;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poker.card.Card;
import com.poker.rankings.ScoreCalculator;

@Component
public class BattleCalculator {

	private static final String PLAYER1 = "Player 1";
	private static final String PLAYER2 = "Player 2";
	private static final String TIE = "Tie";

	@Autowired
	ScoreCalculator scoreCalculator;

	public Result calculateWinner(Map<List<Card>, List<Card>> handMap) {
		int playerOneWins = 0;
		int playerTwoWins = 0;
		int tie = 0;
		for (Map.Entry<List<Card>, List<Card>> entry : handMap.entrySet()) {
			int playerOneScore = scoreCalculator.calculateHandScore(entry.getKey());
			int playerTwoScore = scoreCalculator.calculateHandScore(entry.getValue());
			if (playerOneScore > playerTwoScore) {
				playerOneWins++;
			} else if (playerOneScore < playerTwoScore) {
				playerTwoWins++;
			} else {
				tie++;
			}
		}
		return getResult(playerOneWins, playerTwoWins, tie);
	}

	private Result getResult(int playerOneWins, int playerTwoWins, int tie2) {
		String winMessage = "";
		if (playerOneWins > playerTwoWins) {
			winMessage = winningMessage(PLAYER1, playerOneWins);
		} else if (playerOneWins < playerTwoWins) {
			winMessage = winningMessage(PLAYER2, playerTwoWins);
		} else {
			winMessage = TIE;
		}
		return new Result(winMessage, getPlayerOneResult(playerOneWins));
	}

	private String getPlayerOneResult(int playerOneWins) {
		return PLAYER1 + " won " + playerOneWins + " hands.";
	}

	private String winningMessage(String player, int score) {
		return "Winner is " + player + ", won - " + score + " games.";
	}
	
	
}
