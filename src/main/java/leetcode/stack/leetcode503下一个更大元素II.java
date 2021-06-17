package leetcode.stack;

import java.util.Stack;

public class leetcode503下一个更大元素II {
	public static void main(String[] args) {
		int[] nums= {1,2,1};
		int[] nextGreaterElements = nextGreaterElements(nums);
		for (int i : nextGreaterElements) {
			System.out.println(i);

		}
	}
	public static int[] nextGreaterElements(int[] nums) {
		int[] res=new int[nums.length];
		Stack<Integer> stack = new Stack<Integer>();
		c:for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j <nums.length; j++) {
				if(nums[i]<nums[j]) {
					res[i]=nums[j];
					continue c;
				}
			}
			for (int j = 0; j <i; j++) {
				if(nums[i]<nums[j]) {
					res[i]=nums[j];
					continue c;
				}
			}
			res[i]=-1;
		}
		return res;

	}

}
