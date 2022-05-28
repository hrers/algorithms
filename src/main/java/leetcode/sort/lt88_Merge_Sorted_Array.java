package leetcode.sort;

import common.util.ArrayUtil;

/**
 * @Author: zhangjianwu
 * @Date: 2022/5/28 10:50
 * @Desc:
 **/
public class lt88_Merge_Sorted_Array {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < m && index2 < n) {
            //小于直接继续
            if (nums1[index1] < nums2[index2]) {
                nums1[index++] = nums1[index1++];
            } else {
            //大于先移动元素
                for (int i = m - 1; i >= index; i--) {
                    nums1[i + 1] = nums1[i];
                }
                m++;
                nums1[index++] = nums2[index2++];
                index1 = index;
            }
        }
        if (index1 == m) {
            while (index2 < n) {
                nums1[index++] = nums2[index2++];
            }
        } else {
            while (index1 < m) {
                nums1[index++] = nums1[index1++];
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {0};
        int[] num2 = {1};
        merge2(num1, 0, num2, 1);
        ArrayUtil.print(num1);
    }


    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int[] arr = new int[m + n];
        while (index1 < m && index2 < n) {
            //小于直接继续
            if (nums1[index1] < nums2[index2]) {
                arr[index++] = nums1[index1++];
            } else {
                arr[index++] = nums2[index2++];
            }
        }
        if (index1 == m) {
            while (index2 < n) {
                arr[index++] = nums2[index2++];
            }
        } else {
            while (index1 < m) {
                arr[index++] = nums1[index1++];
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = arr[i];
        }
    }
}
