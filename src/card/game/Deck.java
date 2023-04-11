package card.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> currentDeck = null;

	public void shuffle() {
		Collections.shuffle(currentDeck);
	}

	public Card dealCard() {
		Card returnCard = null;
		if (isEmpty()) {
			System.out.println("Deck is empty");
			return null;
		}
		returnCard = currentDeck.get(currentDeck.size()-1);
		currentDeck.remove(currentDeck.size()-1);
		return returnCard;

	}
	public boolean isEmpty() {
		if (null == currentDeck || currentDeck.isEmpty()) {
			return true;
		}
		return false;
	}
	public void makeNewDeck() {
		currentDeck = new ArrayList<Card>();
		for ( int i = 1; i <= 13; i++ ) {
			currentDeck.add(new Card(i,Card.SPADES));
		}
		for ( int i = 1; i <= 13; i++ ) {
			currentDeck.add(new Card(i,Card.HEARTS));
		}
		for ( int i = 1; i <= 13; i++ ) {
			currentDeck.add(new Card(i,Card.DIAMONDS));
		}
		for ( int i = 1; i <= 13; i++ ) {
			currentDeck.add(new Card(i,Card.CLUBS));
		}
		setCurrentDeck(currentDeck);
	}

	public void printDeck() {
		for(Card card: currentDeck) {
			System.out.println(card);
		}
	}

	public List<Card> getCurrentDeck() {
		return currentDeck;
	}

	public void setCurrentDeck(List<Card> currentDeck) {
		this.currentDeck = currentDeck;
	}
}
