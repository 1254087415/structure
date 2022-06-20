package com.zab.tree;

public class ArrayBinaryTreeDemo {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
		// 前序遍历
		arrayBinaryTree.preOrder(); // 1,2,4,5,3,6,7
		System.out.println();
		// 中序遍历
		arrayBinaryTree.infixOrder(); // 4251637
		System.out.println();
		// 后序遍历
		arrayBinaryTree.postOrder(); // 4526731
	}
}

class ArrayBinaryTree {
	private int[] arr;
	
	public ArrayBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	/**
	 * 顺序存储二叉树前序遍历
	 */
	public void preOrder() {
		preOrder(0);
	}
	
	public void infixOrder() {
		infixOrder(0);
	}
	
	public void postOrder() {
		postOrder(0);
	}
	
	public void preOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.print("数组为空，不能遍历");
			return;
		}
		System.out.print(arr[index]);
		if ((index * 2 + 1) < arr.length) {
			preOrder(index * 2 + 1);
		}
		if ((index * 2 + 2) < arr.length) {
			preOrder(index * 2 + 2);
		}
	}
	
	public void infixOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.print("数组为空，不能遍历");
			return;
		}
		if ((index * 2 + 1) < arr.length) {
			infixOrder(index * 2 + 1);
		}
		System.out.print(arr[index]);
		if ((index * 2 + 2) < arr.length) {
			infixOrder(index * 2 + 2);
		}
	}
	
	public void postOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.print("数组为空，不能遍历");
			return;
		}
		if ((index * 2 + 1) < arr.length) {
			postOrder(index * 2 + 1);
		}
		if ((index * 2 + 2) < arr.length) {
			postOrder(index * 2 + 2);
		}
		System.out.print(arr[index]);
	}
	
	
}