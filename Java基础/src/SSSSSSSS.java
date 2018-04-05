import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Test;

public enum SSSSSSSS {
	A(1){                   //创建对象，要实现其抽象方法
		public  String getSS()	{return "a";}
	}
	
	,B(2){
		public  String getSS()	{return "a";}
	}
	,
	C(3){
		public  String getSS()	{return "a";}
	},
	D(4){
		public  String getSS()	{return "a";}
	},
	E(5){
		public  String getSS()	{return "a";}
	};   //相当于5个SSSSSSS类的对象，调用其午餐构造函数的对象
	
	private int x;
	private SSSSSSSS(int s){
		x=s;
	}
	public int getX() {
		return x;
	}
	
	public abstract String getSS();

	
	public static void main(String[] args) {
		
		SSSSSSSS S=SSSSSSSS.A;
		System.out.println(S.getX()+S.getSS());
	}
	
	



}
