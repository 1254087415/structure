package com.zab.tree.threadedbinaryTree;

public class ThreadedBinaryTreeDemo {
	public static void main(String[] args) {
		HeroNode root = new HeroNode(1, "tom");
		HeroNode node1 = new HeroNode(3, "jack");
		HeroNode node2 = new HeroNode(6, "smith");
		HeroNode node3 = new HeroNode(8, "mary");
		HeroNode node4 = new HeroNode(10, "king");
		HeroNode node5 = new HeroNode(14, "dim");
		
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node2.setLeft(node5);
		
		ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
		threadedBinaryTree.setRoot(root);
		
		/*// 前序线索化二叉树
		threadedBinaryTree.threadedPreNodes();
		System.out.println("8的前驱节点" + node2.getRight());*/
		
		/*// 中序线索化二叉树
		threadedBinaryTree.threadedInfixNodes();
		
		System.out.println("8的前驱节点" + node3.getLeft());
		System.out.println("8的后继节点" + node3.getRight());
		System.out.println("10的前驱节点" + node4.getLeft());
		System.out.println("6的后继节点" + node2.getRight());
		
		// 遍历中序线索二叉树
		threadedBinaryTree.threadedInfixList(); // 8 3 10 1 14 6*/
		
		// 后序线索化二叉树
		threadedBinaryTree.threadedPostNodes();
		System.out.println("10的前驱节点" + node4.getLeft());
		System.out.println("6的后驱节点" + node4.getRight());
		
		
	}
}

class ThreadedBinaryTree {
	private HeroNode root;
	// 定义节点，用于线索化二叉树记录上个节点
	private HeroNode pre;
	
	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	// 前序遍历
	public void preOrder() {
		if (root != null) {
			this.root.preOrder();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}
	
	// 中序遍历
	public void infixOrder() {
		if (root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}
	
	// 后序遍历
	public void postOrder() {
		if (root != null) {
			this.root.postOrder();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}
	
	// 前序查找
	public HeroNode preSearch(int no) {
		if (root != null) {
			return this.root.preOrderSearch(no);
		} else {
			return null;
		}
	}
	
	// 前序查找
	public HeroNode infixSearch(int no) {
		if (root != null) {
			return this.root.infixOrderSearch(no);
		} else {
			return null;
		}
	}
	
	// 后序查找
	public HeroNode postSearch(int no) {
		if (root != null) {
			return this.root.postOrderSearch(no);
		} else {
			return null;
		}
	}
	
	public void delNode(int no) {
		if (root != null) {
			if (root.getNo() == no) {
				root = null;
			} else {
				this.root.delNode(no);
			}
		} else {
			System.out.println("没有");
		}
	}
	
	public void delNodePlus(int no) {
		if (root != null) {
			if (root.getNo() == no) {
				root = null;
			} else {
				this.root.delNodePlus(no);
			}
		} else {
			System.out.println("没有");
		}
	}
	
	public void threadedInfixNodes() {
		this.threadedInfixNodes(root);
	}
	
	public void threadedPreNodes() {
		this.threadedPreNodes(root);
	}
	
	public void threadedPostNodes() {
		this.threadedPostNodes(root);
	}
	
	/**
	 * 线索化二叉树(前序)
	 *
	 * @param node
	 */
	private void threadedPreNodes(HeroNode node) {
		if (node == null) {
			return;
		}
		// 线索化左子树
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		// 如果右节点不为空，进行线索化后继节点
		if (pre != null && pre.getRight() == null) {
			// 前驱节点的右指针指向当前节点
			pre.setRight(node);
			pre.setRightType(1);
		}
		
		pre = node;
		if (node.getLeftType() == 0) {
			threadedPreNodes(node.getLeft());
		}
		if (node.getRightType() == 0) {
			// 线索化右子树
			threadedPreNodes(node.getRight());
		}
	}
	
	/**
	 * 线索化二叉树(中序)
	 *
	 * @param node
	 */
	private void threadedInfixNodes(HeroNode node) {
		if (node == null) {
			return;
		}
		
		// 线索化左子树
		threadedInfixNodes(node.getLeft());
		// 如果左节点为空的话，进行线索化为前驱节点
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		// 如果右节点不为空，进行线索化后继节点
		if (pre != null && pre.getRight() == null) {
			// 前驱节点的右指针指向当前节点
			pre.setRight(node);
			pre.setRightType(1);
		}
		
		// ！！！每处理一次节点，当前节点是下个节点的前驱节点
		pre = node;
		
		// 线索化右子树
		threadedInfixNodes(node.getRight());
	}
	
	/**
	 * 线索化二叉树(后序)
	 *
	 * @param node
	 */
	private void threadedPostNodes(HeroNode node) {
		if (node == null) {
			return;
		}
		
		// 递归线索化左子树
		threadedPostNodes(node.getLeft());
		// 递归线索化右子树
		threadedPostNodes(node.getRight());
		
		// 线索化左子树
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		// 如果右节点不为空，进行线索化后继节点
		if (pre != null && pre.getRight() == null) {
			// 前驱节点的右指针指向当前节点
			pre.setRight(node);
			pre.setRightType(1);
		}
		
		pre = node;
	}
	
	/**
	 * 遍历中序线索化二叉树
	 */
	public void threadedInfixList() {
		HeroNode node = root;
		if (node == null) {
			System.out.println("根节点为空，不能遍历");
			return;
		}
		
		while (node != null) {
			while (node.getLeftType() == 0) {
				node = node.getLeft();
			}
			// 打印最左边的节点
			System.out.print(node.getNo());
			
			while (node.getRightType() == 1) {
				node = node.getRight();
				System.out.print(node.getNo());
			}
			
			node = node.getRight();
			
		}
	}
	
	
}


class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	private int leftType;
	private int rightType;
	
	public HeroNode(int no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public int getLeftType() {
		return leftType;
	}
	
	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}
	
	public int getRightType() {
		return rightType;
	}
	
	public void setRightType(int rightType) {
		this.rightType = rightType;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public HeroNode getLeft() {
		return left;
	}
	
	public void setLeft(HeroNode left) {
		this.left = left;
	}
	
	public HeroNode getRight() {
		return right;
	}
	
	public void setRight(HeroNode right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "HeroNode{" +
				"no=" + no +
				", name='" + name + '\'' +
				'}';
	}
	
	// 前序遍历
	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}
	
	// 中序遍历
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	
	// 后序遍历
	public void postOrder() {
		if (this.right != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
	
	/**
	 * 前序查找
	 *
	 * @param no 查找的编码
	 * @return 如果找到就返回
	 */
	public HeroNode preOrderSearch(int no) {
		if (this.no == no) {
			return this;
		}
		HeroNode res = null;
		if (this.left != null) {
			res = this.left.preOrderSearch(no);
		}
		if (res != null) {
			return res;
		}
		if (this.right != null) {
			res = this.right.preOrderSearch(no);
		}
		return res;
	}
	
	/**
	 * 中序查找
	 *
	 * @param no 查找的编码
	 * @return 查找的节点
	 */
	public HeroNode infixOrderSearch(int no) {
		HeroNode res = null;
		if (this.left != null) {
			res = this.left.infixOrderSearch(no);
		}
		if (res != null) {
			return res;
		}
		if (this.no == no) {
			return this;
		}
		if (this.right != null) {
			res = this.right.infixOrderSearch(no);
		}
		return res;
	}
	
	/**
	 * 后序查找
	 *
	 * @param no 查找的编码
	 * @return 查找的节点
	 */
	public HeroNode postOrderSearch(int no) {
		HeroNode res = null;
		if (this.left != null) {
			res = this.left.postOrderSearch(no);
		}
		if (res != null) {
			return res;
		}
		if (this.right != null) {
			res = this.right.postOrderSearch(no);
		}
		if (res != null) {
			return res;
		}
		if (this.no == no) {
			return this;
		}
		return null;
	}
	
	/**
	 * 删除节点
	 *
	 * @param no 结点编号
	 */
	public void delNode(int no) {
		if (this.left != null && this.left.no == no) {
			this.left = null;
		}
		if (this.right != null && this.right.no == no) {
			this.right = null;
		}
		if (this.left != null) {
			this.left.delNode(no);
		}
		if (this.right != null) {
			this.right.delNode(no);
		}
	}
	
	public void delNodePlus(int no) {
		if (this.left != null && this.left.no == no) {
			if (this.left.left != null) {
				if (this.left.right != null) {
					this.left.left.right = this.left.right;
				}
				this.left = this.left.left;
			} else if (this.left.right != null) {
				this.left = this.left.right;
				this.left.right = null;
			} else {
				this.left = null;
			}
		}
		if (this.right != null && this.right.no == no) {
			if (this.right.left != null) {
				if (this.right.right != null) {
					this.right.left.right = this.right.right;
				}
				this.right = this.right.left;
			} else if (this.right.right != null) {
				this.right = this.right.right;
				this.right.right = null;
			} else {
				this.right = null;
			}
		}
		
		if (this.left != null) {
			this.left.delNodePlus(no);
		}
		if (this.right != null) {
			this.right.delNodePlus(no);
		}
	}
}