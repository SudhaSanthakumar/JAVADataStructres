package com.java.inheritance;

 class Base {

	public void print(){
		System.out.println("Base public Print");
	}
	private void print1(){
		System.out.println("Base private Print");
	}
}
 public class Derived extends Base{

	public void print(){
		System.out.println("child public Print");
	}
	private void print1(){
		System.out.println("child private Print");
	}
	public static void main(String s[]){
		Derived b=new Derived();
		b.print();
		b.print1();
		
		Base b1=new Base();
		b1.print();
		//b1.print1();
		
		Base b11=new Derived();
		b11.print();
		
	}
}