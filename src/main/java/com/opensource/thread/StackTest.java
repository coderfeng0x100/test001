package com.opensource.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackTest {
	
	public static void main(String[] args) {
		
		Stack<Integer> stackInteget = new Stack<>();
		
		stackInteget.push(0);
		stackInteget.push(1);
		stackInteget.push(2);
		
		System.out.println(stackInteget.pop());
		System.out.println(stackInteget.pop());
		System.out.println(stackInteget.pop());
		
		Queue<Integer> queueInteger = new LinkedList<>();
		
		queueInteger.offer(0);
		queueInteger.offer(1);
		queueInteger.offer(2);
		
		System.out.println(queueInteger.poll());
		System.out.println(queueInteger.poll());
		System.out.println(queueInteger.poll());
	}

}
