package com.opensource.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumerModelReentrantLock {
	
	ReentrantLock lock = new ReentrantLock();
	
	Condition producer = lock.newCondition();
	Condition consumer = lock.newCondition();

	private List<String> container = new ArrayList<>(1);
	

	public void put(String str) {

		try {
			lock.lock();
			if (!container.isEmpty()) {
				producer.await();
			}
			container.add(str);
			System.out.println(Thread.currentThread().getName() + "-->" + str);
			consumer.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	private String get() {
		
			String str = "";
			try {
				lock.lock();
				if (container.isEmpty()) {
					consumer.await();
				}
				str = container.remove(0);
				System.err.println(Thread.currentThread().getName() + "-->" + str);
				producer.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
			return str;
		
	}

	public static void main(String[] args) {

		final ProducerAndConsumerModelReentrantLock pacmrl = new ProducerAndConsumerModelReentrantLock();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					pacmrl.put(i + "");
				}
			}
		}, "生产者线程01").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					pacmrl.get();
				}
			}
		}, "消费者线程01").start();

	}

}
