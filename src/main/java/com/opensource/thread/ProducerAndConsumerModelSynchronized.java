package com.opensource.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerAndConsumerModelSynchronized {

	private List<String> container = new ArrayList<>();

	public void put(String str) {
		synchronized (container) {
			try {
				if (!container.isEmpty()) {
					container.wait();
				}
				container.add(str);
				System.out.println(Thread.currentThread().getName() + "-->" + str);
				container.notify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private String get() {
		synchronized (container) {
			String str = "";
			try {
				if (container.isEmpty()) {
					container.wait();
				}
				str = container.remove(0);
				System.err.println(Thread.currentThread().getName() + "-->" + str);
				container.notify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) {

		final ProducerAndConsumerModelSynchronized pacms = new ProducerAndConsumerModelSynchronized();

		/*
		 * new Thread(new Runnable() {
		 * 
		 * @Override public void run() { while (true) { pacms.put("商品编号——" + new
		 * Random().nextInt(100000000)); } } }, "生产者线程01").start();
		 * 
		 * new Thread(new Runnable() {
		 * 
		 * @Override public void run() { while (true) { pacms.put("商品编号——" + new
		 * Random().nextInt(100000000)); } } }, "生产者线程02").start();
		 */

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						pacms.put("商品编号——" + new Random().nextInt(100000000));
					}
				}
			}, "生产者线程" + i).start();
		}

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						pacms.get();
					}
				}
			}, "消费者线程" + i).start();
		}

	}

}
