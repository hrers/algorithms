package leetcode;

import java.util.Stack;

public class test {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		Stack<Integer> stack2 = new Stack<Integer>();
		stack2=stack;
		stack2.pop();
		
		stack2.pop();
		System.out.println(stack.size());
		
	}

}
