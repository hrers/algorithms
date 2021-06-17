package leetcode.map;

import java.util.Arrays;

public class leetcode997找到小镇的法官 {
	public static void main(String args[]) {
		int N=1;
		int[][] trust= {};
		System.out.println(findJudge(N, trust));
	}
    public static int findJudge(int N, int[][] trust) {
    	if(trust.length==0)
    		return -1;	
    	int[] a=new int[N+1];
    	int count=0;
    	for (int i = 0; i < trust.length; i++) {
    		a[trust[i][0]]--;
    		a[trust[i][1]]++;
		}
    	for (int i = 0; i < a.length; i++) {
    		if(a[i]==N-1)
    			return i;
		}
		return -1;
    }
}


