package arithmeticTest;

/**
 * 直接插入排序算法实现
 * 
 * @author: qlq
 * @date : 2018年4月2日下午6:13:15
 */
public class StraightInsert {

	public static void main(String a[]) {
		int array[] = { 5, 4, 9, 8, 6, 6 };
		straightInsertImpl(array);
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
	public static void straightInsertImpl(int[] arr) {
		for (int i = 1; i < arr.length; i++) {// 遍历右边的无序区间
			int temp = arr[i];
			if (arr[i] >= arr[i - 1]) { // 如果无序区的第一个元素大于或者等于有序区的第一个元素，结束本次循环进行下一次
				continue;
			}
			for (int j = 0; j < i; j++) {// 遍历左边的有序区间
				if (temp < arr[j]) {// 找到位置后元素后移
					for (; i > j; i--) {
						arr[i] = arr[i - 1];
					}
					arr[j] = temp;
					break; // 找到合适的位置插入后结束这层循环即可
				}
			}
		}
	}
}
