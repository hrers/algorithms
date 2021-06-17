package basic.sort;

public class sort_快速排序 {
	/**
	 * 首先一组无序数字，快排的主要通过“基准数"的方式，实现相对于冒泡排序只能相邻比较的缺点，
	 * 实现跳跃式排序
	 * 具体实现，设置设置首尾两个哨兵，i哨兵初始在基准数的右边第一个，j哨兵在数组末尾，每次j先向左边移动，找到
	 * 小于基准数的数字时停下，轮到i哨兵动，i哨兵向右移动，遇到大雨基准数的数字时，和j哨兵的位置的数字进行交换
	 * 为什么要保证是j哨兵先找到目标，i才能向右移动？
	 * 只有当j哨兵找到目标时，我们才能确定，当i,j相遇时，相遇的那个数字小于基准数，我们左边第一个基准数才能落位，
	 * 而快排的实现过程就是每一轮基准数落位的过程。若i首先踩到大于基准数的数字时，就无法完成基准数落位（i,j相遇处和基准数交换）
	 * 快排相当于分治，所以我们用递归实现快排比较方便
	 */
//	定义全局变量
	static int arr[] = {3,8,2,7,6,5,1,4,9,0};
	public static void main(String[] args) {

		quickSort(0,arr.length-1);
		for (int i:arr) {
			System.out.print(i);
		}
	}
	private static void quickSort(int left,int right) {
		//哨兵i,j,交换临时变量t,基准数temp
		int i,j,t,temp;
		if(left>right)
			return;
		temp=arr[left];
		i=left;
		j=right;

		while(i!=j) {
			while(arr[j]>=temp&&i<j)
				j--;
			while(arr[i]<=temp&&i<j)
				i++;
			if(i<j) {
				t=arr[i];
				arr[i]=arr[j];
				arr[j]=t;
			}
		}
		//最终将基准数归位
		arr[left]=arr[i];
		arr[i]=temp;

		quickSort(left, i-1);
		quickSort(i+1, right);
	}

}
