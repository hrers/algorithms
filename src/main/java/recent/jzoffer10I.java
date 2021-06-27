package recent;

/**
 * @Author: zhangjianwu
 * @Date: 2021/6/20 13:21
 * @Desc: 斐波那契数列
 **/
public class jzoffer10I {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(fib(95));
    }
    //经典递归
//    public static int fib(int n) {
//        if(n==1){
//            return 0;
//        }else if(n==2){
//            return 1;
//        }else {
//            return fib(n-1)+fib(n-2);
//        }
//    }
    public static Integer fib(int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        int[] arr=new int[n+1];
        arr[0]=0;arr[1]=1;
        for (int i = 2; i <=n; i++) {
            arr[i]=(arr[i-1]+arr[i-2])%(1000000007);
        }
        return arr[n];
    }
}
