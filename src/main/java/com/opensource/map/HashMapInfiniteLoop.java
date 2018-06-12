package com.opensource.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HashMapInfiniteLoop {

	private static void add_01(int a) {

		a += 1;
		System.out.println(a);
	}

	private static void add_02(Integer b) {

		int sum = b.sum(b, 1);
		System.out.println(b);
	}

	public static void main(String[] args) {

		Integer a = 12;
		Integer b = 12;
		

		
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
	}

}
