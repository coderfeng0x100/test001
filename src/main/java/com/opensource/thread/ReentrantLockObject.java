package com.opensource.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockObject {

	ReentrantLock lock = new ReentrantLock();  
	  
	Condition condition  = lock.newCondition(); 
	Condition condition_01  = lock.newCondition();
	
	
	public void reentrantLockMethod01() {

		try {
			lock.lock();
			condition.await();
			System.out.println("-------reentrantLockMethod01-------" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void reentrantLockMethod02() {
		try {
			lock.lock();
			System.out.println("-------reentrantLockMethod02-------" + Thread.currentThread().getName());
			Thread.sleep(1000);
			condition.signal();
		}catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {

		ReentrantLockObject rlo_01 = new ReentrantLockObject();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				rlo_01.reentrantLockMethod01();
			}
		}, "t1").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				rlo_01.reentrantLockMethod02();
			}
		}, "t2").start();
	}
}
