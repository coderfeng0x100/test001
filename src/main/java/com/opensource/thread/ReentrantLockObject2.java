package com.opensource.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockObject2 {

	ReentrantLock lock01 = new ReentrantLock(); 
	
	ReentrantLock lock02 = new ReentrantLock();  
	
	
	public void reentrantLockMethod01() {

		try {
			lock01.lock();
			Thread.sleep(2000);
			System.out.println("-------reentrantLockMethod01-------" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}   finally {
			lock01.unlock();
		}
	}

	public void reentrantLockMethod02() {
		try {
			lock02.lock();
			System.out.println("-------reentrantLockMethod02-------" + Thread.currentThread().getName());
		}finally {
			lock02.unlock();
		}
	}

	public static void main(String[] args) {

		ReentrantLockObject2 rlo_01 = new ReentrantLockObject2();
		
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
