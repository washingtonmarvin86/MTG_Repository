package com.mtg;

import java.util.ArrayList;
import java.util.List;

public class MagicGame
{
	private Deck deck;
	private List<Player> players;
	
	public MagicGame(int numPlayers)
	{
		deck = new Deck();
		players = new ArrayList<>();
	}
}
