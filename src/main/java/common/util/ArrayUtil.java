package common.util;

/**
 * @Author: zhangjianwu
 * @Date: 2021/9/27 22:37
 * @Desc:
 **/
public class ArrayUtil {

    public static int[] geneIntArray(){
        int[] arr={1,2,2,4,5,7,8,11,12,12};
        return arr;
    }
    /**
     * print array
     * @param arr
     */
    public static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }


    /**
     *  print array
     * @param arr
     */
    public static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
}
}
