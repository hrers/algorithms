package leetcode;

import java.util.Arrays;
import java.util.TreeSet;


public class l_4 {
		private static int count;
		public static void main(String[] args) {
			int[] num1 = {};
			int[] num2= {1};
			double findMedianSortedArrays = findMedianSortedArrays(num1,num2);
			System.out.println(findMedianSortedArrays);
		}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		   int len1=nums1.length;
		   int len2=nums2.length;
		   
		
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
		   float middle=0;
		   int len=len1+len2;
		   int c=(len1+len2)/2;//需要上一位和这一位
		   len1=0;
		   len2=0;
		   boolean t1=true;
		   boolean t2=true;
		   for(int i=0;i<=c;i++) {
			   if(t1&&t2)
			   if(nums1[len1]>nums2[len2]&&t2) {
				   if(len2<nums2.length-1) {
					   len2++;
				   }else {
					   t2=false;
				   }
			   }else {
				   if(len1<nums1.length-1&&t1)
				   len1++;
				   else {
					   t1=false;
				   }
					 
			   }
			   else {
				   if(!t1) {
					   len2++;
				   }else
					   len1++;
			   }
			   
		   }
		   System.out.println(len1+len2);
		   if(t1)
		   len1--;
		   if(t2)
		   len2--;
		   System.out.println(len1+len2);
		   int count=0;
		   float[] num= {-999999,-999999,-999999,-999999};
		  
			for(int i=len1;i>=0;i--) {
				if(count>1)
					break;
				else {
					num[count++]=nums1[i];
				}
			}
		   count--;
		   for(int j=len2;j>=0;j--) {
			   if(count>=3)
				   break;
			   else {
				   num[++count]=nums2[j];
			   }
		   }
		   Arrays.sort(num);
		   for (float f : num) {
			System.out.println(f);
		}
		   if(len%2==0)
			   middle=((num[num.length-1]+num[num.length-2])/2);
		   else
			   middle=num[num.length-1];
		return middle;
	    }
}
