package test;

import java.util.HashMap;

/**
 * @Author: zhangjianwu
 * @Date: 2021/6/18 8:51
 * @Desc:
 **/
public class t1 {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i=1;
        System.out.println(i>>>1);
        System.out.println(i>>>2);

        int a=re();
        System.out.println("a"+a);

    }

    private static int re() {
        return 1>2?1:0;
    }


}
