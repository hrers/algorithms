package Util;

import java.util.Random;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/24 9:53
 * @Desc:
 **/
public class NumUtil {

    //获取随机数组
    public static int[] getRandomArray(){
        Random random = new Random();
        int[] a=new int[10];
        for (int i = 0; i < 10 ;i++) {
            a[i]=random.nextInt(100);
        }
        return a;
    }

    //打印一维数组
    public static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    //打印二维数组
    public static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
