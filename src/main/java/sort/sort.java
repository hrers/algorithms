package sort;

import java.util.Random;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/14 23:43
 * @Desc:
 **/
public class sort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] a=new int[10];
        for (int i = 0; i < 10 ;i++) {
            a[i]=random.nextInt(100);
        }
        System.out.println("排序前");
        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println("\n使用交换排序将数据从大排到小");
        change(a);
        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println("\n使用冒泡排序，将数组从小排到大");
        bubbo(a);
        for (int i : a) {
            System.out.print(i+" ");
        }

        //int i=a[random.nextInt(9)];
        int i=random.nextInt(100);
        System.out.println("\n使用二分查找看数组里面是否有"+i);
        search(a,i);
    }

    private static void search(int[] a, int i) {
        boolean flag=false;
        int low=0;
        int high=a.length-1;
        int mid=(low+high)/2;
        while(low<=high){
            mid=(low+high)/2;
            if(i>a[mid]){
                low=mid+1;
            }else if(i<a[mid]){
                high=mid-1;
            }else if(i==a[mid]){
                flag=true;
                break;
            }
        }
        if(flag){
            System.out.println("天啊,"+i+"竟然在数组里面");
        }else {
            System.out.println("抱歉"+i+"不在数组里面");
        }
    }

    private static void change(int[] a) {
        //交换排序法，相当于优化了冒泡排序法，记录下标
        for (int i = 0; i < a.length-1; i++) {
            int max=i;
            for (int j = i+1; j < a.length; j++) {
               if(a[max]<a[j]) {
                   max=j;
               }
            }
            if(max!=i){
                int tem=a[i];
                a[i]=a[max];
                a[max]=tem;
            }
        }
    }

    private static void bubbo(int[] a) {
        /**
         冒泡排序：遍历n-1次，每一次完成一个落位
         里层循环两两交换
         */
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if(a[j]>a[j+1]) {
                    int tem=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tem;
                }
            }
        }
    }


}


