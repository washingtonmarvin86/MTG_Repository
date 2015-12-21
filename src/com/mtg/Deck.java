package com.mtg;

import java.util.ArrayList;
import java.util.List;

public class Deck
{
	List<Card> cards;
	
	public Deck()
	{
		cards = new ArrayList<>();
		
		buildDeck();
	}

	private void buildDeck()
	{
		for (int i = 0; i < 40; i++)
		{
			cards.add(new Card(null, null, null, i, i));
			
		}
	}
}
