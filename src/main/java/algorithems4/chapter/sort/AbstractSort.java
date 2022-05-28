package algorithems4.chapter.sort;

import cn.hutool.core.util.ObjectUtil;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author: zhangjianwu
 * @Date: 2022/5/24 13:40
 * @Desc:
 **/
public abstract class AbstractSort<T extends Comparable> {

    void run(int size) {
        System.out.println(this.getClass().getSimpleName()+" start ... ");
        T[] randomArray = getRandomArray(size);
        beforeShow(randomArray);
        sort(randomArray);
        afterShow(randomArray);
        isSort(randomArray);
    }

    T[] getRandomArray(int size) {
        Random random = new Random();
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100));
        }
        return (T[]) list.toArray(new Integer[size]);
    }

    protected abstract void sort(T[] arr);

    void beforeShow(T[] arr) {
        System.out.print("before ");
        show(arr);
    }

    void afterShow(T[] arr) {
        System.out.print("after  ");
        show(arr);
    }

    void show(T[] arr) {
        if (ObjectUtil.isNull(arr) || arr.length == 0) {
            return;
        }
        for (T number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    void exchange(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    void isSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1])) {
                System.out.println("this number array is not sorted");
                return;
            }
        }
        System.out.println("this number array is sorted");
    }

}
