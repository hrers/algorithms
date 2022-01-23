package test;

import org.junit.Test;

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

    @Test
    public void test(){
        String str="lisi";
        String str2="lisi";
        String str3="lisi";
        System.out.println(str==str2);
        System.out.println(str2==str3);
        String lisi = new String("lisi");
        System.out.println(str==lisi);
        System.out.println(str2==lisi);
        String lisi1 = new String("lisi");
        System.out.println(lisi1==lisi);
        String wangwu = new String("wangwu");
        String wangwu1="wangwu";
        System.out.println(wangwu==wangwu1);
    }


}
