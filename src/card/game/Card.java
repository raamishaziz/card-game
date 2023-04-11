package card.game;

public class Card {
	private String suite;
	private int rank;
    public final static String SPADES = "SPADES";
    public final static String HEARTS = "HEARTS";
    public final static String DIAMONDS = "DIAMONDS";
    public final static String CLUBS = "CLUBS";
    public Card(int rank,String suite) {
		this.setSuite(suite);
		this.setRank(rank);
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(rankAsString(rank));
		builder.append(" of ");
		builder.append(suite);
		return builder.toString();
	}
	public String rankAsString(int rank) {
		if(rank==1) {
			return "Ace";
		}
		else if(rank ==11) {
			return "Jack";

		}
		else if(rank ==12) {
			return "Queen";

		}
		else if (rank ==13) {
			return "King";

		}
		else {
			return String.valueOf(rank);
		}
	}
}
