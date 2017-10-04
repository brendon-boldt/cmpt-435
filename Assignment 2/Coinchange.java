import java.util.Scanner;

public class Coinchange {

	public static int greedycoinchange(int givenvalue, int[] givencoins)
	{
		// Complete code here to make change of givenvalue using coins in the array givencoins
		// Minimize the number of coins used
		// Input: Coin denominations in array givencoins are already sorted in descending order
		// Output: The number of coins used to make change of givenvalue
		
		// Keep track of how many coins of each kind are used.
		int[] coins = new int[givencoins.length];
		int totalCoins = 0;
		for (int i = 0; i < givencoins.length; ++i) {
			// Record the highest number of coins for the given denomination
			coins[i] = givenvalue / givencoins[i];
			// Find the remainder
			givenvalue = givenvalue % givencoins[i];
			// Add the number of current coins to the total number of coins
			totalCoins += coins[i];
		}
		
		return totalCoins;
	}
	
	
	public static void main(String[] args) {
		int n = 0; // n cents
		
		Scanner reader = new Scanner(System.in);  
		System.out.println("Please enter the value you want to make change: ");
		n = reader.nextInt();
		reader.close();
		
		// infinite supply of quarters, dimes, nickels, and pennies
		int[] coins = {25, 10, 5, 1};
		
		System.out.println("used "+ greedycoinchange(n, coins)+" coins for "+ n + " cents");
		
//		for (; n < 50; ++n) {
//			System.out.println("used "+ greedycoinchange(n, coins)+" coins for "+ n + " cents");
//		}
		
		
	}

}
