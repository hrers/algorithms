package algorithems4.chapter.sort;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/24 9:54
 * @Desc:
 **/
public class InsertSort extends AbstractSort {

    public static void main(String[] args) {
        new InsertSort().run(10);
    }

    @Override
    protected void sort(Comparable[] arr) {
        insertSort2(arr);
    }

    private void insertSort2(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tem = (int) arr[i];
            int j = i;
            while (j > 0 && arr[j - 1].compareTo(tem) > 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            if (i != j) {
                arr[j] = tem;
            }
        }
    }

    public void insertSort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tem = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tem) {
                    arr[j + 1] = arr[j];
                } else {
                    arr[j + 1] = tem;
                    break;
                }
            }
            if (j < 0) {
                arr[0] = tem;
            }
        }
    }

}
