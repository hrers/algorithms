package algorithems4.chapter.sort.priorityQueue;

import java.util.Scanner;

/**
 * @Author: zhangjianwu
 * @Date: 2022/5/25 0:00
 * @Desc: 基于堆的优先队列
 **/
public class MaxPQ<Key extends Comparable<Key>> {

    public static void main(String[] args) {
        MaxPQ<Integer> maxPQ = new MaxPQ(5);
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            if (str.contains("insert")) {
                maxPQ.insert(Integer.valueOf(str.split(" ")[1]));
                maxPQ.show();
            } else if (str.contains("delMax")) {
                maxPQ.delMax();
                maxPQ.show();
            } else {
                System.out.println("invalid operation!");
            }
        }
    }

    private Key[] pq; //基于堆的完全二叉树
    private int N = 0;

    public Key[] getPq() {
        return pq;
    }

    void show() {
        for (int i = 1; i <= N; i++) {
            System.out.print(pq[i] + "  ");
        }
        System.out.println();
    }

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    /**
     * 删除对顶元素，并将堆的最后一个元素放到第一个位置，进行下沉，重建堆
     * @return
     */
    public Key delMax() {
        if (!isEmpty()) {
            Key max = pq[1];
            exch(1, N--);
            pq[N + 1] = null;
            sink(1);
            return max;
        }
        System.out.println("堆已空 ");
        return null;
    }

    /**
     * 新增堆元素，存放位置为堆末，进行上浮重建堆
     * @param v
     */
    public void insert(Key v) {
        if (isFull()) {
            System.out.println(" 堆已满 ");
        } else {
            pq[++N] = v;
            swin(N);
        }
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
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
        return pq[i].compareTo(pq[j]) < 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N + 1 == pq.length;
    }

    public int size() {
        return N;
    }

}
