package Second;
public class QuickSort {
	protected int[] quickSort(int[] src) {
		int dest[],temp;
		for (int i=0;i<src.length;i++){
			for(int j=i;j<src.length;j++){
				if(src[i]>src[j]){
					temp = src[i];
					src[i] = src[j];
					src[j] = temp;
				}
			}
		}		
		return src;
	}
}
