package recent;

/**
 * @Author: zhangjianwu
 * @Date: 2021/6/21 14:19
 * @Desc:
 *请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 **/
public class jzoffer_05 {
    public static void main(String[] args) {
        String str="We are happy.";
        String s = replaceSpace(str);
        System.out.println(s);
    }
    public static String replaceSpace(String s) {
        StringBuffer str=new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' '){
               str.append("%20");
            }else {
                str.append(s.charAt(i));
            }
        }
        return str.toString();

    }

}
