package sort;

import common.util.ArrayUtil;
import common.util.NumUtil;

import java.util.Arrays;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/24 14:50
 * @Desc: 归并排序
 * 归并排序利用了分治的思想,进行从下到上的有序合并，进而得到有序的序列
 * 时间复杂度为O(nlogn)见：https://blog.csdn.net/a1033025319/article/details/88650514
 * 归并排序使用的递归的方式，虽然每一次递归都需要定义一个和原来传入的递归数组一样大小的数组，但是由于每一层递归结束都会
 * 释放所用内存，故空间复杂度为N
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr= NumUtil.getRandomArray();
        ArrayUtil.print(arr);
        int[] res=mergeSort(arr);
        ArrayUtil.print(res);
    }
    private static int[] mergeSort(int[] arr) {
        if(arr.length<2){
            return arr;
        }
        int mid=(int)Math.floor(arr.length/2);
        int[] leftArr= Arrays.copyOfRange(arr, 0, mid);
        int[] rightArr= Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(leftArr),mergeSort(rightArr));
    }
    private static int[] merge(int[] leftArr, int[] rightArr) {
        int[] res=new int[leftArr.length+rightArr.length];
        int index=0; //结果数组索引
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex<leftArr.length&&rightIndex<rightArr.length){
           if(leftArr[leftIndex]<rightArr[rightIndex]) {
               res[index++]=leftArr[leftIndex++];
           }else {
               res[index++]=rightArr[rightIndex++];
           }
        }
        if(leftIndex==leftArr.length){
            while (rightIndex<rightArr.length){
                res[index++]=rightArr[rightIndex++];
            }
        }else {
            while (leftIndex<leftArr.length){
               res[index++]=leftArr[leftIndex++];
            }
        }
        return res;
    }
}
