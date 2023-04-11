package card.game;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Game {
	public static void playGame() throws IOException {
		System.out.println("Hello - Welcome to the Card Game!");
	    System.out.println("What is your username?");
	    BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
	    String name = reader.readLine();
	    System.out.println(name+" added to game");
	    Player player = new Player(name,0);
	    boolean playAgain = true;
	    while(playAgain) {
		    playTurn(player);
		    System.out.print("Play again? Y or N");
		    System.out.println();
		    String option = reader.readLine();
		    if(option.equalsIgnoreCase("Y")) {
		    	playAgain = true;
		    }else if(option.equalsIgnoreCase("N")) {
		    	playAgain = false;
		    	break;
		    }
		    else {
		    	System.out.println("Input value is invalid");
		    }
	    }
	    
	}
	   private static int playTurn(Player player) throws IOException {
		   BufferedReader turnInput = new BufferedReader(
		            new InputStreamReader(System.in));
		      Deck deck = new Deck(); 
		      Card currentCard;  
		      Card nextCard;   
		      int correctGuesses ;  
		      String guess = null;  
		      deck.makeNewDeck();
		      deck.shuffle();  

		      correctGuesses = 0;
		      currentCard = deck.dealCard();
		      System.out.println(player.getUserName() + " your first card is the " + currentCard);
		      
		      while (true) { 
		         System.out.print("Is the next card higher or lower than "+ currentCard + " 'H' is higher 'L' is lower");
		         System.out.println();
	             guess = turnInput.readLine();
		         while (!guess.equalsIgnoreCase("H") && !guess.equalsIgnoreCase("L")) {
		             if (!guess.equalsIgnoreCase("H") && !guess.equalsIgnoreCase("L")) {
		                System.out.print("Only H and L are valid input");
		             }
		         } 
		         nextCard = deck.dealCard();
		         System.out.println("The next card from the deck is " + nextCard);
		         
		         
		         if (nextCard.getRank() == currentCard.getRank()) {
		            System.out.println("The value is the same as the previous card, you get another chance");
		         }
		         else if (nextCard.getRank() > currentCard.getRank()) {
		            if (guess.equalsIgnoreCase("H")) {
		                System.out.println("Correct");
		                correctGuesses++;
		            }
		            else {
		                System.out.println("Incorrect");
		                break;  
		            }
		         } else { 
		            if (guess.equalsIgnoreCase("L")) {
		                System.out.println("Correct");
		                correctGuesses++;
		            }
		            else {
		                System.out.println("Incorrect");
		                break;  
		            }
		         }
		         currentCard = nextCard;
		         System.out.println("Current score is: " + correctGuesses+ ".Cards left in the deck "+ deck.currentDeck.size());
		      } 
		      
		      System.out.println();
		      System.out.println("The game is over.");
		      System.out.println("You score is  " + correctGuesses);
		      if(player.getHighScore()<correctGuesses) {
		    	  player.setHighScore(correctGuesses); 
		      }
		      System.out.println();
		      return correctGuesses; 
		   } 
		   
}
