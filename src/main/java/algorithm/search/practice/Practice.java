package algorithm.search.practice;

import edu.princeton.cs.algs4.RandomSeq;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

/**
 * @Author: zhangjianwu
 * @Date: 2021/9/27 23:12
 * @Desc:
 **/
public class Practice{

    public static void main(String[] args) {
        double random = StdRandom.random();
        System.out.println(random);
        double uniform = StdRandom.uniform();
        System.out.println(uniform);
        String s = Integer.toBinaryString(-(-2147483648));
        String x = Integer.toBinaryString(-2147483648);
        String s1 = Integer.toBinaryString(4);
        String s2 = Integer.toBinaryString(-4);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s);
        System.out.println(x);
    }

    @Test
    public void test1_1_1() {
        int a = (0 + 15) / 2;
        System.out.println(a);
        double b = Math.pow(Math.E, -6) * 100000000.1;
        System.out.println(b);
        boolean c = true && false || true && true;
        System.out.println(c);

    }

    @Test
    public void test1_1_2() throws InterruptedException {
        StdDraw.line(0,0,100,100);
        Thread.sleep(10000);
    }

}
