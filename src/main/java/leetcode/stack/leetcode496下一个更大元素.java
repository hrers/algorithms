package leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class leetcode496下一个更大元素{
	public static void main(String[] args) {
		int nums1[] = {2,4};
		int nums2[]= {1,2,3,4};
		int[] nextGreaterElement = nextGreaterElement(nums1,nums2);
		for (int i : nextGreaterElement) {
			System.out.println(i);

		}

	}
	public static  int[] nextGreaterElement(int[] nums1, int[] nums2) {
		for (int i = 0; i < nums1.length; i++) {
			out:for (int j = 0; j < nums2.length; j++) {
				if(nums1[i]==nums2[j]){
					while(j<nums2.length) {
						if(nums1[i]<nums2[j]) {
							nums1[i]=nums2[j];
							break out;
						}else
							j++;
					}
					nums1[i]=-1;
				}
			}
		}
		return nums1;
	}
}
