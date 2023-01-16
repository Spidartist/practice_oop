package practice.practice.app;

import java.util.Scanner;

import practice.practice.controller.Controller;
import practice.practice.player.Player;

public class Application {
	
	private int numberRealPlayer;
	private Controller controller;
	
	public Application() {
		System.out.print("Input number of player(<=4 and >=1): ");
		Scanner sc = new Scanner(System.in);
		int numberPlayer = sc.nextInt();
		while (numberPlayer > 4 || numberPlayer < 1) {
			System.out.print("Input number of player(<=4 and >=1): ");
			numberPlayer = sc.nextInt();
		}
		sc.close();
		this.numberRealPlayer = numberPlayer;
		this.controller = new Controller();
		Player p;
		for (int i=1;i<=4;i++) {
			if (i<=this.numberRealPlayer) {
				p = new Player(Integer.toString(i), false, i);
			}else {
				p = new Player(Integer.toString(i), true, i);
			}
			this.controller.getPlayers().add(p);
		}
		for (Player e: this.controller.getPlayers()) {
			System.out.println(e.getName() + " " + e.getIsBot() + " " + e.getDice().getNumber().get(0));
		}
		Player player;
		while (!this.controller.getisDone()) {
			int currentPlayer = this.controller.getCurrentPlayer();
			if (currentPlayer >= 4) {
				currentPlayer %= 4;
				this.controller.setCurrentPlayer(currentPlayer);
			}
			
			player = this.controller.getPlayers().get(currentPlayer);
			int res = player.goDice();
			this.controller.calculateScore(currentPlayer, res);
			System.out.println("Player " + Integer.toString(currentPlayer + 1) + " goDice and got " + res);
			System.out.format("%-11s%-11s%-11s%-11s\n","Player 1","|Player 2","|Player 3|","|Player 4");
			for (int i=0;i<4;i++) {
				if (i == currentPlayer) {
					System.out.printf("*%-10d", this.controller.getPlayers().get(i).getCurrentScore());
				}else {
					System.out.printf(" %-10d", this.controller.getPlayers().get(i).getCurrentScore());
				}
			}
			System.out.println("");
			if (this.controller.getisDone()) {
				System.out.println("Player " + Integer.toString(currentPlayer+1) + " la nguoi chien thang, la bo cua tat ca!!!");
			}
			
			this.controller.setCurrentPlayer(currentPlayer + 1);
		}
		for (int i=0;i<=3;i++) {
			if (i != this.controller.getWinner()) {
				this.controller.getPlayers().get(i).whenFall();
			}
		}
	}

	public static void main(String[] args) {
		new Application();
	}
}
