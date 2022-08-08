package com.zab.tree;

import java.util.*;

public class HuffmanTree {
	public static void main(String[] args) {
		
		int[] arr = {1, 3, 6, 7, 8, 13, 29};
		
		Node root = createHuffmanTree(arr);
		
		preOrder(root);
		
	}
	
	public static Node createHuffmanTree(int[] arr) {
		
		List<Node> nodes = new ArrayList<>();
		for (int i : arr) {
			Node node = new Node(i);
			nodes.add(node);
		}
		
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			
			Node parent = new Node(leftNode.getValue() + rightNode.getValue());
			parent.setLeft(leftNode);
			parent.setRight(rightNode);
			
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	
	public static void preOrder(Node root) {
		root.preOrder();
	}
}


class Node implements Comparable<Node> {
	
	private int value;
	
	private Node left;
	
	private Node right;
	
	public Node(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public void preOrder() {
		System.out.println(this.value);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}
	
	@Override
	public int compareTo(Node o) {
		// 按照小到大排序
		return this.value - o.value;
	}
	
	@Override
	public String toString() {
		return "Node{" +
				"value=" + value +
				'}';
	}
}
