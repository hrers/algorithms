package leetcode.stack;

import java.util.Stack;


public class leet1021删除最外层括号 {
	public static void main(String[] args) {
		String s ="(()())(())(()(()))";
		String ans = removeOuterParentheses(s);
		System.out.println(ans);
	}

	public static String removeOuterParentheses(String S) {
		StringBuilder ans=new StringBuilder();
		char[] ca = S.toCharArray();
		int start=0;
		int flag=1;
		char old=S.charAt(0);
		for(int i=1;i<ca.length;i++) {
			if(old!=ca[i])
				flag--;
			else
				flag++;
			if(flag==0) {
				ans.append(S.substring(start+1, i));
				start=i+1;
			}
		}
		return ans.toString();
	}

}
