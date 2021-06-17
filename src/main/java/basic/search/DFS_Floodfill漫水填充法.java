package basic.search;

public class DFS_Floodfill漫水填充法 {
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
		int num=0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if(a[i][j]>0)
				{
					num--;//小岛需要染的颜色的编号
					book[i][j]=1;
					dfs(i,j,num);
				}
			}
		}
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
		//枚举四个方向
		int tx,ty;
		a[x][y]=color;//对格子进行染色
		for (int i = 0; i <=3; i++) {
			//下一步坐标
			tx=x+next[i][0];
			ty=y+next[i][1];
			//判断是否越界
			if(tx<0||tx>a.length-1||ty<0||ty>a[0].length-1)
				continue;
			//判断是否是陆地和是否被访问过了
			if(a[tx][ty]>0&&book[tx][ty]==0)
			{
				sum++;
				book[tx][ty]=1;
				dfs(tx,ty,color);//开始尝试下一个点
			}
		}
		return ;
	}
}
