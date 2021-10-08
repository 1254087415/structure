package com.zab.stack;

import java.util.Scanner;

/**
 * 测试类
 */
public class ArrayStackDemo {

	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(4);
		String key = "";
		boolean loop = true;
		Scanner sc = new Scanner(System.in);
		while (loop) {
			System.out.println("show:显示栈");
			System.out.println("exit:退出");
			System.out.println("push:入栈");
			System.out.println("pop:出栈");
			key = sc.next();

			switch (key) {
				case "show":
					stack.list();
					break;
				case "push":
					System.out.println("请输入一个数字");
					int value = sc.nextInt();
					stack.push(value);
					break;
				case "pop":
					try {
						int i = stack.pop();
						System.out.printf("%d元素出栈\n", i);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case "exit":
					sc.close();
					loop = false;
					break;
				default:
					break;
			}
		}
	}
}

/**
 * 数组栈类
 */
class ArrayStack {
	private final int maxSize;
	private final int[] stack;
	private int top = -1;

	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}

	public boolean isNull() {
		return top == -1;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	// 入栈
	public void push(int value) {
		if (isFull()) {
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top] = value;
	}

	// 出栈
	public int pop() {
		if (isNull()) {
			throw new RuntimeException("栈空");
		}
		int value = stack[top];
		top--;
		return value;
	}

	// 输出栈
	public void list() {

		if (isNull()) {
			System.out.println("栈空");
			return;
		}

		for (int i = top; i >= 0; i--) {
			System.out.println(stack[i]);
		}
	}
}
