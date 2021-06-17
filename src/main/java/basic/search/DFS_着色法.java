package basic.search;
public class DFS_着色法 {
	static int a[][]= {
			{1,2,1,0,0,0,0,0,2,3},
			{3,0,2,0,1,2,1,0,1,2},
			{4,0,1,0,1,2,3,2,0,1},
			{3,2,0,0,0,1,2,4,0,0},
			{0,0,0,0,0,0,1,5,3,0},
			{0,1,2,1,0,1,5,4,3,0},
			{0,1,2,3,1,3,6,2,1,0},
			{0,0,3,4,8,9,7,5,0,0},
			{0,0,0,3,7,8,6,0,1,2},
			{0,0,0,0,0,0,0,0,1,0}
	};
	static int[][] book=new int[10][10];
	static int sum=0;
	public static void main(String[] args) {
		dfs(5, 7, -1);
		for (int[] i:a) {
			for(int j:i)
				System.out.print(j+"            ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}
	static void dfs(int x,int y,int color) {
		//行走规则
		int next[][]= {
				{0,1},
				{1,0},
				{0,-1},
				{-1,0},
		};
		int tx,ty;
		a[x][y]=color;//对
		for (int i = 0; i <=3; i++) {
			//下一步坐标
			tx=x+next[i][0];
			ty=y+next[i][1];
			//判断是否越界
			if(tx<0||tx>a.length-1||ty<0||ty>a[0].length-1)
				continue;
			//判断是否是陆地或该地是否已被访问
			if(a[tx][ty]>0&&book[tx][ty]==0) {
				sum++;
				book[tx][ty]=1;//标记该点已经走过
				dfs(tx,ty,-1);//"色彩"为-1
			}
		}
		return;
	}
}
