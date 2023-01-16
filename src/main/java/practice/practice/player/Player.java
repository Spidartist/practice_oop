package practice.practice.player;

import practice.practice.dice.Dice;

public class Player {
	
	private String name;
	private int currentScore;
	private boolean isBot;
	private Dice dice;
	
	
	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	public void whenFall() {
		if (this.isBot) {
			System.out.println(this.name + " ta day se tro lai!!!");
		}else {
			System.out.println(this.name + " haizz");
		}
	}
	
	public int goDice() {
		int res = this.dice.play();
		return res;
	}
	
	public Player(String name, boolean isBot, int weightDice) {
		this.name = name;
		this.currentScore = 0;
		this.isBot = isBot;
		this.dice = new Dice(weightDice);
	}
	
	public static void main(String[] args) {
		Player player = new Player("Quan", false, 1);
		System.out.println(player.goDice());
	}

	public String getName() {
		return name;
	}

	public boolean getIsBot() {
		return isBot;
	}

	public Dice getDice() {
		return dice;
	}
	
	

}
