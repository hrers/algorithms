package leetcode.array;

import java.util.Arrays;

/**
 * @Author: zhangjianwu
 * @Date: 2022/1/23 13:50
 * @Desc:
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class lt16_3SumClosest {
    public static void main(String[] args) {
//        int[] nums={-1,2,1,-4};
        int[] nums={-3,-2,-5,3,-4};
        int goal=-1;
        int i = threeSumClosest(nums, goal);
        System.out.println(i);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2] - target;
        for (int i = 0; i < nums.length - 2; i++) {
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sign = nums[i] + nums[L] + nums[R] - target;
                if (Math.abs(sign) < Math.abs(closest)) {
                    closest = sign;
                }
                if (sign < 0) {
                    L++;
                } else if (sign > 0) {
                    R--;
                } else {
                    return target + closest;
                }
            }
        }
        return target + closest;
    }

}





















