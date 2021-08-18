package com.poker.card;

public enum Rank {
	
	ACE("A", 14),
	TWO("2", 2), 
	THREE("3", 3),
	FOUR("4", 4),
	FIVE("5", 5),
	SIX("6", 6),
	SEVEN("7", 7),
	EIGHT("8", 8),
	NINE("9", 9),
	TEN("T", 10),
	JACK("J", 11),
	QUEEN("Q", 12),
	KING("K", 13);
	
	private String id;
	private int value;

	Rank(String id, int value) {
		this.id = id;
		this.value = value;
	}
	public String getId() {
		return id;
	}
	public int getValue() {
		return value;
	}
	
	public static Rank fromString(String id) {
        for (Rank rank : Rank.values()) {
            if (rank.id.equalsIgnoreCase(id)) {
                return rank;
            }
        }
        return null;
    }
}
