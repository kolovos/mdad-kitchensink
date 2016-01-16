package com.kitchensink.util;

public class Worker {
	
	public static void work(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
