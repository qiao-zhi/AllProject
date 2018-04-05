
import java.io.*;
import java.util.*;
public class TestList {
	  public static void main(String []args) {
		  
		  int a[]=new int[10];  //����������봴��
		  a[1]=1;
		  System.out.println(a.length);
		 
		  
		  List<Integer>  list=new ArrayList<Integer>();   //List�������봴����list������δ֪���ȵ����鱣������
		  list.add(5);
		  list.add(6);
		  list.add(10);
		  
		  
		  /***��ȡListԪ�صĵ�һ�ַ���**/
		  System.out.println(list.size());//��ȡlist��Ԫ�ظ���
		  System.out.println(list.get(0));//��ȡlist��ָ��λ�õĶ���
		  System.out.println(list.get(1));
		  System.out.println(list.get(2));
		  
		  /***��ȡListԪ�صĵڶ��ַ���**/
		for(int i=0;i<list.size();i++){      //for����ȡlistԪ��
			  System.out.println(list.get(i));
	  }
		
		
		/***��ȡListԪ�صĵ����ַ�������˼��ֻҪTestListNum��list��һ�����оͿ���ȡ��*********/
		for(int TestListNum:list){
			System.out.println(TestListNum);
			
			
			
		}
		  
		  
		  
	  }

}
