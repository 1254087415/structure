package com.zab.stack;

public class Calculator {
	public static void main(String[] args)     {
		String expreession = "10+2*6-2";
		// 创建两个栈，数栈，一个符号栈
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);

		int index = 0; //用于扫描
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' '; //将每次扫描得到的char保存到ch

		String keepNum = "";

		while (true) {
			ch = expreession.substring(index, index + 1).charAt(0);
			if (operStack.isOper(ch)) { // 是运算符的情况
				// 判断符号栈是否为空
				if (!operStack.isNull()) {
					// 如果符号栈有操作符，就进行比较；
					// 如果当前操作当前的优先级小于或等于栈中的运算符，就需要从数栈中pop出两个数，从符号栈中pop出一个符号，进行运算，并得到结果，入数栈，然后将当前的操作符入符号栈
					if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						// 把运算的结果入栈0
						numStack.push(res);
						operStack.push(ch);
					} else {
						operStack.push(ch);
					}
				} else {
					operStack.push(ch);
				}
			} else { // 是数字的情况
				// 则直接入栈
				// numStack.push(ch - 48);

				// 如果是多位数

				// 1. 当处理多位数时，不能发现是一个数就立刻入栈，因为他可能是多位数
				// 2. 在处理数，需要想expression的表达式的index，后再看以为，如果是数就进行扫描，如果是符号才入栈
				// 3. 因此我们需要定义一个变量 字符串，用于拼接

				// 处理多位数
				keepNum += ch;

				// 如果ch已经是expression是最后一位，就直接入栈
				if (index == expreession.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				} else {
					// 判断下一个字符不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
					if (operStack.isOper(expreession.substring(index + 1, index + 2).charAt(0))) {
						// 是运算符
						numStack.push(Integer.parseInt(keepNum));
						// 重要的！！！ keepNum清空
						keepNum = "";
					}
				}
			}

			// 让index + 1
			index++;
			if (index >= expreession.length()) {
				break;
			}
		}

		while (true) {
			if (operStack.isNull()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			// 把运算的结果入栈
			numStack.push(res);
		}
		
		System.out.printf("表达是%s = %d", expreession, numStack.pop());
	}
}


/**
 * 数组栈类
 */
class ArrayStack2 { // 扩展功能
	private final int maxSize;
	private final int[] stack;
	private int top = -1;

	public ArrayStack2(int maxSize) {
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

	// 返回运算符优先级,优先级使用数字表示
	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1; // 假定当前的表达式只有+，-,*,/
		}
	}

	// 是否是运算符
	public boolean isOper(char oper) {
		return oper == '*' || oper == '-' || oper == '+' || oper == '/';
	}

	// 计算返回
	public int cal(int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {
			case '+':
				res = num1 + num2;
				break;
			case '-':
				res = num2 - num1;
				break;
			case '*':
				res = num1 * num2;
				break;
			case '/':
				res = num2 / num1;
				break;
			default:
				break;
		}
		return res;
	}

	// 返回栈顶的值
	public int peek() {
		return stack[0];
	}

}
