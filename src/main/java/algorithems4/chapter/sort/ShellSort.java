package algorithems4.chapter.sort;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/24 11:02
 * @Desc: 希尔排序:将一组数据进行分组进行插入排序，
 * 常规的插入排序，时间复杂度为O(n^2),而希尔排序时间复杂度接近nlog(n)，快速排序的时间复杂度为nlogn
 * 希尔排序比快排慢一点。但是比常规的插入排序快很多
 * 希尔排序对常规插入排序进行了一些优化，主要表现在，插入排序的时间复杂度集中表现在元素的移动上，最坏情况下为逆序数组，
 * 那么此时的插入排序的时间复杂度为O(n^2).而若是数组基本有序的情况下，插入排序就能很快的完成任务
 * <p>
 * 希尔排序又称缩小增量排序，将数据分成多组，组内进行插入排序，这样若是出现逆序或者逆序元素较多的时候
 * 组内元素相对于直接的原始数组，数量要少很多，这样就降低了移动的时间消耗
 * 随着算法的进行，增量不断降低，直至为1，这样就得到了一个基本有序的序列，最后整个序列执行增量为1的希尔排序也就是插入
 * 排序，因为基本有序所以只需移动很少的元素就能完成插入排序
 * <p>
 * 注意：虽然希尔排序的分组的概念，但是排序的时候是同时进行的，而不是一组到一组
 **/
public class ShellSort extends AbstractSort {

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        shellSort.run(10);
    }

    @Override
    public void sort(Comparable[] arr) {
        //初始gap = len/2 每次循环get/=2
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int tem = (int) arr[i]; //i 就是个h数组里面 进行插入排序的最后一个
                int j = i - gap;        //j 就是插入排序中改组的前一个
                //组内插入排序
                while (j >= 0 && arr[j].compareTo(tem) > 0) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                //组内插入排序该组结束
                arr[j + gap] = tem;
            }
        }
    }
}
