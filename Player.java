package CS111MS4;
// This class represents one blackjack player (or the dealer)
public class Player
{
	// define fields here
	private boolean isDealer;
	private String  playerName;
	private Hand hand;
	private int money;
	public int currentTurn;
	public boolean insurance;
	// This constructor creates a player.
	// If isDealer is true, this Player object represents the dealer.
	
	public Player(String playerName, boolean isDealer)
	{
		
		this.isDealer = isDealer;
		this.playerName = playerName;
		this.hand = new Hand();
	}

	// This method retrieves the player's name.
	public String getName()
	{
		return playerName; // replace this line with your code
	}

	// This method retrieves the player's hand of cards.
	public Hand getHand()
	{
		return hand; 
	}
	
	// This method deals two cards to the player (one face down if this is the dealer).
	// The window input should be used to redraw the window whenever a card is dealt.
	public void startRound(Deck deck, BlackjackWindow window)
	{
		Card card1 = deck.drawCard();
		Card card2 = deck.drawCard();
		if (isDealer == false) {

				card1.turnFaceUp();
				hand.addCard(card1);
				window.redraw();
				card2.turnFaceUp();
				hand.addCard(card2);
				window.redraw();
				
		}else {
			card1.turnFaceUp();
			hand.addCard(card1);
			window.redraw();

			card2.turnFaceDown();
			hand.addCard(card2);
			window.redraw();
		}
		window.redraw();
	}

	// This method executes game play for one player.
	// If this player is the dealer:
	//	- hits until score is at least 17
	// If this is an ordinary player:
	//	- repeatedly asks the user if they want to hit (draw another card)
	//	  until either the player wants to stand (not take any more cards) or
	//	  his/her score exceeds 21 (busts).
	// The window input should be used to redraw the window whenever a card is dealt or turned over.
	public void playRound(Deck deck, BlackjackWindow window)
	{
        boolean decide;
		if (isDealer == false){
			while (hand.getScore() < 21) {
				decide = GIO.readBoolean(playerName + ", do you want one more card");
				if (decide == true) {
					Card card = deck.drawCard();
					card.turnFaceUp();
					hand.addCard(card);
					System.out.println(card);
					window.redraw();
				}else {
					break;
				}
			}
			if (hand.getScore() > 21){
				GIO.displayMessage(playerName + "'s total score exceed 21!");
			}
		} 
		else{
			hand.getCard(1).turnFaceUp();
			while (hand.getScore()<17){
				Card card = deck.drawCard();
				card.turnFaceUp();
				hand.addCard(card);
				System.out.println(card);
				window.redraw();
			}			
		}
	}

	// This method informs the player about whether they won, lost, or pushed.
	// It also discards the player's cards to prepare for the next round.
	// The window input should be used to redraw the window after cards are discarded.
	public void finishRound(int dealerScore, BlackjackWindow window)
	{
		if(isDealer == false){
			if((dealerScore > 21)){
				if (hand.getScore() > 21){
					GIO.displayMessage(playerName + ", lost.");
				} else {
					GIO.displayMessage(playerName + ", win.");
				}
			}
			else{
			if (hand.getScore() > 21){
				GIO.displayMessage(playerName + ", lost.");
			}
			else if (hand.getScore()>dealerScore){
				GIO.displayMessage(playerName + ", win.");
			}
			else if(hand.getScore()==dealerScore){
				GIO.displayMessage(playerName + ", ties.");
			}
			else{
				GIO.displayMessage(playerName + ", lost.");
			}
		}
		}
		hand.discardAll();
		window.redraw();
	}
}
