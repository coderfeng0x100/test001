package com.opensource.map;

import java.util.HashMap;
import java.util.Map;

public class TwoArray {

	public static void main(String[] args) {
		
		int search_num = 5;

		int[][] array_2 = { 
				{ 15, 17, 33, 45 }, 
				{ 16, 27, 43, 55 }, 
				{ 18, 31, 59, 69 }, 
				{ 19, 42, 61, 76 } 
				};
		System.out.println(search_2(array_2, search_num));
	}
	
	
	public static Map<String,Integer> search_2(int[][] array_2,int search_num) {
		
		Map<String,Integer> resultMap = new HashMap<String,Integer>();

		for (int i = array_2.length - 1; i >= 0; i--) {

			int[] array_1 = array_2[i];
			if (array_1[0] > search_num) continue;
			int j;
			if ((j = search_1(array_1, search_num)) != -1) {
				resultMap.put("i", i);
				resultMap.put("j", j);
				return resultMap;
			}

		}
		return null;
	}
	
	public static int search_1(int[] array_1,int search_num) {
		
		int start_index = 0;
		int end_index = array_1.length -1;
		
		while (start_index <= end_index) {
			
			int mid_index = (start_index + end_index) / 2;
			if(search_num == array_1[mid_index]) {
				return mid_index;
			}else if (search_num > array_1[mid_index]) {
				start_index = mid_index + 1;
			}else {
				end_index = mid_index - 1;
			}
		}
		return -1;
	}

}
