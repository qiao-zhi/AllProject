package arithmeticTest;

/**
 * 折半插入算法实现
* @author: qlq
* @date :  2018年4月2日下午7:24:36
 */
public class HalfInsert {

	public static void main(String a[]) {
		int array[] = { 4,6,7,5,9,6,3};
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
			//1.查找元素位置
			int low=0,high=i-1,temp=arr[i];
			while(low <= high){//查找元素应该插入的位置
				int mid=(low+high)/2;
				if(temp<arr[mid])//说明在low-mid区间
					high=mid-1;
				else		//在左边区间
					low=mid+1;
			}
			
			//2.移动元素
			for(int j=i-1;j>=high+1;j--)
				arr[j+1]=arr[j];//元素后移
			
			//3.将需要排序的元素插进去
			arr[high+1]=temp;
			
		}
	}

}
