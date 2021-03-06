package arithmeticTest;

/**
 * 希尔排序实现
 * 
 * @author: qlq
 * @date : 2018年4月2日下午9:10:25
 */
public class XierInsert {

	public static void main(String a[]) {
		int array[] = { 9, 8, 7, 6, 4, 5, 3, 2, 1, 0 };
		xierInsertImpl(array);
		// 打印排序后的数组
		for (int i : array) {
			System.out.print(i + "   ");
		}
	}

	/**
	 * 主要算法实现
	 * 
	 * @param arr
	 *            需要排序的数组
	 */
	public static void xierInsertImpl(int[] arr) {
		int gap = arr.length / 2, temp, j;// 增量置初值
		while (gap > 0) {
			for (int i = gap; i < arr.length; i++) {// 对所有相距gap的元素进行直接插入排序
				temp = arr[i];
				j = i - gap;
				while (j >= 0 && temp < arr[j]) {
					arr[j + gap] = arr[j];
					j = j - gap;
				}
				arr[j + gap] = temp;

			}
			gap = gap / 2; // 减小增量
		}

	}

}
