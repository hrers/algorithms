package basic.search;

import java.util.Scanner;
/**
 * 求源点到各点的最短距离(单源最短路径)
 *
 *算法步骤
 *从源点出发，每次找到一个未被找过的离源点最近的点，以该点为中心扩展，最终找到源点到所有节点的最短路径
 *
 *从源点出发
 *1找离源点最近的一个点
 *2该点的值就是源点到该节点的最短路径
 *以该节点为中心，继续循环2扩展
 *（因为是当前源点距此节点最近的点，故不存在源点从第三个节点到该节点有最短路径。所以该点最短路径值确定，更新dis数组，记录该点book数组）
 *3找到源点距离所有节点最近的点
 *
 */

public class Dijkstra_边松弛算法 {
	static final Integer INF=999999999;
	public static void main(String[] args) {
		int curr=0;
		int e[][]= {//邻接矩阵图
				{0,2,6,4},
				{INF,0,3,INF},
				{7,INF,0,1},
				{5,INF,12,0}
		};
		int[] dis=new int[e.length];//更新过的数组
		int[] book=new int[e.length];//book记录节点是(1)否(0)已知最短路径
		//初始化dis数组，初始只有源点一个节点·
		for (int i = 0; i < e.length; i++) {dis[i]=e[0][i];}
		//初始化book数组，当前只知道只有源点到各个顶点的最短路径
		//在当前状态下,源点借助任何一个节点都会大于可以直接到达的当前最短节点
		book[0]=1;
		//自己到自己为0
		dis[0]=0;
		//算法核心语句
		for (int i = 0; i < book.length; i++) {
			int min=INF;
			if(book[i]==0&&dis[i]<min) {
				min=dis[i];//找出当前距离源点最近的节点
				curr=i;
			}
			book[curr]=1;//表示当前节点已被找过
			for (int j = 0; j < e.length; j++) {
				if(e[curr][j]<INF) {
					if(dis[j]>dis[curr]+e[curr][j])
						dis[j]=dis[curr]+e[curr][j];
				}
			}
		}
		for (int i = 0; i < dis.length; i++) {
			System.out.print(dis[i]);
		}
	}
}
