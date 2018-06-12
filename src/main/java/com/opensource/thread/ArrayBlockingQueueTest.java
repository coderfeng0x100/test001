package com.opensource.thread;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest {
	
	public static void main(String[] args) {
		
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
		
		queue.add(0);
		queue.add(1);
		//queue.add(2);
		
		
		System.out.println(queue.offer(0));
		System.out.println(queue.offer(1));
		System.out.println(queue.offer(2));
		
		try {
			queue.put(0);
			queue.put(1);
			queue.put(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println(queue.remove());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
		try {
			System.out.println(queue.take());
			System.out.println(queue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		
	}

}
