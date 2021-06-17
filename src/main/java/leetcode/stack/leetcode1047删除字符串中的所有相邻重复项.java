package leetcode.stack;

import java.util.Stack;

public class leetcode1047删除字符串中的所有相邻重复项 {
	public static void main(String[] args) {
		String S="abbaca";
		String removeDuplicates = removeDuplicates(S);
		System.out.println(removeDuplicates);

	}

	public static String removeDuplicates(String S) {
		StringBuffer s = new StringBuffer();
		char[] ca = S.toCharArray();
		for (int i = 0; i < ca.length; i++) {
			if(s.length()==0||s.charAt(s.length()-1)!=ca[i])
				s.append(ca[i]);
			else
				s.deleteCharAt(s.length()-1);
		}
		return s.toString();
	}
}
