package algorithems4.chapter.sort;

import java.util.Arrays;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/24 14:50
 * @Desc: 归并排序(自顶向下归并)
 * 归并排序利用了分治的思想,进行从下到上的有序合并，进而得到有序的序列
 * 时间复杂度为O(nlogn)见：https://blog.csdn.net/a1033025319/article/details/88650514
 * 归并排序使用的递归的方式，虽然每一次递归都需要定义一个和原来传入的递归数组一样大小的数组，但是由于每一层递归结束都会
 * 释放所用内存，故空间复杂度为N
 **/
public class MergeSort extends AbstractSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.run(100);
    }

    @Override
    protected void sort(Comparable[] arr) {
//        Comparable[] comparables = mergeSortTopDown(arr);
        mergeSortDownTop(arr);
//        for (int i = 0; i < comparables.length; i++) {
//            arr[i] = comparables[i];
//        }
    }

    /**
     * 自顶向下归并法
     *
     * @param arr
     * @return
     */
    private Comparable[] mergeSortTopDown(Comparable[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int mid = (int) Math.floor(arr.length / 2);
        Comparable[] leftArr = Arrays.copyOfRange(arr, 0, mid);
        Comparable[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSortTopDown(leftArr), mergeSortTopDown(rightArr));
    }

    /**
     * 自底向上归并
     *
     * @param arr
     */
    private void mergeSortDownTop(Comparable[] arr) {
        int length = arr.length;
        for (int sz = 1; sz < length; sz = sz * 2) {//sz子数组大小
            for (int lo = 0; lo < length - sz; lo += sz * 2) { //lo子数组索引
                merge(arr, lo, lo + sz - 1, Math.min(lo + sz * 2 - 1, length - 1));
            }
        }
    }

    private void merge(Comparable[] arr, int left, int mid, int end) {
        Comparable[] aux = new Comparable[end - left + 1];
        int leftIndex = left;
        int rightIndex = mid + 1;
        int index = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            boolean less = less(arr[leftIndex], arr[rightIndex]);
            if (less) {
                aux[index++] = arr[leftIndex++];
            } else {
                aux[index++] = arr[rightIndex++];
            }
        }
        if (leftIndex > mid) {
            while (rightIndex <= end) {
                aux[index++] = arr[rightIndex++];
            }
        } else {
            while (leftIndex <= mid) {
                aux[index++] = arr[leftIndex++];
            }
        }
        index = 0;
        for (int i = left; i <= end; i++) {
            arr[i] = aux[index++];
        }
        show(arr);
    }

    /**
     * 将两个数组从小到大合并成为一个数组
     *
     * @param leftArr
     * @param rightArr
     * @return
     */
    private Comparable[] merge(Comparable[] leftArr, Comparable[] rightArr) {
        Comparable[] res = new Comparable[leftArr.length + rightArr.length];
        int index = 0; //结果数组索引
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex].compareTo(rightArr[rightIndex]) < 0) {
                res[index++] = leftArr[leftIndex++];
            } else {
                res[index++] = rightArr[rightIndex++];
            }
        }
        if (leftIndex == leftArr.length) {
            while (rightIndex < rightArr.length) {
                res[index++] = rightArr[rightIndex++];
            }
        } else {
            while (leftIndex < leftArr.length) {
                res[index++] = leftArr[leftIndex++];
            }
        }
        return res;
    }
}
