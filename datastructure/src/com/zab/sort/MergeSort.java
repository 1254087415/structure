package com.zab.sort;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
		int[] temp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, temp);
		System.out.println(Arrays.toString(arr));
	}
	/**
	 * 分+和
	 *
	 * @param arr
	 * @param left
	 * @param right
	 * @param temp
	 */
	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			// 中间索引
			int mid = (left + right) / 2;
			// 向左递归进行分解
			mergeSort(arr, left, mid, temp);
			// 向右递归进行分解
			mergeSort(arr, mid + 1, right, temp);
			// 治理
			merge(arr, left, mid, right, temp);
		}
	}  /**
	 * 合并的方法
	 *
	 * @param arr 排序的原始数组
	 * @param left 左边有序序列的初始索引
	 * @param mid 中间索引
	 * @param right 右边索引
	 * @param temp 做中转的数组
	 */
	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		// 初始化i,左边有序序列初始化的索引
		int i = left;
		// 右边有序序列的初始索引
		int j = mid + 1;
		// 指向temp数组的当前索引
		int t = 0;
		// （一）
		// 先把左右两边（有序）的数组按照规则填写到temp数组中
		// 直到左右两边的有序序列，有一边处理完毕为止
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t += 1;
				i += 1;
			} else {
				temp[t] = arr[j];
				t += 1;
				j += 1;
			}
		}  // (二)
		// 把有剩余数据的一边的数据依次全部填充到temp中
		while (i <= mid) {
			temp[t] = arr[i];
			t += 1;
			i += 1;
		}
		while (j <= right) {
			temp[t] = arr[j];
			t += 1;
			j += 1;
		}
		// (三)
		// 将temp数据的元素拷贝到arr
		// 注意，并不是每次都拷贝所有
		t = 0;
		int tempLeft = left;
		while (tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t += 1;
			tempLeft += 1;
		}
		
	}
}
