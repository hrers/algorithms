package sort;

import Util.ArrayUtil;
import Util.NumUtil;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/29 21:32
 * @Desc:
 **/
public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr= NumUtil.getRandomArray();
        ArrayUtil.print(arr);
        quickSort(0,arr.length-1,arr);
        ArrayUtil.print(arr);
    }
    private static void quickSort(int left, int right, int[] arr) {
        if(right<=left){
            int step= sort(left, right, arr);
            quickSort(left, step - 1, arr);
            quickSort(step+ 1, right, arr);
        }
    }
    private static int sort(int left, int right, int[] arr) {
        int i=left;
        int j=right;
        int tem=arr[left];
        while (i<j){
            while (i<j&&arr[j]>tem){
                j--;
            }
            if(i<j){
                arr[i]=arr[j];
                i++;
            }
            while (i<j&&arr[i]<tem){
                i++;
            }
            if(i<j){
                arr[j]=arr[i];
                j--;
            }
        }
        arr[i]=tem;
        return  i;
    }
}
