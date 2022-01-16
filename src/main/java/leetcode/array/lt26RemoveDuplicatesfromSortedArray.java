package leetcode.array;

import common.util.ArrayUtil;
import sun.security.rsa.RSASignature;

import java.util.Arrays;

/**
 * @Author: zhangjianwu
 * @Date: 2022/1/16 13:13
 * @Desc:
 **/
public class lt26RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
//        int[] arr = ArrayUtil.geneIntArray();
        int[] arr={2};
        ArrayUtil.print(arr);
        System.out.println(removeDuplicates(arr));
        ArrayUtil.print(arr);

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return nums.length;
        }
        int curr = 0;
        int j;
        for (int i = 0; i < nums.length; i++) {
            nums[curr++] = nums[i];
            j = i + 1;
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            i = j - 1;
        }
        return curr;
    }

}






















