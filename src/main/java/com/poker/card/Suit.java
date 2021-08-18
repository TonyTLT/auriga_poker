package com.poker.card;

public enum Suit {

	SPAID("S"), CLUB("C"), DIAMOND("D"), HEART("H");

	String id;
	Suit(String id) {
		this.id = id;
	}
	
	public static Suit fromString(String id) {
        for (Suit suit : Suit.values()) {
            if (suit.id.equalsIgnoreCase(id)) {
                return suit;
            }
        }
        return null;
    }
}
