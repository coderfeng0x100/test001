package com.opensource.thread;

import java.util.Stack;

public class TwoStackToQueue {
	
	public Stack<Integer> stack1 = new Stack<>();
	
	public Stack<Integer> stack2 = new Stack<>();
	
	
	public void push(Integer item) {
		stack1.push(item);
	}
	
	
	public Integer pop() {
		
		if(stack2.size() == 0) {
			while (stack1.size() > 0) {
				stack2.push(stack1.pop());
			}
		}
		
		if(stack2.isEmpty()) return null;
		
        return stack2.pop();
		
	}
	
	public static void main(String[] args) {
		TwoStackToQueue tst = new TwoStackToQueue();
		tst.push(0);
		tst.push(1);
		System.out.println(tst.pop());
		System.out.println(tst.pop());
	}

}
