package basic.sort;

public class sort_冒泡排序 {
	/**
	 *给定一个无序数组，双层循环，两两交换，每一轮能得出一个结果(升序或降序)
	 *故称为冒泡排序
	 */
	public static void main(String[] args) {
		int arr[] = {3,8,2,7,6,5,1,4,9,0};
		bubbleSort(arr);
	}
	private static void bubbleSort(int[] arr) {

		for (int i = 0; i <arr.length-1; i++) {
			for (int j = 0; j <arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for (int i : arr) {
			System.out.print(i);
		}
	}

}
