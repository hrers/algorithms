package common.util;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @Author: zhangjianwu
 * @Date: 2021/6/17 14:42
 * @Desc:
 **/
public class ListUtil {

    public static void main(String[] args) {
        ArrayList<Object> list= new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(199);
        Integer[] integers = listToArray(list);
        for (int i = 0; i < integers.length; i++) {
            System.out.println(integers[i]);
        }
    }

    public static Integer[] listToArray(ArrayList<Object> list){
        //stream 讲List转化为array
        return list.stream().sorted().collect(Collectors.toList()).toArray(new Integer[list.size()]);
    }
}
