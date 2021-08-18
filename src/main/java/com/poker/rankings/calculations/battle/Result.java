package com.poker.rankings.calculations.battle;

public class Result {

	private String winner;
	private String playerOneResult;

	public Result(String winner, String playerOneResult) {
		super();
		this.winner = winner;
		this.playerOneResult = playerOneResult;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getPlayerOneResult() {
		return playerOneResult;
	}

	public void setPlayerOneResult(String playerOneResult) {
		this.playerOneResult = playerOneResult;
	}

}
