package sort;

import common.util.ArrayUtil;
import common.util.NumUtil;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/24 16:07
 * @Desc: 快速排序使用了分治法+填坑法
 * 通过基准（坑）调整元素位置，每一轮快排过后都会有一个元素最终落位。
 * 时间复时间复杂度分析：由快排分治法的思想，共需要递归Logn次
 * 第一轮 需要比较n个元素 故时间为T(n)=2T(n/2)+n
 * 第二轮 分成了两个部分 T(n)=2*(2*T(n/4)+n/2)+n = 4*T(n/4)+2n
 * 第三轮 分成了四个部分 T(n)=4*(2*T(n/8)+n/4)+2n = 8*T(n/8)+3n
 * ...
 * 第n轮 T(n)=n*(T(1))+(logn)*n= nlogn    T(1)=0
 *
 * 最坏情况：一棵斜树，需要进行n次递归，第i轮快排就要比较n-i次，一轮比较的时间复杂度为O(n)
 * 故最坏情况下快排的时间复杂度为O(n^2),和冒泡排序时间复杂度类似
 * https://blog.csdn.net/jacke121/article/details/78145761?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control&dist_request_id=1332042.12545.16192588554075069&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-1.control
 *
 * 关于快排的空间复杂度：快排使用自身数组通过交换的方式进行元素排序，属于原地排序空间复杂度
 * 为O(1)但是，算上递归栈传参等空间，需要递归logn次，故消耗logn的空间复杂度
 * 故综合来说空间复杂为logn 但是坏情况下，斜树，n次递归，则最坏时间复杂度为n
 * 快排由于元素的跳跃，是不稳定的排序
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = NumUtil.getRandomArray();
        ArrayUtil.print(arr);
        quickSort(arr,0,arr.length-1);
        ArrayUtil.print(arr);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left<right){
            int i=AdjustArray(arr,left,right);
            quickSort(arr,left,i-1);
            quickSort(arr,i+1,right);
        }
    }

    private static int AdjustArray(int[] arr, int left, int right) {
        int i=left,j=right;
        int x=arr[left]; //以左边第一个数为坑
        while (i<j){
            //从右到左找小于x的书来填s[i]
            while (i<j&&arr[j]>x){
                j--;
            }
            if(i<j){
                arr[i]=arr[j];//将arr[j]填充到arr[i]中
                i++;
            }
            //从左到右找大于或等于x的数来填arr[j]
            while (i<j&&arr[i]<x){
               i++;
            }
            if(i<j){
               arr[j]=arr[i];//将arr[j]填充到arr[i]中，arr[j]就形成一个新的坑
               j--;
            }
        }
        //退出时i==j，将x填充到这个坑中
        arr[i]=x;
        return i;
    }
}
