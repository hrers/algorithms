package leetcode.hash;

import java.util.HashMap;

/**
 * @Author: zhangjianwu
 * @Date: 2022/3/12 14:13
 * @Desc:
 **/
public class lt_1_TwoSum {
    public static void main(String[] args) {
        
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }else {
                map.put(target-nums[i],i);
            }
        }
        return null;
    }
}
