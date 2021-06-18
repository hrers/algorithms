package leetcode.linklist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/19 14:54
 * @Desc:
 **/
public class List转化为Array {

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(19);
        //stream 讲List转化为array
        Integer[] intList= list.stream().sorted().collect(Collectors.toList()).toArray(new Integer[list.size()]);
        for (Integer integer : intList) {
            System.out.println(integer);
        }

    }
}
