package com.poker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poker.rankings.calculations.battle.BattleScore;
import com.poker.rankings.calculations.battle.BattleCalculator;

@Configuration
public class BeanConfiguration {

	@Bean
	public BattleScore battleScore(BattleCalculator battleUtils) {
		return new BattleScore(battleUtils);
	}
}
