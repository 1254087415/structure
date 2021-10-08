package com.zab.queue;

import sun.misc.ObjectInputFilter;

import java.util.Scanner;

public class Queue {

	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(3);
		Scanner sc = new Scanner(System.in);
		char key;
		boolean loop = true;
		while (loop) {
			System.out.println("s(show)：显示队列");
			System.out.println("a(add)：添加数据到队列");
			System.out.println("g(get)：从队列取出数据");
			System.out.println("h(head)：查看头部数据");
			System.out.println("e(exit)：退出程序");

			key = sc.next().charAt(0);  // 获取一个字符

			switch (key) {
				case 's':
					arrayQueue.showQueue();
					break;
				case 'e':
					sc.close();
					loop = false;
					break;
				case 'a':
					System.out.println("将请输入添加的元素");
					int i = sc.nextInt();
					arrayQueue.addQueue(i);
					break;
				case 'g':
					try {
						int queue = arrayQueue.getQueue();
						System.out.println("取出的数据是"+queue);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 'h':
					try {
						int value = arrayQueue.headget();
						System.out.println("队列头是"+value);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					break;
			}
		}

		System.out.println("程序退出");
	}

}


class ArrayQueue {
	private int maxSize;   // 表示数组的最大容量
 	private int rear;    // 尾指针 指向最后一个元素
	private int front;   // 头指针 指向最开始元素前的一个位置
	private int[] arr;   // 该数据用于存放数据，模拟队列

	// 1.创建队列的构造器
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[arrMaxSize];
		rear = -1;
		front = -1;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	// 判断队列是否满了
	public boolean isFull() {
		return rear < maxSize - 1;
	}

	// 添加数据入队列
	public void addQueue(int element) {
		// 判断是否满了
		if (isFull()) {
			System.out.println("队列已满，不能添加数据");
		}
		rear++;
		arr[rear] = element;
	}

	// 取出数据出队列
	public int getQueue() {
		// 判断是否为空队列
		if (isEmpty()) {
			throw new RuntimeException("队列空，不能取数据");
		}
		front++;
		return arr[front];
	}

	// 显示列表的全部数据
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列是空的，没有数据~~");
			return;
		}
		for (int i : arr) {
			System.out.println(i);
		}
	}


	public int headget() {
		if (isEmpty()) {
			throw new RuntimeException("队列是空的，没有数据");
		}
		return arr[front + 1];
	}
}