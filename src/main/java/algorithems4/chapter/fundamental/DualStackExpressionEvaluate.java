package algorithems4.chapter.fundamental;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: zhangjianwu
 * @Date: 2022/1/15 13:59
 * @Desc: Dijkstra双栈表达式求值算法 没定义优先级，只能使用括号的方式进行表达式存放
 **/
public class DualStackExpressionEvaluate{
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        Stack<String> ops= new Stack<>();
        Stack<Double> vals= new Stack<>();
        String expressStr=scan.nextLine();
        String[] expression = expressStr.split(" ");
        for (String stdIn : expression) {
            if(stdIn.equals("exit")){
                break;
            }
            if(stdIn.equals("("));
            else if (stdIn.equals("+")) ops.push(stdIn);
            else if (stdIn.equals("-")) ops.push(stdIn);
            else if (stdIn.equals("*")) ops.push(stdIn);
            else if (stdIn.equals("/")) ops.push(stdIn);
            else if (stdIn.equals(")")){
                String o= ops.pop();
                Double right = vals.pop();
                Double left = vals.pop();
                switch (o){
                    case "+":vals.push(left+right);break;
                    case "-":vals.push(left-right);break;
                    case "*":vals.push(left*right);break;
                    case "/":vals.push(left/right);break;
                }
            }else
                vals.push(new Double(stdIn));
        }
        System.out.println(vals.pop());
    }
    public String testScaner(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
