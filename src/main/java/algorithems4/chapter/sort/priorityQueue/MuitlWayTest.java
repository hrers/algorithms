package algorithems4.chapter.sort.priorityQueue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * @Author: zhangjianwu
 * @Date: 2022/5/26 21:57
 * @Desc:
 **/
public class MuitlWayTest {

    private static void merge(In[] streams) {
        int n = streams.length;
        edu.princeton.cs.algs4.IndexMinPQ<String> pq = new IndexMinPQ(n);

        int i;
        for(i = 0; i < n; ++i) {
            if (!streams[i].isEmpty()) {
                pq.insert(i, streams[i].readString());
            }
        }

        while(!pq.isEmpty()) {
            StdOut.print((String)pq.minKey() + " ");
            i = pq.delMin();
            if (!streams[i].isEmpty()) {
                pq.insert(i, streams[i].readString());
            }
        }

        StdOut.println();
    }

    public static void main(String[] args) {
        int n = args.length;
        In[] streams = new In[n];
        for(int i = 0; i < n; ++i) {
            streams[i] = new In(args[i]);
        }
        merge(streams);
    }
}
