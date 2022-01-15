package common.util;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: zhangjianwu
 * @Date: 2021/4/24 9:53
 * @Desc:
 **/
public class NumUtil {

    /**
     * get a randon array
     * @return
     */
    public static int[] getRandomArray(){
        Random random = new Random();
        int[] a=new int[10];
        for (int i = 0; i < 10 ;i++) {
            a[i]=random.nextInt(100);
        }
        return a;
    }
    
    /**
     * get a const array for debug
     */
    public static int[] getConstArray(){
        return new int[]{14, 2, 6, -86, 1, 9, 22, 26, 97, 83};
    }

    /**
     * get a sorted array
     */
    public static int[] getSortedArray(){
        return  Arrays.stream(NumUtil.getRandomArray()).sorted().toArray();
    }


}
