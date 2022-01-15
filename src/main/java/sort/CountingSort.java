package sort;

import common.util.ArrayUtil;
import common.util.NumUtil;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/24 18:51
 * @Desc: 基数排序
 * 使用了桶的概念，只能排序确定范围的整数
 * 将值转化为对应数组下标，数组值为概数的个数，是不稳定的排序方法
 * 时间复杂度O(n+k) k为范围 n为个数
 * 空间复杂度O(k)
 *
 *
 **/
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = NumUtil.getRandomArray();
        ArrayUtil.print(arr);
        int[] res=countingSort(arr);
        ArrayUtil.print(arr);
    }
    private static int[] countingSort(int[] arr) {
        //获取最大的值
        int max=0;
        for (int i : arr) {
           if(max<i) {
               max=i;
           }
        }
        //计入桶中
        int[] bucket=new int[max+1];
        for (int value : arr) {
            bucket[value]++;
        }
        //从桶中往原数组覆盖
        int index=0;
        for (int i = 0; i < bucket.length; i++) {
           while (bucket[i]>0){
               arr[index++]= i;
               bucket[i]--;
           }
        }
        return arr;
    }
}
