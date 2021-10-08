package com.zab.recursion;

public class RecursionTest {
	public static void main(String[] args) {
		// 打印
		// test(4);
		
	}
	
	// 打印的方法
	public static void test(int n) {
		if (n > 2) {
			test(n - 1);
		} else {
			System.out.println("n = " + n);
		}
	}
	
	
	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return factorial(n - 1) * n;
		}
	}
}
