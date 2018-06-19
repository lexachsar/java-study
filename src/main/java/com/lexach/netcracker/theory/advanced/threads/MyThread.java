package com.lexach.netcracker.theory.advanced.threads;

public class MyThread implements Runnable {
	private int increment = 20;


	@Override
	public void run() {
		while(increment-- > 0) {
			Main.i++;
			System.out.println(Main.i);
		}
	}

}
