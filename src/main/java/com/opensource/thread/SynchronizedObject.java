package com.opensource.thread;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SynchronizedObject {

	public void synchronizedMethod_01() {
		synchronized (this) {
			try {
				this.wait();
				System.out.println("-------synchronizedMethod_01-------" + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void synchronizedMethod_02() {
		synchronized (this) {
			try {
				System.out.println("-------synchronizedMethod_02-------" + Thread.currentThread().getName());
				Thread.sleep(100);
				this.notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void synchronizedMethod_03() {
		synchronized (this) {
			try {
				this.wait();
				System.out.println("-------synchronizedMethod_03-------" + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		/*
		 * final SynchronizedObject so = new SynchronizedObject();
		 * 
		 * new Thread(new Runnable() {
		 * 
		 * @Override public void run() { so.synchronizedMethod_01(); } }, "t1").start();
		 * 
		 * new Thread(new Runnable() {
		 * 
		 * @Override public void run() { so.synchronizedMethod_03(); } }, "t3").start();
		 * 
		 * new Thread(new Runnable() {
		 * 
		 * @Override public void run() { so.synchronizedMethod_02(); } }, "t2").start();
		 */

		/*
		 * ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS,
		 * new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());
		 * 
		 * pool.execute(new Runnable() {
		 * 
		 * @Override public void run() { try { Thread.sleep(5000);
		 * System.out.println("任务1"+Thread.currentThread().getName()); } catch
		 * (InterruptedException e) { e.printStackTrace(); } } });
		 * 
		 * pool.execute(new Runnable() {
		 * 
		 * @Override public void run() { try { Thread.sleep(3000);
		 * System.out.println("任务2"+Thread.currentThread().getName()); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } });
		 * 
		 * pool.execute(new Runnable() {
		 * 
		 * @Override public void run() { try { Thread.sleep(1000);
		 * System.out.println("任务3"+Thread.currentThread().getName()); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } });
		 * 
		 * pool.shutdown();
		 */

		/*
		 * SynchronousQueue<Integer> sq = new SynchronousQueue<>(true);
		 * 
		 * sq.size();
		 * 
		 * new ArrayBlockingQueue<>(10).size();
		 * 
		 * 
		 * new LinkedBlockingQueue<>().size();
		 * 
		 * 
		 * new Thread(new Runnable() {
		 * 
		 * @Override public void run() { try { sq.put(1); } catch (InterruptedException
		 * e) { e.printStackTrace(); } } }).start();
		 * 
		 * new Thread(new Runnable() {
		 * 
		 * @Override public void run() { try { sq.put(2); } catch (InterruptedException
		 * e) { e.printStackTrace(); } } }).start();
		 * 
		 * new Thread(new Runnable() {
		 * 
		 * @Override public void run() { try {
		 * 
		 * System.out.println(sq.take()); } catch (InterruptedException e) {
		 * e.printStackTrace(); } } }).start();
		 * 
		 * new Thread(new Runnable() {
		 * 
		 * @Override public void run() { try {
		 * 
		 * System.out.println(sq.take()); } catch (InterruptedException e) {
		 * e.printStackTrace(); } } }).start();
		 */

		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 2, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				
				return new Thread(r, "t"+UUID.randomUUID());
			}
		});

		pool.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("-------renwu01-------" + Thread.currentThread().getName());
			}
		});

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		pool.execute(new Runnable() {

			@Override
			public void run() {
				System.out.println("-------renwu02-------" + Thread.currentThread().getName());

			}
		});

	}
}
