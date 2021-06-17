package basic.sort;

public class sort_桶排序_简版 {
	/**
	 *
	 * 初始化一个长度等于待排序数字范围的数组并置0
	 * 将每一个数字对应放入相应的数组下标，遍历数组就可以输出有序的数字了
	 */
	public static void main(String[] args) {
		//将10以内的十个数字打乱，用桶排序输出有序数字
		int[] arr= {3,8,2,7,6,5,1,4,9,0};
		bucketSort(arr);
	}
	private static void bucketSort(int[] arr) {
		int[] res=new int[10];

		for (int i : arr) {
			res[i]++;
		}
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i]; j++) {
				System.out.print(i);
			}
		}
	}
}
