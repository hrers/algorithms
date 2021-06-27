package recent;

import java.util.Arrays;
/**
 * @Author: zhangjianwu
 * @Date: 2021/6/20 16:17
 * @Desc:
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 **/
public class jzoffer05 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
    public static String longestPalindrome(String s) {
        int count=0;//记录回文串的长度
        int strStart=0; //回文串左下标
        int strEnd=0;//回文串由下标
        int tem=0;
        for (int i = 0; i < s.length(); i++) {
            if((s.length()-i+1)<count){
                break;
            }
            for (int j = i; j < s.length(); j++) {
                //优化,必须大于当前的count
                if(j-i+1<count){
                    continue;
                }
                int left=i;int right=j;
                while (s.charAt(left)==s.charAt(right)&&left<right){
                    left++;right--;
                }
                if(left==right||s.charAt(left)==s.charAt(right)){
                    tem=j-i+1;
                    if(tem>count){
                        count=tem;
                        strStart=i;
                        strEnd=j;
                    }
                }
            }
        }
        return s.substring(strStart,strEnd+1);
    }
}
