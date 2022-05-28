package algorithems4.chapter.sort.priorityQueue;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @Author: zhangjianwu
 * @Date: 2022/5/25 17:08
 * @Desc:
 **/
public class IndexMaxPQ<Item extends Comparable> {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        IndexMaxPQ<Integer> indexMaxPQ = new IndexMaxPQ<Integer>(5);
        Scanner scan = new Scanner(System.in);
        int z = 0;
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            if (str.contains("insert")) {
                System.out.println("z:"+z);
                indexMaxPQ.insert(z++, Integer.valueOf(str.split(" ")[1]));
                indexMaxPQ.show();
            } else if (str.contains("delMax")) {
                indexMaxPQ.delMax();
                indexMaxPQ.show();
                z--;
            } else {
                System.out.println("invalid operation!");
            }
        }
    }

    private int maxN;//堆元素最大限制
    private int n;//对中的元素数量
    private int[] pq;//二叉堆的索引,索引指向的是堆中元素的下标
    private int[] qp;//二叉堆索引的逆.相当于倒排索引.倒排索引由堆中元素的下标指向索引
    private Item[] items;//实际存储堆元素的数组

    public IndexMaxPQ(int maxN) {
        if (maxN < 0) throw new IllegalArgumentException();
        this.maxN = maxN;
        n = 0;
        items = (Item[]) new Comparable[maxN + 1];    // make this of length maxN??
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];                   // make this of length maxN??
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }


    public void insert(int i, Item item) {
        validateIndex(i);
        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        n++; //堆元素+1
        pq[n] = i; //堆中最后一个元素指向新插入的元素
        qp[i] = n; //记录倒置索引,方便以后通过索引找到元素数组下标pq[qp[i]]=n
        items[i] = item; //给元素数组赋值
        swin(n);
    }

    public int delMax() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        //将数组最后一个元素和第一个元素交换(通过pq)，再进行sink操作
        int maxIndex = pq[1];
        exch(1, n--);
        sink(1);
        maxIndex = pq[n + 1];
        qp[maxIndex] = -1;
        pq[n + 1] = -1;
        items[maxIndex] = null;
        return maxIndex;
    }

    public void changeKey(int i, Item key) {
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        items[i] = key;
        //虽然是两个操作，但是元素的比较只有两个可能，要么大于，要么小于（等于可以划分为前面两个中的其中一个）
        swin(qp[i]);
        sink(qp[i]);

    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void swin(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    public boolean less(int i, int j) {
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    private void exch(int i, int j) {
        //除了交换索引
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
        //还要更新倒置索引
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    // throw an IllegalArgumentException if i is an invalid index
    private void validateIndex(int i) {
        if (i < 0) throw new IllegalArgumentException("index is negative: " + i);
        if (i >= maxN) throw new IllegalArgumentException("index >= capacity: " + i);
    }

    /**
     * Is {@code i} an index on this priority queue?
     *
     * @param i an index
     * @return {@code true} if {@code i} is an index on this priority queue;
     * {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     */
    public boolean contains(int i) {
        validateIndex(i);
        return qp[i] != -1;
    }

    void show() {
        for (int i = 1; i <= n; i++) {
            System.out.print(items[pq[i]] + "  ");
        }
        System.out.println();
    }
}
