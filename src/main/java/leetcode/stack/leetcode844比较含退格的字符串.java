package leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class leetcode844比较含退格的字符串 {
	public static void main(String[] args) {
		String S="y#fo##f";
		String T="y#f#o##f";
		boolean backspaceCompare = backspaceCompare(S,T);
		System.out.println(backspaceCompare);
	}
	public static boolean backspaceCompare(String S, String T) {

		char[] stack1 = new char[S.length()];
		char[] stack2 = new char[T.length()];
		int index1=-1;
		int index2=-1;
		char[] ca1 = S.toCharArray();
		for (int i = 0; i < ca1.length; i++) {
			if(ca1[i]!='#')
				stack1[++index1]=ca1[i];
			else {
				if(index1>-1)
					index1--;
			}

		}

		char[] ca2 = T.toCharArray();
		for (int i = 0; i < ca2.length; i++) {
			if(ca2[i]!='#')
				stack2[++index2]=ca2[i];
			else {
				if(index2>-1)
					index2--;
			}
		}

		StringBuffer str1=new StringBuffer();
		for (char c : stack1) {
			str1.append(c);
		}
		StringBuffer str2=new StringBuffer();
		for (char c : stack2) {
			str2.append(c);
		}

		if(index1!=index2)
			return false;
		else if(index1!=-1)
			return str1.toString().trim().substring(0, index1+1).equals(str2.toString().trim().substring(0, index2+1));
		else return true;


	}
}
