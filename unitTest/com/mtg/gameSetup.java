package com.mtg;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class gameSetup
{

	private int lifeTotal = 20;

	@Test
	public void shouldHaveLifeTotalOf20()
	{
		assertTrue(lifeTotal == 20);
	}
	
	@Ignore
	@Test
	public void shouldHave40TotalCards()
	{
		fail();
	}

}
