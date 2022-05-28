package leetcode.hash;

import java.util.HashMap;

/**
 * @Author: zhangjianwu
 * @Date: 2022/3/12 14:24
 * @Desc:
 **/
public class lt13_RomanToInteger {

    public static void main(String[] args) {
        int iiiv = romanToInt("MCMXCIV");
        System.out.println(iiiv);
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = buildMap();
        Integer sum = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < length) {
                if (romanMap.get(chars[i]) >= romanMap.get(chars[i + 1])) {
                    sum += romanMap.get(chars[i]);
                } else {
                    sum += (romanMap.get(chars[i + 1]) - romanMap.get(chars[i]));
                    i++;
                }
            } else {
                sum += romanMap.get(chars[i]);
            }
        }
        return sum;
    }

    private  static HashMap<Character, Integer> buildMap() {
        HashMap<Character, Integer> map= new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        return map;
    }
}
