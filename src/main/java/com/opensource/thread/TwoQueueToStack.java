package com.opensource.thread;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueToStack {
	
	public Queue<Integer> queue1 = new LinkedList<Integer>();

	public Queue<Integer> queue2 = new LinkedList<Integer>();
	
	/**
	 *压栈
	 * @param item
	 */
	public void push(Integer item) {
		
		if (0 == queue1.size() && 0 == queue2.size()) {
			queue1.offer(item);
		}else if (queue1.size() > 0 && 0 == queue2.size()) {
			queue1.offer(item);
		}else if(0 == queue1.size() && queue2.size() > 0) {
			queue2.offer(item);
		}
	}
	/**
	 * 出栈
	 * @return
	 */
	public Integer pop() {
		
		if (queue1.size() > 0 && 0 == queue2.size()) {
			while (queue1.size() > 1) {
				queue2.offer(queue1.poll());
			}
			return queue1.poll();
		}else if (0 == queue1.size() && queue2.size() > 0) {
			while (queue2.size() > 1) {
				queue1.offer(queue2.poll());
			}
			return queue2.poll();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		TwoQueueToStack tqs = new TwoQueueToStack();
		
		tqs.push(0);
		tqs.push(1);
		
		System.out.println(tqs.pop());
		System.out.println(tqs.pop());
	}
}
