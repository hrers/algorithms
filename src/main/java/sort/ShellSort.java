package sort;
import Util.ArrayUtil;
import Util.NumUtil;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/24 11:02
 * @Desc: 希尔排序:将一组数据进行分组进行插入排序，
 * 常规的插入排序，时间复杂度为O(n^2),而希尔排序时间复杂度接近nlog(n)，快速排序的时间复杂度为nlogn
 * 希尔排序比快排慢一点。但是比常规的插入排序快很多
 * 希尔排序对常规插入排序进行了一些优化，主要表现在，插入排序的时间复杂度集中表现在元素的移动上，最坏情况下为逆序数组，
 * 那么此时的插入排序的时间复杂度为O(n^2).而若是数组基本有序的情况下，插入排序就能很快的完成任务
 *
 * 希尔排序又成缩小增量排序，将数据分成多组，组内进行插入排序，这样若是出现逆序或者逆序元素较多的时候
 * 组内元素相对于直接的原始数组，数量要少很多，这样就降低了移动的时间消耗
 * 随着算法的进行，增量不断降低，直至为1，这样就得到了一个基本有序的序列，最后整个序列执行增量为1的希尔排序也就是插入
 * 排序，因为基本有序所以只需移动很少的元素就能完成插入排序
 *
 * 注意：虽然希尔排序的分组的概念，但是排序的时候是同时进行的，而不是一组到一组
 *
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] randomArray = NumUtil.getRandomArray();
        ArrayUtil.print(randomArray);
        sort(randomArray);
        ArrayUtil.print(randomArray);
    }
    public static void sort(int[] arr){
        for (int gap = arr.length/2; gap>0; gap/=2){
//            while (gap>0){
                for (int i = gap; i < arr.length; i++) {
                    int tem=arr[i];
                    int j=i-gap;
                    while (j>= 0&&arr[j]>tem){
                        arr[j+gap]=arr[j];
                        j-=gap;
                    }
                    arr[j+gap]=tem;
                }
//                gap=(int)Math.floor(gap/3);
//            }
        }
    }
}
