package coding;
/**
 *算法描述
 *1从第一个节点出发，进行深度遍历
 *2每次遍历默认种花1，
 *	3相邻的花园已经种了，遍历与该花园相邻的花园，花色++
 * 循环执行2，直到深度花园遍历结束
 *
 *
 */
public class leetcode1042不邻接植花_传统递归 {
	public static void main(String[] args) {
		int[][] paths= {
				{1,2},
				{3,4},
		};
		int N=4;
		leetcode1042不邻接植花_传统递归 test = new leetcode1042不邻接植花_传统递归();
		int[] gardenNoAdj = test.gardenNoAdj(N, paths);
		for (int i : gardenNoAdj) {
			System.out.println(i);
		}
	}
	static int[] answer;
	int[] book;
	int index;
	public  int[] gardenNoAdj(int N, int[][] paths) {
		answer=new int[N];
		book=new int[N];
//      	answer[0]=1;//第一个花园的花为1
//    	book[0]=1;//表示花园已经选择了要种植的花
		int[][] map=new int[N+1][N+1];
		//建立花园图，如果两点之间存在连接为1
		for (int i = 0; i < paths.length; i++) {
			map[paths[i][0]][paths[i][1]]=1;
			map[paths[i][1]][paths[i][0]]=1;
		}
		dfs(map,1);
		return answer;
	}
	public void dfs(int[][] map,int cur) {
		int[] color=new int[5];
		int ci=0;
		//种花
		if(cur<map.length) {
			if(book[cur-1]==0) {//当前节点还没种花
				//选花
				for (int i = 1; i < map.length; i++) {
					//相邻并且已被种花
					if(map[cur][i]==1&&book[i-1]==1) {
						color[answer[i-1]]++;
					}
				}
				//选好了，种
				for (int j = 1; j < color.length; j++) {
					if(color[j]==0) {
						answer[cur-1]=j;
						book[cur-1]=1;
						break;
					}
				}
			}
			//继续下一次种花
			//若是cur++则调用后再++，传的还是没++之前的cur
			dfs(map,++cur);
		}
		return ;
	}
}
