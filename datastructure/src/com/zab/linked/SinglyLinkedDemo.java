package com.zab.linked;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Stack;

public class SinglyLinkedDemo {

	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
		HeroNode hero5 = new HeroNode(5, "卢哈哈", "傻逼");

		// 加入不按照编号，在尾部添加
		SinglyLinkedList sll1 = new SinglyLinkedList();
		SinglyLinkedList sll2 = new SinglyLinkedList();

		// 加入按照顺序添加
		sll1.addByNo(hero2);
		sll1.addByNo(hero1);
		sll1.addByNo(hero4);
		System.out.println("sll1：");

		sll1.list(); // 显示链表

		sll2.addByNo(hero3);
		sll2.addByNo(hero5);

		System.out.println("sll2:");
		sll2.list();

		System.out.println("---------------------------------------");

		// 从尾到头打印链表
		/*System.out.println("从头到尾打印链表：");
		printReverseNode(sll.getHead());*/

		System.out.println("合并链表");
		HeroNode merge = mergeLink(sll1.getHead(), sll2.getHead());
		System.out.println(merge);
		System.out.println(hero1);


		// 修改数组
		// sll.update(hero5);

		/*
		sll.list();
		int length = getLength(sll.getHead());
		System.out.println(length);

		System.out.println(lastNode(sll.getHead(),1));*/

	}

	/**
	 * 方法：获取单链表的节点的个数（getLength）
	 * @param head 链表的头结点
	 * @return 返回有效结点的个数
	 */
	public static int getLength(HeroNode head) {
		if (head.next == null) {
			return 0;
		}
		HeroNode temp = head.next;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	/**
	 * 获取倒数第k个结点
	 * @param head 链表的头结点
	 * @param index 表示倒水的第index个结点
	 * @return 倒数的第index个结点
	 */
	public static HeroNode lastNode(HeroNode head, int index) {
		if (head.next == null) {
			System.out.println("链表为空");
			return null;
		}
		int length = getLength(head);

		if (index < 0 || index > length) {
			return null;
		}
		HeroNode temp = head.next;
		for (int i = 0; i < length - index;i++) {
			temp = temp.next;
		}
		return temp;
	}

	/**
	 * 反转单向链表
	 * @param head 链表的头结点
	 * 1. 新建一个节点reverseNode
	 * 2. 遍历链表，取出每一个节点，放在新节点的前面
	 * 3. 将头结点的next域指向reverseNode.next
	 */
	public static void reverseNode(HeroNode head){
		if (head.next == null || head.next.next == null) {
			System.out.println("无需反转");
			return ;
		}
		HeroNode temp = head.next;
		HeroNode next = null;
		HeroNode reverse = new HeroNode(0,"","");
		while (temp != null) {
			next = temp.next;
			temp.next = reverse.next;
			reverse.next = temp;
			temp = next;
		}
		head.next = reverse.next;
	}

	/**
	 * 从头到尾打印链表
	 * @param head 头结点
	 */
	public static void printReverseNode(HeroNode head) {
		if (head.next == null) {
			return;
		}
		Stack<HeroNode> nodes = new Stack<HeroNode>();
		HeroNode temp = head.next;
		while (temp != null) {
			nodes.add(temp);
			temp = temp.next;
		}

		while (nodes.size() > 0) {
			System.out.println(nodes.pop());
		}
	}

	/**
	 * 合并两个有序的单链表，合并之后依然有序,会修改原来的链表
	 * @param heroNode1 第一个链表
	 * @param heroNode2 第二个链表
	 * @return 合并后的链表
	 *
	 */
	public static HeroNode mergeLink(HeroNode heroNode1,HeroNode heroNode2){
		HeroNode temp1 = heroNode1.next;
		HeroNode temp2 = heroNode2.next;
		HeroNode cur = new HeroNode(0, "", "");
		HeroNode next = cur;

		while (temp1 != null && temp2 != null) {
			if (temp1.no < temp2.no) {
				next.next = temp1;
				next = temp1;
				temp1 = temp1.next;
			} else {
				next.next = temp2;
				next = temp2;
				temp2 = temp2.next;
			}
		}
		return cur;
	}
	/*public static HeroNode mergeLink(HeroNode heroNode1,HeroNode heroNode2) {
		// 1.定义一个新结点
		// 2.
		HeroNode cur1 = heroNode1.next;
		HeroNode cur2 = heroNode2.next;
		HeroNode temp = new HeroNode(0, "", "");
		HeroNode cur = temp;

		while (true){
			if(cur1 == null){
				cur.next = cur2;
				break;
			}
			if(cur2 == null){
				cur.next = cur1;
				break;
			}
			if(cur1.no<cur2.no){
				cur.next = cur1;
				cur = cur1;
				cur1 = cur1.next;
			}else{
				cur.next = cur2;
				cur = cur2;
				cur2 = cur2.next;
			}
		}
		return temp;
	}*/
}

// 定义一个链表类
class SinglyLinkedList {
	// 初始化一个头结点
	private HeroNode head = new HeroNode(0, "", "");

	public HeroNode getHead() {
		return head;
	}

	// 添加结点，直接添加到链表尾部
	/*
		1. 定义一个temp结点保存头结点
		2. 遍历链表
	*/
	public void add1(HeroNode heroNode) {
		// 头结点不能移动，所以生成一个可变结点
		HeroNode temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
	}

	// 按顺序进行添加
	/*
	1.找到对应的位置
	2. 将新节点的next域指向下一个结点
	3. 将temp.next指向新的结点
	 */
	public void addByNo(HeroNode heroNode) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no > heroNode.no) {
				break;
			}
			if (temp.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.println("编号已存在，不能添加");
		} else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	// 修改链表
	/*
	1. 找到修改的结点
	2. 修改信息
	 */
	public void update(HeroNode heroNode) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (heroNode.no == temp.no) {
				// 找到了
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = heroNode.name;
			temp.nickName = heroNode.nickName;
		} else {
			System.out.println("没有找要修改的结点");
		}
	}

	// 删除
	public void delete(int o) {
		if (head.next == null) {
			System.out.println("链表为空，无法删除");
		}
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no == o) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		} else {
			System.out.println("没有找到删除的结点");
		}
	}


	// 显示链表
	public void list() {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head.next;
		while (true) {
			if (temp == null) { // 到链表的尾部了
				break;
			}
			// 输出结点信息
			System.out.println(temp);
			// 将temp后移，一定小心
			temp = temp.next;
		}
	}
}

// 定义一个头结点
class HeroNode {
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;

	public HeroNode(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "HeroNode{" +
						"no=" + no +
						", name='" + name + '\'' +
						", nickName='" + nickName + '\'' +
						", next=" + next +
						'}';
	}
}