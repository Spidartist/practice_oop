package practice.practice.controller;

import java.util.ArrayList;
import java.util.List;

import practice.practice.player.Player;

public class Controller {
	private List<Player> players = new ArrayList<Player>();
	private int currentPlayer;
	private boolean isDone;
	private int winner;
	
	public void calculateScore(int currentPlayer, int addScore) {
		Player thisPlayer = this.players.get(currentPlayer);
		int newScore = thisPlayer.getCurrentScore() + addScore;
		if (newScore > 21) {
			thisPlayer.setCurrentScore(0);
		}else {
			if (newScore == 21) {
				this.isDone = true;
				this.winner = currentPlayer;
			}
			thisPlayer.setCurrentScore(newScore);
		}
				
	}
	
	
	public Controller() {
		this.currentPlayer = 0;
		this.isDone = false;
	}


	public int getCurrentPlayer() {
		return currentPlayer;
	}


	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}


	public List<Player> getPlayers() {
		return players;
	}


	public int getWinner() {
		return winner;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	public boolean getisDone() {
		return isDone;
	}


	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	
}
