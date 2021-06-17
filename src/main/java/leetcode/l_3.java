package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class l_3 {
	public static void main(String[] args) {
		String s="assdsaab";
		int lengthOfLongestSubstring = lengthOfLongestSubstring(s);
		System.out.println(lengthOfLongestSubstring);
	}
	public static int lengthOfLongestSubstring(String s) { 
		if(s.equals("")) return 0;
		int count=0;
		Integer max=0;
	  TreeSet<Character> set = new TreeSet<Character>();
	  char[] ch = s.toCharArray();
	  for(int i=0;i<ch.length;i++) {
		  index:for(int j=i;j<ch.length;j++){
			  	  count=set.size();
				  set.add(ch[j]);
				  if(count==set.size()) {//不等于是正常加入
					  if(max<set.size())
						  max=set.size();
					  break index;
				  }
				 if(j==ch.length-1)//串尾
					 if(max<set.size())
						 max=set.size();
				 }
	  	set.clear();
	  }
	  		return max;
  }

		 
}
