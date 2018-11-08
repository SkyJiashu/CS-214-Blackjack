package CS111MS4;
public class Blackjack
{
	// This method should:
	//	- Ask the user how many people want to play (up to 3, not including the dealer).
	//	- Create an array of players.
	//	- Create a Blackjack window.
	// 	- Play rounds until the players want to quit the game.
	//	- Close the window.
	public static void main(String[] args)
	{   
		int playerNum=0;
		String[] playerNames;
		Player[] players;
		while(true){
		playerNum = GIO.readInt("How many people want to play? (Up to 3)");
		if(playerNum>3){
		GIO.displayMessage("Player should not more than 3, enter again");
		continue;
		}
		else{
		break;
		}
		}
		players = new Player[playerNum + 1];
     	playerNames = new String[playerNum+1];
		boolean[] isDealer = new boolean[playerNum+1];
		playerNames[0] = "Dealer";
		isDealer[0] = true;
		for (int i = 1; i <= playerNum; i++)
		{
		playerNames[i] = GIO.readString("What is "+i+" player's name?");
		isDealer[i] = false;
		}	
		
		for (int i = 0; i <= playerNum; i++)
		{
		players[i] = new Player(playerNames[i],isDealer[i]);
		} 
		
		BlackjackWindow window = new BlackjackWindow(players);
		window.redraw();
		while (true)
		{
		playRound(players,window);
			boolean playagain = GIO.readBoolean("Do you want to play again?");
			if (playagain==false)
			{
				window.close();
				break;
			}
		}
	}

	// This method executes an single round of play (for all players).  It should:
	//	- Create and shuffle a deck of cards.
	//	- Start the round (deal cards) for each player, then the dealer.
	//	- Allow each player to play, then the dealer.
	//	- Finish the round (announce results) for each player.
	
	public static void playRound(Player[] players, BlackjackWindow window)
	{
		Deck deck = new Deck();
		deck.shuffle();
		
		for (int i = 1; i < players.length; i++)
		{
		players[i].startRound(deck, window);
		}
		players[0].startRound(deck, window);
		
		for (int i = 1; i < players.length; i++)
		{
			players[i].playRound(deck, window); //While points are 21, automatically go to next player round.
		}
		
		players[0].playRound(deck, window);
		
		for (int i = 1; i < players.length; i++)
		{
			players[i].finishRound(players[0].getHand().getScore(), window);
		}
		
		players[0].finishRound(players[0].getHand().getScore(), window);

	}
}