package com.javarush.task.task25.task2504;

/*
Switch for threads
*/

public class Solution {
	public static void processThreads(Thread... threads) {
		for (Thread thread : threads) {
			switch (thread.getState()) {
			case NEW:
				thread.start();
				break;
			case RUNNABLE:
				thread.isInterrupted();
				break;
			case WAITING:
				thread.interrupt();
				break;
			case BLOCKED:
				thread.interrupt();
				break;
			case TIMED_WAITING:
				thread.interrupt();
				break;
			case TERMINATED:
				System.out.println(thread.getPriority());
				break;
			}
		}
		// implement this method - implement this method
	}

	public static void main(String[] args) {
	}
}
