package algorithems4.chapter.sort;

/**
 * @Author: zhangjianwu
 * @Date: 2022/5/24 15:43
 * @Desc:
 **/
public class BubbleSort extends AbstractSort {

    public static void main(String[] args) {
        new BubbleSort().run(10);
    }

    @Override
    protected void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if(less(arr[j+1],arr[j])){
                    exchange(arr,j+1,j);
                }
            }
        }
    }
}
