package coding;

import java.util.Stack;

/**
 *算法描述
 *1从第一个节点出发，进行深度遍历
 *2每次遍历默认种花1，
 *	3相邻的花园已经种了，遍历与该花园相邻的花园，花色++
 * 循环执行2，直到深度花园遍历结束
 *
 *
 */
public class leetcode1042不邻接植花_栈递归 {
	public static void main(String[] args) {
		int[][] paths= {
				{1,2},
				{2,4},
				{3,4},
				{1,5},
				{1,3}
		};
		int N=5;
		leetcode1042不邻接植花_栈递归 test = new leetcode1042不邻接植花_栈递归();
		int[] gardenNoAdj = test.gardenNoAdj(N, paths);
		for (int i : gardenNoAdj) {
			System.out.println(i);
		}
	}
	int[] answer;
	int[] book;
	int index;
	Stack stack=new Stack<Integer>();
	public  int[] gardenNoAdj(int N, int[][] paths) {
//      	answer[0]=1;//第一个花园的花为1
//    	book[0]=1;//表示花园已经选择了要种植的花
		int[][] map=new int[N+1][N+1];
		//建立花园图，如果两点之间存在连接为1
		for (int i = 0; i < paths.length; i++) {
			map[paths[i][0]][paths[i][1]]=1;
			map[paths[i][1]][paths[i][0]]=1;
		}
		int[] answer  = dfs(map,1);
		return answer;
	}
	//使用栈递归
	public int[] dfs(int[][] map,int cur) {
		int index=0;
		int[] answer=new int[map.length-1];
		for (int i = 1; i < map.length; i++) {
			int[] color=new int[5];
			//判断相邻已被种花
			for (int j = 1; j < map[0].length; j++) {
				if(map[i][j]==1&&answer[j-1]!=0) {
					color[answer[j-1]]++;
				}
			}
			//种花
			for (int j = 1; j < color.length; j++) {
				if(color[j]==0) {
					answer[i-1]=j;
					break;
				}
			}
		}
		return answer;
	}
}
