package Util;

import java.util.Random;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/24 9:53
 * @Desc:
 **/
public class NumUtil {

    public static int[] getRandomArray(){
        Random random = new Random();
        int[] a=new int[10];
        for (int i = 0; i < 10 ;i++) {
            a[i]=random.nextInt(100);
        }
        return a;
    }

    public static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
