package com.opensource.algorithm;

public class BinarySearch {

	public static int action_01(int targetNum, int[] array) {

		int length = array.length;
		if (length <= 0) return -1;


		int startIndex = 0;
		int endIndex = length - 1;

		while (startIndex < endIndex) {
			int midIndex = (startIndex + endIndex) / 2;
			if (targetNum == array[midIndex]) {
				return midIndex;
			} else if (targetNum < array[midIndex]) {
				endIndex = midIndex;
			} else {
				startIndex = midIndex;
			}
		}
		return -1;
	}

	public static int action_02(int targetNum, int[] array,int startIndex,int endIndex) {

		int length = array.length;
		if (length <= 0) return -1;
		
		int midIndex = (startIndex + endIndex) / 2;
		
		if(targetNum == array[midIndex]) { 
			return midIndex;
		}else if(targetNum < array[midIndex]){
			action_02(targetNum,array,startIndex,midIndex-1);
		}else {
			action_02(targetNum,array,midIndex-1,endIndex);
		}
		
		return -1;
		
	}

}
