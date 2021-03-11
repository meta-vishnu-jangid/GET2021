package main;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Number of Balls Virat is Going to Play : ");
		int noOfBallsViratIsGoingToPlay = scanner.nextInt();

		System.out.println("Enter Number of Bowlers: ");
		int noOfBowlers = scanner.nextInt();
		int[] noOfBallsOfBowlers = new int[noOfBowlers];
		
		for(int index = 0; index <= noOfBowlers -1; index++ ){
			System.out.println("Enter Number of Balls Left for Bowler " + (index+1) + " : ");
			noOfBallsOfBowlers[index] = scanner.nextInt();
		}
		
		Cricket cricket = new Cricket(noOfBallsViratIsGoingToPlay, noOfBallsOfBowlers);
		ArrayList<Bowler> bowlersOrder = cricket.getOrderOfBowler();
		
		System.out.println("Order of Bowlers: ");
		System.out.println("BowlerID : No Of Balls");
		for(Bowler bowler: bowlersOrder){
			System.out.println(bowler.getId() + "      :    " + bowler.getNoOfBallsLeft());
		}
	}

}
