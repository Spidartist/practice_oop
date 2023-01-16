package practice.practice.dice;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;


public class Dice {
	
	private List<Integer> number = new ArrayList<Integer>();
	
	public int play() {
		Random rand = new Random();
		int res = rand.nextInt(100);
		int retVal;
		if (res <= 19) {
			retVal = this.number.get(0);
		}else if (res > 19 && res <= 35) {
			retVal = this.number.get(1);
		}else if (res > 35 && res <= 51) {
			retVal = this.number.get(2);
		}else if (res > 51 && res <= 67) {
			retVal = this.number.get(3);
		}else if (res > 67 && res <= 83) {
			retVal = this.number.get(4);
		}else {
			retVal = this.number.get(5);
		}
		return retVal;
	}
	
	
	public List<Integer> getNumber() {
		return number;
	}


	public Dice(int weightDice) {
		number.add(weightDice);
		for (int i=1;i<=6;i++) {
			if (i!=weightDice) {
				number.add(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Dice dice = new Dice(4);
		for (int i: dice.number) {
			System.out.println(i);
		}
	}

}
