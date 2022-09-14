package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Start amount:");
		double startAmount = scan.nextDouble();
		
		System.out.println("Win chance:");
		double winChance = scan.nextDouble();
		
		System.out.println("Win limit:");
		double winLimit = scan.nextDouble();
		
		System.out.println("Total Simulations:");
		int totalSimulations = scan.nextInt();
		double win = 0;
		double restartAmount = startAmount;
		int plays = 0;
		
		for(int i = 0; i<totalSimulations; i++) {
			startAmount = restartAmount;
			plays = 0;
		while(startAmount<winLimit && startAmount>0) {
			plays++;
			if((1-winChance)<Math.random()) {
			startAmount++;
			}
			else {
			startAmount--;
			}
		}
		System.out.println("Number of plays: "+plays);
		System.out.println("Day number: "+(i+1));
		
		if(startAmount!=0) {
			System.out.println("Day ended in: win");
			win++;
		}
		else {
			System.out.println("Day ended in: ruin");
		}
		}
		double ruinPercent =((totalSimulations-win)/totalSimulations);
		ruinPercent = Math.round(ruinPercent*100);
		
		System.out.println("Ruin percentage: "+ruinPercent+"%");
		
		double alpha = (1-winChance)/winChance;
		System.out.print(alpha);
		
		if(winChance==.5) {
			System.out.println("Expected ruin rate: "+(1-(startAmount/winLimit)));
		}
		else {
			double expectedRuin = ((Math.pow(alpha,startAmount)-Math.pow(alpha,winLimit))/(1-(Math.pow(alpha,winLimit))));
			//expectedRuin = Math.round(expectedRuin*100);
			System.out.println("Expected ruin rate: "+expectedRuin);
		}
		
		
	}

}
