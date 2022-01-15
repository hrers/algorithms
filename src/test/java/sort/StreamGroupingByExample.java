package sort;

import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StreamGroupingByExample {
    public static void main(String[] args) {
        Integer[] arr={1,32,31,21,2,41,2,67};
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("***********************************");
//        quicksort(arr,0,arr.length-1);
        bubble(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void quicksort(Integer[] arr,int left,int right){
        if(left<right){
            int index=adjust(arr,left,right);
            quicksort(arr,left,index-1);
            quicksort(arr,index+1,right);
        }
    }

    private static int adjust(Integer[] arr, int left, int right) {
        int i=left;
        int j=right;
        int indexValue=arr[left];
        while (i<j){
            while (i<j&&indexValue<=arr[j]){
                j--;
            }
            if(i<j){
                arr[i]=arr[j];
                i++;
            }
            while (i<j&&indexValue>=arr[i]){
                i++;
            }
            if(i<j){
                arr[j]=arr[i];
                j--;
            }
        }
        arr[i]=indexValue;
        return i;
    }


    /**
     * 冒泡排序
     * @param arr
     */
    private static void bubble(Integer[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i; j <arr.length; j++) {
                if(arr[i]>arr[j]){
                    int tmp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
    }

    @Test
    public void test() throws InterruptedException {
        Object o = new Object();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            try {
                synchronized (o){
                    o.notify();
                }
                Thread.sleep(2000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }).start();
        synchronized (o){
            o.wait(10000);
            System.out.println(Thread.currentThread().getName());
            System.out.println("...");
        }
    }

    public static void insertSort(){
        Integer[] arr={1,32,31,21,2,41,2,67};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >=0 ; j++) {

            }
        }
    }



}




























