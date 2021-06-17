package basic.search;

public class DFS_迷宫最短路径搜索 {
	//迷宫
	static int map[][]=
			{
					{0,0,1,0},
					{0,0,0,0},
					{0,0,1,0},
					{0,1,0,0},
					{0,0,0,1},
			};
	//行走规则
	static int next[][]= {
			{0,1},
			{1,0},
			{0,-1},
			{-1,0},
	};
	//目的地坐标
	static int p=3;
	static int q=2;
	//路径标记数组(假设迷宫为10*10内的)
	static int book[][]=new int[10][10];
	//最短路程
	static int min=9999999;
	//移动临时变量

	public static void main(String[] args) {
		book[0][0]=1;
		dfs(0,0,0);
		System.out.println(min);
	}

	static void dfs(int x,int y,int step) {
		int tx,ty;
		if(x==p&&y==q) {
			if(step<min)
				min=step;

			return;//找到，返回寻找更短路径
		}
		//枚举4种走法
		for (int i = 0; i < next.length; i++) {
			//计算下一个点的坐标
			tx=x+next[i][0];
			ty=y+next[i][1];
			// m=5 n=4五行四列
			if(tx<0||tx>map.length-1||ty<0||ty>map[0].length-1)
				continue;
			//判断该点是否为障碍物或者已经在路路径中
			if(map[tx][ty]==0&&book[tx][ty]==0) {
				book[tx][ty]=1;//标记该点已经走过
				dfs(tx,ty,step+1);//开始尝试下一个点
				book[tx][ty]=0;//尝试取消，取消这个点的标记
			}
		}
		return ;
	}
}
