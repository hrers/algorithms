package algorithm.search;

import common.util.ArrayUtil;
import common.util.NumUtil;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: zhangjianwu
 * @Date: 2021/9/27 22:35
 * @Desc: 二分查找
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] randomArray = Arrays.stream(NumUtil.getRandomArray()).sorted().toArray();
        Scanner scan = new Scanner(System.in);
        ArrayUtil.print(randomArray);
        System.out.println("please input the number you want to find in this array\n");
        int goal=scan.nextInt();
        int index=search(randomArray,goal);
        if(index==-1){
            System.out.println("there is not exist in this array");
        }else {
            System.out.println("the goal in the array's index is"+index);
        }
    }

    private static int search(int[] arr, int goal) {
        int low =0;
        int hight=arr.length-1;
        int mid;
        while (low<=hight){
            mid=(low+hight)/2;
            if(goal<arr[mid]) hight=mid-1;
            else if (goal>arr[mid]) low=mid+1;
            else return mid;
        }
        return -1;
    }

}
