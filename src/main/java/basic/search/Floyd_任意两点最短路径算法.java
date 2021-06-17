package basic.search;
/**
 * 作用：求出任意两点的最短子路经(求全局最短路径)
 * 算法思想：
 * 如果两顶点间存在一条更短的路径，就必须通过第三个点(两顶点的路径不是两点直线最短那个意思)
 * 相关定理：最短路径的子路径也是最短的
 *
 * 主要通过插点法不断更新邻接矩阵表中的最短路径
 *
 */
public class Floyd_任意两点最短路径算法 {

	static int inf=999999;
	public static void main(String[] args) {
		int e[][]= {
				{0,2,6,4},
				{inf,0,3,inf},
				{7,inf,0,1},
				{5,inf,12,0}
		};
		int n=e.length;
		for(int k=0;k<n;k++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(e[i][j]>e[i][k]+e[k][j])
						e[i][j]=e[i][k]+e[k][j];
		for (int[] is : e) {
			for (int i = 0; i < e.length; i++) {
				System.out.print(is[i]+"   ");
			}
			System.out.println();

		}
	}

}
