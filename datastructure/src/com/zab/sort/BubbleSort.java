package com.zab.sort;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = {10, -1, 31, 3};
		
		int temp = 0;
		boolean flag = false; //是否发生过交换
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			System.out.println("第" + (i + 1) + "趟排序：" + Arrays.toString(arr));
			
			if (!flag) {
				break;
			} else {
				flag = false;
			}
			
		}
	}
}
