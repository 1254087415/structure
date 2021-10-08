package com.zab.linked;

public class Josepfu {

	public static void main(String[] args) {
		CircleSinglyLinkedList cll = new CircleSinglyLinkedList();
		cll.addBoy(5);

		System.out.println("输出小孩编号");
		cll.list();

		System.out.println("小孩出队顺序：");
		cll.countBoy(1, 2, 5);

	}
}

class CircleSinglyLinkedList {
	private Boy first = null;

	/**
	 * 添加小孩节点，构成一个环形队列
	 * @param nums 小孩节点个数
	 */
	public void addBoy(int nums) {

		if (nums < 1) { // 数据校验
			System.out.println("nums的值不对");
			return;
		}

		Boy temp = null; // 辅助指针

		for (int i = 1; i <= nums; i++) {
			// 根据编号，创建小孩节点
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				first.next = first;
				temp = first;
			} else {
				temp.next = boy;
				boy.next = first;
				temp = boy;
			}
		}

	}

	/**
	 * 遍历循环环形链表
	 */
	public void list() {
		if (first == null) {
			System.out.println("链表为空，无需遍历");
			return;
		}

		Boy temp = first;
		while (true) {
			System.out.printf("小孩的编号为%d \n", temp.no);
			if (temp.next == first) {
				break;
			}
			temp = temp.next;
		}
	}

	/**
	 *  根据用户的输入，计算出小孩出圈的顺序
	 * @param startNo 从第几个小孩开始计数
	 * @param countNum 表示数几下
	 * @param nums 表示最初有多少个小孩在圈中
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("玩尼玛呢玩，参数都输错了");
			return;
		}
		// 1.定义一个辅助变量
		Boy helper = first;
		// 2.将helper指针指向链表最后一个节点
		// 到达最后的位置
		while (helper.next != first) {
			helper = helper.next;
		}

		// 3.小孩报数前，先让first和helper先移动k - 1次
		for (int i = 0; i < startNo - 1; i++) {
			first = first.next;
			helper = helper.next;
		}

		// 4.循环出圈，直到只有一个节点
		while (helper != first) {

			for (int i = 0; i < countNum - 1; i++) {
				first = first.next;
				helper = helper.next;
			}
			System.out.printf("小孩的%d出队\n", first.no);
			first = first.next;
			helper.next = first;
		}
		System.out.printf("最后小孩的编号是%d\n", first.no);


	}
}


// 创建一个boy类，表示一个节点 j
class Boy {
	public int no; // 编号
	public Boy next; // 指向下一个结点，默认为null

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Boy{" +
						"no=" + no +
						// ", next=" + next +
						'}';
	}
}


