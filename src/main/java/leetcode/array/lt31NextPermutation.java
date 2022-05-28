package leetcode.array;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

/**
 * @Author: zhangjianwu
 * @Date: 2022/1/25 23:26
 * @Desc:
 **/
public class lt31NextPermutation {
    public static void main(String[] args) {
        //int[] ints = ArrayUtil.geneIntArray();
        //nextPermutation(ints);
        Thread hello_world = new Thread(() -> System.out.println("hello world"));
        hello_world.interrupt();
        Vector<Integer> integers = new Vector<>();
        integers.remove(1);
        integers.get(1);
        System.setIn(new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        });
    }
    public static void nextPermutation(int[] nums) {

    }

}
