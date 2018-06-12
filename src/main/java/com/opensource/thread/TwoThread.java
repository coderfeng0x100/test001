package com.opensource.thread;

public class TwoThread {

	private int i = 0;
	private boolean flag = false;

	public static void main(String[] args) {

		TwoThread tt = new TwoThread();

		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (tt) {
					while (tt.i < 100) {
						if (tt.flag) {
							try {
								tt.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else {
							System.out.println(Thread.currentThread().getName() +"-->"+ (tt.i++));
							tt.flag = true;
							tt.notify();

						}
					}
				}

			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (tt) {
					while (tt.i < 100) {
						if (!tt.flag) {
							try {
								tt.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else {
							System.out.println(Thread.currentThread().getName()+"-->" + (tt.i++));
							tt.flag = false;
							tt.notify();

						}
					}
				}

			}
		}).start();

	}

}
