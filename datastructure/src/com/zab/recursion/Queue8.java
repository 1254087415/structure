package com.zab.recursion;

public class Queue8 {
	int max = 8;
	int[] array = new int[max];
	static int count;
	
	public static void main(String[] args) {
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.printf("运行的次数是%d", count);
	}
	
	public void check(int n) {
		if (n == max) {
			print();
			return;
		}
		for (int i = 0; i < max; i++) {
			array[n] = i;
			if (judge(n)) {
				check(n + 1);
			}
		}
	}
	
	/**
	 * 检测当前位置是否可以放置
	 *
	 * @param n 第几个皇后
	 * @return 是否可以放置
	 */
	public boolean judge(int n) {
		for (int i = 0; i < n; i++) {
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}
	
	public void print() {
		count++;
		for (int i : array) {
			System.out.printf("%d", i);
		}
		System.out.println();
	}
}



