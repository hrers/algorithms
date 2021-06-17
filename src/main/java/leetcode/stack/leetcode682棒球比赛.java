package leetcode.stack;

import java.util.Stack;


public class leetcode682棒球比赛{
	public static void main(String[] args) {
		String[] s= {"5","-2","4","C","D","9","+","+"};
		System.out.println(calPoints(s));
	}
	public static int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		int count=0;
		int peek=0;
		int prePeek=0;
		for (int i = 0; i < ops.length; i++) {
			String s=ops[i];
			if(s.equals("+")) {
				peek=stack.pop();
				prePeek=stack.pop();
				count+=peek+prePeek;

				//���ݷŻ�ȥ
				stack.push(prePeek);
				stack.push(peek);
				stack.push(peek+prePeek);
			}else if(s.equals("D")) {
				peek=stack.peek();
				count+=peek*2;
				stack.push(peek*2);
			}else if(s.equals("C")) {
				count-=stack.pop();
			}else {
				int c=Integer.parseInt(s);
				count+=c;
				stack.push(c);
			}
		}
		return count;

	}
}
