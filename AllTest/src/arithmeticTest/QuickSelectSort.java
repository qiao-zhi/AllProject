package arithmeticTest;

import java.util.Arrays;

import javax.xml.transform.Templates;

/**
 * 快速选择排序
 * 
 * @author: qlq
 * @date : 2018年4月4日下午2:30:28
 */
public class QuickSelectSort {

	public static void main(String[] args) {
		int a[] = { 5, 9, 8, 7, 4, 6, 5 };
		sort(a);
		System.out.println(Arrays.toString(a));
	}

	/**
	 * 主要算法
	 * 
	 * @param arr
	 */
	public static void sort(int arr[]) {
		for (int i = 0, length_1 = arr.length - 1; i < length_1; i++) {
			for (int j = i + 1; j < length_1 + 1; j++) {
				if (arr[j] < arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
}
