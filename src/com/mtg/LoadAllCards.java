package com.mtg;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoadAllCards
{
	static List<MTGCard> allCards = new ArrayList<MTGCard>();
//	List<MTGCard> blackCards;
//	List<MTGCard> whiteCards;
//	List<MTGCard> redCards;
//	List<MTGCard> blueCards;
//	List<MTGCard> greenCards;
	
	static List<MTGCard> whiteCards = new ArrayList<MTGCard>();
	static List<MTGCard> blackCards = new ArrayList<MTGCard>();
	static List<MTGCard> redCards = new ArrayList<MTGCard>();
	static List<MTGCard> greenCards = new ArrayList<MTGCard>();
	static List<MTGCard> blueCards = new ArrayList<MTGCard>();
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			@SuppressWarnings("unchecked")
			List<MTGCard> allCards = getAllCards((Map<String, MTGSet>)mapper.readValue(new File("C:\\Users\\Admin\\workspace\\AllSets.json"), new TypeReference<Map<String, MTGSet>>()  {}));
			List<MTGCard> library = allCards.subList(0,4);
			
			

			Collections.shuffle(library);
			
		    
			
			
			
			for (int i = 0; i < library.size(); i++)
			{
				//System.out.println("Number of cards: " + library.size());
				System.out.println("Name of card: " + library.get(i).getName());
				System.out.println("Type of card: " + library.get(i).getType());
				System.out.println("ManaCost of card: " + library.get(i).getManaCost());
				System.out.println("Text of card: " + library.get(i).getText());
				System.out.println("-------------------------------------------------------------");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	
		
		
		
		

		//System.out.println("Number of cards: " + allCards.size());
		//System.out.println("Number of cards: " + allCards.get(0).getColors());
		
		
		
	}
	
	
	



	public static List<MTGCard> getAllCards(Map<String, MTGSet> sets)
	{
		try {
			
			
			
			
			
			for(MTGSet set : sets.values())
			{
				for(MTGCard card : set.getCards())
				{
					//card.setSetCode(set.getCode());
					//card.setSetName(set.getName());
					//System.out.println(set.getName() + ": " + card.getName());
					
					if(card.getColors() != null)
					{
					
					
					allCards.add(card);
					System.out.println(card.getColors());
					System.out.println(card.getName());
					
				
				if(card.getManaCost().contains("W") )
				{
					whiteCards.add(card);
				}
				else if (card.getManaCost().contains("B"))
				{
					
					blackCards.add(card);
				}
				else if (card.getManaCost().contains("R"))
				{
					redCards.add(card);
				}
				else if (card.getManaCost().contains("G"))
				{
					greenCards.add(card);
				}
				else
				{
					blueCards.add(card);
				}
					}
					
					

				}
			}
			
			
			
			return allCards;
			
		}
		catch (Exception e)
		{			
			
		}
		finally
		{
			System.out.println("Number of black cards: " + blackCards.size());
			System.out.println("Number of white cards: " + whiteCards.size());
			System.out.println("Number of red cards: " + redCards.size());
			System.out.println("Number of green cards: " + greenCards.size());
			System.out.println("Number of blue cards: " + blueCards.size());
		}
		return allCards;
		
		
	}
	
		
}