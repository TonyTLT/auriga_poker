package com.poker.rankings.calculations.battle;

import java.util.List;
import java.util.Map;

import com.poker.card.Card;

public class BattleScore {

	private BattleCalculator battleUtils;
	private Result result;

	public BattleScore(BattleCalculator battleUtils) {
		this.battleUtils = battleUtils;
	}

	public void calculateWinner(Map<List<Card>, List<Card>> handMap) {
		this.result = battleUtils.calculateWinner(handMap);
	}

	public String getWinner() {
		return result.getWinner();
	}
	
	public String playerOneResult() {
		return result.getPlayerOneResult();
	}

}
