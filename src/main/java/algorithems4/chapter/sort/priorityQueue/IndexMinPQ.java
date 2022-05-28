package algorithems4.chapter.sort.priorityQueue;
/******************************************************************************
 *  Compilation:  javac IndexMinPQ.java
 *  Execution:    java IndexMinPQ
 *  Dependencies: StdOut.java
 *
 *  Minimum-oriented indexed PQ implementation using a binary heap.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code IndexMinPQ} class represents an indexed priority queue of generic keys.
 * It supports the usual <em>insert</em> and <em>delete-the-minimum</em>
 * operations, along with <em>delete</em> and <em>change-the-key</em>
 * methods. In order to let the client refer to keys on the priority queue,
 * an integer between {@code 0} and {@code maxN - 1}
 * is associated with each key—the client uses this integer to specify
 * which key to delete or change.
 * It also supports methods for peeking at the minimum key,
 * testing if the priority queue is empty, and iterating through
 * the keys.
 * <p>
 * This implementation uses a binary heap along with an array to associate
 * keys with integers in the given range.
 * The <em>insert</em>, <em>delete-the-minimum</em>, <em>delete</em>,
 * <em>change-key</em>, <em>decrease-key</em>, and <em>increase-key</em>
 * operations take &Theta;(log <em>n</em>) time in the worst case,
 * where <em>n</em> is the number of elements in the priority queue.
 * Construction takes time proportional to the specified capacity.
 * <p>
 * For additional documentation, see
 * <a href="https://algs4.cs.princeton.edu/24pq">Section 2.4</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @param <Key> the generic type of key on this priority queue
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
    /**
     * 变量解释：
     * maxN:堆的最大容量
     * n：当前堆中的容量
     * pq: 堆的索引
     * 记录堆中元素的下标，下标对应的元素堆有序,所以pd相当于是一个堆中元素的索引
     * 堆的维护根据索引pq对堆进行swim,sink
     * qp: 堆的索引的逆序
     * 如:pq[1]=10 --> qp[10]=1
     * 目的: 当我们需要修改堆中的值，就是pq索引对应的keys中的值，修改了堆中元素，自然需要进行堆重建，
     * 进行对重建的swim,sink需要知道索引的值才能通过索引进行操作.
     * 如将keys[1]=’H',那么需要找到keys[1]在pq中的索引
     * 方式1： 遍历pq,找到值为1的在pq下标为8，即keys[1]的索引,堆操作堆pq[8]进行操作即可
     * 假设：
     * 下标:   0 1 2 3 4 5 6 7 8
     * keys : S O R T E X A M P
     *
     *下标:    0 1 2 3 4 5 6 7 8
     * pq   : 4 0 6 3 2 7 8 5 1
     *
     * 下标:   0 1 2 3 4 5 6 7 8
     * qp   : 1 8 4 3 0 7 2 5 6
     * 方式2： 用一个pq的逆序数组，如果需要修改keys[1]=‘O' 变为 keys[1]='H' 只需要通过pq[qp[1]]-->pq[8],很快找到数组元素对应的索引下标
     * 类似于索引pq,倒排索引qp,这样就能高效的找出修改的堆值的索引位置，进行堆操作
     *
     * 索引优先队列对优先队列的改进：
     * 优先队列基于堆的数据结构，在大量数据中获得top k优先级的元素，但是缺点是不能调整堆中元素的值，也就是不能改变堆中元素的优先级,
     * 在现实生活中的应用就很局限，在项目开发中，最开始那些最紧急的需求因为某些政策的影响，暂缓开发，优先级就会降到很低的水平。但是这时
     * 这些需求已经放在我们的需求堆里面，在优先队列中就没有办法很方便的对这些需求进行降级操作.理论上其实是可行的，
     * 可以通过遍历堆中的元素，找到元素在堆中的位置，然后对元素进行swim或sink操作,但是堆的目的是处理大数据量的元素，这样操作并不能发挥堆结构的能力，没有意义
     *
     * 索引优先队列，通过记录堆中元素索引的方式，通过索引操作堆，通过索引就能O(1)时间复杂度内确定元素在堆中的位置，省去了遍历查找，
     * 直接进行swim,sink操作
     *
     */
    private int maxN;        // maximum number of elements on PQ
    private int n;           // number of elements on PQ
    private int[] pq;        // binary heap using 1-based indexing
    private int[] qp;        // inverse of pq - qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys;      // keys[i] = priority of i

    /**
     * Initializes an empty indexed priority queue with indices between {@code 0}
     * and {@code maxN - 1}.
     *
     * @param maxN the keys on this priority queue are index from {@code 0}
     *             {@code maxN - 1}
     * @throws IllegalArgumentException if {@code maxN < 0}
     */
    public IndexMinPQ(int maxN) {
        if (maxN < 0) throw new IllegalArgumentException();
        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];    // make this of length maxN??
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];                   // make this of length maxN??
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }

    /**
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     * {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
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

    /**
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
     * Associates key with index {@code i}.
     *
     * @param i   an index
     * @param key the key to associate with index {@code i}
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws IllegalArgumentException if there already is an item associated
     *                                  with index {@code i}
     */
    public void insert(int i, Key key) {
        validateIndex(i);
        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        n++;        //堆元素数量+1
        qp[i] = n;  //索引倒置，后面方便通过索引值，找到索引
        pq[n] = i;  //记录堆元素(下标)是索引,n-->i
        keys[i] = key;//将元素存储到索引指定的位置,keys中的位置不是堆中的位置，堆中的位置是pq指定的，所以新元素的加入，加入了pq[n],pq[n]再指向keys中的位置
        //说白了，keys只是一个存储元素的位置，和堆结构没有强联系，堆结构有pq调整
        swim(n);    //将堆中的元素进行上浮
    }

    /**
     * Returns an index associated with a minimum key.
     *
     * @return an index associated with a minimum key
     * @throws NoSuchElementException if this priority queue is empty
     */
    public int minIndex() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    /**
     * Returns a minimum key.
     *
     * @return a minimum key
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key minKey() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        return keys[pq[1]];
    }

    /**
     * Removes a minimum key and returns its associated index.
     *
     * @return an index associated with a minimum key
     * @throws NoSuchElementException if this priority queue is empty
     */
    public int delMin() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, n--);
        sink(1);
        assert min == pq[n + 1];
        //以下三步貌似在算法理解的角度可以不需要的
        qp[min] = -1;        // delete
        keys[min] = null;    // to help with garbage collection
        pq[n + 1] = -1;        // not needed
        return min;
    }

    /**
     * Returns the key associated with index {@code i}.
     *
     * @param i the index of the key to return
     * @return the key associated with index {@code i}
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws NoSuchElementException   no key is associated with index {@code i}
     */
    public Key keyOf(int i) {
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        else return keys[i];
    }

    /**
     * Change the key associated with index {@code i} to the specified value.
     *
     * @param i   the index of the key to change
     * @param key change the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws NoSuchElementException   no key is associated with index {@code i}
     */
    public void changeKey(int i, Key key) {
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = key;
        //虽然是两个操作，但是元素的比较只有两个可能，要么大于，要么小于（等于可以划分为前面两个中的其中一个）
        swim(qp[i]);
        sink(qp[i]);
    }

    /**
     * Change the key associated with index {@code i} to the specified value.
     *
     * @param i   the index of the key to change
     * @param key change the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @deprecated Replaced by {@code changeKey(int, Key)}.
     */
    @Deprecated
    public void change(int i, Key key) {
        changeKey(i, key);
    }

    /**
     * Decrease the key associated with index {@code i} to the specified value.
     *
     * @param i   the index of the key to decrease
     * @param key decrease the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws IllegalArgumentException if {@code key >= keyOf(i)}
     * @throws NoSuchElementException   no key is associated with index {@code i}
     */
    public void decreaseKey(int i, Key key) {
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) == 0)
            throw new IllegalArgumentException("Calling decreaseKey() with a key equal to the key in the priority queue");
        if (keys[i].compareTo(key) < 0)
            throw new IllegalArgumentException("Calling decreaseKey() with a key strictly greater than the key in the priority queue");
        keys[i] = key;
        swim(qp[i]);
    }

    /**
     * Increase the key associated with index {@code i} to the specified value.
     *
     * @param i   the index of the key to increase
     * @param key increase the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws IllegalArgumentException if {@code key <= keyOf(i)}
     * @throws NoSuchElementException   no key is associated with index {@code i}
     */
    public void increaseKey(int i, Key key) {
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) == 0)
            throw new IllegalArgumentException("Calling increaseKey() with a key equal to the key in the priority queue");
        if (keys[i].compareTo(key) > 0)
            throw new IllegalArgumentException("Calling increaseKey() with a key strictly less than the key in the priority queue");
        keys[i] = key;
        sink(qp[i]);
    }

    /**
     * Remove the key associated with index {@code i}.
     *
     * @param i the index of the key to remove
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws NoSuchElementException   no key is associated with index {@code i}
     */
    public void delete(int i) {
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        int index = qp[i];
        exch(index, n--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }

    // throw an IllegalArgumentException if i is an invalid index
    private void validateIndex(int i) {
        if (i < 0) throw new IllegalArgumentException("index is negative: " + i);
        if (i >= maxN) throw new IllegalArgumentException("index >= capacity: " + i);
    }

    /***************************************************************************
     * General helper functions.
     ***************************************************************************/
    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }


    /***************************************************************************
     * Heap helper functions.
     ***************************************************************************/
    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }


    /***************************************************************************
     * Iterators.
     ***************************************************************************/

    /**
     * Returns an iterator that iterates over the keys on the
     * priority queue in ascending order.
     * The iterator doesn't implement {@code remove()} since it's optional.
     *
     * @return an iterator that iterates over the keys in ascending order
     */
    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Integer> {
        // create a new pq
        private IndexMinPQ<Key> copy;

        // add all elements to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            copy = new IndexMinPQ<Key>(pq.length - 1);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i], keys[pq[i]]);
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }


    /**
     * Unit tests the {@code IndexMinPQ} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        // insert a bunch of strings
        String[] strings = {"it", "was", "the", "best", "of", "times", "it", "was", "the", "worst"};

        IndexMinPQ<String> pq = new IndexMinPQ<String>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }

        // delete and print each key
        while (!pq.isEmpty()) {
            int i = pq.delMin();
            StdOut.println(i + " " + strings[i]);
        }
        StdOut.println();

        // reinsert the same strings
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }

        // print each key using the iterator
        for (int i : pq) {
            StdOut.println(i + " " + strings[i]);
        }
        while (!pq.isEmpty()) {
            pq.delMin();
        }

    }
}
