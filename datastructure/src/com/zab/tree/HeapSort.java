package com.zab.tree;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = new int[]{4, 6, 8, 5, 9,-1,90,-99};
		heapSort(arr);
	}
	
	
	public static void heapSort(int arr[]) {
		int temp = 0;
		System.out.println("堆排序");
		
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adjustHeap(arr, i, arr.length);
		}
		
		for (int j = arr.length - 1; j > 0; j--) {
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			
			adjustHeap(arr, 0, j);
		}
		System.out.println("第一次" + Arrays.toString(arr));
		
	}
	
	/**
	 * 将数据构建成大顶堆的方法
	 *
	 * @param arr 待调整的数组
	 * @param i 非叶子节点在数组的索引
	 * @param length 调整的数组长度
	 * @return void
	 * @author <1254087415@qq.com>
	 * @since 2022/8/2 21:33
	 */
	public static void adjustHeap(int[] arr, int i, int length) {
		// 保存叶子节点的值
		int temp = arr[i];
		
		// k表示为i的左子树
		for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
			if (k + 1 < length && arr[k] < arr[k + 1]) {
				// 使得k节点指向右节点
				k++;
			}
			if (arr[k] > temp) {
				arr[i] = arr[k];
				i = k;
			} else {
				break;
			}
		}
		
		arr[i] = temp;
	}
	
}
