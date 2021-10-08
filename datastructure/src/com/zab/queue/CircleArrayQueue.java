package com.zab.queue;

import java.util.Scanner;

public class CircleArrayQueue {

	public static void main(String[] args) {
		CircleQueue arrayQueue = new CircleQueue(4);
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
						System.out.println("取出的数据是" + queue);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 'h':
					try {
						int value = arrayQueue.headget();
						System.out.println("队列头是" + value);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					break;
			}
		}
	}

}
class CircleQueue {

	private int maxSize; // 始终空出一个空间作为约定
	private int rear; // 指向队列的最后一个元素位置的后一个位置
	private int front;  // 指向队列的头元素
	private int[] arr;

	/**
	 * 创建队列的构造函数
	 * @param arrSize 添加的元素
	 */
	public CircleQueue(int arrSize) {
		maxSize = arrSize;
		arr = new int[arrSize];
		// front和arr默认为0
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	// 判断队列是否满了
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	/**
	 * 添加元素进队列
	 * @param element 添加进队列的元素
	 */
	public void addQueue(int element) {
		if (isFull()) {
			System.out.println("队列满了，不能添加元素");
			return;
		}

		arr[rear] = element;
		rear = (rear + 1) % maxSize;
	}

	/**
	 * 从队列中去除元素
	 * @return 取出的元素
	 */
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空，不能取出数据");
		}
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	// 显示列表的全部数据
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列是空的，没有数据~~");
			return;
		}

		// 应该循环有效个数
		for (int i = front; i < front + size(); i++) System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);

	}

	// 返回
	public int headget() {
		if (isEmpty()) {
			throw new RuntimeException("队列是空的，没有数据");
		}
		return arr[front];
	}

	/**
	 * 返回有效的队列数据
	 * @return 有效队列数据的个数
	 */
	public int size() {
		// System.out.println("有效个数为："+(rear + maxSize - front) % maxSize);
		return (rear + maxSize - front) % maxSize;
	}


}
