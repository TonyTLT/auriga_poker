package com.poker.rest.client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class PlayersCombinationClient {

	private static final String URL = "https://projecteuler.net/project/resources/";
	private static final String FILE_NAME = "p054_poker.txt";

	public String getCombinations() {
		try (BufferedInputStream inputStream = new BufferedInputStream(new URL(URL + FILE_NAME).openStream())) {
			return new BufferedReader(new InputStreamReader(inputStream))
					.lines().collect(Collectors.joining("\n"));
		} catch (IOException e) {
			return "";
		}
	}
}
