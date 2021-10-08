package com.zab.sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {-9, -1, 0, 23, -567, 70};
		quickSort(arr, 0, arr.length - 1);
		System.out.println("arr = " + Arrays.toString(arr));
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		int l = left; // 左下标
		int r = right;  // 右下标
		int pivot = arr[(left + right) / 2]; // 中轴值
		
		while (l < r) {
			// 找到左边大于pivot的值,则退出循环
			while (arr[l] < pivot) {
				l++;
			}
			while (arr[r] > pivot) {
				--r;
			}
			
			// 如果l的值大于等于r的值，退出循环
			if (l >= r) {
				break;
			}
			
			// 否则，发生交换
			int temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			
			// 如果交换完后，发现这个arr[l] == pivot 相等
			if (arr[l] == pivot) {
				r--;
			}
			if (arr[r] == pivot) {
				l++;
			}
		}
		
		if (l == r) {
			l++;
			r--;
		}
		
		if (left < r) {
			quickSort(arr, left, r);
		}
		
		if (right > l) {
			quickSort(arr, l, right);
		}
	}
}
