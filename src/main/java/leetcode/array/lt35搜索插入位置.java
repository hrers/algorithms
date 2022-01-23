package leetcode.array;

import common.util.ArrayUtil;

/**
 * @Author: zhangjianwu
 * @Date: 2022/1/18 23:32
 * @Desc:
 **/
public class lt35搜索插入位置 {
    public static void main(String[] args) {
//        int[] nums= ArrayUtil.geneIntArray();
        int[] nums={1,3,5,6};
        ArrayUtil.print(nums);
        int i = searchInsert(nums, 7);
        System.out.println(i);
    }
    public static int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid = 0;
        while (left<=right){
            mid=(left+right)/2;
            if(target>nums[mid]){
                left=mid+1;
            }else if(target<nums[mid]){
                right=mid-1;
            }else {
                return mid;
            }
        }
        if(target>nums[mid]){
            return mid+1;
        }else {
            return mid;
        }
    }
}
