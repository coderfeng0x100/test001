package com.opensource.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumerModelBlockingQueue {
	
	private BlockingQueue<String> resourceQueue = new LinkedBlockingQueue<>(1);
	

	public void put(String str) {

		try {
			resourceQueue.put(str);
			System.out.println(Thread.currentThread().getName() + "-->" + str);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 

	}

	private String get() {
		String str = "";
		try {
			str = resourceQueue.take();
			System.err.println(Thread.currentThread().getName() + "-->" + str);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return str;
	}

	public static void main(String[] args) {

		final ProducerAndConsumerModelBlockingQueue pacmbq = new ProducerAndConsumerModelBlockingQueue();

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						pacmbq.put("商品编号——" + new Random().nextInt(100000000));
					}
				}
			}, "生产者线程" + i).start();
		}

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						pacmbq.get();
					}
				}
			}, "消费者线程" + i).start();
		}

	}

}
