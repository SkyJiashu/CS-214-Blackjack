package CS111MS4;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
// This class represents the deck of cards from which cards are dealt to players.
public class Deck
{
	// define fields here
	java.util.List<Card> lCards;
	// This constructor builds a deck of 52 cards.
	public Deck()
	{
		lCards = new ArrayList<Card>();

		for(int i = 0; i <= 3; i++)
		{
			for(int j = 1; j <= 13; j++)
			{
				lCards.add(new Card(i,j));
			}
		}
	}

	// This method shuffles the deck (randomizes the array of cards).
	// Hint: loop over the cards and swap each one with another card in a random position.
	public void shuffle()
	{
		Collections.shuffle(lCards);
	}
	
	// This method takes the top card off the deck and returns it.
	public Card drawCard()
	{
		if (lCards.size() == 0)
		return null;
		Card card = lCards.get(0);
		lCards.remove(0);
		return card; 
	}
	
	// This method returns the number of cards left in the deck.
	public int getSize()
	{
		return lCards.size(); 
	}
}

