package sort;

import Util.NumUtil;

/**
 * @Author: zhangjianwu
 * @Date: 2021/6/17 17:47
 * @Desc:
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] arr= NumUtil.getRandomArray();
        NumUtil.print(arr);
        quickSort(0,arr.length-1,arr);
        NumUtil.print(arr);
    }

    private static void quickSort(int left, int right, int[] arr) {
        if(left<right){
            int index=adjust(left,right,arr);
            adjust(left,index-1,arr);
            adjust(index+1,right,arr);
        }
    }

    private static int adjust(int left, int right, int[] arr) {
        int i=left;
        int j=right;
        while (i<j){
        }

        return 0;
    }
}
