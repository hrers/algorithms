package leetcode.hash;

/**
 * @Author: zhangjianwu
 * @Date: 2022/3/12 15:11
 * @Desc:
 **/
public class lt_12_IntegertoRoman {

    public static void main(String[] args) {
        String s = intToRoman(3);
        System.out.println(s);
    }

    public static String intToRoman(int num) {
        StringBuilder str= new StringBuilder();
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String reps[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for (int i = 0; i < values.length; i++) {
            while (num>0&&num/values[i]!=0){
                num-=values[i];
                str.append(reps[i]);
            }
        }
        return str.toString();
    }

}
