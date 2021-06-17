package leetcode;

import java.util.TreeSet;

public class l_4_2 {
	public static void main(String[] args) {
		int[] num1 = {1};
		int[] num2= {1};
		double findMedianSortedArrays = findMedianSortedArrays(num1,num2);
		System.out.println(findMedianSortedArrays);
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 int len1=nums1.length;
		 int len2=nums2.length;
		 int len=len1+len2;
		 //一个数组为空的情况
	   if(len1==0)
		   if(len2%2==0)
			   return (float)(nums2[len2/2]+nums2[len2/2-1])/2;
		   else 
			   return nums2[len2/2];
	   else if(len2==0)
		   if(len1%2==0)
			   return (float)(nums1[len1/2]+nums1[len1/2-1])/2;
		   else
			   return nums1[len1/2];
	   len1=0;
	   len2=0;
	   TreeSet<Float> set = new TreeSet<>();
	   for(int i=0;i<=len/2;i++) {
		   if(len1==nums1.length)
			   set.add((float)nums2[len2++]);
		   else if(len2==nums2.length)
			   set.add((float)nums1[len1++]);
		   else if(set.size()<=(len/2+1))
			   if(nums1[len1]>nums2[len2])
				   set.add((float)nums2[len2++]);
			   else
				   set.add((float)nums1[len1++]);
		   else
			   break;
	   }
//	   boolean t1=true;
//	   boolean t2=true;
//	   for(int i=0;i<=len/2;i++) {
//		   if(t1&&t2)
//		   if(nums1[len1]>nums2[len2]&&t2) {
//			   if(len2<nums2.length-1) {
//				   set.add((float)nums2[len2++]);
//			   }else {
//				   t2=false;
//			   }
//		   }else {
//			   if(len1<nums1.length-1&&t1)
//				   set.add((float)nums1[len1++]);
//			   else {
//				   t1=false;
//			   }
//				 
//		   }
//		   else {
//			   if(!t1) {
//				   len2++;
//			   }else
//				   len1++;
//		   }
//		   
//	   }
	   
	   
	   
	   
	   
	   
	   
	   if(set.size()==1)
		   return set.first();
	   
	   float middle=0;
	   System.out.println(len);
	   Object[] num=set.toArray();
	   
	   if(len%2==0)
		   middle=(((float)num[num.length-1]+(Float)num[num.length-2])/2);
	   else
		   middle=(float)num[num.length-1];
	   return middle;
	}
}
