package leetcode.linklist;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/23 21:11
 * @Desc:
 **/
public class T1 {

    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;

        Integer c = 2000;
        Integer d = 2000;


        System.out.println("hhh".equals("sss"));

        Integer f = new Integer(100);
        Integer g = new Integer(100);

        Integer h = new Integer(2000);
        Integer i = new Integer(2000);

        System.out.println(a==b);
        System.out.println(a.equals(b));

        System.out.println(c==d);
        System.out.println(c.equals(d));

        System.out.println(f==g);
        System.out.println(f.equals(g));

        System.out.println(h==i);
        System.out.println(h.equals(i));

        System.out.println(a==f);
        System.out.println(a.equals(f));
        System.out.println("=========================");
    }
}
