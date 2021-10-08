package com.zab.stack;

import java.util.*;

public class PolandNotation {
	
	public static void main(String[] args) {
		// 定义一个中缀表达式
		String InfixExpression = "10+((2+3)*4)-5";
		// 将中缀表达式转化为一个数组
		List<String> infixToList = getInfixToList(InfixExpression);
		System.out.println(infixToList);
		
		// 将中缀表达式的数组转化为逆波兰表达式数组 1 2 3 + 4 * + 5 –"
		List<String> strings = parseSuffixExpreesionList(infixToList);
		System.out.println("转化后的逆波兰表达式为：" + strings);
		
		// 定义一个逆波兰表达式
		String suffixExpression = "3 4 + 5 * 6 -";
		List<String> list = getListString(suffixExpression);
		
		int calculate = calculate(list);
		System.out.println("计算出的结果是：" + calculate);
	}
	
	/**
	 * 将一个逆波兰表达式转化为数组
	 *
	 * @param suffixExpression 逆波兰表达式
	 * @return 逆波兰表达式数组
	 */
	public static List<String> getListString(String suffixExpression) {
		String[] split = suffixExpression.split(" ");
		return new ArrayList<>(Arrays.asList(split));
	}
	
	/**
	 * 计算逆波兰表达式
	 *
	 * @param ls 逆波兰表达式数组
	 * @return 计算结果
	 */
	public static int calculate(List<String> ls) {
		Stack<Integer> stack = new Stack<>();
		for (String l : ls) {
			// 使用正则表达式匹配数字
			if (l.matches("\\d+")) {
				stack.push(Integer.valueOf(l));
			} else {
				Integer num2 = stack.pop();
				Integer num1 = stack.pop();
				int res = 0;
				switch (l) {
					case "+":
						res = num1 + num2;
						break;
					case "-":
						res = num1 - num2;
						break;
					case "*":
						res = num1 * num2;
						break;
					case "/":
						res = num1 / num2;
						break;
					default:
						throw new RuntimeException("运算符错误");
				}
				stack.push(res);
				// System.out.println(res);
			}
		}
		
		return stack.pop();
	}
	
	/**
	 * 将中缀表达式转化为数组
	 *
	 * @param Infix 中缀表达是字符串
	 * @return 中缀表达式数组
	 */
	public static List<String> getInfixToList(String Infix) {
		ArrayList<String> list = new ArrayList<>();
		String num;
		char c;
		int i = 0;
		while (i < Infix.length()){
			if ((c = Infix.charAt(i)) < 48 || (c = Infix.charAt(i)) > 57) { // 非数字的情况
				list.add("" + c);
				i++;
			} else { // 考虑多位数的情况
				num = "";
				while (i < Infix.length() && (c = Infix.charAt(i)) >= 48 && (c = Infix.charAt(i)) <= 57) {
					num += c;
					i++;
				}
				list.add(num);
			}
		}
		return list;
	}
	
	/**
	 * 将中缀表达式数组转化为后缀表达式数组
	 *
	 * @param InfixList 中缀表达式数组
	 * @return 后缀表达式数组
	 */
	public static List<String> parseSuffixExpreesionList(List<String> InfixList) {
		// 定义一个符号栈OperStack和一个中间结果数组numList
		Stack<String> OperStack = new Stack<>();
		List<String> numList = new ArrayList<>();
		int i = 0;
		for (String s : InfixList) {
			if (s.matches("\\d+")) { // 是数字直接添加进数组
				numList.add(s);
			} else if (s.equals("(")) { // 左括号直接入栈
				OperStack.add(s);
			} else if (s.equals(")")) { // 是右括号的情况
				while (!OperStack.peek().equals("(")) { // 一直弹出栈入数组直到遇到做左括号
					numList.add(OperStack.pop());
				}
				OperStack.pop(); // 清除左括号
			} else { // 是运算符的情况
				while (!OperStack.isEmpty() && Operation.getValue(OperStack.peek()) >= Operation.getValue(s)) {
					numList.add(OperStack.pop());
				}
				OperStack.push(s); // 如果栈为空或栈顶为左括号或优先级比栈顶运算符的高
			}
		}
		// 将剩余的运算符加入到数组
		while (OperStack.size() != 0) {
			numList.add(OperStack.pop());
		}
		return numList;
	}
}

/**
 * 运算符类
 */
class Operation {
	private static final int ADD = 1;
	private static final int SUB = 1;
	private static final int MUL = 2;
	private static final int DIV = 2;
	
	// 写一个方法，返回对应的优先级
	public static int getValue(String operation) {
		int result = 0;
		switch (operation) {
			case "+":
				result = ADD;
				break;
			case "-":
				result = SUB;
				break;
			case "*":
				result = MUL;
				break;
			case "/":
				result = DIV;
				break;
			default:
				System.out.println("运算符错误");
				break;
		}
		return result;
	}
}


