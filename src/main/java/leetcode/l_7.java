package leetcode;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * @Author: zhangjianwu
 * @Date: 2021/9/26 23:35
 * @Desc:
 **/
public class l_7 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        Integer integer = new Integer("1232");
        System.out.println(integer);
        int reverse = reverse(234);
        System.out.println(reverse);
    }
    public static Integer reverse(int x) {
        boolean flag=false;
        String valueStr;
        if(x<0){
            Integer value=new Integer(x);
            valueStr = value.toString();
            valueStr= valueStr.substring(1, valueStr.length());
            flag=true;
        }else {
            Integer value=new Integer(x);
            valueStr= value.toString();
        }
        char[] chars = valueStr.toCharArray();
        LinkedList<Character> queue= new LinkedList<>();
        for (char aChar : chars) {
            queue.push(aChar);
        }
        String resStr="";
        if(flag){
            resStr+="-";
        }
        while (queue.size()>0){
            resStr+=queue.pop();
        }
        Long res= new Long(resStr);
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
            return 0;
        }
        return Integer.parseInt(String.valueOf(res));
    }
}
