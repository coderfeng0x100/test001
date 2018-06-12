package com.opensource.thread;

public class ThreadInterrupt {
	
	
	public static void main(String[] args) {
		
		Thread.currentThread().interrupt();
		
		Thread t1 = new Thread();
		
		System.out.println(Thread.interrupted());
		System.out.println(Thread.interrupted());
		
		
	}

}
