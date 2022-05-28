package algorithems4.chapter.sort;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/24 18:51
 * @Desc: 基数排序
 * 使用了桶的概念，只能排序确定范围的整数
 * 将值转化为对应数组下标，数组值为概数的个数，是不稳定的排序方法
 * 时间复杂度O(n+k) k为范围 n为个数
 * 空间复杂度O(k)
 *
 *
 **/
public class CountingSort extends AbstractSort{

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        countingSort.run(10);
    }

    @Override
    protected void sort(Comparable[] arr) {
        Comparable[] comparables = countingSort(arr);
        for (int i = 0; i < comparables.length; i++) {
            arr[i]=comparables[i];
        }
    }

    private Comparable[] countingSort(Comparable[] arr) {
        //获取最大的值
        int max=0;
        for (Comparable i : arr) {
           if(i.compareTo(max)>0) {
               max= (int) i;
           }
        }
        //计入桶中
        int[] bucket=new int[max+1];
        for (Comparable value : arr) {
            bucket[(int) value]++;
        }
        //从桶中往原数组覆盖
        int index=0;
        for (int i = 0; i < bucket.length; i++) {
           while (bucket[i]>0){
               arr[index++]= i;
               bucket[i]--;
           }
        }
        return arr;
    }

}
