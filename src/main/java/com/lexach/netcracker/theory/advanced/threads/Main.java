package com.lexach.netcracker.theory.advanced.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	static int i;

	public static void Main(String[] args) {
		/*
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();

		t1.run();
		t2.run();
		*/

		ExecutorService executorService = Executors.newFixedThreadPool(4);

		List<Future<String>> result = new ArrayList<>();
		for (int j = 0; j < 7; j++) {
			result.add(executorService.submit(new MyTaskWithResult()));
		}

		while(true) {
			boolean flag = true;

			for (Future<String> r : result) {

			}
		}
	}
}
