package CS111MS4;

import java.util.ArrayList;

// This class represents the set of cards held by one player (or the dealer).
public class Hand
{
	// define fields here
	ArrayList<Card> cards;
	// This constructor builds a hand (with no cards, initially).
	public Hand()
	{
		cards = new ArrayList<Card>();
		
	}
	
	// This method retrieves the size of this hand.
	public int getNumberOfCards()
	{
		return cards.size(); // replace this line with your code
	}

	// This method retrieves a particular card in this hand.  The card number is zero-based.
	public Card getCard(int index)
	{
		if (index < 0 || index >= cards.size())
		return null; 
		return cards.get(index);
	}

	// This method takes a card and places it into this hand.
	public void addCard(Card newcard)
	{
		cards.add(newcard);
	}

	// This method computes the score of this hand.
	public int getScore()
	{
		int score = 0;
		for (int i = 0; i < cards.size(); ++i){
			if(score>21){
				for (int z = 0; z < cards.size(); ++z){
					if(cards.get(z).getFace()==1){
						score=score-10;
						break;
					} else {
						break;
					}
				}
				
			}
			score += cards.get(i).getValue();
		}
		return score;
	}

	// This methods discards all cards in this hand.
	public void discardAll()
	{
		cards.clear();
	}
}
