package card.game;

public class Player {
	private String userName = null;
	private int highScore = 0;
	public Player(String userName, int highScore) {
		this.userName = userName;
		this.highScore = highScore;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getHighScore() {
		return highScore;
	}
	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
	@Override
	public String toString() {
		return getUserName() + "," + getHighScore(); 
	}
}
