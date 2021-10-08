package com.zab.array;

public class MyArray {
	private int[] array;
	private int size;

	/**
	 * 初始化输入
	 *
	 * @param capacity 创建数组的初始长度
	 */
	public MyArray(int capacity) {
		this.array = new int[capacity];
		size = 0;
	}

	/**
	 * 数组插入元素
	 *
	 * @param index   插入元素下标
	 * @param element 插入元素个数
	 * @throws Exception 异常
	 */
	public void insert(int index, int element) throws Exception {
		// 1.判断是否下标越界
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("超出数组实际元素范围");
		}


		// 2.如果数组容量超过，进行扩容
		if (size >= array.length) {
			resize();
		}

		// 3.向右移动数组
		for (int i = size - 1; i >= index; i--) {
			array[i + 1] = array[i];
		}

		array[index] = element;
		size++;
	}

	/**
	 * 数组扩容
	 */
	public void resize() {
		int[] newArray = new int[array.length * 2];
		System.arraycopy(array, 0, newArray, 0, array.length);
		array = newArray;

	}

	/**
	 * 输出数组
	 */
	public void output() {
		for (int value : array) {
			System.out.println(value);
		}
	}

	/**
	 * 删除元素
	 * @param index  删除元素的位置
	 * @return 返回删除的元素
	 * @throws Exception 删除异常
	 */
	public int delete(int index) throws Exception {

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("超出数组实际范围");
		}
		int deleteElement = array[index];

		for (int i = index; i <= size; i++) {
			array[i] = array[i + 1];
		}
		size--;
		return deleteElement;
	}

	public static void main(String[] args) throws Exception {
		MyArray array = new MyArray(4);
		array.insert(0, 4);
		array.insert(1, 2);
		array.insert(1, 2);
		array.insert(1, 2);
		array.insert(4, 2);
		array.output();
	}
}


