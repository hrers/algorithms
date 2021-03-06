package recent;

import common.util.ArrayUtil;
import common.util.NumUtil;

/**
 * @Author: zhangjianwu
 * @Date: 2021/6/20 14:05
 * @Desc: 数组中的重复数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 经典桶排序
 **/
public class jzoffer03 {
    public static void main(String[] args) {
        int[] arr = NumUtil.getRandomArray();
        ArrayUtil.print(arr);
        findRepeatNumber(arr);
    }
    public static int findRepeatNumber(int[] nums) {
        int[] bucket=new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            if(bucket[nums[i]]==0){
                bucket[nums[i]]=1;
            }else {
                return nums[i];
            }
        }
        return -1;
    }
}
