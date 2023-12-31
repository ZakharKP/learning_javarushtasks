package com.javarush.task.task29.task2911;

import java.util.Random;
import java.util.Scanner;

public class Solution {
	public static boolean flagWin = false;

	public static void main(String[] args) {
		new Solution().runGame();
	}

	private void runGame() {
		Random random = new Random();
		int secret = random.nextInt(1000);
		int tryNumber = -1;
		Scanner scanner = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			System.out.printf("Attempt %d - enter a number: ", i);
			tryNumber = scanner.nextInt();
			if (tryNumber < secret)
				if (i < 10)
					System.out.println("The hidden number is greater");
			if (tryNumber > secret)
				if (i < 10)
					System.out.println("The hidden number is less");
			if (tryNumber == secret) {
				i = stopGame();
				flagWin = true;
			}
		}
		if (flagWin)
			printCongratulations(tryNumber);
		else
			printUpset();
	}

	private void printCongratulations(int number) {
		System.out.println();
		System.out.println("You guessed it!");
		System.out.println("Hidden number: " + number);
	}

	private void printUpset() {
		System.out.println();
		System.out.println("You lose!");
	}

	private int stopGame() {
		return 10;
	}
}