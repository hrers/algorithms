package leetcode.array;

import common.util.ArrayUtil;

/**
 * @Author: zhangjianwu
 * @Date: 2022/1/18 23:07
 * @Desc:
 **/
public class lt27RemoveElement {
    public static void main(String[] args) {
//        int[] nums = ArrayUtil.geneIntArray();
        int[] nums={1,2};
        ArrayUtil.print(nums);
        int i = removeElement(nums, 1);
        System.out.println(i);
        ArrayUtil.print(nums);
    }

    public static  int removeElement(int[] nums, int val) {
        int curr=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                nums[curr++]=nums[i];
            }
        }
        return curr;
    }
}
