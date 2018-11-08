package CS111MS4;
// This class represents one playing card.
public class Card
{
	// Card suits (provided for your convenience - use is optional)
	public static final int SPADES   = 0;
	public static final int HEARTS   = 1;
	public static final int CLUBS    = 2;
	public static final int DIAMONDS = 3;

	// Card faces (provided for your convenience - use is optional)
	public static final int ACE      = 1;
	public static final int TWO      = 2;
	public static final int THREE    = 3;
	public static final int FOUR     = 4;
	public static final int FIVE     = 5;
	public static final int SIX      = 6;
	public static final int SEVEN    = 7;
	public static final int EIGHT    = 8;
	public static final int NINE     = 9;
	public static final int TEN      = 10;
	public static final int JACK     = 11;
	public static final int QUEEN    = 12;
	public static final int KING     = 13;


	// define fields here
	int suit;
	int face;
	boolean isFaceUp = false;
	// This constructor builds a card with the given suit and face, turned face down.
	public Card(int cardSuit, int cardFace)
	{
		suit = cardSuit;
		face = cardFace;
	}

	// This method retrieves the suit (spades, hearts, etc.) of this card.
	public String getSuitW()
	{
		String getSuitW=" ";
		if(this.suit==0){
			getSuitW="Spades";
		}
		if(this.suit==1){
			getSuitW="Hearts";
		}
		if(this.suit==2){
			getSuitW="Clubs";
		}
		if(this.suit==3){
			getSuitW="Diamonds";
		}
		return getSuitW;
	}
	public int getSuit()
	{
		return this.suit;
	}
	// This method retrieves the face (ace through king) of this card.
	public String getFaceW()
	{
		String getFaceW=" ";
		if(this.face==1){
			getFaceW="ACE";
		}
		if(this.face==2){
			getFaceW="Two";
		}
		if(this.face==3){
			getFaceW="Three";
		}
		if(this.face==4){
			getFaceW="Four";
		}
		if(this.face==5){
			getFaceW="Five";
		}
		if(this.face==6){
			getFaceW="Six";
		}
		if(this.face==7){
			getFaceW="Seven";
		}
		if(this.face==8){
			getFaceW="Eight";
		}
		if(this.face==9){
			getFaceW="Nine";
		}
		if(this.face==10){
			getFaceW="Ten";
		}
		if(this.face==11){
			getFaceW="Jack";
		}
		if(this.face==12){
			getFaceW="Queen";
		}
		if(this.face==13){
			getFaceW="King";
		}
		return getFaceW;
	}
	public int getFace()
	{
	
		return this.face;
	}
	// This method retrieves the numerical value of this card
	// (usually same as card face, except 1 for ace and 10 for jack/queen/king)
	public int getValue()
	{
		if(this.face < 10)
		{
			return this.face;
		}
		else
		{
			return 10;
		}
	}
	public int getValueW()
	{
		//new method of get value to replace the previous one, the announcement does not allow me to change getValue method >:
		//I set the new one, and I use it in Blackjack.

		if(this.face>10){
			return 10;
		} else if (this.face==1){
			return 11;
		} else
		{
			return this.face;
		}
	}
	// This method determines whether the front of the card should be visible.
	public boolean isFaceUp()
	{
		return isFaceUp;
	}

	// This method records that the front of the card should be visible.
	public void turnFaceUp()
	{
		isFaceUp = true;
	}
	public String toString(){
		return getFaceW()+getSuitW();
	}
	// This method records that only the back of the card should be visible.
	public void turnFaceDown()
	{
		isFaceUp =false;
	}
}
