package javabean;

import java.math.BigDecimal;

import javax.management.RuntimeErrorException;

public class Calculator {

	private String firstNum="0";
	private char operator='+';    //Switch参数只能是 int  char
	private String secondNum="0";
	private String result="0";
	
	
	
	
	public Calculator() {
	
	}
	public Calculator(String firstNum, char operator, String secondtNum) {
		super();
		this.firstNum = firstNum;
		this.operator = operator;
		this.secondNum = secondtNum;
	}
	public String getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(String firstNum) {
		this.firstNum = firstNum;
	}

	public char getOperator() {
		return operator;
	}
	public void setOperator(char operator) {
		this.operator = operator;
	}
	public String getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(String secondtNum) {
		this.secondNum = secondtNum;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	public void calculate(){
		BigDecimal first=new BigDecimal(firstNum);
		BigDecimal second=new BigDecimal(secondNum);
		switch (this.getOperator()) {
		case '+':{
			this.result = first.add(second).toString();
			break;
		}
		case '-':{
			this.result = first.subtract(second).toString();
			break;
		}
		case '*':{
			this.result = first.multiply(second).toString();
			break;
		}
		case '/':{
			boolean kong=false;
			if(second.doubleValue()==0){throw new RuntimeException("被除数不能为0");}
			//除法要判断精度和四舍五入方式
			this.result = first.divide(second,20,BigDecimal.ROUND_HALF_DOWN).toString();
			break;
		}		
		default:{
			throw new RuntimeException("错误");
		}
		}
	}
	
	
	
}
