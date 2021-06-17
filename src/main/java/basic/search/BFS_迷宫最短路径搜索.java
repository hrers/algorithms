package basic.search;


/**
 * 使用队列的方式对图进行广度遍历
 *
 */
public class BFS_迷宫最短路径搜索 {
	int x;//横坐标
	int y;//纵坐标
	int f;//父亲在队列中的编号，本体不要求输出路径，可以需要f
	int s;//步数
	public BFS_迷宫最短路径搜索(){

	}
	public static void main(String[] args) {
		//地图大小不超过50*50,因此队列扩展不会超过2500个

		BFS_迷宫最短路径搜索[] notes= new BFS_迷宫最短路径搜索[2051];
		//java创建对象数组，里面每一个元素对象没有赋值，都是Null,自然是指空指针
		for (int i = 0; i < notes.length; i++) {
			notes[i]=new BFS_迷宫最短路径搜索();
		}
		int head,tail;
		int i,j,k,n,m,startx,starty,p,q,tx,ty,flag;
		n=5;//迷宫行
		m=4;//迷宫列

		//目标位置
		p=3;
		q=2;
		//迷宫 1为障碍物，0为可以行走
		int map[][]=
				{
						{0,0,1,0},
						{0,0,0,0},
						{0,0,1,0},
						{0,1,0,0},
						{0,0,0,1},
				};

		//行走规则
		int next[][]= {
				{0,1},
				{1,0},
				{0,-1},
				{-1,0},
		};
		//
		int[][] book=new int[51][51];

		//初始位置
		startx=0;
		starty=0;
		//队列初始化
		head=1;
		tail=1;
		//往队列里插入迷宫入口坐标
		notes[tail].x=startx;
		notes[tail].y=starty;
		notes[tail].f=0;
		notes[tail].s=0;

		tail++;
		book[startx][starty]=1;
		flag=0;//标记是否找到目标，0表示暂时未找到，1表示找到了
		//当队列不为空的时候循环
		while(head<tail) {
			//枚举四个方向
			for (int l = 0; l <= 3; l++) {
				//计算下一个点的坐标
				tx=notes[head].x+next[l][0];
				ty=notes[head].y+next[l][1];

				//判断是否越界
				if(tx<0||tx>n-1||ty<0||ty>m-1)
					continue;

				//判断是否是障碍物或已经在路劲中
				if(map[tx][ty]==0&&book[tx][ty]==0) {
					//把这个点标记为已经走过
					//宽搜每个点只入队一次，所以和深搜不同不需要将book数组还原
					book[tx][ty]=1;
					//插入新的点到队列中
					notes[tail].x=tx;
					notes[tail].y=ty;
					notes[tail].f=head;//因为这个点是head扩展出来的，所以父节点是head
					notes[tail].s=notes[head].s+1;
					tail++;
				}
				//如果到目标点了,停止扩展，任务结束，退出循环

				if(tx==p&&ty==q) {
					flag=1;
					break;
				}
			}
			if(flag==1)
				break;
			head++;
		}
		//打印队列最后一个点（目标点）的步数
		System.out.println("需要"+notes[tail-1].s+"步");
		return;
	}
}
