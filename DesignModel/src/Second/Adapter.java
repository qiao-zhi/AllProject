package Second;

public class Adapter extends QuickSort implements DataOperation {

	@Override
	public int[] quickSort(int[] src) {
		return super.quickSort(src);
		}
	@Override
	public int binarySearch(int[] srcArray, int searchData) {
		
		BinarySearch bs = new BinarySearch();
		return bs.binarySearch(srcArray, searchData);
	}
	/*************测试****/
	public static void main(String[] args) {
		Adapter ad = new Adapter();
		int a[] = {1,5,9,8,6,5,7};
		System.out.println("排序前的数组为:");
		System.out.print("\t");
		for(int i:a){System.out.print(i+"  ");}
		a = ad.quickSort(a);
		System.out.println("\n排序后的数组为:");
		System.out.print("\t");
		for(int i:a){System.out.print(i+"  ");}
		System.out.print("\n查找7的数组下标是："+ad.binarySearch(a, 7));
		
	}
}
