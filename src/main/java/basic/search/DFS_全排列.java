package basic.search;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 深度优先搜索基本模型
 * void dfs(int step) {
 判断边界
 尝试每一种可能
 for(int i=1;i<=n;i++) {
 继续下一步
 dfs(step+1);
 }
 return
 }
 *
 *
 */

public class DFS_全排列 {
	//设置存放全排列的一维数组（每次直接输出，要保存应使用二维数组）
	static int arr[]=new int[10];
	//设置n,输出0~5的全排列
	static int n=9;
	//记录手里还有哪些数字的数组1为已用，0为在手
	static int book[]=new int[10];
	//记录一下数量
	static int count=0;
	public static void main(String[] args) {
		//实现1~n的全排列
		dfs(0);
		System.out.println("此次全排列的个数为："+count);
	}

	static void dfs(int step) {
		String str="";
		if(step==n+1) {
			for (int i = 0; i <=n; i++) {
				System.out.print(arr[i]);
				str+=arr[i];
			}
			count++	;
			System.out.print("   ");
			System.out.println();
			return;
		}

		for (int i = 0; i <= n; i++) {
			//对这个盒子（步）进行全部尝试尝试
			if(book[i]==0) {
				arr[step]=i;
				book[i]=1;//本次循环已用，递归不能再用置1
				dfs(step+1);
				book[i]=0;//将用过的数字收回，下一次循环就不是这个数字了，而下一次循环递归会用到这个数字
			}
		}
		return ;
	}



}

