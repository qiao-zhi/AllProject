package arithmeticTest;

import javax.xml.transform.Templates;

/**
 * 冒泡排序
 * 
 * @author: qlq
 * @date : 2018年4月2日下午10:03:13
 */
public class Bubble {

	public static void main(String a[]) {
		int array[] = { 4, 6, 7, 5, 9, 6, 3 };
		bubbleSortImpl(array);
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
	public static void bubbleSortImpl(int[] arr) {
		for(int i=0,length_1=arr.length;i<length_1;i++){//从后往前扫描
			for(int j=length_1-1;j>=i+1;j--){
				if(arr[j]<arr[j-1]){	//如果小于就交换数据
					int temp = arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
			}
		}
	}
	

}
