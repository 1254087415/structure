package com.zab.sort;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {101, 34, 119, 2};
		insertSort(arr);
	}
	
	
	public static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			//
			int insertVal = arr[i]; //待插入的元素
			int insertIndex = i - 1; // 插入元素的前一个元素下标
			
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex--;
			}
			
			arr[insertIndex + 1] = insertVal;
			
			System.out.println("第" +(i)+"轮：");
			System.out.println(Arrays.toString(arr));
		}
	}
}
