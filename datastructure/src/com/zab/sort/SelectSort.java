package com.zab.sort;

import java.util.Arrays;

public class SelectSort {
	public static void main(String[] args) {
		int[] arr = {101, 34, 119, 2};
		selectSort(arr);
		
	}
	
	/**
	 * 选择排序
	 *
	 * @param arr 排序的数据
	 */
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			int min = arr[i];
			
			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {
					minIndex = j;
					min = arr[j];
				}
			}
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
			System.out.println("第" + (i + 1) + "轮数组");
			System.out.println(Arrays.toString(arr));
		}
	}
}
