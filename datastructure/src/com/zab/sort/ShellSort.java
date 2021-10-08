package com.zab.sort;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 希尔排序--交换法
	 *
	 * @param arr 数组
	 * @author <1254087415@qq.com>
	 * @since 2021/10/8 21:41
	 */
	public static void shellSort(int[] arr) {
		int temp = 0;
		int count = 0;
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 第一轮排序
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
			System.out.println("第"+(++count)+"轮希尔排序为：");
			System.out.println(Arrays.toString(arr));
		}
	}
	
	/**
	 * 希尔排序--移位法
	 *
	 * @param arr 排序数组
	 */
	public static void shellSort2(int[] arr) {
		
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				// 保存当前的位置
				int j = i;
				// 保存当前位置值
				int temp = arr[j];
				// 查找插入的位置
				while (j - gap >= 0 && temp < arr[j - gap]) {
					arr[j] = arr[j - gap];
					j -= gap;
				}
				// 当while循环完就是找到插入的位置
				arr[j] = temp;
			}
		}
	}
	
}
