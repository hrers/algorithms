package algorithems4.chapter.sort;

/**
 * @Author: zhangjianwu
 * @Date: 2022/5/24 15:38
 * @Desc:
 **/
public class SelectSort extends AbstractSort {

    public static void main(String[] args) {
        new SelectSort().run(10);
    }

    @Override
    protected void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            if (min != i) {
                exchange(arr, min, i);
            }
        }
    }


}
