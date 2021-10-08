package com.zab.stack;

import java.util.Scanner;

/**
 * 测试类
 */
public class LinkedStackDemo {

	public static void main(String[] args) {
		LinkedStack stack = new LinkedStack();
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
 * 链表栈类
 */
class LinkedStack {
	stackNode head = null;

	public LinkedStack() {
		head = new stackNode(null);
	}

	// 判断是否为空
	public boolean isNull() {
		return head.next == null;
	}

	// 入栈
	public void push(int data) {
		stackNode node = new stackNode(data);
		stackNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}

	// 出栈
	public int pop() {
		if (isNull()) {
			throw new RuntimeException("栈空");
		}
		stackNode temp = head.next;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		int value = temp.next.data;
		temp.next = null;
		return value;
	}

	// 显示栈
	public void list() {
		if (isNull()) {
			System.out.println("栈空");
			return;
		}

		stackNode temp = head;
		while (temp.next != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}

/**
 * 栈链表节点类
 */
class stackNode {
	public Integer data;
	public stackNode next;

	public stackNode(Integer data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "stackNode{" +
						"data=" + data +
						'}';
	}
}
