package recent;
import Util.NumUtil;

import java.math.BigInteger;
import java.util.LinkedList;
/**
 * @Author: zhangjianwu
 * @Date: 2021/6/19 22:34
 * @Desc: 现将两个字符串处理成int数组,先将两个数组乘法的中间结果存放在一个二维数组中(O(n^2))，然后
 * 再讲中间数组进行最后结果的处理
 * 处理规则 /**
 *          * 二维数组斜打印规律
 *          * （0,0) //x+y=0
 *          * (0,1),(1,0)//x+y=1
 *          * (0,2),(1,1),(2,0)//x+y=2
 * 时间复杂度O(n^2)
 * 综合复杂度O(n^2)
 * */
public class lt43_multiply_strings {
    public static void main(String[] args) {
        String str1="123";
        String str2="456";
        System.out.println(multiply(str1,str2));
    }
    public static String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        //此处先默认num1比num2长(其实两个长度也不限制，为了便于描述而已)
        // 注意字符串顺序和正常运算顺序往数组中赋值是相反的,初始化成数字需要反方向存放
        int[] D1=new int[num1.length()];
        for (int i = 0; i < num1.length(); i++) {
            D1[i]=Character.getNumericValue(num1.charAt(num1.length()-1-i));
        }
        int[] D2=new int[num2.length()];
        for (int i = 0; i < num2.length(); i++) {
            D2[i]=Character.getNumericValue(num2.charAt(num2.length()-1-i));
        }
        //获得中间数组
        int plus = 0;//进位
        int temp;//当前计算的值
        int arr[][]=new int[D2.length][D1.length+1];
        for (int i = 0; i < D2.length; i++) {
            int j;
            for (j = 0; j < D1.length; j++) {
                temp=D2[i]*D1[j]+plus;
                arr[i][j]=temp%10;//去掉进位
                plus=temp/10;//大于10就是进位
            }
            if(plus!=0){
                arr[i][j]=plus;
            }
            //每一位运算之后进位清零
            plus=0;
        }
        System.out.println("中间数组");
        NumUtil.print(arr);
       //处理中间数组
        LinkedList<Integer> list= new LinkedList<>();
        int count=0;int resplus=0;int restem=0;
        int i=0;int j=0;
        while (count<=(arr[0].length+arr.length-2)){//如果 横坐标+纵坐标的最长都小于count就结束
            i=0;j=count;
            if((count>arr[0].length-1)){//计算初始的i,j值
               j=arr[0].length-1;
               i=count-j;
            }
            while (true){
                if(i<arr.length&&j>=0){
                    restem+=arr[i][j];
                    i++;
                    j--;
                }else {
                    restem+=resplus;
                    //list.add(restem%10);//加法余位
                    list.push(restem%10);//加法余位 使用栈的方式从高位向低位输出
                    resplus=restem/10;//加法进位
                    restem=0;
                    count++;
                    break;
                }
            }
        }
        if(list.peek()==0){//最后特殊处理
           list.pop();
        }
        //将栈元素输出成字符串
        StringBuilder str = new StringBuilder("");
        list.forEach(integer -> {
            str.append(integer);
        });
        return str.toString();
    }
}
