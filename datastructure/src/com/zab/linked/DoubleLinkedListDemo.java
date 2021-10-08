package com.zab.linked;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {

		Node hero1 = new Node(1, "宋江", "及时雨");
		Node hero2 = new Node(2, "卢俊义", "玉麒麟");
		Node hero3 = new Node(3, "吴用", "智多星");
		Node hero4 = new Node(4, "林冲", "豹子头");
		Node hero5 = new Node(5, "卢哈哈", "傻逼");

		DoubleLinkedList dll = new DoubleLinkedList();

		// 添加元素到链表尾部
		/*dll.addLast(hero1);
		dll.addLast(hero2);
		dll.addLast(hero3);
		dll.addLast(hero4);*/

		dll.addByNo(hero1);
		dll.addByNo(hero3);
		dll.addByNo(hero2);
		dll.addByNo(hero4);

		// 打印链表
		dll.list();

		// 修改链表
		Node updateNode = new Node(4, "小冲冲", "愣头青");
		dll.update(updateNode);

		System.out.println("------------------修改后的链表------------------");
		dll.list();

		// 删除链表
		dll.delete(4);
		System.out.println("------------------删除后的链表------------------");
		dll.list();

		//
	}


}

class DoubleLinkedList {
	// 头结点
	Node head = new Node(0, "", "");

	public Node getHead() {
		return head;
	}

	/**
	 * 输出链表
	 */
	public void list() {
		if (head.next == null) {
			System.out.println();
			return;
		}
		Node temp = head.next;
		while (temp != null) {
			System.out.println(temp);
			temp = temp.next;
		}
	}


	/**
	 * 添加结点到双向链表的末尾
	 *
	 * @param node 添加的结点
	 */
	public void addLast(Node node) {
		// 定义一个可变结点
		Node temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = node;
		node.pre = temp;
	}

	public void addByNo(Node node) {
		// 定义一个可变结点
		Node temp = head;
		boolean flag = false; // 编号是否重复

		while (true) {
			if (temp.no == node.no) {
				flag = true;
				break;
			}
			if (temp.next == null) {
				break;
			}
			if (temp.next.no > node.no) {
				break;
			}
			temp = temp.next;
		}

		if (flag) {
			System.out.println("编号已存在");
		} else {
			if (temp.next != null) {// 如果在链表中间
				node.next = temp.next;
				temp.next.pre = node;
				temp.next = node;
				node.pre = temp;
			}

			// 在链表尾部
			temp.next = node;
			node.pre = temp;
		}
	}

	/**
	 * 对双向链表的节点进行修改
	 *
	 * @param node 修改的结点信息
	 */
	public void update(Node node) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}

		Node temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) { // 已经到了链表的末尾
				break;
			}
			if (temp.no == node.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// 找到了结点
		if (flag) {
			temp.name = node.name;
			temp.nickName = node.nickName;
		} else {
			System.out.println("没有找到此节点");
		}
	}

	/**
	 * 删除链表中的结点
	 *
	 * @param no 要删除的结点
	 */
	public void delete(int no) {
		Node temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) { // 已经到链表结尾
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}

		if (flag) {
			temp.pre.next = temp.next;
			// 如果删除的为最后一个节点，必须做判断，不然会报空指针异常
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.println("没有找到该链表，无法删除");
		}
	}

}


// 双向链表的结点
class Node {
	public int no;
	public String name;
	public String nickName;
	public Node next; // 指向下一个结点
	public Node pre;

	public Node(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "Node{" +
						"no=" + no +
						", name='" + name + '\'' +
						", nickName='" + nickName + '\'' +
						// ", next=" + next +
						// ", pre=" + pre +
						'}';
	}
}
