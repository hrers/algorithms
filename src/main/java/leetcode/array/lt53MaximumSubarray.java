package leetcode.array;

import common.util.ArrayUtil;

/**
 * @Author: zhangjianwu
 * @Date: 2022/1/19 21:40
 * @Desc:
 **/
public class lt53MaximumSubarray {

    public static void main(String[] args) {
//        int[] ints = ArrayUtil.geneIntArray();
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(arr);
        System.out.println(i);
    }
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0 && nums[i] < 0) {
                continue;
            }
            sum += nums[i];
            max = sum > max ? sum : max;
            /**
             * 1. 对于当前该段序列来说，记Sum为左子序列(必须从左边第一个算起)连续求和
             *  只要该段序列的任意连续左子序列的Sum都是大于0的,那么序列值求和的最大值就出现在遍历顺序求和过程中.
             *  下面给出证明，只要保持sum>0,那么该段序列的任意子序列和都<=该段序列之和
             *  证明: 存在序列a1,a2,a3,a4,a5该序列任意连续左子序列的和都大于0
             *  通过反证法，令序列A=a1,a2,a3,a4,a5 非左子序列的序列B=a3,a4,a5
             *  假设在该序列中若存在某段非左子序列和>整个序列之和，那么则至少有一段子序列B和大于所有序列之和的A 即SumB>SumA
             *  若SumB>SumA
             *  -->SumB-SumA>0
             *  -->(SumA-a1-a2)-SumA>0
             *  -->-(a1+a2)>0
             *  -->a1+a2<0
             *  故不存在非左子序列的Sum值大于包含左子序列的Sum值大的情况。
             *  这个就可以保证，该段序列求和过程中，最大值只能出现在自左向右求和，因为左子序列都是对求和产生增益的。无论后面的序列求和数多大，只要加上任意大小的左子序列，都将大于等于不包含左子序列的
             *  需要说明的是，因为Sum左子序列>0的特点,左子序列对于整个序列求和总有增益效果,正是利用这个原理，才能一次自左向右遍历就能确定子序列中的连续求和最大值
             *
             * 2. 对该段序列之后的序列来说，
             *  只要出现sum<0,就表示该段序列对于后续序列只能出现减损的作用，对于序列求和没有益处，直接从出现sum<0的下一个数开始计算下一段序列值才能出现正确的最大子序列和
             *
             *  由1,2可以得出，在遍历数组的过程中计算过的子序列的sum值都是那些子序列的最大值，每次更新max就可以得到最大值
             */
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
