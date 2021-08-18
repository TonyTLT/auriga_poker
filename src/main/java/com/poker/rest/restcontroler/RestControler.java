package com.poker.rest.restcontroler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.poker.card.Card;
import com.poker.parsers.StringParser;
import com.poker.rankings.calculations.battle.BattleScore;
import com.poker.rest.client.PlayersCombinationClient;

@RestController
@RequestMapping("poker")
public class RestControler {

	@Autowired
	StringParser stringParser;
	
	@Autowired
	BattleScore battleScore;

	@Autowired
	PlayersCombinationClient client;

	@GetMapping("/score")
	@ResponseBody
	public String score() {
		return calculateResult().getWinner();
	}
	
	@GetMapping("/playeronescore")
	@ResponseBody
	public String playerOneScore() {
		return calculateResult().playerOneResult();
	}
	
	private BattleScore calculateResult() {
		String answer = client.getCombinations();
		Map<List<Card>, List<Card>> handMap = stringParser.parseHandsFromString(answer);
		battleScore.calculateWinner(handMap);
		return battleScore;
	}
	
}
