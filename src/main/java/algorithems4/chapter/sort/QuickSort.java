package algorithems4.chapter.sort;

/**
 * @Author: zhangjianwu
 * @Date: 2022/5/24 13:56
 * @Desc:
 **/
public class QuickSort extends AbstractSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.run(10);
    }

    @Override
    protected void sort(Comparable[] arr) {
        quickSort((Integer[]) arr, 0, arr.length - 1);
    }

    private void quickSort(Integer[] arr, int left, int right) {
        if (left < right) {
            int i = AdjustArray(arr, left, right);
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }

    private int AdjustArray(Integer[] arr, int left, int right) {
        int i = left, j = right;
        int x = arr[left]; //以左边第一个数(跨分两边的基准)为坑
        while (i < j) {
            //从右到左找小于x的书来填s[i]
            while (i < j && arr[j] > x) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];//将arr[j]填充到arr[i]中
                i++;
            }
            //从左到右找大于或等于x的数来填arr[j]
            while (i < j && arr[i] < x) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];//将arr[j]填充到arr[i]中，arr[j]就形成一个新的坑
                j--;
            }
        }
        //退出时i==j，将x填充到这个坑中
        arr[i] = x;
        return i;
    }
}
