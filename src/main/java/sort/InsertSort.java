package sort;

import Util.ArrayUtil;
import Util.NumUtil;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/24 9:54
 * @Desc:
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] randomArray = NumUtil.getRandomArray();
        ArrayUtil.print(randomArray);
        insertSort2(randomArray);
    }
    private static void insertSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tem=arr[i];
            int j=i;
            while(j>0&&arr[j-1]>tem){
                arr[j]=arr[j-1];
                j--;
            }
            if(i!=j){
                arr[j]=tem;
            }
        }
        ArrayUtil.print(arr);
    }

    public static void insertSort1(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int tem=arr[i];
            int j;
            for (j = i-1; j >= 0 ; j--) {
               if(arr[j]>tem){
                   arr[j+1]=arr[j];
               }else {
                   arr[j+1]=tem;
                   break;
               }
            }
            if(j<0){
                arr[0]=tem;
            }
        }
        ArrayUtil.print(arr);
    }
}
